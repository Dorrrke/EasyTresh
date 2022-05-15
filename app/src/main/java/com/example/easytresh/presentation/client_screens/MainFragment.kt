package com.example.easytresh.presentation.client_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.AllFragmentsViewModel
import com.example.easytresh.domain.LoginViewModel
import com.example.easytresh.domain.ViewModelFactories.AllFragmentsViewModelFactory
import com.example.easytresh.domain.ViewModelFactories.LoginViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject
import kotlin.properties.Delegates

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        const val userIdKey = "USER_ID"
        var userId by Delegates.notNull<Int>()
    }

    lateinit var generalViewModel: AllFragmentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = arguments?.get(userIdKey) as Int
        generalViewModel = ViewModelProvider(this, AllFragmentsViewModelFactory(activity?.application as MainApp) ).get(
            AllFragmentsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)
        val navController = (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

}