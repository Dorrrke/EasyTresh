package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.easytresh.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.properties.Delegates

class MainWorkerFragment : Fragment(R.layout.fragment_workers_main) {

    companion object {
        const val workerIdKey = "USER_ID"
        var workerId by Delegates.notNull<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workerId = arguments?.get(workerIdKey) as Int
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.workersBottomNavigationView)
        val navController = (childFragmentManager.findFragmentById(R.id.mainWorkersContainerView) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}