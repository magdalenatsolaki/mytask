import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.masterthesis.common.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
