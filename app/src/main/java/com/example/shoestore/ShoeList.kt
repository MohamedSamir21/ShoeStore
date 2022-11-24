package com.example.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeListBinding
import android.support.v4.*
class ShoeList : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {
        // Inflate layout and obtain an instance of the binding class.
        binding = DataBindingUtil.inflate(
        inflater, R.layout.fragment_shoe_list, container, false)

        binding.setLifecycleOwner(this)

        setHasOptionsMenu(true)

        binding.addFAB.setOnClickListener{
            findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }

        shoeViewModel.shoes.observe(viewLifecycleOwner, Observer {
            if (it != null){
                for (index in 0 .. (shoeViewModel.shoeListw!!.size)-1){

                    val linearLayout = binding.linearLayout
                    val customView = layoutInflater.inflate(R.layout.custom_item, null, false)


                    val shoeNameTextView = customView.findViewById<TextView>(R.id.shoeNameTextView)
                    shoeNameTextView.text = "Name: " + shoeViewModel.shoeListw?.elementAt(index)?.name.toString()

                    val companyTextView = customView.findViewById<TextView>(R.id.companyTextView)
                    companyTextView.text = "Company: " + shoeViewModel.shoeListw?.elementAt(index)?.company.toString()

                    val shoeSizeTextView = customView.findViewById<TextView>(R.id.shoeSizeTextView)
                    shoeSizeTextView.text = "Size: " + shoeViewModel.shoeListw?.elementAt(index)?.size.toString()

                    val shoeDescriptionTextView = customView.findViewById<TextView>(R.id.shoeDescriptionTextView)
                    shoeDescriptionTextView.text = "Description: " + shoeViewModel.shoeListw?.elementAt(index)?.description.toString()

                    customView.setLayoutParams(LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));

                    linearLayout.addView(customView);

                }
            }

        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logut -> findNavController().navigate(R.id.action_shoeList_to_login)
        }
        return true
    }
}