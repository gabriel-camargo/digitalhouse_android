package com.gabrielcamargo.fakeloginv2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gabrielcamargo.fakeloginv2.users.UserService
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout


class SignUpFragment : Fragment(), View.OnClickListener {

    private lateinit var iNewUsername: INewUsername
    private lateinit var viewSignUp: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewSignUp = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val checkBox = viewSignUp.findViewById<MaterialCheckBox>(R.id.cbAgree_signUp)
        checkBox.setOnClickListener(this)

        val btnSignUp = viewSignUp.findViewById<MaterialButton>(R.id.btnSignUp_signUp)
        btnSignUp.setOnClickListener(this)

        return viewSignUp
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        iNewUsername = context as INewUsername
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SignUpFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btnSignUp_signUp -> clickSignUp()
            R.id.cbAgree_signUp -> clickAgreeCheck()
        }
    }

    private fun clickSignUp() {
        val usernameInput = viewSignUp.findViewById<TextInputLayout>(R.id.txtUsername_signUp)
        val usernameText = usernameInput.editText?.text.toString()

        val passwordInput = viewSignUp.findViewById<TextInputLayout>(R.id.txtPassword_signUp)
        val passwordText = passwordInput.editText?.text.toString()

        val confirmPasswordInput = viewSignUp.findViewById<TextInputLayout>(R.id.txtConfirmPassword_signUp)
        val confirmPasswordText = confirmPasswordInput.editText?.text.toString()

        try {
            UserService.register(usernameText, passwordText, confirmPasswordText)

            clearSignUpForm()
            goToSignIn(usernameText)

            Snackbar.make(viewSignUp, "Usuário $usernameText cadastrado com sucesso!", Snackbar.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Snackbar.make(viewSignUp, e.message!!, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun clearSignUpForm() {
        val usernameInput = viewSignUp.findViewById<TextInputLayout>(R.id.txtUsername_signUp)
        val passwordInput = viewSignUp.findViewById<TextInputLayout>(R.id.txtPassword_signUp)
        val confirmPasswordInput = viewSignUp.findViewById<TextInputLayout>(R.id.txtConfirmPassword_signUp)
        val checkbox = viewSignUp.findViewById<MaterialCheckBox>(R.id.cbAgree_signUp)

        usernameInput.editText?.text?.clear()
        passwordInput.editText?.text?.clear()
        confirmPasswordInput.editText?.text?.clear()
        checkbox.isChecked = false
    }

    private fun goToSignIn(username: String) {
        val mainActivity = (activity as MainActivity?)
        val pager: ViewPager = mainActivity!!.findViewById(R.id.vpLogin_mainActivity)

        pager.setCurrentItem(0, true)
        iNewUsername.setNewUsername(username)
    }

    private fun clickAgreeCheck() {
        val button = viewSignUp.findViewById<MaterialButton>(R.id.btnSignUp_signUp)
        val checkbox = viewSignUp.findViewById<MaterialCheckBox>(R.id.cbAgree_signUp)

        button.isEnabled = checkbox.isChecked
    }
}