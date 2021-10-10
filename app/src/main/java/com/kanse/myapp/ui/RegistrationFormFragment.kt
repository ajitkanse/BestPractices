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
import com.kanse.myapp.databinding.RegistrationFormFragmentBinding
import com.kanse.myapp.utils.Helper

class RegistrationFormFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationFormFragment()
    }

    private lateinit var viewModel: RegistrationFormViewModel
    private var _binding: RegistrationFormFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(RegistrationFormViewModel::class.java)

        _binding = RegistrationFormFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }
fun init(){

}


}