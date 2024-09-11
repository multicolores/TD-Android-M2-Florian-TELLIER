package com.example.myapplication.data.repository

import com.example.myapplication.architecture.CustomApplication
import com.example.myapplication.architecture.RetrofitBuilder
import com.example.myapplication.data.model.toRoom
import com.example.myapplication.ui.model.YuGiOhObject
import com.example.myapplication.ui.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class YuGiOhRepository {
    private val yuGiOhDao = CustomApplication.instance.mApplicationDatabase.yuGiOhDao()

    suspend fun fetchData() {
        yuGiOhDao.insert(RetrofitBuilder.getYuGiOhCard().getRandomCard().toRoom())
    }

    fun deleteAll() {
        yuGiOhDao.deleteAll()
    }

    fun selectAll(): Flow<List<YuGiOhObject>> {
        return yuGiOhDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
