package com.harunkor.androidviewmodelsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    fun onMinusScore(){
        _score.value = _score.value?.minus(1)
    }

    fun onPlusScore(){
        _score.value = _score.value?.plus(1)
    }

    init {
        _score.value = 0
       // Log.v("PATIKA","GameViewModel created.")
    }

    override fun onCleared() {
        super.onCleared()
       // Log.v("PATIKA","GameViewModel destroyed!")
    }

}