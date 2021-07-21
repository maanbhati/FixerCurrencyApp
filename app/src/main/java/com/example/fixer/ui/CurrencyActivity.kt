package com.example.fixer.ui

import android.content.Context
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.fixer.R
import com.example.fixer.navigation.Navigation
import com.example.fixer.ui.main.CurrencyFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper

open class CurrencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixer_currency)

        initViews()
    }

    fun initViews() {
        initCurrencyFragment()
    }

    fun initCurrencyFragment() {
        Navigation.replaceFragment(
            supportFragmentManager,
            R.id.fragmentContainer,
            CurrencyFragment()
        )
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    companion object {
        private val CLASS_TAG = CurrencyActivity::class.java.simpleName
    }
}
