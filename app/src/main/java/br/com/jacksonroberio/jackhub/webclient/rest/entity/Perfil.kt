package br.com.jacksonroberio.jackhub.webclient.rest.entity

import br.com.jacksonroberio.jackhub.ui.business.entity.PerfilUiState

/**
 * Os parâmetro login e name, podem ser nulos devido o retorno
 * das consultas na API do git, que permitem esses dados vierem
 * nulo em determinada situação.
 *
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
data class Perfil(
    var avatar_url: String = "",
    val name: String? = "",
    val login: String? = "",
    val bio: String = ""
)
/**
 * Conversor para uma entidade mais amigável, a qual exibirá as informações na tela.
 * Foi feito dessa forma, pois, é feito duas consultas e juntado os dados da consulta
 * em um único objeto, o PerfilUiState
 **/
fun Perfil.toPefilUiState(): PerfilUiState {
    return PerfilUiState(login = this.login?: "",
                            bio = this.bio,
                            imagem =  this.avatar_url,
                            nome = this.name?: "")
}


