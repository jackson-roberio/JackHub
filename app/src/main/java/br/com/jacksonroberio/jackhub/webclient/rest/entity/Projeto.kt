package br.com.jacksonroberio.jackhub.webclient.rest.entity

import br.com.jacksonroberio.jackhub.ui.business.entity.ProjetoUiState

/**
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
data class Projeto (val name: String = "",
               val description: String? = null)

fun Projeto.toProjetoUiState() = ProjetoUiState(nome = name, descricao = description?: "")