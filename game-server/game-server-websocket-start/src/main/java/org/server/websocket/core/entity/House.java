package org.server.websocket.core.entity;

import io.netty.channel.ChannelHandlerContext;

public class House {

	/**
	 * 房间id
	 */
	private String houseId;
	
	/**
	 * 房主
	 */
	private ChannelHandlerContext master;
	
	/**
	 * 来宾
	 */
	private ChannelHandlerContext guest;
	
	/**
	 * true:准备   false:未准备
	 */
	private Boolean masterState = false;
	
	/**
	 * true:准备   false:未准备
	 */
	private Boolean guestState = false;
	
	/**
	 * 0:新建  1:一人准备  2:两人都准备  
	 */
	private Integer houseState = 0;
	
	/**
	 * 1:谐音   2:同字
	 */
	private Integer type = 1;
	
	public String getHouseId() {
		return houseId;
	}


	public House setHouseId(String houseId) {
		this.houseId = houseId;
		return this;
	}


	public ChannelHandlerContext getMaster() {
		return master;
	}


	public House setMaster(ChannelHandlerContext master) {
		this.master = master;
		return this;
	}


	public ChannelHandlerContext getGuest() {
		return guest;
	}


	public House setGuest(ChannelHandlerContext guest) {
		this.guest = guest;
		return this;
	}


	public Boolean getMasterState() {
		return masterState;
	}


	public void setMasterState(Boolean masterState) {
		this.masterState = masterState;
	}


	public Boolean getGuestState() {
		return guestState;
	}


	public House setGuestState(Boolean guestState) {
		this.guestState = guestState;
		return this;
	}


	public Integer getHouseState() {
		return houseState;
	}


	public House setHouseState(Integer houseState) {
		this.houseState = houseState;
		return this;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
