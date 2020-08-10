package com.him.secured_pincode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.him.secured_pincode.ui.main.PinCodeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PinCodeFragment.newInstance())
                    .commitNow()
        }
    }
}
