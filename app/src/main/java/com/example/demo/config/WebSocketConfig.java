package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//define method for protocol for messaging
@Configuration
@EnableWebSocketMessageBroker  //STOMP concept of routting message
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("https://localhost:8080")
                .withSockJS();   //defining endpoints to a chat application with endpoints of sockets end points
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //set message Broker
        registry.enableSimpleBroker( "/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }


}
