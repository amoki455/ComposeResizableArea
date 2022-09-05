import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val text = remember {
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s " +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
    }
    MaterialTheme {
        var height by remember { mutableStateOf(Dp.Unspecified) }
        BoxWithConstraints(
            modifier = Modifier.background(Color(0xff323950))
        ) {
            val boxMaxWidth = maxWidth
            ResizableArea(
                modifier = Modifier.heightIn(maxHeight / 4, Dp.Unspecified)
                    .height(height),
                onRequestNewHeight = {
                    height = it
                },
                dragAreaColor = Color.Red.copy(alpha = 0.2f)
            ) {
                Row {
                    var width by remember { mutableStateOf(600.dp) }
                    ResizableArea(
                        modifier = Modifier.widthIn(boxMaxWidth / 4, boxMaxWidth - boxMaxWidth / 3)
                            .width(width)
                            .fillMaxHeight()
                            .background(Color.Gray),
                        onRequestNewWidth = {
                            width = it
                        }
                    ) {
                        Box {
                            Text(
                                text = text,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = text,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
