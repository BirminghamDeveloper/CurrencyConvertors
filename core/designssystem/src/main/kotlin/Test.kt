import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Test() {
    Text(text = "hello")
}

@Preview
@Composable
private fun TestPreview() {
    Test()
}