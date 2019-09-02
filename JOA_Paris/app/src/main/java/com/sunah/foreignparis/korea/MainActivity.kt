package com.sunah.foreignparis.korea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sunah.foreignparis.korea.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding =  DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}
