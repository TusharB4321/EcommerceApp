package com.example.ecommercea.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.ecommerce.R
import com.example.ecommerce.common.invisible
import com.example.ecommerce.common.viewBinding
import com.example.ecommerce.common.visible
import com.example.ecommerce.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)

            navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id == R.id.homeFragment || destination.id == R.id.cartFragment || destination.id == R.id.searchFragment || destination.id == R.id.favoriteFragment) {
                    bottomNavigationView.visible()
                } else {
                    bottomNavigationView.invisible()
                }
            }

        }
    }
}