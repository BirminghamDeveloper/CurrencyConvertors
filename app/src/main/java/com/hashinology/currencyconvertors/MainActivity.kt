package com.hashinology.currencyconvertors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.hashinology.currencyconvertors.ui.theme.CurrencyConvertorsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import service.CurrencyService
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var currencyService: CurrencyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            currencyService.getExchangeRates().also {
                println("testing200: $it")
            }
        }

        enableEdgeToEdge()
        setContent {
            CurrencyConvertorsTheme {
                Scaffold {
                    Text(
                        text = "Hello World!",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    )
                }
            }
        }
    }
}
