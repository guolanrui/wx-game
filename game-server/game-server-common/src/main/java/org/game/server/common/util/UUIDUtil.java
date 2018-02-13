package org.game.server.common.util;

import java.util.UUID;

public class UUIDUtil {

	
	public static String get() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
