package com.him.secured_pincode.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.him.secured_pincode.databinding.MainFragmentBinding
import com.him.secured_pincode.databinding.MainFragmentBindingImpl

class PinCodeFragment : Fragment() {

    lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: PinCodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBindingImpl.inflate(inflater)
        viewModel = ViewModelProvider(this).get(PinCodeViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    companion object {
        fun newInstance() = PinCodeFragment()
    }

}
