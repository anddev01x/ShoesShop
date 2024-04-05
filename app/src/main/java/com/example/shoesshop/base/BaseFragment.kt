package com.example.shoesshop.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.shoesshop.R

abstract class BaseFragment<V : ViewBinding> : Fragment(), View.OnClickListener {

    lateinit var binding: V

    abstract val _binding: (LayoutInflater, ViewGroup?, Boolean) -> V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = _binding(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated()
    }

    abstract fun onViewCreated()

    override fun onClick(view: View) {
        view.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in))
        clickViews(view)
    }

    protected open fun clickViews(view: View) {
        // do nothing
    }

}