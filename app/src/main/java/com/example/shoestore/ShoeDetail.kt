package com.example.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetail : Fragment() {
    private  val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_shoe_detail, container, false)
        // Get the ShoeViewModel

        binding.saveButton.setOnClickListener {

            var name = binding.shoeNameEditText.text.toString()
            var company = binding.companyEditText.text.toString()
            var size = binding.shoeSizeEditText.text.toString()
            var description = binding.descriptionEditText.text.toString()

            shoeViewModel.add(name, company, size, description)

            findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }

        return binding.root
    }

}