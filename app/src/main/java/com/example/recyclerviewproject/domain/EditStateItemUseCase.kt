package com.example.recyclerviewproject.domain

class EditStateItemUseCase(private val stateListRepository: StateListRepository) {
    fun editStateItem(stateItem:State){
        stateListRepository.editStateItem(stateItem)
    }
}