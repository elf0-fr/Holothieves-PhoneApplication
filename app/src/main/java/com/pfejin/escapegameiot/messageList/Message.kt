package com.pfejin.escapegameiot.messageList

enum class MessageAuthor {
    PLAYER,
    GAME_MASTER
}

class Message(val author: MessageAuthor, val text : String)