package com.example.recyclerviewproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.domain.State
import com.example.recyclerviewproject.domain.StateListRepository

object StateListRepositoryImpl:StateListRepository {
    private val stateList= sortedSetOf<State>({o1,o2->o1.id.compareTo(o2.id)})
    private val stateListID=MutableLiveData<List<State>>()
    init {
        for(i in 1 until 10){
            val item=State(i,"State $i","Capital $i",R.drawable.russia)
            addStateItem(item)
        }
    }
    override fun addStateItem(stateItem: State) {
        stateList.add(stateItem)
        updateList()
    }
    override fun deleteStateItem(stateItem: State) {
        stateList.remove(stateItem)
        updateList()
    }
    override fun editStateItem(stateItem: State) {
        val oldState= getStateItem(stateItem.id)
        stateList.remove(oldState)
        addStateItem(stateItem)
    }
    override fun getStateItem(stateItemId: Int): State {
        return stateList.find {
            it.id==stateItemId
        }?:throw RuntimeException("Element not found")
    }
    override fun getStateList(): LiveData<List<State>> {
        return stateListID
    }
    private fun updateList(){
        stateListID.value= stateList.toList()
    }
}