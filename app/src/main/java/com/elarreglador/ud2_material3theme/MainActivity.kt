package com.elarreglador.ud2_material3theme

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.ColorFilter
import com.elarreglador.ud2_material3theme.ui.theme.WonderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WonderTheme {
                WidgetsDemo()
            }
        }
    }
}

@Composable
fun WidgetsDemo() {
    // Estado para cada widget
    var name by remember { mutableStateOf("David") }
    var isChecked by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    var colored by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        // Text
        Text(text = "Widgets comunes en Jetpack Compose",
            fontSize = 24.sp)

        // Separacion
        Spacer(modifier = Modifier.height(36.dp))

        // TextField
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
        )

        // Separacion
        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
            )
            Text(text = "${name} acepta los términos y condiciones: $isChecked")
        }

        // Separacion
        Spacer(modifier = Modifier.height(16.dp))

        // Slider
        Text(text = "Nivel de satisfacción: ${(sliderValue*10).toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..1f,
            steps = 9 // 0 a 10
        )

        Row {
            Image(
                painter = painterResource(id = android.R.drawable.ic_dialog_info),
                contentDescription = "Ícono de información",
                modifier = Modifier.size(120.dp),
                colorFilter =
                    if (colored) ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                    else ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(id = android.R.drawable.ic_dialog_info),
                contentDescription = "Ícono de información",
                modifier = Modifier.size(120.dp),
                colorFilter =
                    if (colored) ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    else ColorFilter.tint(MaterialTheme.colorScheme.secondary)
            )
        }

        // Button
        Button(onClick = {colored = !colored}) {
            Text("Alternar colores")
        }

    }
}

@Preview(
    showSystemUi = true ,
    device = "id:pixel_4",
    name = "Tema claro",
    uiMode = Configuration.UI_MODE_NIGHT_NO    )
@Preview(
    showSystemUi = true ,
    device = "id:pixel_4",
    name = "Tema oscuro",
    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    WonderTheme () {
        WidgetsDemo()
    }
}