package org.server.websocket.netty;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.server.websocket.netty.config.NettyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;

@Component
public class NettyWebSocketServerStart {
	
	private static final Logger log = LoggerFactory.getLogger(NettyWebSocketServerStart.class);

	
	@Autowired
	private ServerBootstrap bootstrap;
	@Autowired
	@Qualifier("masterGroup")
	private NioEventLoopGroup masterGroup;
	
	@Autowired
	@Qualifier("workGroup")
	private NioEventLoopGroup workGroup;
	
	
	@Autowired
	private NettyConfig config;
	
	@PostConstruct
	public void start() throws InterruptedException {
		new Thread(()->{
			Channel channel;
			try {
				channel = bootstrap.bind(config.getPort()).sync().channel();
				log.info("Netty Server started  "+ config.getPort());
				channel.closeFuture().sync();
			} catch (InterruptedException e) {
				log.error("Netty Server started fail ");
				e.printStackTrace();
			}
		}) .start();
	}
	
	@PreDestroy
	public void destroy() {
		masterGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
	}
	
}
