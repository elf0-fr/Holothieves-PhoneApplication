package com.pfejin.escapegameiot.messageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pfejin.escapegameiot.R

class MessageListFragment : Fragment() {
    private val nextMessageList = mutableListOf<Message>(
        Message(
            MessageAuthor.GAME_MASTER,
            """
            Bienvenu dans le jeu. L'immersion est totale. Prenez goût au risque.
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                Message 2
                Test
                Test
                Test
                Test
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                Message 3
                suite.
            """.trimIndent()),
        Message(MessageAuthor.PLAYER, "message 2"),
        Message(MessageAuthor.GAME_MASTER, "message 2"),
        Message(MessageAuthor.PLAYER, "message 2"),
        Message(MessageAuthor.PLAYER, "message 2"),
        Message(MessageAuthor.GAME_MASTER, "message 2"),
        Message(MessageAuthor.PLAYER, "message 2")
    )

    private val messageList = mutableListOf<Message>()

//        , , "message 3", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message", "autre message")

    private val adapter by lazy {
        MessageListAdapter(messageList)
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        val nextMessage = view.findViewById<FloatingActionButton>(R.id.next_message)
        nextMessage.setOnClickListener {
            getNextMessage()
        }
    }

    private fun getNextMessage() {
        if (nextMessageList.size == 0) {
            return
        }

        val message = nextMessageList.removeFirst()
        messageList.add(message)
        val position = messageList.indexOf(message)

        adapter.notifyItemInserted(position)
        recyclerView.scheduleLayoutAnimation();
    }
}