package com.example.shoesshop.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.shoesshop.R

open class BaseActivity<VB : ViewBinding>(
    val bindingInflater: (LayoutInflater) -> VB
) : AppCompatActivity(), View.OnClickListener {
    val binding: VB by lazy { bindingInflater(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onCreateView()
        window.statusBarColor = Color.WHITE
        window.navigationBarColor = Color.WHITE
    }

    open fun onCreateView() {

    }

    final override fun onClick(view: View) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))
        clickViews(view)
    }

    protected open fun clickViews(view: View) {
        // do nothing
    }

}