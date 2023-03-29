package com.example.pruebatecnica_dashfleet.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnica_dashfleet.data.model.Routes
import com.example.pruebatecnica_dashfleet.data.provider.RouteProviders

class RouteViewModel: ViewModel() {

    val routeModel = MutableLiveData<List<Routes>>()

    fun listRoutes(){
        val list = RouteProviders.route
        routeModel.value = list
    }

}