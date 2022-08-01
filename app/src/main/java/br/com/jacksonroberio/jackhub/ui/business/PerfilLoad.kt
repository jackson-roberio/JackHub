package br.com.jacksonroberio.jackhub.ui.business

import androidx.compose.runtime.*
import br.com.jacksonroberio.jackhub.ui.business.entity.PerfilUiState
import br.com.jacksonroberio.jackhub.webclient.rest.WebClient
import br.com.jacksonroberio.jackhub.webclient.rest.entity.toPefilUiState
import br.com.jacksonroberio.jackhub.webclient.rest.entity.toProjetoUiState

/**
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
class PerfilLoad {

    var usuarioResposta by mutableStateOf(PerfilUiState())
        private set

    @Composable
    fun carregarPerfilWeb(webservice: WebClient = WebClient()): PerfilUiState{
       val usuarioEncontrado = webservice.perfilJackson().collectAsState(initial = null).value?.toPefilUiState()
       usuarioEncontrado?.let {
            val projetosEncontrados = webservice.projetosJackson()
                                        .collectAsState(initial = null).value?.map { it.toProjetoUiState() }
            usuarioResposta = usuarioEncontrado.copy(projetos = projetosEncontrados?: emptyList())
       }

        return usuarioResposta
    }
}