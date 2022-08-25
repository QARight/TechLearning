package com.qingniu.techlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qingniu.techlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gotoViewModelTv.setOnClickListener {
            this.startActivity(ViewModelActivity.getCallIntent(this))
        }
    }
}