package com.harunkor.androidviewmodelsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.harunkor.androidviewmodelsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // private lateinit var viewModel: GameViewModel
    private  val gameViewModel:GameViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.setLifecycleOwner(this)
        Log.v("PATIKA","GameViewModel called.")
        //viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        //init()
         binding.gameViewModel = gameViewModel
        //binding.setVariable(BR.gameViewModel,gameViewModel)

    }

    private fun init() {
        with(gameViewModel){
            binding.apply {
                scoreMinusButton.setOnClickListener {
                    onMinusScore()
                }
                scorePlusButton.setOnClickListener {
                    onPlusScore()
                }
                score.observe(this@MainActivity, Observer { scoreValue ->
                    scoreTxt.text = scoreValue.toString()
                })
            }
        }
    }
}