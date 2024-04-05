package com.example.shoesshop.features.main.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shoesshop.databinding.FragmentFavoriteBinding
import com.example.shoesshop.base.BaseFragment

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override val _binding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFavoriteBinding
        get() = FragmentFavoriteBinding::inflate

    override fun onViewCreated() {

    }
}