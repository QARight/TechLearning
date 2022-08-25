package com.qingniu.techlearning

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Closeable

/**
 *@author: hyr
 *@date: 2022/8/25 09:50
 *@desc:
 */
class TestViewModel:ViewModel() {

    private val name:MutableLiveData<String> = MutableLiveData("123")

    val outName:LiveData<String> get() = name

    fun setName(newName:String){
        name.value = newName
    }

    override fun addCloseable(closeable: Closeable) {
        super.addCloseable(closeable)
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("hyrrr","onCleared")
    }

    protected fun finalize() {
        Log.e("hyrrr","finalize")
    }


}