package com.example.shoesshop.features.main.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shoesshop.base.BaseFragment
import com.example.shoesshop.databinding.FragmentCartBinding

class CartFragment : BaseFragment<FragmentCartBinding>() {
    override val _binding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCartBinding
        get() = FragmentCartBinding::inflate

    override fun onViewCreated() {

    }
}