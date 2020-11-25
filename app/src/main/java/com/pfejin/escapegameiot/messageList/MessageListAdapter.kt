package com.pfejin.escapegameiot.messageList

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MessageListAdapter(private val messageList: List<String>) : RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>() {
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: String) {
            itemView.apply {

            }
        }
    }

}