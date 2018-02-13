package org.server.websocket.configuration;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MusicHubTomcatEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory{  

	public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers){  
		super.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notFound"));
        return super.getEmbeddedServletContainer(initializers);  
    }  
      
	protected void customizeConnector(Connector connector){  
        super.customizeConnector(connector);  
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();  
        protocol.setConnectionTimeout(20000);
        
//        protocol.setKeepAliveTimeout(5000);
    }  
}
