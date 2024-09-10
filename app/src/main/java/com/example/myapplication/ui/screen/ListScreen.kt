package com.example.myapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.ui.model.ItemUi
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Récapitulatif de scéance") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
            MusculationWorkoutList(modifier = Modifier.padding(padding))
    }
}

private fun populateMusculationListData(): List<ItemUi.MusculationObject> {
    return listOf(
        ItemUi.MusculationObject(exerciseName = "Développé couché", recoveryTime = "1 min", totalNumberOfRepetation = 10),
        ItemUi.MusculationObject(exerciseName = "Squat", recoveryTime = "2 min", totalNumberOfRepetation = 12),
        ItemUi.MusculationObject(exerciseName = "Soulevé de terre", recoveryTime = "1 min 30", totalNumberOfRepetation = 8),
        ItemUi.MusculationObject(exerciseName = "Curl biceps", recoveryTime = "1 min", totalNumberOfRepetation = 15),
        ItemUi.MusculationObject(exerciseName = "Développé militaire", recoveryTime = "1 min", totalNumberOfRepetation = 12),
        ItemUi.MusculationObject(exerciseName = "Traction", recoveryTime = "2 min", totalNumberOfRepetation = 10),
        ItemUi.MusculationObject(exerciseName = "Dips", recoveryTime = "1 min", totalNumberOfRepetation = 15),
        ItemUi.MusculationObject(exerciseName = "Leg press", recoveryTime = "2 min", totalNumberOfRepetation = 10),
        ItemUi.MusculationObject(exerciseName = "Développé couché", recoveryTime = "2 min 15", totalNumberOfRepetation = 5),
        ItemUi.MusculationObject(exerciseName = "Squat", recoveryTime = "2 min", totalNumberOfRepetation = 12),
        ItemUi.MusculationObject(exerciseName = "Soulevé de terre", recoveryTime = "3 min 30", totalNumberOfRepetation = 3),
        ItemUi.MusculationObject(exerciseName = "Curl biceps", recoveryTime = "2 min", totalNumberOfRepetation = 17),
        ItemUi.MusculationObject(exerciseName = "Développé militaire", recoveryTime = "1 min 15", totalNumberOfRepetation = 12),
        ItemUi.MusculationObject(exerciseName = "Développé couché", recoveryTime = "2 min 25", totalNumberOfRepetation = 3),
        ItemUi.MusculationObject(exerciseName = "Développé couché", recoveryTime = "2 min 5", totalNumberOfRepetation = 4),
        ItemUi.MusculationObject(exerciseName = "Traction", recoveryTime = "2 min", totalNumberOfRepetation = 10),
        ItemUi.MusculationObject(exerciseName = "Dips", recoveryTime = "1 min 20", totalNumberOfRepetation = 16),
        ItemUi.MusculationObject(exerciseName = "Leg press", recoveryTime = "3 min", totalNumberOfRepetation = 20)

    )
}

@Composable
private fun MusculationWorkoutList(modifier: Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        val listOfResult: MutableList<ItemUi> = mutableListOf()

        populateMusculationListData().groupBy { musculationObject ->
            musculationObject.exerciseName
        }
            .forEach { element ->
                listOfResult.add(
                    ItemUi.Header(
                        title = element.key,
                    )
                )
                listOfResult.addAll(
                    element.value
                )
                listOfResult.add(
                    ItemUi.Footer(
                        numberOfSet = element.value.size,
                    ))
            }
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(listOfResult) { eachItem ->
                when (eachItem) {
                    is ItemUi.Header ->
                        OutlinedCard(
                            modifier = Modifier.fillParentMaxWidth().then(Modifier.padding(top = 35.dp)),
                            colors = CardDefaults.cardColors().copy(containerColor = Color.Black)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = eachItem.title,
                                    style = MaterialTheme.typography.displaySmall,
                                    color = Color.White,
                                )
                            }
                        }

                    is ItemUi.MusculationObject -> Text(
                        text = "${eachItem.totalNumberOfRepetation} reps - RecoveryTime: ${eachItem.recoveryTime}",
                        style = MaterialTheme.typography.titleSmall,
                    )

                    is ItemUi.Footer ->
                    OutlinedCard(
                        colors = CardDefaults.cardColors().copy(containerColor = Color.DarkGray)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Nombre total de set: ${eachItem.numberOfSet}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White,
                            )
                        }
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListScreenPreview() {
    MyApplicationTheme {
         val navController = rememberNavController()

        ListScreen(navController)
    }
}