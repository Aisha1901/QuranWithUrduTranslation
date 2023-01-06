package com.world.quran.quranwithurdutranslation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.world.quran.quranwithurdutranslation.adapter.AayatRecycleAdapter
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.data.AyatData
import com.world.quran.quranwithurdutranslation.databinding.FragmentViewBinding
import com.world.quran.quranwithurdutranslation.utils.ReadDatabase

class ViewFragment : Fragment() {

    private lateinit var viewBinding: FragmentViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentViewBinding.inflate(inflater,container,false)
        val viewActionBar = activity?.findViewById<RelativeLayout>(R.id.action_bar_2)
        viewActionBar!!.visibility= View.VISIBLE


        if (arguments?.getString("dataType").equals("juz")){
            val ayaatList = ReadDatabase.getAyatDataList().filter { it.juzNo == arguments?.getString("surahNo")}
            viewBinding.aayatRv.adapter = AayatRecycleAdapter(ayaatList as ArrayList<AyatData>)
        }else {
            val ayaatList = ReadDatabase.getAyatDataList()
                .filter { it.surahNo == arguments?.getString("surahNo") }
            viewBinding.aayatRv.adapter = AayatRecycleAdapter(ayaatList as ArrayList<AyatData>)
        }

        val paraTitle = activity?.findViewById<TextView>(R.id.para_title)
        paraTitle!!.visibility=View.VISIBLE

        return viewBinding.root
    }
}