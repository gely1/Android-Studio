package com.example.covid

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.covid.ui.main.SectionsPagerAdapter

class Tabs : AppCompatActivity() {

    lateinit var tabs: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        setSupportActionBar( findViewById(R.id.toolbar))
        supportActionBar?.setLogo(R.drawable.virus)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = this.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when( item.itemId){
            R.id.camera_menu->{
                Toast.makeText(applicationContext, "Hola", Toast.LENGTH_LONG).show()
                true
            }
            R.id.menu_dos->{
                Toast.makeText(applicationContext, "Hola2", Toast.LENGTH_LONG).show()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    fun cargarIconos(){
        tabs.getTabAt(0)?.setIcon(android.R.drawable.ic_dialog_alert)
        tabs.getTabAt(1)?.setIcon(android.R.drawable.ic_dialog_alert)
    }
}