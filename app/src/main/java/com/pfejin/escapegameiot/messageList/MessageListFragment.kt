package com.pfejin.escapegameiot.messageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pfejin.escapegameiot.R

class MessageListFragment : Fragment() {
    private val messageList = listOf("\n message 1\n test\n", "message 2", "message 3", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = MessageListAdapter(messageList)
    }
}