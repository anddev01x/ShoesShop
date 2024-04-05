package com.example.shoesshop.features.main.home

import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shoesshop.R
import com.example.shoesshop.base.BaseFragment
import com.example.shoesshop.databinding.FragmentHomeBinding
import com.example.shoesshop.model.Banner
import com.google.android.material.tabs.TabLayoutMediator
import android.os.Handler
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var adapterTabLayout: AdapterTabLayout
    private var handler: Handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable
    private var currentPosition = 0
    private val delayTime: Long = 3000
    private var listBanner = mutableListOf<Banner>()


    override val _binding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated() {
        setUpTabLayout()
        setUpBanner()

    }

    private fun setUpBanner() {
        runnable = Runnable {
            currentPosition = binding.viewPageArrival.currentItem
            if (currentPosition == listBanner.size - 1) {
                binding.viewPageArrival.currentItem = 0
            } else {
                binding.viewPageArrival.currentItem = currentPosition + 1

            }
        }
        listBanner = getListBanner()
        val adapterBanner = AdapterShowBanner(requireActivity(), listBanner)
        binding.viewPageArrival.adapter = adapterBanner
        binding.circleIndicator3.setViewPager(binding.viewPageArrival)
        handler.postDelayed(runnable, delayTime)

        binding.viewPageArrival.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, delayTime)
            }
        })
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(50))
        binding.viewPageArrival.setPageTransformer(compositePageTransformer)

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, delayTime)
    }

    private fun getListBanner(): MutableList<Banner> {
        listBanner.clear()
        listBanner.add(Banner(R.drawable.banner_1))
        listBanner.add(Banner(R.drawable.banner_4))
        listBanner.add(Banner(R.drawable.banner_2))
        listBanner.add(Banner(R.drawable.banner_3))
        return listBanner
    }

    private fun setUpTabLayout() {
        adapterTabLayout = AdapterTabLayout(childFragmentManager, lifecycle)
        binding.apply {
            viewPageShoes.adapter = adapterTabLayout
            TabLayoutMediator(tabLayout, viewPageShoes) { tab, _ ->
                viewPageShoes.setCurrentItem(tab.position, true)
            }.attach()
        }
        setupTabIcons()
    }

    private fun setupTabIcons() {
        binding.apply {
            tabLayout.getTabAt(0)?.setText("All Shoes")
            tabLayout.getTabAt(1)?.setText("Family's Shoes")
            tabLayout.getTabAt(2)?.setText("Sports")
            tabLayout.getTabAt(3)?.setText("Out door")
            tabLayout.getTabAt(4)?.setText("Life Style")
            tabLayout.getTabAt(5)?.setText("Other")
        }
    }
}
