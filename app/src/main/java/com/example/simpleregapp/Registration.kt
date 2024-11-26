package com.example.simpleregapp

import androidx.fragment.app.activityViewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.simpleregapp.databinding.FragmentRegistrationBinding

class Registration : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private val viewModel: RegistrationViewModel by activityViewModels()

    val action = RegistrationDirections.actionRegistrationToLoginFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater)


        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

        binding.regRegistrationBtn.setOnClickListener {
            val login = binding.regLogin.text.toString().trim()
            val password = binding.regPassword.text.toString().trim()
            val passwordConfirmed = binding.regPasswordConfirm.text.toString().trim()

            if (login == "" || password == "" || passwordConfirmed == "") {
                Toast.makeText(requireContext(), "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show()
            } else if (password != passwordConfirmed) {
                Toast.makeText(requireContext(), "Nie zgadzają się hasła", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.registerUser(login, password)

                if (viewModel.error.value == null) {
                    Toast.makeText(requireContext(), "Zarejestrowano użytkownika!", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(requireView()).navigate(action)
                }
            }
        }

        binding.regGoBackBtn.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(action)
        }
        return binding.root
    }
}
