package com.example.simpleregapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.simpleregapp.databinding.FragmentLoginBinding
import kotlin.math.log

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel : RegistrationViewModel by activityViewModels()

    val actionToRegistrationWindow = LoginFragmentDirections.actionLoginFragmentToRegistration()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)

        binding.loginWindowLoginBtn.setOnClickListener {
            val login = binding.loginWindowLogin.text.toString()
            val password = binding.loginWindowPassword.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Podaj login i hasło", Toast.LENGTH_SHORT).show()
            } else if (viewModel.isUserExist(login, password)) {

                val bundle = Bundle().apply {
                    putString("login", login)
                }

                Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_mainWindow, bundle)
            } else {
                Toast.makeText(requireContext(), viewModel.error.value, Toast.LENGTH_SHORT).show()
            }
        }
        binding.loginWindowGoToRegestrationBtn.setOnClickListener{
            Navigation.findNavController(requireView()).navigate(actionToRegistrationWindow)
        }
    return binding.root
    }


}