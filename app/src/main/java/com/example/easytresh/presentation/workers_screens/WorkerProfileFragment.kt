package com.example.easytresh.presentation.workers_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.easytresh.MainApp
import com.example.easytresh.R
import com.example.easytresh.domain.ViewModelFactories.WorkerProfileViewModelFactory
import com.example.easytresh.domain.workersViewModles.WorkerProfileViewModel
import com.example.easytresh.repository.database.pojo.WorkersPojoItem


class WorkerProfileFragment : Fragment(R.layout.fragment_worker_profile) {

    lateinit var viewModel: WorkerProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            WorkerProfileViewModelFactory(activity?.application as MainApp)
        ).get(WorkerProfileViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.catchWorker(MainWorkerFragment.workerId)
        viewModel.getWorker().observe(viewLifecycleOwner, Observer { fillFields(it) })
    }

    private fun fillFields(it: WorkersPojoItem?) {
        if (it != null){
            view?.findViewById<TextView>(R.id.nameEdit)!!.text = it.name
            view?.findViewById<TextView>(R.id.phoneEdit)!!.text = it.phone
            view?.findViewById<TextView>(R.id.dateEdit)!!.text = it.registrationDate
        }
    }

}