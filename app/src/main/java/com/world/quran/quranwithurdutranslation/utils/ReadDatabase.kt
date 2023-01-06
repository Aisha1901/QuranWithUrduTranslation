package com.world.quran.quranwithurdutranslation.utils

import android.content.Context
import android.util.Log
import com.world.quran.quranwithurdutranslation.data.AyatData
import com.world.quran.quranwithurdutranslation.data.SurahData
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.IOException
import java.io.InputStream

object ReadDatabase {

    var surahList: ArrayList<SurahData>?=null
    var juzDataList: ArrayList<SurahData>?=null
    var ayatList :ArrayList<AyatData>? = null

    fun initDatabase(context: Context){
        surahList = ArrayList<SurahData>()
        juzDataList = ArrayList<SurahData>()
        ayatList = ArrayList<AyatData>()
        var assetInStream: InputStream? = null

        try {
            assetInStream = context.assets.open("quran_database.xlsx")
            val myWorkBook = XSSFWorkbook(assetInStream)
            val dataSheet: XSSFSheet = myWorkBook.getSheetAt(0)

            val rowIter: Iterator<Row> = dataSheet.rowIterator()
            var rowno = 0
            while (rowIter.hasNext()) {
                if (rowno != 0) {
                    val cellIter = rowIter.next().cellIterator()
                    var colno = 0
                    var s_arb_name = ""
                    var s_eng_name = ""
                    var region = ""
                    var s_no=""
                    var juz_no=""
                    var juz_arb_name=""
                    var juz_eng_name = ""
                    var ayatNo = ""
                    var ayat = ""
                    var translation = ""
                    var transliteration = ""
                    while (cellIter.hasNext()) {
                        val myCell = cellIter.next() as XSSFCell
                        if (colno == 2) {
                            s_arb_name = myCell.toString()
                        }
                        if (colno == 3) {
                            s_eng_name = myCell.toString()
                        }
                        if (colno == 4) {
                            region = myCell.toString()
                        }
                        if (colno == 1) {
                            s_no = myCell.toString().substringBefore(".")
                        }

                        if (colno == 5) {
                            juz_no = myCell.toString().substringBefore(".")
                        }

                        if (colno == 6) {
                            juz_arb_name = myCell.toString()
                        }

                        if (colno == 7) {
                            juz_eng_name = myCell.toString()
                        }

                        if (colno == 8) {
                            ayatNo = myCell.toString().substringBefore(".")
                        }

                        if (colno == 9) {
                            ayat = myCell.toString()
                        }

                        if (colno == 11) {
                            translation = myCell.toString()
                        }
                        if (colno == 10) {
                            transliteration = myCell.toString()
                        }
                        colno++
                    }
                    if (!s_arb_name.equals("s_arb_name")) {
                        val surahData = SurahData(s_no,s_arb_name,s_eng_name,region)
                        if(!surahList!!.contains(surahData)) {
                            surahList!!.add(surahData)
                        }
                    }
                    if (!juz_no.equals("juz_no")) {
                        val juzData = SurahData(juz_no,juz_arb_name,juz_eng_name,"")
                        if(!juzDataList!!.contains(juzData)) {
                            juzDataList!!.add(juzData)
                        }
                    }

                    if (!ayat.equals("verses")) {
                        val AyatNo = AyatData(juz_no,s_no,ayatNo,ayat,translation,transliteration)
                        ayatList!!.add(AyatNo)
                    }
                }
                rowno++
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("MainActivity",e.printStackTrace().toString())
        } finally {
            assetInStream?.close()
        }
    }

    fun getContentList(): ArrayList<SurahData> {
        return surahList!!
    }

   fun getJuzList(): ArrayList<SurahData>{
        return juzDataList!!
    }

    fun getAyatDataList(): ArrayList<AyatData>{
        return ayatList!!
    }
}