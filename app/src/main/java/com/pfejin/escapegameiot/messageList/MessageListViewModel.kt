package com.pfejin.escapegameiot.messageList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MessageListViewModel : ViewModel() {
    private val _messagesList = MutableLiveData<List<Message>>()
    public val messagesList: LiveData<List<Message>> = _messagesList

    private val questionsPlayerList = listOf<Message>(
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Nous avons besoin d'aide.
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Nous ne savons pas quoi faire.
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Pouvez-vous nous donner plus d'indice.
                    """.trimIndent()
            )
    )

    private val finishedPlayerList = listOf<Message>(
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Nous avons réussi.
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.PLAYER,
                    """
                    L'énigme est résolue.
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Enigme réussie sans problème.
                    """.trimIndent()
            ),
    )

    private val unfinishedPlayerList = listOf<Message>(
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Je me suis trompé, nous n'avons pas fini la tâche précédente.
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Pouvez-vous nous réexpliquer la tâche précédente ?
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.PLAYER,
                    """
                    Pouvez-vous nous récapituler la tâche précédente ?
                    """.trimIndent()
            ),
    )

    private val firstHintGMList = listOf<Message>(
            Message(
                    MessageAuthor.GAME_MASTER,
                    """
                    Vous avez donc réussi à vous introduire dans la banque ! Je n'y croyais pas.
                    Ha ha ha !
                    Maintenant hâtez-vous d'accomplir votre mission !
                    Je veux ces données...
                    Il vous suffit de récupérer l'ID du serveur. Ça ne devrait pas vous prendre trop de temps.
                    """.trimIndent()),
            Message(
                    MessageAuthor.GAME_MASTER,
                    """
                    Je vous conseille de bien prendre connaissance de la pièce. Notifiez moi quand ce sera fait.
                    """.trimIndent()
            ),
            Message(
                    MessageAuthor.GAME_MASTER,
                    """
                    Vous devez d'abord accéder à la salle des serveurs, mais vous ne pouvez vous y rendre directement.
                    Trouvez un moyen de l'atteindre sans sortir de la salle.
                    """.trimIndent()),
    )

    fun receiveFirstHint() {
        viewModelScope.launch {
            val editableList = _messagesList.value.orEmpty().toMutableList()
            editableList.add(firstHintGMList[0])
            _messagesList.value = editableList
        }
    }

    fun sendFinished() {
        viewModelScope.launch {
            val editableList = _messagesList.value.orEmpty().toMutableList()
            editableList.add(finishedPlayerList[0])
            _messagesList.value = editableList
        }
    }

    fun sendUnfinished() {
        viewModelScope.launch {
            val editableList = _messagesList.value.orEmpty().toMutableList()
            editableList.add(unfinishedPlayerList[0])
            _messagesList.value = editableList
        }
    }

    fun sendQuestion() {
        viewModelScope.launch {
            val editableList = _messagesList.value.orEmpty().toMutableList()
            editableList.add(questionsPlayerList[0])
            _messagesList.value = editableList
        }
    }
}