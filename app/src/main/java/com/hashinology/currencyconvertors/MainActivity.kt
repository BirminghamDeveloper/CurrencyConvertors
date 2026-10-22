package com.hashinology.currencyconvertors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mc.designssystem.components.MCTextMenu
import com.mc.designssystem.theme.CurrencyConvertorsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CurrencyConvertorsTheme(
                dynamicColor = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground
                ) {
                    Box(
                        modifier = Modifier
                            .statusBarsPadding()
                            .padding(24.dp)
                    ) {
                        MCTextMenu(
                            selectedOption = "USD",
                            options = listOf(
                                "USD",
                                "EUR",
                                "GBP",
                                "JPY",
                                "AUD"
                            ),
                            onOptionSelected = { index ->
                                println("Selected index: $index")
                            }
                        )
                    }
                }
            }
        }
    }
}
