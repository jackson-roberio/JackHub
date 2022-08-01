package br.com.jacksonroberio.jackhub.webclient.rest

import br.com.jacksonroberio.jackhub.webclient.rest.service.UsuarioService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Classe de configuração chave para realização das consultas da API do Git.
 *
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
class RetrofitConfig {
    private val retrofit: Retrofit = Retrofit.Builder()
                                        .baseUrl("https://api.github.com/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()

    val usuarioService = retrofit.create(UsuarioService::class.java)

}