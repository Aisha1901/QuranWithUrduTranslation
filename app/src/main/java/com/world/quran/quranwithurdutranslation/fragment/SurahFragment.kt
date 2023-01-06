package com.world.quran.quranwithurdutranslation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.utils.ReadDatabase
import com.world.quran.quranwithurdutranslation.adapter.RecycleAdapter
import com.world.quran.quranwithurdutranslation.databinding.FragmentSurahBinding

class SurahFragment : Fragment() {

    private  lateinit var viewBinding: FragmentSurahBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentSurahBinding.inflate(inflater,container,false)

        viewBinding.recycleView.adapter = RecycleAdapter(ReadDatabase.getContentList(),"surah")

        return viewBinding.root
    }
}