package com.toby.test.kotlinchat.chat.domain

data class ChatMessage (
    var type: MessageType,
    var content: String?,
    var sender: String,

    var chatId : Long,
    var writer: String,
    var chatRoomId : Long,

)