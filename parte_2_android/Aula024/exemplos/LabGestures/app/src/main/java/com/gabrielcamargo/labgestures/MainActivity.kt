package com.gabrielcamargo.labgestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager: ViewPager = findViewById<ViewPager>(R.id.myViewPager)
        val tab = findViewById<TabLayout>(R.id.myTabLayout)

        tab.setupWithViewPager(pager)

        val fragments = listOf(
            MyFragment(), MyFragment(), MyFragment()
        )

        val titulos = listOf(
            "Nome", "Biblioteca", "Favoritos"
        )

        pager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)
    }
}