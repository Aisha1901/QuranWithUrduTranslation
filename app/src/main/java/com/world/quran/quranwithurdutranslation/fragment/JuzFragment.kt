package com.world.quran.quranwithurdutranslation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.utils.ReadDatabase
import com.world.quran.quranwithurdutranslation.adapter.RecycleAdapter
import com.world.quran.quranwithurdutranslation.databinding.FragmentJuzBinding

class JuzFragment : Fragment() {

    private lateinit var viewBinding: FragmentJuzBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentJuzBinding.inflate(inflater,container,false)

        val paraTitle = activity?.findViewById<TextView>(R.id.para_title)
        paraTitle!!.visibility=View.GONE

        viewBinding.recycleView.adapter = RecycleAdapter(ReadDatabase.getJuzList(),"juz")
        return viewBinding.root
    }
}