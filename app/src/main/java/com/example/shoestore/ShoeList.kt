package com.example.shoestore

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeListBinding
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ShoeList : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View {
        // Inflate layout and obtain an instance of the binding class.
        binding = DataBindingUtil.inflate(
        inflater, R.layout.fragment_shoe_list, container, false)

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        val activity = activity as AppCompatActivity
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        binding.addFAB.setOnClickListener{
            findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }

        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val i = Intent()
                i.action = Intent.ACTION_MAIN
                i.addCategory(Intent.CATEGORY_HOME)
                startActivity(i)
            }
        })


        shoeViewModel.shoes.observe(viewLifecycleOwner) {
            if (it != null){
                for (index in 0 until (shoeViewModel.shoesList!!.size)){

                    val linearLayout = binding.linearLayout
                    val customView = layoutInflater.inflate(R.layout.custom_item, null, false)

                    val nameTextView = customView.findViewById<TextView>(R.id.shoeNameTextView)
                    nameTextView.text = resources.getString(R.string.item_name, shoeViewModel.shoesList?.elementAt(index)?.name.toString())

                    val companyTextView = customView.findViewById<TextView>(R.id.companyTextView)
                    companyTextView.text = resources.getString(R.string.item_company, shoeViewModel.shoesList?.elementAt(index)?.company.toString())

                    val shoeSizeTextView = customView.findViewById<TextView>(R.id.shoeSizeTextView)
                    shoeSizeTextView.text = resources.getString(R.string.item_size, shoeViewModel.shoesList?.elementAt(index)?.size.toString())

                    val shoeDescriptionTextView = customView.findViewById<TextView>(R.id.shoeDescriptionTextView)
                    shoeDescriptionTextView.text = resources.getString(R.string.item_description, shoeViewModel.shoesList?.elementAt(index)?.description.toString())

                    customView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT)

                    linearLayout.addView(customView)

                }

            }

        }
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