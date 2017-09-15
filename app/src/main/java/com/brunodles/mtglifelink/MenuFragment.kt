package com.brunodles.mtglifelink

import android.os.Bundle
import android.support.transition.AutoTransition
import android.support.transition.TransitionManager.*
import android.support.transition.TransitionSet
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.brunodles.mtglifelink.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater!!, container, false)
        return binding.getRoot()
    }

    override fun onStart() {
        super.onStart()
        binding.open.setOnClickListener {
            binding?.let {
                beginDelayedTransition(binding.root, AutoTransition().setOrdering(TransitionSet.ORDERING_TOGETHER))
                if (binding.actions.visibility == View.VISIBLE) {
                    val layoutParams = binding.open.layoutParams as FrameLayout.LayoutParams
                    layoutParams.gravity = Gravity.CENTER
                    binding.open.layoutParams = layoutParams
                    layoutParams.topMargin = 0
                    layoutParams.bottomMargin = 0
                    val size = context.dp(40f).toInt()
                    binding.open.height = size
                    binding.open.width = size
                    binding.actions.visibility = View.GONE
                } else {
                    val layoutParams = binding.open.layoutParams as FrameLayout.LayoutParams
                    layoutParams.gravity = Gravity.END + Gravity.CENTER_VERTICAL
                    binding.open.layoutParams = layoutParams
                    val margin = context.dp(16f).toInt()
                    layoutParams.topMargin = margin
                    layoutParams.bottomMargin = margin
                    val size = context.dp(80f).toInt()
                    binding.open.height = size
                    binding.open.width = size
                    binding.actions.visibility = View.VISIBLE
                }
            }
        }
    }
}