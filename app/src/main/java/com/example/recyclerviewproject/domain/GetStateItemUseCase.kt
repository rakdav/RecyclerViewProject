package com.example.recyclerviewproject.domain

class GetStateItemUseCase(private val stateListRepository: StateListRepository)
{
    fun getStateItem(stateItemId:Int):State{
        return stateListRepository.getStateItem(stateItemId)
    }
}