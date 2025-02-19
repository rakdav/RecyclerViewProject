package com.example.recyclerviewproject.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.example.recyclerviewproject.domain.State

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var stateListAdapter:StateAdapter
    private lateinit var linearLayoutManager:LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager= LinearLayoutManager(this)
        setupRecyclerView()
        viewModel= ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.stateList.observe(this){
           stateListAdapter.submitList(it)
        }
        binding.fab.setOnClickListener {
            val intent=StateItemActivity.newIntentAddItem(this)
            startActivity(intent)
        }
    }
    private fun setupRecyclerView(){
        val rvList=binding.list
        with(rvList){
            stateListAdapter= StateAdapter()
            adapter=stateListAdapter
            binding.list.layoutManager=linearLayoutManager

        }
        setupClickListener()
    //    setupSwipeListener(rvList)
    }
    private fun setupClickListener(){
        stateListAdapter.onStateItemOnClickListener={
            val intent=StateItemActivity.newIntentEditItem(this,it.id)
            startActivity(intent)
        }
    }
}
