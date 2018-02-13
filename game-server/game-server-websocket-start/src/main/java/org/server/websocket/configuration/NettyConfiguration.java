package org.server.websocket.configuration;

import org.game.server.common.util.OSUtil;
import org.server.websocket.netty.NettyChannelInitializer;
import org.server.websocket.netty.config.NettyConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Configuration
public class NettyConfiguration {

	@Bean
	@ConfigurationProperties("netty")
	public NettyConfig nettConfig() {
		return new NettyConfig();
	}
	
	@Bean
	public ServerBootstrap serverBootstrap(NettyChannelInitializer channelInitializer,@Qualifier("masterGroup")EventLoopGroup masterGroup,@Qualifier("workGroup")EventLoopGroup workGroup) {
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(masterGroup, workGroup)
		.channel(NioServerSocketChannel.class)
		.option(ChannelOption.SO_BACKLOG, 1024)
		.option(ChannelOption.SO_KEEPALIVE, true)
		.childHandler(channelInitializer);
		return bootstrap;
	}
	
	@Bean(name="masterGroup")
	public EventLoopGroup masterGroup() {
		return OSUtil.isLinux() ? new EpollEventLoopGroup() : new NioEventLoopGroup(100);
	}
	
	@Bean(name="workGroup")
	public EventLoopGroup workGroup() {
		return OSUtil.isLinux() ? new EpollEventLoopGroup() : new NioEventLoopGroup(55);
	}
	
	
}
