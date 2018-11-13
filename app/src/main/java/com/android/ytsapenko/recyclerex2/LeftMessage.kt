package com.android.ytsapenko.recyclerex2

import java.time.LocalDateTime
import java.util.*

class LeftMessage {
    private lateinit var senderName:String
    private lateinit var messageText:String
    //private lateinit var deliveryDate: LocalDateTime

    constructor(senderName: String, messageText: String) {
        this.senderName = senderName
        this.messageText = messageText
        //this.deliveryDate = LocalDateTime.now()
    }

    fun genSenderName():String{
        return this.senderName
    }

    fun getMesageText():String{
        return this.messageText
    }
}