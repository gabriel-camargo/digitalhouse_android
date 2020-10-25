package com.gabrielcamargo.fakeloginv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gabrielcamargo.fakeloginv2.users.UserService
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class SignInFragment : Fragment(), View.OnClickListener {
    private lateinit var viewSignIn: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewSignIn = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val btnSignIn = viewSignIn.findViewById<MaterialButton>(R.id.btnSignIn_signIn)
        btnSignIn.setOnClickListener(this)

        return viewSignIn
    }

    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btnSignIn_signIn -> clickSignIn()
        }
    }

    private fun clickSignIn() {
        val usernameInput = viewSignIn.findViewById<TextInputLayout>(R.id.txtUsername_signIn)
        val usernameText = usernameInput.editText?.text.toString()

        val passwordInput = viewSignIn.findViewById<TextInputLayout>(R.id.txtPassword_signIn)
        val passwordText = passwordInput.editText?.text.toString()

        val user = UserService.logIn(usernameText, passwordText)

        if(user == null) {
            Snackbar.make(viewSignIn, "Email ou senha incorretos!", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(viewSignIn, "Login Success!", Snackbar.LENGTH_SHORT).show()

        }
    }
}