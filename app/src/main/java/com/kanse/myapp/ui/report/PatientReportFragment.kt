package com.kanse.myapp.ui.report

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kanse.myapp.data.PatientReportDataModel
import com.kanse.myapp.databinding.PatientReportFragmentBinding

import com.kanse.myapp.utils.Helper

class PatientReportFragment : Fragment() {

    companion object {
        fun newInstance() = PatientReportFragment()
    }

    private lateinit var adapter: PatientReportAdapter
    private lateinit var viewModel: PatientReportViewModel

    private var _binding: PatientReportFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(PatientReportViewModel::class.java)

        _binding = PatientReportFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }
fun init(){

    binding.sampleRecyclerView.layoutManager = LinearLayoutManager(context)

    adapter = context?.let { PatientReportAdapter(it, Helper.getPatientReportList()) }!!
    binding.sampleRecyclerView.adapter = adapter

}

}