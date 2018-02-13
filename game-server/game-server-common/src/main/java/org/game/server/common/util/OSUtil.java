package org.game.server.common.util;

public class OSUtil {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isLinux() {
		return OS.indexOf("linux") >= 0;
	}
}
