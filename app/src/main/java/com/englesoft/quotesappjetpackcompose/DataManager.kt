package com.englesoft.quotesappjetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.englesoft.quotesappjetpackcompose.model.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LIST_PAGE)
    var selectedQuote: Quote? = null

    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)

        isDataLoaded.value = true
    }

    fun switchPage() {
        if (currentPage.value == Pages.LIST_PAGE) {
            currentPage.value = Pages.DETAIL_PAGE
        } else {
            currentPage.value = Pages.LIST_PAGE
        }
    }
}
