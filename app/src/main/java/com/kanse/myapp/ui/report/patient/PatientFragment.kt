package com.kanse.myapp.ui.report.patient

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
import com.kanse.myapp.data.PatientDataModel
import com.kanse.myapp.databinding.PatientFragmentBinding
import com.kanse.myapp.ui.HomeFragListener
import com.kanse.myapp.ui.report.PatientListener
import com.kanse.myapp.utils.Helper

class PatientFragment : Fragment(), PatientAdapterListener {

    companion object {
        fun newInstance() = PatientFragment()
    }

    private lateinit var listener: PatientListener
    private lateinit var adapter: PatientAdapter
    private lateinit var viewModel: PatientViewModel

    private var _binding: PatientFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(PatientViewModel::class.java)

        _binding = PatientFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }
fun init(){

    binding.sampleRecyclerView.layoutManager = LinearLayoutManager(context)

    adapter = context?.let { PatientAdapter(this as PatientAdapterListener, Helper.getPatientList()) }!!
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

    val filteredCourseAry: ArrayList<PatientDataModel> = ArrayList()

    val courseAry : ArrayList<PatientDataModel> = Helper.getPatientList()

    for (eachCourse in courseAry) {
        if (eachCourse.patientName!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.patientName!!.toLowerCase().contains(text.toLowerCase())) {
            filteredCourseAry.add(eachCourse)
        }
    }

    //calling a method of the adapter class and passing the filtered list
    adapter.filterList(filteredCourseAry);
}

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener =  context as PatientListener

    }

    override fun onPatientSelect() {
        listener.onPatientSelect()
    }

}