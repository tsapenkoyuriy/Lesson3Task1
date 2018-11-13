package com.android.ytsapenko.recyclerex2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MessageAdapter(private val messages:MutableList<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val LEFT_MESSAGE:Int = 1
    private val RIGHT_MESSAGE:Int = 2
    private val messagesList = messages
    private lateinit var context:Context


    override fun getItemCount(): Int {
        return messagesList.size
    }


    override fun getItemViewType(position: Int): Int {
        if(messagesList.get(position) is LeftMessage) return LEFT_MESSAGE
        else if(messagesList.get(position) is RightMessage) return RIGHT_MESSAGE
        return -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var itemView: View
        lateinit var viewHolder: RecyclerView.ViewHolder
        when(viewType){
            LEFT_MESSAGE->{
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.left_message, parent, false)
                viewHolder = LeftMessageViewHolder(itemView)
            }
            RIGHT_MESSAGE->{
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.right_message, parent, false)
                viewHolder = RightMessageViewHolder(itemView)
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = holder.itemViewType
        when(viewType){
            LEFT_MESSAGE->{
                val leftMessage:LeftMessage = messagesList.get(position) as LeftMessage
                (holder as LeftMessageViewHolder).showMessage(leftMessage)
            }
            RIGHT_MESSAGE->{
                val rightMessage:RightMessage = messagesList.get(position) as RightMessage
                (holder as RightMessageViewHolder).showMessage(rightMessage)
            }
        }

    }

    class LeftMessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val messageText:TextView = itemView.findViewById(R.id.leftMessageText)

        fun showMessage(leftMessage: LeftMessage){
            messageText.text = leftMessage.getMesageText()
        }
    }

    class RightMessageViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val messageText:TextView = itemView.findViewById(R.id.rightMessageText)

        fun showMessage(rightMessage: RightMessage){
            messageText.text = rightMessage.getMesageText()
        }
    }

}