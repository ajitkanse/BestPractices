package com.kanse.myapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kanse.myapp.databinding.FragmentHomeBinding
import com.kanse.myapp.ui.HomeFragListener

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    lateinit var listener : HomeFragListener

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.priceView.setOnClickListener{
            listener.onPlanSelection()
        }

        binding.bookTestBt.setOnClickListener{
            listener.onRegistrationClick()
        }

 binding.patientReport.setOnClickListener{
            listener.onViewReport()
        }

        binding.getInTouch.setOnClickListener{
            listener.onGetInTouch()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener =  context as HomeFragListener

    }
}