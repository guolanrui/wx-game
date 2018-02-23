package org.server.websocket.core.entity;

/**
 * 统一消息码
 *
 */
public enum Code {
	success(200, "成功"),

	parameters_incorrect(400, "参数不正确"),
	service_notfound(401, "没有这个服务"),

	error(500, "执行错误"),

	
	online(1001, "客户端上线请求"),
	create_house(1002, "创建房间"),
	quit_house(1003, "退出房间"),
	downline(1004, "客户端下线请求");
	
	public String note;
	public Integer code;

	private Code(Integer code, String note) {
		this.note = note;
		this.code = code;
	}
}
