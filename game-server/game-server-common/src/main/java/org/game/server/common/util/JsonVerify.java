package org.game.server.common.util;

/**
 * 用于校验一个字符串是否是合法的JSON格式
 * 
 */
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
 
public class JsonVerify {
 
    private CharacterIterator it;
    private char              c;
 
    private JsonVerify(){
    }
    
    public static boolean validJson(String input){
    	return new JsonVerify().validate(input);
    }
 
    /**
     * 验证一个字符串是否是合法的JSON串
     * 
     * @param input 要验证的字符串
     * @return true-合法 ，false-非法
     */
    public boolean validate(String input) {
    	if(input == null || "".equals(input)) return false;
        return valid(input.trim());
    }
 
    private boolean valid(String input) {
        boolean ret = true;
        it = new StringCharacterIterator(input);
        c = it.first();
        if (!value()) {
            ret = false;
        } else {
            skipWhiteSpace();
            if (c != CharacterIterator.DONE) {
                ret = false;
            }
        }
 
        return ret;
    }
 
    private boolean value() {
        return literal("true") || literal("false") || literal("null") || string() || number() || object() || array();
    }
 
    private boolean literal(String text) {
        CharacterIterator ci = new StringCharacterIterator(text);
        char t = ci.first();
        if (c != t) return false;
 
        boolean ret = true;
        for (t = ci.next(); t != CharacterIterator.DONE; t = ci.next()) {
            if (t != nextCharacter()) {
                ret = false;
                break;
            }
        }
        nextCharacter();
        if (!ret) return false;
        return ret;
    }
 
    private boolean array() {
        return aggregate('[', ']', false);
    }
 
    private boolean object() {
        return aggregate('{', '}', true);
    }
 
    private boolean aggregate(char entryCharacter, char exitCharacter, boolean prefix) {
        if (c != entryCharacter) return false;
        nextCharacter();
        skipWhiteSpace();
        if (c == exitCharacter) {
            nextCharacter();
            return true;
        }
 
        for (;;) {
            if (prefix) {
                if (!string()) return false;
                skipWhiteSpace();
                if (c != ':') return false;
                nextCharacter();
                skipWhiteSpace();
            }
            if (value()) {
                skipWhiteSpace();
                if (c == ',') {
                    nextCharacter();
                } else if (c == exitCharacter) {
                    break;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            skipWhiteSpace();
        }
 
        nextCharacter();
        return true;
    }
 
    private boolean number() {
        if (!Character.isDigit(c) && c != '-') return false;
        if (c == '-') nextCharacter();
        if (c == '0') {
            nextCharacter();
        } else if (Character.isDigit(c)) {
            while (Character.isDigit(c))
                nextCharacter();
        } else {
            return false;
        }
        if (c == '.') {
            nextCharacter();
            if (Character.isDigit(c)) {
                while (Character.isDigit(c))
                    nextCharacter();
            } else {
                return false;
            }
        }
        if (c == 'e' || c == 'E') {
            nextCharacter();
            if (c == '+' || c == '-') {
                nextCharacter();
            }
            if (Character.isDigit(c)) {
                while (Character.isDigit(c))
                    nextCharacter();
            } else {
                return false;
            }
        }
        return true;
    }
 
    private boolean string() {
        if (c != '"') return false;
 
        boolean escaped = false;
        for (nextCharacter(); c != CharacterIterator.DONE; nextCharacter()) {
            if (!escaped && c == '\\') {
                escaped = true;
            } else if (escaped) {
                if (!escape()) {
                    return false;
                }
                escaped = false;
            } else if (c == '"') {
                nextCharacter();
                return true;
            }
        }
        return false;
    }
 
    private boolean escape() {
        if (" \\\"/bfnrtu".indexOf(c) < 0) {
            return false;
        }
        if (c == 'u') {
            if (!ishex(nextCharacter()) || !ishex(nextCharacter()) || !ishex(nextCharacter())
                || !ishex(nextCharacter())) {
                return false;
            }
        }
        return true;
    }
 
    private boolean ishex(char d) {
        return "0123456789abcdefABCDEF".indexOf(d) >= 0;
    }
 
    private char nextCharacter() {
        c = it.next();
        return c;
    }
 
    private void skipWhiteSpace() {
        while (Character.isWhitespace(c)) {
            nextCharacter();
        }
    }
 
}