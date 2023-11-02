package com.example.fragmentnavigatorcrash

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("custom-destination")
class CustomNavigator(
    private val manager: FragmentManager,
    context: Context,
    containerId: Int,
) : FragmentNavigator(context, manager, containerId) {
    override fun navigate(
        entries: List<NavBackStackEntry>,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
        println("FragmentNavigatorCrash navigating with CustomNavigator")
        super.navigate(entries, navOptions, navigatorExtras)
    }

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        println("FragmentNavigatorCrash navigating with CustomNavigator")
        return super.navigate(destination, args, navOptions, navigatorExtras)
    }
}