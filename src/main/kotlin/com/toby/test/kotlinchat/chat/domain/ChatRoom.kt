package com.toby.test.kotlinchat.chat.domain

data class ChatRoom (
    var roomId : Long,
    var messageList : List<ChatMessage>,
)