package com.kanse.myapp

import android.os.Bundle
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kanse.myapp.databinding.ActivityMainBinding
import com.kanse.myapp.ui.HomeFragListener
import com.kanse.myapp.ui.report.PatientListener

class MainActivity : AppCompatActivity(), HomeFragListener, PatientListener {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_covid, R.id.navigation_wallet, R.id.navigation_notifications, R.id.navigation_profile))

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        if (supportActionBar != null) {
            supportActionBar?.hide();
        }

        /*     getWindow().setFlags(
                 WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        /*      setupActionBarWithNavController(navController, appBarConfiguration)
              navView.setupWithNavController(navController)*/
    }

    override fun onPlanSelection() {
        navController.navigate(R.id.action_navigation_home_to_priceListFragment)
    }

    override fun onRegistrationClick() {
        navController.navigate(R.id.action_navigation_home_to_registrationFormFragment)
    }

    override fun onViewReport() {
        navController.navigate(R.id.action_navigation_home_to_patientReportFragment)
    }

    override fun onPatientSelection() {

    }

    override fun onGetInTouch() {
        navController.navigate(R.id.action_navigation_home_to_hospitalListFragment)
    }

    override fun onPatientSelect() {
        navController.navigate(R.id.action_patientReportFragment_to_patientReportFragment2)
    }
}