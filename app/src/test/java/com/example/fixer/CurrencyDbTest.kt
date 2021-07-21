package com.example.fixer

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CurrencyDbTest {

    @Mock
    lateinit var currencyDb: CurrencyDbTest

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun `write test case here`() {
        //
    }
}