package com.kanse.myapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kanse.myapp.data.PriceDataModel
import com.kanse.myapp.databinding.PriceListFragmentBinding
import com.kanse.myapp.utils.Helper

class PriceListFragment : Fragment() {

    companion object {
        fun newInstance() = PriceListFragment()
    }

    private lateinit var adapter: PriceListAdapter
    private lateinit var viewModel: PriceListViewModel

    private var _binding: PriceListFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(PriceListViewModel::class.java)

        _binding = PriceListFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }
fun init(){
   // val rvRecyclerView = findViewById<RecyclerView>(R.id.sample_recyclerView)

    binding.sampleRecyclerView.layoutManager = LinearLayoutManager(context)

    adapter = context?.let { PriceListAdapter(it, Helper.getPriceList()) }!!
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

    val filteredCourseAry: ArrayList<PriceDataModel> = ArrayList()

    val courseAry : ArrayList<PriceDataModel> = Helper.Companion.getPriceList()

    for (eachCourse in courseAry) {
        if (eachCourse.title!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.title!!.toLowerCase().contains(text.toLowerCase())) {
            filteredCourseAry.add(eachCourse)
        }
    }

    //calling a method of the adapter class and passing the filtered list
    adapter.filterList(filteredCourseAry);
}

}