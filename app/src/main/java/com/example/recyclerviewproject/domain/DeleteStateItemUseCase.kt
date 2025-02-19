package com.example.recyclerviewproject.domain

class DeleteStateItemUseCase(private val stateListRepository: StateListRepository) {
    fun deleteStateItem(stateItem:State){
        stateListRepository.deleteStateItem(stateItem)
    }
}