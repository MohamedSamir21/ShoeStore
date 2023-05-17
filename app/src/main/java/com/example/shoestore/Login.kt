package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentLoginBinding


class Login : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container,false)

        binding.loginButton.setOnClickListener {view->
            view.findNavController().navigate(R.id.action_login_to_welcome)
        }

        binding.signupButton.setOnClickListener {view->
            view.findNavController().navigate(R.id.action_login_to_welcome)
        }

        return binding.root
    }


}