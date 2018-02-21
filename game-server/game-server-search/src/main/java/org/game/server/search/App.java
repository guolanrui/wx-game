package org.game.server.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.game.server.search.entity.Idiom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String s1 = App.class.getResource("/idiom.txt").getPath();    
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(s1), Charset.forName("gbk")));
    	String line = null;
    	List<Idiom> idiomList = new ArrayList<>();
    	while((line = br.readLine()) != null){
    		System.out.println(line);
//    		String[] arr = line.split(">");
//    		idiomList.add(new Idiom(arr[0], arr[1].substring(3), arr[2].substring(3), arr[3].substring(3), arr[4].substring(3)));
    	}
    	System.out.println(idiomList);
        
    }
}
