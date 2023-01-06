package com.world.quran.quranwithurdutranslation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.world.quran.quranwithurdutranslation.utils.CubeOutPageTransformer
import com.world.quran.quranwithurdutranslation.adapter.MainPagerAdapter
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMainBinding.inflate(inflater,container,false)

        val actionBar = activity?.findViewById<LinearLayout>(R.id.action_bar_1)
        actionBar!!.visibility= View.VISIBLE
        val viewActionBar = activity?.findViewById<RelativeLayout>(R.id.action_bar_2)
        viewActionBar!!.visibility= View.GONE
        val paraTitle = activity?.findViewById<TextView>(R.id.para_title)
        paraTitle!!.visibility=View.GONE

        val viewPager = viewBinding.pager
        val tabLayout = viewBinding.tabLayout

        val adapter = MainPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        viewPager.setPageTransformer(CubeOutPageTransformer())
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "SURAH"
                    tab.icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_surah,null)
                }
                1 -> {
                    tab.text = "JUZ"
                    tab.icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_juz,null)
                }
                2 -> {
                    tab.text = "BOOKMARKS"
                    tab.icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_bookmarks,null)
                }
            }
        }.attach()

        return viewBinding.root
    }
}