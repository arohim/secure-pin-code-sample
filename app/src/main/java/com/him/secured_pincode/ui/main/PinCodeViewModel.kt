package com.him.secured_pincode.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PinCodeViewModel(val sharedPreferences: SharedPreferences) : ViewModel() {

    val pinCode = MutableLiveData<String>()

    val securedPinCode = MutableLiveData<String>()

    val numPadListener = object : NumPadListener {
        override fun onNumberClicked(number: Char) {
            val existingPinCode = pinCode.value ?: ""
            val newPassCode = existingPinCode + number
            pinCode.postValue(newPassCode)

            if (newPassCode.length == 6) {
                sharedPreferences.edit().run {
                    putString(PIN_CODE_KEY, newPassCode)
                    apply()
                }
                val pinCodeInSharedPreference = sharedPreferences.getString(PIN_CODE_KEY, "")
                securedPinCode.postValue(pinCodeInSharedPreference)
                pinCode.postValue("")
            }
        }

        override fun onEraseClicked() {
            val droppedLast = pinCode.value?.dropLast(1) ?: ""
            pinCode.postValue(droppedLast)
        }
    }

    companion object {
        const val PIN_CODE_KEY = "PIN_CODE_KEY"
    }

}
