package com.toby.test.kotlinchat.chat

import com.toby.test.kotlinchat.chat.domain.ChatMessage
import com.toby.test.kotlinchat.chat.domain.ChatMessageCreateCommand
import com.toby.test.kotlinchat.chat.domain.ChatMessageResponse
import com.toby.test.kotlinchat.chat.domain.ChatMessageRequest
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

//@Controller
@RestController
class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(@Payload chatMessage: ChatMessage?): ChatMessage? {
        return chatMessage
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    fun addUser(@Payload chatMessage: ChatMessage, headerAccessor: SimpMessageHeaderAccessor): ChatMessage? {
        headerAccessor.sessionAttributes!!["username"] = chatMessage.sender
        return chatMessage
    }

    @MessageMapping("/chat.deleteUser")
    @SendTo("/topic/public")
    fun deleteUser(@Payload chatMessage: ChatMessage?): ChatMessage? {
        return chatMessage
    }

    @MessageMapping("/chat.enter")
    @SendTo("/topic/public")
    fun enterChat(@Payload chatMessage: ChatMessage): ChatMessage? {
        return chatMessage
    }

    @MessageMapping("/chat.rooms.{roomId}.send")
    @SendTo("/topic/public/rooms/{roomId}")
    fun sendMessage_ing(@DestinationVariable roomId: Long, @Payload chatMessage: ChatMessageRequest): ChatMessageResponse? {
        val chatMessageCreateCommand = ChatMessageCreateCommand(
            content = chatMessage.text(),
            from = chatMessage.from(),
            roomId = roomId
        )

        val chatId : Long = chatmessageCreateUseCase.createChatMessage(chatMessage)?.chatId()
        val chatMessageResponse = ChatMessageResponse(
            id = chatId,
            content = chatMessage.content(),
            writer = chatMessage.from(),
        )
        return chatMessageResponse
    }
}
