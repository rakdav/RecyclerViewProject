package com.example.recyclerviewproject.domain

class AddStateItemUseCase(private val stateListRepository: StateListRepository) {
    fun addStateItem(stateItem:State){
        stateListRepository.addStateItem(stateItem)
    }
}