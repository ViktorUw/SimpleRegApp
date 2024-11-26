package com.example.simpleregapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.NavArgsLazy
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.viewbinding.ViewBinding
import com.example.simpleregapp.databinding.FragmentMainWindowBinding


class MainWindow : Fragment() {

    private lateinit var binding: FragmentMainWindowBinding

    val action_logout = MainWindowDirections.actionMainWindowToWelcomeWindow()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val userName = arguments?.getString("login") ?: "Default User"

        binding = FragmentMainWindowBinding.inflate(inflater)

        binding.mainWelcomeTxt.text = "Witaj, $userName!"

        binding.logoutBtn.setOnClickListener{
            Navigation.findNavController(requireView()).navigate(action_logout)
        }
        return binding.root
    }
}