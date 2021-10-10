package com.kanse.myapp.ui.hospital

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kanse.myapp.data.HospitalDataModel
import com.kanse.myapp.data.PatientDataModel
import com.kanse.myapp.databinding.PatientFragmentBinding
import com.kanse.myapp.ui.HomeFragListener
import com.kanse.myapp.ui.report.PatientListener
import com.kanse.myapp.utils.Helper

class HospitalListFragment : Fragment() {

    companion object {
        fun newInstance() = HospitalListFragment()
    }

    private lateinit var adapter: HospitalAdapter
    private lateinit var viewModel: HospitalViewModel

    private var _binding: PatientFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(HospitalViewModel::class.java)

        _binding = PatientFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }
fun init(){

    binding.sampleRecyclerView.layoutManager = LinearLayoutManager(context)

    adapter = context?.let { HospitalAdapter(requireContext(), Helper.getHospitalList()) }!!
    binding.sampleRecyclerView.adapter = adapter

    binding.sampleEditText.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            filter(p0.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    })
}

fun filter(text: String) {

    val filteredCourseAry: ArrayList<HospitalDataModel> = ArrayList()

    val courseAry : ArrayList<HospitalDataModel> = Helper.getHospitalList()

    for (eachCourse in courseAry) {
        if (eachCourse.name!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.name!!.toLowerCase().contains(text.toLowerCase())) {
            filteredCourseAry.add(eachCourse)
        }
    }

    //calling a method of the adapter class and passing the filtered list
    adapter.filterList(filteredCourseAry);
}

}