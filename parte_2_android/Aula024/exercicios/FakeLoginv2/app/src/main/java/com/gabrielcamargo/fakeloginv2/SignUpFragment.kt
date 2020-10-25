package com.gabrielcamargo.fakeloginv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout


class SignUpFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val signUpView: View = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val checkBox = signUpView.findViewById<MaterialCheckBox>(R.id.cbAgree_signUp)
        checkBox.setOnClickListener(this)

        val btnSignUp = signUpView.findViewById<MaterialButton>(R.id.btnSignUp_signUp)
        btnSignUp.setOnClickListener(this)

        return signUpView
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

    fun clickSignUp() {
        val usernameInput = view!!.findViewById<TextInputLayout>(R.id.txtUsername_signUp)
        val text = usernameInput.editText?.text.toString()

        Snackbar.make(view!!, text, Snackbar.LENGTH_SHORT).show()
    }

    fun clickAgreeCheck() {
        val button = view!!.findViewById<MaterialButton>(R.id.btnSignUp_signUp)
        val checkbox = view!!.findViewById<MaterialCheckBox>(R.id.cbAgree_signUp)

        button.isEnabled = checkbox.isChecked
    }
}