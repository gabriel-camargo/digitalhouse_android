package com.gabrielcamargo.fakeloginv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), INewUsername {

    private val signInFragment = SignInFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager: ViewPager = findViewById(R.id.vpLogin_mainActivity)
        val tab: TabLayout = findViewById(R.id.tlLogin_mainActivity)

        tab.setupWithViewPager(pager)

        val fragments = listOf(
                signInFragment, SignUpFragment()
        )

        val titulos = listOf(
                "Sign In", "Sign Up"
        )

        pager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)
    }

    override fun setNewUsername(username: String) {
        val usernameInput = signInFragment.activity?.findViewById<TextInputLayout>(R.id.txtUsername_signIn)
        usernameInput?.editText?.setText(username)
    }
}