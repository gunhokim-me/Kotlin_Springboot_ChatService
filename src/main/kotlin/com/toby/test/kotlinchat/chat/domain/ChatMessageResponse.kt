package com.toby.test.kotlinchat.chat.domain

data class ChatMessageResponse (
    var id: Long? = null,
    var content : String,
    var writer: String,
)