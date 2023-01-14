import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.masterthesis.shared.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
