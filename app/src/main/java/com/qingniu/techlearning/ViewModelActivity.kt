package com.qingniu.techlearning

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider

/**
 *@author: hyr
 *@date: 2022/8/24 18:21
 *@desc:
 */
class ViewModelActivity : AppCompatActivity() {

    companion object {
        fun getCallIntent(ctx: Context): Intent {
            return Intent(ctx, ViewModelActivity::class.java)
        }
    }

    lateinit var model: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        Log.e("hyrrr", "onCreate")
        model = ViewModelProvider(this)[TestViewModel::class.java]
        model.outName.observe(this) {
            Log.e("hyrrr", "change to $it")
        }

        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                Log.e("hyrrr", "LifecycleOwner onCreate")
            }

            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                Log.e("hyrrr", "LifecycleOwner onStart")
            }

            override fun onResume(owner: LifecycleOwner) {
                super.onResume(owner)
                Log.e("hyrrr", "LifecycleOwner onResume")
            }

            override fun onPause(owner: LifecycleOwner) {
                super.onPause(owner)
                Log.e("hyrrr", "LifecycleOwner onPause")
            }

            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
                Log.e("hyrrr", "LifecycleOwner onStop")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
                Log.e("hyrrr", "LifecycleOwner onDestroy")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        Log.e("hyrrr", "onResume")
        Log.e("hyrrr", model.outName.value.toString())
        model.setName("测试改名")
    }

    override fun onStop() {
        super.onStop()
        Log.e("hyrrr", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("hyrrr", "onDestroy")
        Runtime.getRuntime().gc()
    }
}