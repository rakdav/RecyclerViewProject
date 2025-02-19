package com.example.recyclerviewproject.domain

import androidx.lifecycle.LiveData

interface StateListRepository {
    fun addStateItem(stateItem:State)
    fun deleteStateItem(stateItem:State)
    fun editStateItem(stateItem:State)
    fun getStateItem(stateItemId:Int):State
    fun getStateList():LiveData<List<State>>
}