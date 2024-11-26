package com.example.simpleregapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.simpleregapp.databinding.FragmentWelcomeWindowBinding


class WelcomeWindow : Fragment() {

    private lateinit var binding : FragmentWelcomeWindowBinding
    val action = WelcomeWindowDirections.actionWelcomeWindowToRegistration()
    val actionToLoginWindow = WelcomeWindowDirections.actionWelcomeWindowToLoginFragment()
    private val viewModel: RegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.addUsers()
        binding = FragmentWelcomeWindowBinding.inflate(inflater)
        binding.welcomeRegBtn.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.welcomeLoginBtn.setOnClickListener{
            Navigation.findNavController(requireView()).navigate(actionToLoginWindow)
        }

        return binding.root
    }


}