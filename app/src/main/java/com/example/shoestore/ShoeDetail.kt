package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetail : Fragment() {
    private  val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.saveButton.setOnClickListener {

            val name = binding.shoeNameEditText.text.toString()
            val company = binding.companyEditText.text.toString()
            val size = binding.shoeSizeEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()

            shoeViewModel.add(name, company, size, description)

            findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
            Toast.makeText(requireContext(), "New item has been added !!", Toast.LENGTH_SHORT).show()
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

}