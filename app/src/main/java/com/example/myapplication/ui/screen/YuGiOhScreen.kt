package com.example.myapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.ui.viewModel.YuGiOhViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YuGiOhScreen(navController: NavController,) {
    val viewModel: YuGiOhViewModel = viewModel()
    val list = viewModel.card.collectAsState(emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cartes YuGiOh") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { viewModel.insertNewCard() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                ) {
                    Text("Add")
                }
                Button(
                    onClick = { viewModel.deleteAllCards() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                ) {
                    Text("Delete")
                }
            }
        }

    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(top=70.dp, bottom=70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(list) { item ->
                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = item.url)
                        .build()
                )
                Image(
                    modifier = Modifier.size(300.dp),
                    painter = painter,
                    contentDescription = "Image d'une carte YUGIOH !!",
                )

                Text(
                    text = "${item.title}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Text(
                    text = "Type:  ${item.type}",
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

            }
//            item {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 16.dp),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Button(
//                        onClick = { viewModel.insertNewCard() },
//                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
//                    ) {
//                        Text("Add")
//                    }
//                    Button(
//                        onClick = { viewModel.deleteAllCards() },
//                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//                    ) {
//                        Text("Delete")
//                    }
//                }
//            }
        }
    }
}
