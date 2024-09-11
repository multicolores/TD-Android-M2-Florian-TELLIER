package com.example.myapplication.data.repository

import com.example.myapplication.data.model.MusculationObject

class MusculationRepository {
     fun populateMusculationListData(): List<MusculationObject> {
        return listOf(
            MusculationObject(exerciseName = "Développé couché", recoveryTime = "1 min", totalNumberOfRepetation = 10),
            MusculationObject(exerciseName = "Squat", recoveryTime = "2 min", totalNumberOfRepetation = 12),
            MusculationObject(exerciseName = "Soulevé de terre", recoveryTime = "1 min 30", totalNumberOfRepetation = 8),
            MusculationObject(exerciseName = "Curl biceps", recoveryTime = "1 min", totalNumberOfRepetation = 15),
            MusculationObject(exerciseName = "Développé militaire", recoveryTime = "1 min", totalNumberOfRepetation = 12),
            MusculationObject(exerciseName = "Traction", recoveryTime = "2 min", totalNumberOfRepetation = 10),
            MusculationObject(exerciseName = "Dips", recoveryTime = "1 min", totalNumberOfRepetation = 15),
            MusculationObject(exerciseName = "Leg press", recoveryTime = "2 min", totalNumberOfRepetation = 10),
            MusculationObject(exerciseName = "Développé couché", recoveryTime = "2 min 15", totalNumberOfRepetation = 5),
            MusculationObject(exerciseName = "Squat", recoveryTime = "2 min", totalNumberOfRepetation = 12),
            MusculationObject(exerciseName = "Soulevé de terre", recoveryTime = "3 min 30", totalNumberOfRepetation = 3),
            MusculationObject(exerciseName = "Curl biceps", recoveryTime = "2 min", totalNumberOfRepetation = 17),
            MusculationObject(exerciseName = "Développé militaire", recoveryTime = "1 min 15", totalNumberOfRepetation = 12),
            MusculationObject(exerciseName = "Développé couché", recoveryTime = "2 min 25", totalNumberOfRepetation = 3),
            MusculationObject(exerciseName = "Développé couché", recoveryTime = "2 min 5", totalNumberOfRepetation = 4),
            MusculationObject(exerciseName = "Traction", recoveryTime = "2 min", totalNumberOfRepetation = 10),
            MusculationObject(exerciseName = "Dips", recoveryTime = "1 min 20", totalNumberOfRepetation = 16),
            MusculationObject(exerciseName = "Leg press", recoveryTime = "3 min", totalNumberOfRepetation = 20)
        )
    }
}