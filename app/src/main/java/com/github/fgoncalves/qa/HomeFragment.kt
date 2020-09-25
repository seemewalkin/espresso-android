package com.github.fgoncalves.qa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.fgoncalves.qa.databinding.HomeScreenBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: HomeScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_screen, container, false
        )
        binding.OutOfHomeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_second_act)
        }
        return binding.root
    }
}