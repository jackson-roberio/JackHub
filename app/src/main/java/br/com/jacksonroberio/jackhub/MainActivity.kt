package br.com.jacksonroberio.jackhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import br.com.jacksonroberio.jackhub.ui.business.PerfilLoad
import br.com.jacksonroberio.jackhub.ui.business.entity.PerfilUiState
import br.com.jacksonroberio.jackhub.ui.screen.Layout
import br.com.jacksonroberio.jackhub.ui.theme.JackHubTheme
import br.com.jacksonroberio.jackhub.webclient.rest.WebClient
import br.com.jacksonroberio.jackhub.webclient.rest.entity.Perfil
import br.com.jacksonroberio.jackhub.webclient.rest.entity.toPefilUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Única tela do aplicativo a qual carregará todos os dados de acordo
 * com informações obtidas do pacote ui.
 *
 * @author Jackson Roberio - https:jacksonroberio.com.br
 **/
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JackHubTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background) {
                    Layout(PerfilLoad())
                }
            }
        }
    }
}


