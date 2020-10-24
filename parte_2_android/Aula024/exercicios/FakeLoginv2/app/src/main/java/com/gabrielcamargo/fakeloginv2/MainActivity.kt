package com.gabrielcamargo.fakeloginv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager: ViewPager = findViewById(R.id.vpLogin_mainActivity)
        val tab: TabLayout = findViewById(R.id.tlLogin_mainActivity)

        tab.setupWithViewPager(pager)

        val fragments = listOf(
                SignInFragment(), SignUpFragment()
        )

        val titulos = listOf(
                "Sign In", "Sign Up"
        )

        pager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)

    }
}