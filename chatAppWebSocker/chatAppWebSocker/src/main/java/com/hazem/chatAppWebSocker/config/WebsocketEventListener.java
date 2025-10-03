package com.hazem.chatAppWebSocker.config;

import com.hazem.chatAppWebSocker.controllers.ChatMessage;
import com.hazem.chatAppWebSocker.controllers.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebsocketEventListener {
    private final SimpMessageSendingOperations messagingTemplate;
    @EventListener
    public void handelWebSocketConnect(SessionConnectEvent disconnectEvent){
    }
    @EventListener
    public void handelWebSocketDisconnect(SessionDisconnectEvent connectEvent){
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.wrap(connectEvent.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("user");
        if(username != null){
            ChatMessage chatMessage = new ChatMessage();
            log.info("{} disconnected", username);
            chatMessage.setSender(username);
            chatMessage.setType(MessageType.LEAVE);
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
