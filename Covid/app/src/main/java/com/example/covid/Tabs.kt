package com.example.covid

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.covid.ui.main.SectionsPagerAdapter

class Tabs : AppCompatActivity() {

    lateinit var tabs: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = this.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)



    }
    fun cargarIconos(){
        tabs.getTabAt(0)?.setIcon(android.R.drawable.ic_dialog_alert)
        tabs.getTabAt(1)?.setIcon(android.R.drawable.ic_dialog_alert)
    }
}