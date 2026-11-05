package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper

@Composable
fun EucharisticAdorationScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val userPrefs = remember { UserPreferences(context) }
  val fontSize = (userPrefs.getFontSize() * 16).toInt()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  val comunionEspiritual = "Creo, Jesús mío, que estás real y verdaderamente presente en el Santísimo Sacramento del Altar. Te amo sobre todas las cosas y deseo vivamente recibirte dentro de mi alma; pero no pudiendo hacerlo ahora sacramentalmente, ven al menos espiritualmente a mi corazón. Y como si ya te hubiese recibido, me abrazo y me uno del todo a Ti; no permitas, Señor, que jamás me separe de Ti. Amén."

  fun speakComunion() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      ttsHelper.speak("Acto de Comunión Espiritual de San Alfonso María de Ligorio. $comunionEspiritual")
      isSpeaking = true
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(8.dp))

    // Header Card
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      shape = RoundedCornerShape(18.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = "Adoración y Comunión Espiritual",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = WinePrimary
          )
          Text(
            text = "Presencia Real de Cristo en el Sagrario",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        IconButton(
          onClick = { speakComunion() },
          modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
        ) {
          Icon(
            imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
            contentDescription = "Escuchar Comunión Espiritual",
            tint = WinePrimary
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .widthIn(max = 600.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      // Comunión Espiritual Hero Card
      item {
        ElevatedCard(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("🍞", fontSize = 22.sp)
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Comunión Espiritual",
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  ),
                  color = WinePrimary
                )
                Text(
                  text = "San Alfonso María de Ligorio",
                  style = MaterialTheme.typography.labelSmall,
                  color = GoldSecondary,
                  fontWeight = FontWeight.SemiBold
                )
              }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = comunionEspiritual,
              style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = FontFamily.Serif,
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.5).sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
              shape = RoundedCornerShape(8.dp),
              color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
              modifier = Modifier.fillMaxWidth()
            ) {
              Text(
                text = "«El acto de comunión espiritual produce en el alma frutos de gracia semejantes a los de la comunión sacramental, según la disposición interior y el fervor de quien la hace».",
                style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(10.dp)
              )
            }
          }
        }
      }

      // Visita al Santísimo Sacramento
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Alabanza Inicial ante el Sagrario",
              style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
              color = WinePrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "V/. Alabado sea el Santísimo Sacramento del Altar.\nR/. Y la limpia e Inmaculada Concepción de la Virgen María, Madre de Dios y Señora nuestra.\n\n(Se repite tres veces con devoción e inclinación de cabeza).",
              style = MaterialTheme.typography.bodyLarge.copy(fontSize = fontSize.sp, lineHeight = (fontSize * 1.45).sp),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }

      // Adoro Te Devote (Santo Tomás de Aquino)
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Adoro Te Devote (Te adoro con devoción)",
              style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
              color = GoldSecondary
            )
            Text(
              text = "Santo Tomás de Aquino, Doctor Angélico",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = "Te adoro con devoción, Dios escondido, oculto verdaderamente bajo estas especies.\nA ti se somete mi corazón por entero, y al contemplarte se rinde totalmente.\n\nAl juzgar de ti se equivocan la vista, el tacto, el gusto; pero basta el oído para creer firmemente;\ncreo todo lo que ha dicho el Hijo de Dios: nada hay más verdadero que esta palabra de verdad.\n\nEn la Cruz se escondía sólo la Divinidad, pero aquí se esconde también la Humanidad;\ncreo y confieso ambas cosas, y pido lo que pidió aquel ladrón arrepentido.\n\nNo veo las llagas como las vio Tomás, pero confieso con él que eres mi Dios;\nhaz que yo crea más y más en ti, que en ti espere y que te ame.\n\n¡Oh memorial de la muerte del Señor! Pan vivo que das la vida al hombre:\nconcede a mi alma que de ti viva, y que siempre saboree tu dulzura.\n\nJesús, a quien ahora veo oculto, te ruego que se cumpla lo que tanto ansío:\nque al contemplarte cara a cara, sea eternamente dichoso con la visión de tu gloria. Amén.",
              style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = FontFamily.Serif,
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.45).sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }

      // Acto de Desagravio al Sagrado Corazón
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Acto de Reparación y Desagravio",
              style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
              color = WinePrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "¡Oh Corazón amabilísimo de Jesús, tan poco amado y tan olvidado de los hombres! En reparación por nuestras ingratitudes, frialdades e indiferencias ante el Sagrario, te ofrecemos nuestro amor sincero, nuestras oraciones y el deseo ardiente de consolarte. Haz que vivamos siempre unidos a Ti. Sagrado Corazón de Jesús, en Ti confío.",
              style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.4).sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }

      item { Spacer(modifier = Modifier.height(24.dp)) }
    }
  }
}
