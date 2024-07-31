package com.devspacecinenow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
 fun MovieDetailScreen() {
    
}

@Composable
private fun MovieDetailContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Description")
    }
    
}

@Preview(showBackground = true)
@Composable
fun MovieDetailPreview() {
    
}