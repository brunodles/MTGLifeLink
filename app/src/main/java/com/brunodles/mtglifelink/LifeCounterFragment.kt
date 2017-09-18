package com.brunodles.mtglifelink

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brunodles.mtglifelink.databinding.FragmentLifecounterBinding

class LifeCounterFragment : Fragment() {

    companion object {
        val STATE_LIFECOUNTER = "STATE_LIFECOUNTER"
        val ARG_ROTATION = "ARG_ROTATION"
        val ARG_PLAYER = "ARG_PLAYER"

        fun buildArgs(rotation: Int = 0, player: Int = 0): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ROTATION, rotation)
            bundle.putInt(ARG_PLAYER, player)
            return bundle
        }
    }

    private lateinit var binding: FragmentLifecounterBinding
    private lateinit var lifecounter: LifeCounter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecounter = if (savedInstanceState != null && savedInstanceState.containsKey(STATE_LIFECOUNTER)) {
            savedInstanceState.getParcelable(STATE_LIFECOUNTER)
        } else {
            val lifeCounter = LifeCounter()

            val player = arguments.getInt(ARG_PLAYER, 0)
            val preferences = context.getSharedPreferences("Life-$player", Context.MODE_PRIVATE)
            val life = preferences.getInt("life", -1)
            if (life >= 0)
                lifecounter.life.set(life)

            lifecounter
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLifecounterBinding.inflate(inflater!!, container, false)
        return binding.getRoot()
    }

    override fun onStart() {
        super.onStart()
        binding.lifeCounter = lifecounter
        if (arguments != null)
            binding.root.rotation = arguments.getInt(ARG_ROTATION, 0).toFloat()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(STATE_LIFECOUNTER, lifecounter)
    }

    override fun onDestroy() {
        super.onDestroy()
        val player = arguments.getInt(ARG_PLAYER, 0)
        context.getSharedPreferences("Life-$player", Context.MODE_PRIVATE).edit().apply {
            putInt("life", lifecounter.life.get())
        }.apply()
    }

}