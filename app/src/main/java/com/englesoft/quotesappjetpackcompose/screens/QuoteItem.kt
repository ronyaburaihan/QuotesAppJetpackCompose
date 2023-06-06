package com.englesoft.quotesappjetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.englesoft.quotesappjetpackcompose.R
import com.englesoft.quotesappjetpackcompose.model.Quote

@Composable
fun QuoteItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(quote)
            }

    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription = "Quote Image",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .clip(shape = RoundedCornerShape(8))
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth(0.4f)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}