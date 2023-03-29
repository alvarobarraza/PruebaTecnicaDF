package com.example.pruebatecnica_dashfleet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica_dashfleet.R
import com.example.pruebatecnica_dashfleet.data.model.Routes
import com.example.pruebatecnica_dashfleet.databinding.ItemRoutesBinding

class RouteAdapter (var route: List<Routes>):RecyclerView.Adapter<RouteAdapter.RouteHolder>() {


    class RouteHolder (view: View):RecyclerView.ViewHolder(view){
        private val binding = ItemRoutesBinding.bind(view)

        fun render(route: Routes){
            binding.tvName.text = route.name
            binding.tvDistance.text = route.distance
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RouteHolder(
            layoutInflater.inflate(
                R.layout.item_routes,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RouteHolder, position: Int) {
        holder.render(route[position])
    }

    override fun getItemCount(): Int {
        return route.size
    }
}