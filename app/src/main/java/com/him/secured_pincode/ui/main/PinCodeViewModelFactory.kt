package com.him.secured_pincode.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PinCodeViewModelFactory(
    private val sharedPreferences: SharedPreferences
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PinCodeViewModel(sharedPreferences) as T
    }

}