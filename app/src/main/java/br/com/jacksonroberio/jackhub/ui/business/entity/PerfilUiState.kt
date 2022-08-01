package br.com.jacksonroberio.jackhub.ui.business.entity

/**
 * Classe responsável por adatar os retornos das consultas
 * do objeto WebClient.kt e adaptar as entidades Perfil.kt e Projetos.kt.
 *
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
data class PerfilUiState(
    val login: String = "",
    val imagem: String = "",
    val nome: String = "",
    val bio: String = "",
    val projetos: List<ProjetoUiState> = emptyList())
