package com.android.ytsapenko.recyclerex2

class RightMessage {
    private lateinit var senderName:String
    private lateinit var messageText:String
    //private lateinit var deliveryTime:String

    constructor(senderName: String, messageText: String){
        this.senderName = senderName
        this.messageText = messageText
    }

    fun getMesageText():String{
        return this.messageText
    }


}