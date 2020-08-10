package com.him.secured_pincode.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PinCodeViewModel : ViewModel() {

    val pinCode = MutableLiveData<String>().also {
        it.value = "12312"
    }

    val numPadListener = object : NumPadListener {
        override fun onNumberClicked(number: Char) {
            val existingPassCode = pinCode.value ?: ""
            val newPassCode = existingPassCode + number
            pinCode.postValue(newPassCode)
        }

        override fun onEraseClicked() {
            val droppedLast = pinCode.value?.dropLast(1) ?: ""
            pinCode.postValue(droppedLast)
        }
    }


}
