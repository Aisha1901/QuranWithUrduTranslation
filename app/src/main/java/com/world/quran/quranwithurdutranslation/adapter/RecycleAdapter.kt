package com.world.quran.quranwithurdutranslation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.data.SurahData

class RecycleAdapter(private val contentList: ArrayList<SurahData>, private val dataType:String):
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          val surah_ara_name:TextView = itemView.findViewById(R.id.arabic_text)
          val surah_eng_name:TextView = itemView.findViewById(R.id.sur_eng_name)
          val region:TextView = itemView.findViewById(R.id.region)
          val surahNo:TextView = itemView.findViewById(R.id.surahNo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.surah_ara_name.text = contentList[position].surahArabicName
        holder.surah_eng_name.text =contentList[position].surahEngName
        holder.region.text = contentList[position].region
        holder.surahNo.text = contentList[position].surahNo
        if (contentList[position].region==""){
            holder.region.visibility=View.GONE
        }
        holder.itemView.setOnClickListener {
            val bundle = bundleOf("surahNo" to contentList[position].surahNo, "dataType" to  dataType)
            holder.itemView.findNavController().navigate(R.id.action_mainFragment_to_viewFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }
}