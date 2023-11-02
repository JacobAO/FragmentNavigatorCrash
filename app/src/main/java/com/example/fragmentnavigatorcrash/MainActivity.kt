package com.example.fragmentnavigatorcrash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentnavigatorcrash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    private val navController: NavController by lazy {
        // the first time the nav controller is accessed, add our custom navigator
        navHostFragment.navController.also { navController ->

            val customNavigator = CustomNavigator(
                navHostFragment.childFragmentManager,
                this,
                binding.navHostFragment.id,
            )

            // if you remove this custom navigator and use <fragment instead of <custom-destination
            // in main_nav_graph.xml the crash no longer occurs
            navController.navigatorProvider.addNavigator("custom-destination", customNavigator)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val graph = navController.navInflater.inflate(R.navigation.main_nav_graph)
        navController.setGraph(graph, startDestinationArgs = null)
    }
}
