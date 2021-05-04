package com.example.mdp_bollie.ui.login

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentLoginBinding
import com.example.mdp_bollie.databinding.FragmentRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            logInUser()
        }

        view.findViewById<Button>(R.id.navToReg).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    private fun logInUser() {
        //Check on user input
        when {
            //check if email field is empty
            TextUtils.isEmpty(binding.loginEmail.text.toString().trim {
                it <= ' '
            }) -> {
                Toast.makeText(requireContext(), getString(R.string.enter_email), Toast.LENGTH_LONG).show()
            }
            //check if password field is empty
            TextUtils.isEmpty(binding.loginPassword.text.toString().trim {
                it <= ' '
            }) -> {
                Toast.makeText(requireContext(), getString(R.string.enter_password), Toast.LENGTH_LONG).show()
            }
            //Get rid of spaces in user input
            else -> {
                val email: String = binding.loginEmail.text.toString().trim {
                    it <= ' '
                }
                val password: String = binding.loginPassword.text.toString().trim {
                    it <= ' '
                }
                //Log in using firebase auth
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), getString(R.string.successful_login), Toast.LENGTH_LONG).show()
                        val user = auth.currentUser
                        findNavController().navigate(R.id.action_loginFragment_to_navigation_home)
                    }
                    //if task was not successful, print error message
                    else {
                        Toast.makeText(requireContext(), (task.exception?.message), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}