package com.toby.test.kotlinchat.chat.domain


data class ChatMessageCreateCommand (
    var roomId : Long = 0,
    var content : String,
    var from : String,
)