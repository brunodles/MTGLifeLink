package com.brunodles.mtglifelink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        supportFragmentManager.findFragmentById(R.id.first).arguments = LifeCounterFragment.buildArgs(180)
        super.onStart()
    }
}
