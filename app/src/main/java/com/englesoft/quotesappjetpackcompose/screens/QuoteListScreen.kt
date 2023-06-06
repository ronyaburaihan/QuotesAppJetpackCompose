package com.englesoft.quotesappjetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.englesoft.quotesappjetpackcompose.model.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column {
        Text(
            text = "Quote Application",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth()
        )
        LazyColumn(content = {
            items(data) {
                QuoteItem(quote = it, onClick = onClick)
            }
        })
    }
}