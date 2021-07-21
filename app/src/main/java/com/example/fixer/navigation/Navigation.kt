package com.example.fixer.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object Navigation {
    /**
     * Replace a [Fragment] in the backstack in the [FragmentManager]
     *
     * @param fragment the fragment to be added.
     */
    fun replaceFragment(
        supportFragmentManager: FragmentManager, @IdRes idResContainer: Int,
        fragment: Fragment
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(idResContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}