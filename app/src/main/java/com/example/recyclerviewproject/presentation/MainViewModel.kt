package com.example.recyclerviewproject.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewproject.data.StateListRepositoryImpl
import com.example.recyclerviewproject.domain.DeleteStateItemUseCase
import com.example.recyclerviewproject.domain.EditStateItemUseCase
import com.example.recyclerviewproject.domain.GetStateListUseCase
import com.example.recyclerviewproject.domain.State

class MainViewModel:ViewModel() {
    private val repository=StateListRepositoryImpl
    private val getStateListUseCase=GetStateListUseCase(repository)
    private val deleteStateItemUseCase=DeleteStateItemUseCase(repository)
    private val editStateItemUseCase=EditStateItemUseCase(repository)

    val stateList=getStateListUseCase.getStateList()

    fun deleteStateItem(state: State){
        deleteStateItemUseCase.deleteStateItem(state)
    }
    fun changeState(state: State){
        editStateItemUseCase.editStateItem(state)
    }
}