package com.englesoft.quotesappjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.englesoft.quotesappjetpackcompose.screens.QuoteDetails
import com.englesoft.quotesappjetpackcompose.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile(applicationContext)
        }

        setContent {
            if (DataManager.isDataLoaded.value) {
                if (DataManager.currentPage.value == Pages.LIST_PAGE) {
                    QuoteListScreen(data = DataManager.data) {
                        DataManager.selectedQuote = it
                        DataManager.switchPage()
                    }
                } else {
                    DataManager.selectedQuote?.let {
                        QuoteDetails(quote = it)
                    }
                }
            } else {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

enum class Pages {
    LIST_PAGE,
    DETAIL_PAGE
}