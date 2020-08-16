package com.him.secured_pincode.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.him.secured_pincode.data.EncryptSharedPreferences
import com.him.secured_pincode.databinding.FragmentPinCodeBinding

class PinCodeFragment : Fragment() {

    lateinit var binding: FragmentPinCodeBinding

    private lateinit var viewModel: PinCodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPinCodeBinding.inflate(inflater)
        val sharedPreferences =
            EncryptSharedPreferences.getInstance(requireContext()).sharedPreferences
        viewModel = ViewModelProvider(this, PinCodeViewModelFactory(sharedPreferences))
            .get(PinCodeViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    companion object {
        fun newInstance() = PinCodeFragment()
    }

}
