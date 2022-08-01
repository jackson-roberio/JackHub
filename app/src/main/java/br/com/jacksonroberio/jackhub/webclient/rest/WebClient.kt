package br.com.jacksonroberio.jackhub.webclient.rest

import kotlinx.coroutines.flow.flow

/**
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
class WebClient(private val retrofitConfig: RetrofitConfig = RetrofitConfig()) {


    fun perfilJackson() = flow {
        emit(retrofitConfig.usuarioService.buscarPerfilJackson())
    }

    fun projetosJackson() = flow {
        emit(retrofitConfig.usuarioService.buscarRepositorioPerfilJackson())
    }
}