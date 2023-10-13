package cl.solisg.deliverycalculator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import cl.solisg.deliverycalculator.ui.theme.DeliveryCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GradosARadianesConverter()
                }
            }
        }
    }
}

@Composable
fun GradosARadianesConverter() {
    var gradosText by remember { mutableStateOf(TextFieldValue("0")) }
    var radianesText by remember { mutableStateOf("") }

    BasicTextField(
        value = gradosText.text,
        onValueChange = {
            gradosText = TextFieldValue(text = it)
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = {
            val grados = gradosText.text.toDoubleOrNull() ?: 0.0
            val radianes = grados * PI / 180.0
            radianesText = radianes.toString()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text("Convertir a Radianes")
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text("Resultado en Radianes: $radianesText")
}
