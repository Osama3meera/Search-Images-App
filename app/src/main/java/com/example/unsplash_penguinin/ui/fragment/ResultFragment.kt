package com.example.unsplash_penguinin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplash_penguinin.databinding.FragmentResultBinding
import com.example.unsplash_penguinin.ui.adapter.PhotosAdapter
import com.example.unsplash_penguinin.vm.DataViewModel


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)

        val args: ResultFragmentArgs by navArgs()
        val searchQuery = args.searchQuery

        binding.resultEt.setText(searchQuery)
        binding.resultEt.isClickable = false

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(this)[DataViewModel::class.java]

        vm.result.observe(requireActivity(), Observer {
            binding.recyclerView.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            val adapter = PhotosAdapter(requireActivity(), it)
            binding.recyclerView.adapter = adapter
        })
    }

}