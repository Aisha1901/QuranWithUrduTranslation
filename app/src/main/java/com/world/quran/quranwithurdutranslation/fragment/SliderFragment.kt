package com.world.quran.quranwithurdutranslation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.world.quran.quranwithurdutranslation.adapter.ImageSliderAdapter
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.databinding.FragmentSliderBinding


class SliderFragment : Fragment() {

    private lateinit var viewBinding: FragmentSliderBinding

    var images = intArrayOf(
        R.drawable.slide_img_1, R.drawable.slide_img_2, R.drawable.slide_img_3
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentSliderBinding.inflate(inflater,container,false)

        val sliderAdapter = ImageSliderAdapter(requireContext(), images)
        viewBinding.imageSlider.adapter = sliderAdapter
        viewBinding.wormDotsIndicator.attachTo(viewBinding.imageSlider)

        viewBinding.imageSlider.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {

                if (position == sliderAdapter.count - 1)
                    viewBinding.allDoneBtn.visibility = View.VISIBLE
                else
                    viewBinding.allDoneBtn.visibility = View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        viewBinding.allDoneBtn.setOnClickListener {
            findNavController().navigate(R.id.action_sliderFragment_to_mainFragment)
        }

        return viewBinding.root
    }
}