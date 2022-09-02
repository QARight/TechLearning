package com.qingniu.techlearning

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qingniu.techlearning.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author: hyr
 *@date: 2022/8/26 09:22
 *@desc:
 */
class CoroutineActivity : AppCompatActivity() {
    companion object {
        fun getCallIntent(ctx: Context): Intent {
            return Intent(ctx, CoroutineActivity::class.java)
        }
    }

    private lateinit var binding: ActivityCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("CoroutineActivity","onCreate1 msg")
        test1()
        Log.e("CoroutineActivity","onCreate2 msg")
    }

    fun test1() = runBlocking {
        launch {
            delay(2000L)
            Log.e("CoroutineActivity","test1 delay 2000 msg")
        }
        launch {
            delay(1000L)
            Log.e("CoroutineActivity","test1 delay 1000 msg")
        }
        Log.e("CoroutineActivity","test1 msg")
    }

    suspend fun test2() = coroutineScope {
        launch {
            delay(5000L)
            Log.e("CoroutineActivity","test2 delay 5000 msg")
        }
        launch {
            delay(3000L)
            Log.e("CoroutineActivity","test2 delay 3000 msg")
        }
        Log.e("CoroutineActivity","test2 msg")
    }
}