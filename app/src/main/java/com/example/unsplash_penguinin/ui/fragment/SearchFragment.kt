package com.example.unsplash_penguinin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.unsplash_penguinin.databinding.FragmentSearchBinding
import com.example.unsplash_penguinin.vm.DataViewModel

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(requireActivity())[DataViewModel::class.java]

        binding.searchBtn.setOnClickListener {
            if (binding.searchEt.text.toString() != ""){
                vm.search(requireActivity(), binding.searchEt.text.toString())
                val action =
                    SearchFragmentDirections.actionSearchFragmentToResultFragment(binding.searchEt.text.toString())
                findNavController().navigate(action)
            }else{
                Toast.makeText(requireActivity(),"You must enter a keyword",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.searchEt.text.clear()
    }
}