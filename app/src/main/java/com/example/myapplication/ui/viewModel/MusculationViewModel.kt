package com.example.myapplication.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.MusculationRepository
import com.example.myapplication.ui.model.ItemUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random


class MusculationViewModel : ViewModel() {
    // Variable mutable en privée signifie que personne peut modifier le contenu à part le ViewModel
    // lui même. C'est un pattern important à respecter
    private val _musculationList: Flow<List<ItemUi>>
        get() = musculationRepository.selectAllMusculation().map { musculationObjectEntities ->
            musculationObjectEntities.groupBy { musculationObjectEntity ->
                musculationObjectEntity.exerciseName
            }.flatMap {
                buildList {
                    add(
                        ItemUi.Header(
                            title = it.key,
                        )
                    )
                    addAll(it.value)

                    add(
                        ItemUi.Footer(
                            numberOfSet = it.value.size,
                        )
                    )
                }
            }
        }


    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val musculationList: Flow<List<ItemUi>> get() = _musculationList

    private val musculationRepository: MusculationRepository by lazy { MusculationRepository() }

    fun insertAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)
            musculationRepository.insertmMsculation(
                ItemUi.Item("exercise $random", "$random min", random)
            )
        }
    }

    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            musculationRepository.deleteAllMusculation()
        }
    }
}
