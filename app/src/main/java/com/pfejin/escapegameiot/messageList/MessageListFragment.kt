package com.pfejin.escapegameiot.messageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
                Vous avez donc réussi à vous introduire dans la banque ! Je n'y crayais pas.
                Ha ha ha !
                Maintenant attez-vous d'accomplir votre mission !
                Je veux ces données...
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                Il vous suffit de récupérer l'ID du serveur. Ça ne devrait pas vous prendre trop de temps.
                Je vous conseille de bien prendre connaissance de la pièce. Notifier moi quand ce sera fait.
            """.trimIndent()),
        Message(
            MessageAuthor.PLAYER,
            """
                Nous ne trouvons pas l'ID du serveur dans la pièce.
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                Vous devez d'abord accèder à la salle des serveurs, mais vous ne pouvez vous y rendre directement.
                Trouvez un moyen de l'atteindre sans sortir de la salle.
            """.trimIndent()),
        Message(
            MessageAuthor.PLAYER,
            """
                Nous avons trouvé les contrôles d'un drone mais nous n'avons pas les autorisations nécessaire à son activation.
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                C'est à votre coéquipier de vous accorder l'accès. Grâce à son dispositif extra-sensoriel il seracapable de voir la position du drone même à travers les obstacles. Idéale, non ?
                Cependant, je crains qu'il n'ait besoin d'une connexion wifi stable.
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                Attention !! Vous perdez trop de temps.
                Les gardes vont bienôt finir leur poses.
            """.trimIndent()),
        Message(
            MessageAuthor.GAME_MASTER,
            """
                Attention !! Un garde se rapproche !
                Faites le moins de bruit possible, pour ne pas vous faire remarquer.
            """.trimIndent()),
    )

    private val messageList = mutableListOf<Message>()

    private val adapter by lazy {
        MessageListAdapter(messageList)
    }

    private lateinit var recyclerView: RecyclerView

    private lateinit var imageContext: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        imageContext = view.findViewById(R.id.context_image)

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

        if (position == 1) {
            imageContext.setBackgroundResource(R.color.purple_200)
            imageContext.setImageResource(R.drawable.ic_baseline_explore_24)
        }

        if (position == 5) {
            imageContext.setBackgroundResource(R.color.purple_200)
            imageContext.setImageResource(R.drawable.ic_baseline_wifi_24)
        }

        if (position == 6) {
            imageContext.setBackgroundResource(R.color.orange)
            imageContext.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
        }

        if (position == 7) {
            imageContext.setBackgroundResource(R.color.red)
            imageContext.setImageResource(R.drawable.ic_baseline_warning_24)
        }

        adapter.notifyItemInserted(position)
        recyclerView.scheduleLayoutAnimation();

        recyclerView.layoutManager?.scrollToPosition(position)
    }
}