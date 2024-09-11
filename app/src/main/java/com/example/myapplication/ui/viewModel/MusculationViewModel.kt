package com.example.myapplication.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.MusculationRepository
import com.example.myapplication.ui.model.ItemUi
import com.example.myapplication.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MusculationViewModel : ViewModel() {
    // Variable mutable en privée signifie que personne peut modifier le contenu à part le ViewModel
    // lui même. C'est un pattern important à respecter
    private val _musculationList = MutableStateFlow<List<ItemUi>>(emptyList())

    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val musculationList: StateFlow<List<ItemUi>> get() = _musculationList.asStateFlow()

    private val musculationRepository: MusculationRepository by lazy { MusculationRepository() }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // On exécute dans un petit thread dédié à Input/Output le fait de générer la liste
            _musculationList.emit(populateMusculationListData())
        }
    }

    private fun populateMusculationListData(): List<ItemUi> {
        val result = mutableListOf<ItemUi>()
        musculationRepository.populateMusculationListData().groupBy { myAndroidObject ->
            myAndroidObject.exerciseName
        }
            .forEach { element ->
                result.add(
                    ItemUi.Header(
                        title = element.key,
                    )
                )
                result.addAll(
                    element.value.toUi()
                )
                result.add(
                    ItemUi.Footer(
                        numberOfSet = element.value.size,
                    ))
            }
        return result
    }

}

