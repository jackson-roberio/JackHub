package br.com.jacksonroberio.jackhub.webclient.rest.service

import br.com.jacksonroberio.jackhub.webclient.rest.entity.Perfil
import br.com.jacksonroberio.jackhub.webclient.rest.entity.Projeto
import retrofit2.http.GET


/**
 * Interface que vai prover serviços do domínio "https://api.github.com/",
 * tendo cada um dos seus métodos um endpoint específico.
 *
 * @author Jackson Roberio - https://jacksonroberio.com.br
 **/
interface UsuarioService {

    /**
     * https://api.github.com/users/jackson-roberio
     **/
    @GET("/users/jackson-roberio")
    suspend fun buscarPerfilJackson(): Perfil


    /**
     * https://api.github.com/users/jackson-roberio/repos
     **/
    @GET("/users/jackson-roberio/repos")
    suspend fun buscarRepositorioPerfilJackson(): List<Projeto>

}