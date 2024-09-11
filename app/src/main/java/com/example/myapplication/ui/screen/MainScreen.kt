package com.example.myapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
    onButtonClick2: () -> Unit,
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            Text(
                text = "Florian TELLIER",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(text = "Application de suivie des scéances de musculation", textAlign = TextAlign.Center)
            Button(
                modifier = Modifier.fillMaxWidth(),
                content = { Text("Voir mes séances") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                onClick = { onButtonClick() }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                content = { Text("Voir carte YuGiOh !") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                onClick = { onButtonClick2() }
            )
        }
        val painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data = "https://images.unsplash.com/photo-1516481265257-97e5f4bc50d5?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .build()
        )
        Image(
            modifier = Modifier.size(400.dp),
            painter = painter,
            contentDescription = "Image d'illustration d'une salle de sport",
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MainScreen({}, {})
    }
}