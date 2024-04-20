package com.example.testappeffectivemobile

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.feature_main.view.fragments.MainFragment
import com.example.navigation.NavigationFlow
import com.example.navigation.Navigator
import com.example.navigation.ToFlowNavigatable
import com.example.testappeffectivemobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ToFlowNavigatable {

    private val navigator: Navigator = Navigator()

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))


        val navController = findNavController(binding.fragmentContainerView.id)
        navigator.navController = navController

        setContentView(binding.root)
    }

    override fun navigateToFlow(flow : NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}