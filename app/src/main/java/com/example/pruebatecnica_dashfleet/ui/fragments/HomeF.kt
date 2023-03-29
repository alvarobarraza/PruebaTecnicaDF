package com.example.pruebatecnica_dashfleet.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica_dashfleet.R
import com.example.pruebatecnica_dashfleet.data.model.Routes
import com.example.pruebatecnica_dashfleet.databinding.FragmentHomeBinding
import com.example.pruebatecnica_dashfleet.ui.adapter.RouteAdapter
import com.example.pruebatecnica_dashfleet.ui.viewModel.RouteViewModel
import java.io.LineNumberReader

class HomeF : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private var listRoute: ArrayList<Routes> = arrayListOf()
    private var routesAdapter: RouteAdapter = RouteAdapter(listRoute)

    private val routeViewModel: RouteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        routeViewModel.listRoutes()

        routeViewModel.routeModel.observe(viewLifecycleOwner){ item ->
            listRoute.clear()
            listRoute.addAll(item)

            println(listRoute)

            routesAdapter = RouteAdapter(listRoute).also {

                binding.rvLista.layoutManager = LinearLayoutManager(requireContext())
                binding.rvLista.adapter = it
                binding.rvLista.adapter!!.notifyDataSetChanged()

            }
        }

    }
}