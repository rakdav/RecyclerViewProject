package com.example.recyclerviewproject.domain

import androidx.lifecycle.LiveData

class GetStateListUseCase(private val stateListRepository: StateListRepository)
{
    fun getStateList():LiveData<List<State>>{
        return stateListRepository.getStateList()
    }
}