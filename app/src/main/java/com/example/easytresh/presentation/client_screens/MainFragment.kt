package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.easytresh.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.properties.Delegates

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        const val userIdKey = "USER_ID"
        var userId by Delegates.notNull<Int>()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = arguments?.get(userIdKey) as Int
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.workersBottomNavigationView)
        val navController = (childFragmentManager.findFragmentById(R.id.mainWorkersContainerView) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

}