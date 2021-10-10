package com.kanse.myapp.ui.report.patient

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kanse.myapp.R
import com.kanse.myapp.data.PatientDataModel


class PatientAdapter() : RecyclerView.Adapter<PatientAdapter.ViewHolder>() {

    lateinit var courseList: ArrayList<PatientDataModel>
    lateinit var listener : PatientAdapterListener

    constructor(context : PatientAdapterListener, courseList1: ArrayList<PatientDataModel>) : this() {
        listener = context as PatientAdapterListener
        courseList = courseList1

    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.txtTitle?.text = courseList[p1].patientName
        p0?.txtContent?.text = "P.Id :- " + courseList[p1].patientID.toString()
        p0?.testType?.text = "Status :- " + courseList[p1].status.toString()

        p0.itemView1.setOnClickListener{
            listener.onPatientSelect()
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.patient_list_item, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.appOSTitle_txtVw)
        val txtContent = itemView.findViewById<TextView>(R.id.appOSDetails_txtVw)
        val testType = itemView.findViewById<TextView>(R.id.testType)
        val itemView1 = itemView.findViewById<ConstraintLayout>(R.id.itemView)

    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<PatientDataModel>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}