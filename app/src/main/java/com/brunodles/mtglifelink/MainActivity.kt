package com.brunodles.mtglifelink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        supportFragmentManager.findFragmentById(R.id.player1).arguments = LifeCounterFragment.buildArgs(180, 1)
        supportFragmentManager.findFragmentById(R.id.player2).arguments = LifeCounterFragment.buildArgs(player = 2)
        super.onStart()
    }
}
