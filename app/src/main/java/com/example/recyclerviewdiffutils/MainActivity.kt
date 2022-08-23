package com.example.recyclerviewdiffutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdiffutils.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sampleAdapter by lazy {SampleAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sampleAdapter.differ.submitList(loadData())

        binding.apply {
                rvMain.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter=sampleAdapter
                }
        }
    }


    fun loadData() : MutableList<SampleModel>{
        val nameList : MutableList<SampleModel> = mutableListOf()
        nameList.add(SampleModel(1,"Sample name"))
        nameList.add(SampleModel(2,"Sample name"))
        nameList.add(SampleModel(3,"Sample name"))
        nameList.add(SampleModel(4,"Sample name"))
        nameList.add(SampleModel(5,"Sample name"))
        nameList.add(SampleModel(6,"Sample name"))
        nameList.add(SampleModel(7,"Sample name"))
        nameList.add(SampleModel(8,"Sample name"))
        nameList.add(SampleModel(9,"Sample name"))
        nameList.add(SampleModel(10,"Sample name"))
        nameList.add(SampleModel(11,"Sample name"))

        return nameList
    }
}