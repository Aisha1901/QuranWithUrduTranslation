package com.world.quran.quranwithurdutranslation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.world.quran.quranwithurdutranslation.utils.ReadDatabase
import com.world.quran.quranwithurdutranslation.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.leftNavigationBtn.setOnClickListener {
            viewBinding.drawer.openDrawer(GravityCompat.START)
        }

        viewBinding.rightNavigationBtn.setOnClickListener {
            viewBinding.drawer.openDrawer(GravityCompat.END)
        }

        CoroutineScope(Dispatchers.IO).launch {
            getData()
        }
    }

    private suspend fun getData(){
        ReadDatabase.initDatabase(this@MainActivity)
    }
}