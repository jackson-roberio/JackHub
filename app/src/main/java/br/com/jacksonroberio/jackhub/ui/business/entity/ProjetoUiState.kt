package br.com.jacksonroberio.jackhub.ui.business.entity

/**
 * Adaptador da entidade Projeto.kt, apenas para facilitar
 * o consumo dos dados da entidade populada em REST.
 *
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
data class ProjetoUiState (val nome: String = "",
                        val descricao: String = "")