package com.example.myapplication.data.repository

import com.example.myapplication.architecture.CustomApplication
import com.example.myapplication.data.model.MusculationEntity
import com.example.myapplication.data.model.toRoomObject
import com.example.myapplication.data.model.toUi
import com.example.myapplication.ui.model.ItemUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MusculationRepository {
    private val musculationDao =
        CustomApplication.instance.mApplicationDatabase.musculationDao()


    fun selectAllMusculation(): Flow<List<ItemUi.Item>> {
        return musculationDao.selectAll().map {
            it.toUi()
        }
    }


    fun insertmMsculation(androidObject: ItemUi.Item) {
        musculationDao.insert(androidObject.toRoomObject())
    }


    fun deleteAllMusculation() {
        musculationDao.deleteAll()
    }


//    fun populateMusculationListData(): List<MusculationEntity> {
//        return listOf(
//            MusculationEntity(exerciseName = "Développé couché", recoveryTime = "1 min", totalNumberOfRepetation = 10),
//            MusculationEntity(exerciseName = "Squat", recoveryTime = "2 min", totalNumberOfRepetation = 12),
//            MusculationEntity(exerciseName = "Soulevé de terre", recoveryTime = "1 min 30", totalNumberOfRepetation = 8),
//            MusculationEntity(exerciseName = "Curl biceps", recoveryTime = "1 min", totalNumberOfRepetation = 15),
//            MusculationEntity(exerciseName = "Développé militaire", recoveryTime = "1 min", totalNumberOfRepetation = 12),
//            MusculationEntity(exerciseName = "Traction", recoveryTime = "2 min", totalNumberOfRepetation = 10),
//            MusculationEntity(exerciseName = "Dips", recoveryTime = "1 min", totalNumberOfRepetation = 15),
//            MusculationEntity(exerciseName = "Leg press", recoveryTime = "2 min", totalNumberOfRepetation = 10),
//            MusculationEntity(exerciseName = "Développé couché", recoveryTime = "2 min 15", totalNumberOfRepetation = 5),
//            MusculationEntity(exerciseName = "Squat", recoveryTime = "2 min", totalNumberOfRepetation = 12),
//            MusculationEntity(exerciseName = "Soulevé de terre", recoveryTime = "3 min 30", totalNumberOfRepetation = 3),
//            MusculationEntity(exerciseName = "Curl biceps", recoveryTime = "2 min", totalNumberOfRepetation = 17),
//            MusculationEntity(exerciseName = "Développé militaire", recoveryTime = "1 min 15", totalNumberOfRepetation = 12),
//            MusculationEntity(exerciseName = "Développé couché", recoveryTime = "2 min 25", totalNumberOfRepetation = 3),
//            MusculationEntity(exerciseName = "Développé couché", recoveryTime = "2 min 5", totalNumberOfRepetation = 4),
//            MusculationEntity(exerciseName = "Traction", recoveryTime = "2 min", totalNumberOfRepetation = 10),
//            MusculationEntity(exerciseName = "Dips", recoveryTime = "1 min 20", totalNumberOfRepetation = 16),
//            MusculationEntity(exerciseName = "Leg press", recoveryTime = "3 min", totalNumberOfRepetation = 20)
//        )
//    }
}