package com.world.quran.quranwithurdutranslation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.world.quran.quranwithurdutranslation.R
import com.world.quran.quranwithurdutranslation.data.AyatData


class AayatRecycleAdapter(private val aayatList: ArrayList<AyatData>):
    RecyclerView.Adapter<AayatRecycleAdapter.ViewHolder>() {

    private var context:Context? = null

    init {
        this.context= context
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ayat_arb:TextView = itemView.findViewById(R.id.arabic_text)
        val ayatNo:TextView = itemView.findViewById(R.id.ayatNo)
        val translation:TextView = itemView.findViewById(R.id.translation_text)
        val transliteration:TextView = itemView.findViewById(R.id.roman_text)
         val bookMark:ImageView = itemView.findViewById(R.id.bookmark)
        val share:ImageView = itemView.findViewById(R.id.share)
        val parent:ConstraintLayout = itemView.findViewById(R.id.parent)
        val layout:LinearLayout = itemView.findViewById(R.id.linearLayout2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ayat_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return aayatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ayat_arb.text = aayatList[position].ayat
        holder.ayatNo.text = aayatList[position].AyatNo
        holder.translation.text = aayatList[position].translation
        holder.transliteration.text = aayatList[position].transliteration
        holder.itemView.setOnLongClickListener{
            holder.layout.visibility=View.VISIBLE
            true
        }
        holder.itemView.setOnClickListener {
            if(holder.bookMark.visibility==View.VISIBLE && holder.share.visibility==View.VISIBLE){
                holder.bookMark.visibility= View.VISIBLE
                holder.share.visibility = View.VISIBLE
            }
        }

    }
}
