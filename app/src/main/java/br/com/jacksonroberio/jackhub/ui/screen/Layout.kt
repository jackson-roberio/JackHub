package br.com.jacksonroberio.jackhub.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jacksonroberio.jackhub.ui.business.PerfilLoad
import coil.compose.AsyncImage
import br.com.jacksonroberio.jackhub.R
import br.com.jacksonroberio.jackhub.ui.business.entity.PerfilUiState
import br.com.jacksonroberio.jackhub.ui.business.entity.ProjetoUiState


@Composable
fun Layout(service: PerfilLoad = PerfilLoad()) {
        Layout(service.carregarPerfilWeb())
}

@Preview(showBackground = true)
@Composable
fun Layout(perfil: PerfilUiState = PerfilUiState()){
    LazyColumn {
        item {
            DadosPessoaisLayout(perfil)
        }

        item {
            perfil.projetos.isNotEmpty().let {
                Text(text = "Projetos", Modifier.padding(8.dp), fontSize = 24.sp)
            }
        }

        items(perfil.projetos) {
            project -> ProjetoItemLayout(project)
        }
    }
}

@Composable
private fun ProjetoItemLayout(projeto: ProjetoUiState = ProjetoUiState()){
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            Text(
                projeto.nome,
                Modifier.fillMaxWidth()
                    .background(Color(0xFF2d333b))
                    .padding(8.dp),
                    fontSize = 24.sp,
                    color = Color.White
            )

            projeto.descricao.isNotBlank().let {
                Text(projeto.descricao, Modifier.padding(8.dp).fillMaxWidth())
            }
        }
    }
}

/**
 * Parte superior e primária da aplicação, mostra a imagem do usuário, assim como também, sua BIO,
 * login e nome de exibiçaõ.
 **/
@Composable
private fun DadosPessoaisLayout(perfil: PerfilUiState = PerfilUiState()){
    Column {
        val boxHeight = remember { 150.dp }
        val imageHeight = remember { boxHeight }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(boxHeight)
                .background(Color(R.color.cinza_background), shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
        ) {

            AsyncImage(
                model = perfil.imagem,
                contentDescription = "${perfil.nome} Perfil Online",
                Modifier.offset(y = imageHeight / 2).clip(CircleShape).align(Alignment.BottomCenter).size(imageHeight),
                placeholder = painterResource(id = R.drawable.jackson_roberio_bracos_cruzado_e_terno_400x400)
            )
        }
        Spacer(modifier = Modifier.height(imageHeight / 2))

        Column(Modifier.padding(8.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = perfil.nome , fontSize = 32.sp)
            Text(text = perfil.login , fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = perfil.bio,
                    Modifier.padding(start = 8.dp, bottom = 8.dp, end = 8.dp).fillMaxWidth(),
                    textAlign = TextAlign.Center)
        }
    }
}

//TODO: Aplicar a lógica da página de erro para carregamentos que extrapolem as conexões free
@Composable
private fun LayoutErro(){

}