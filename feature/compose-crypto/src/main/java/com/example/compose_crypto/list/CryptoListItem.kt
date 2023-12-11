package com.example.compose_crypto.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Coin

@Composable
fun CryptoListItem(
    modifier: Modifier = Modifier,
    model: Coin,
    onClicked: (Coin) -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClicked(model) },
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = model.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = model.symbol)
        }
    }
}
