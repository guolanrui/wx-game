package org.server.websocket.core;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.server.websocket.core.entity.House;

import io.netty.channel.ChannelHandlerContext;

public class GameCore {
	

	/**
	 * 游戏房间集合
	 */
	private final static Map<String, House> houseMap = new ConcurrentHashMap<>();
	
	/**
	 * 创建房间
	 * @param master
	 * @return
	 */
	public static String createHouse(ChannelHandlerContext master) {
		String houseId = String.valueOf(UUID.randomUUID().toString());
		House house = new House();
		house.setMaster(master).setHouseId(houseId);
		houseMap.put(houseId, house);
		return houseId;
	}
	
	public static String quitHouse(String houseId,ChannelHandlerContext user) {
		
		House house = houseMap.get(houseId);
		
		return houseId;
	}
	
	/**
	 * 解散房间
	 * @param houseId
	 * @return
	 */
	public static boolean dissolveHouse(String houseId) {
		return houseMap.remove(houseId) == null ? false : true;
	}
	
	/**
	 * 在线人数统计
	 */
	private final static AtomicInteger playerCount = new AtomicInteger(0);
	
	/**
	 * 获取在线人数
	 * @return
	 */
	public static int playerCount() {
		return playerCount.get();
	}
	
	/**
	 * 增加人数
	 * @return
	 */
	public static int addPlayerCount() {
		return playerCount.incrementAndGet();
	}
	
	/**
	 * 减少人数
	 * @return
	 */
	public static int decrementPlayerCount() {
		return playerCount.decrementAndGet();
	}
	
}
