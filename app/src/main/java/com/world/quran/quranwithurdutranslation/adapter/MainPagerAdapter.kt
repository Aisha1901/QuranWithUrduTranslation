package com.world.quran.quranwithurdutranslation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.world.quran.quranwithurdutranslation.fragment.BookMarkFragment
import com.world.quran.quranwithurdutranslation.fragment.JuzFragment
import com.world.quran.quranwithurdutranslation.fragment.SurahFragment

class MainPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return SurahFragment()
            1-> return JuzFragment()
            2-> return BookMarkFragment()
        }
        return BookMarkFragment()
    }


}