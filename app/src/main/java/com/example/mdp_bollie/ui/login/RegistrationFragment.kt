package com.example.mdp_bollie.ui.login

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.google.firebase.auth.FirebaseAuth


class RegistrationFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        view.findViewById<Button>(R.id.btn_reg).setOnClickListener {
            authUser()
        }

        view.findViewById<Button>(R.id.navToLogin).setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
    }

    private fun authUser() {
        //Check on user input
        when {
            //check if email field is empty
            TextUtils.isEmpty(R.id.reg_email.toString().trim {
                it <= ' '
            }) -> {
                Toast.makeText(RegistrationFragment().context, getString(R.string.enter_email), Toast.LENGTH_LONG).show()
            }
            //check if password field is empty
            TextUtils.isEmpty(R.id.reg_password.toString().trim {
                it <= ' '
            }) -> {
                Toast.makeText(RegistrationFragment().context, getString(R.string.enter_password), Toast.LENGTH_LONG).show()
            }
            //Get rid of spaces in user input
            else -> {
                val email: String = R.id.reg_email.toString().trim {
                    it <= ' '
                }
                val password: String = R.id.reg_password.toString().trim {
                    it <= ' '
                }
                //Create a user with success Sign in
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    task ->
                    if (task.isSuccessful) {
                        Toast.makeText(RegistrationFragment().context, getString(R.string.successful_reg), Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
                    }
                    //if task was not successful, print error message
                    else {
                        Toast.makeText(RegistrationFragment().context, (task.exception?.message), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}