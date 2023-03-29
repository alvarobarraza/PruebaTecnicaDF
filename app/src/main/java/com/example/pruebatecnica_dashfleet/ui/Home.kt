package com.example.pruebatecnica_dashfleet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.pruebatecnica_dashfleet.R
import com.example.pruebatecnica_dashfleet.databinding.ActivityHomeBinding
import com.example.pruebatecnica_dashfleet.ui.fragments.*

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeF())

        binding.apply {
            toggle = ActionBarDrawerToggle(this@Home, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            binding.menu.setOnClickListener {
                binding.drawerLayout.openDrawer(navView)
            }

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        loadFragment(HomeF())
                        drawerLayout.closeDrawer(navView)
                        true
                    }
                    R.id.agregar -> {
                        loadFragment(AgregarF())
                        drawerLayout.closeDrawer(navView)
                        true
                    }
                    R.id.cartera -> {
                        loadFragment(CarteraF())
                        drawerLayout.closeDrawer(navView)
                        true
                    }
                    R.id.cash -> {
                        loadFragment(CashF())
                        drawerLayout.closeDrawer(navView)
                        true
                    }
                    R.id.config -> {
                        loadFragment(ConfigF())
                        drawerLayout.closeDrawer(navView)
                        true
                    }
                    else -> {
                        return@setNavigationItemSelectedListener true
                    }
                }
            }
        }

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeF())
                    true
                }
                R.id.agregar -> {
                    loadFragment(AgregarF())
                    true
                }
                R.id.cartera -> {
                    loadFragment(CarteraF())
                    true
                }
                R.id.cash -> {
                    loadFragment(CashF())
                    true
                }
                R.id.config -> {
                    loadFragment(ConfigF())
                    true
                }
                else -> {
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}