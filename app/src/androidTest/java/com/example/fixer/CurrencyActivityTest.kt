package com.example.fixer

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.fixer.di.appModule
import com.example.fixer.di.dataModule
import com.example.fixer.di.scopesModule
import com.example.fixer.navigation.Navigation
import com.example.fixer.ui.CurrencyActivity
import com.example.fixer.ui.main.CurrencyFragment
import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.unloadKoinModules
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class CurrencyActivityTest {

    lateinit var currencyActivity: CurrencyActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        currencyActivity = CurrencyActivity()
    }

    @After
    fun after() {
        unloadKoinModules(listOf(appModule, dataModule, scopesModule))
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.fixer", appContext.packageName)
    }

    @Test
    fun test_initViews_calls_navigation_replace_fragment_view() {
        val fragmentActivity = mock<FragmentActivity>()
        val supportFragmentManager = mock<FragmentManager>()
        val currencyFragment = mock<CurrencyFragment>()
        val navigation = mock<Navigation>()

        `when`(fragmentActivity.supportFragmentManager).thenReturn(supportFragmentManager)

        currencyActivity.initCurrencyFragment()

        verify(
            navigation.replaceFragment(
                currencyActivity.supportFragmentManager,
                R.id.fragmentContainer,
                currencyFragment
            ), Mockito.times(1)
        )
    }
}