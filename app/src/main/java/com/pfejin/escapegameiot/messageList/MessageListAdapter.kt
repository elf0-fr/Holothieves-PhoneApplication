package com.pfejin.escapegameiot.messageList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pfejin.escapegameiot.R

class MessageListAdapter(private val messageList: List<String>) : RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>() {
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: String) {
            itemView.apply {
                val textView = findViewById<TextView>(R.id.message)
                textView.text = message
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount(): Int {
        return messageList.size;
    }

}