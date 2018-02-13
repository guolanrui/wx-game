package org.server.websocket.netty;

import org.server.websocket.channelhandler.MainWebSocketServerHandler;
import org.springframework.stereotype.Component;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

@Component
public class NettyChannelInitializer extends ChannelInitializer<Channel> {

	@Override
	protected void initChannel(Channel channel) throws Exception {
		channel.pipeline().addLast(new HttpServerCodec()); // 将请求和应答消息解码为HTTP消息
		channel.pipeline().addLast(new HttpObjectAggregator(65536)); // 将HTTP消息的多个部分合成一条完整的HTTP消息
		channel.pipeline().addLast(new ChunkedWriteHandler()); //向客户端发送HTML5文件
		channel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
		channel.pipeline().addLast(new MainWebSocketServerHandler());
	}

}
