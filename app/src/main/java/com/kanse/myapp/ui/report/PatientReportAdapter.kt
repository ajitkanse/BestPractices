package com.kanse.myapp.ui.report

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kanse.myapp.R
import com.kanse.myapp.data.PatientReportDataModel


class PatientReportAdapter(val context : Context, var courseList: ArrayList<PatientReportDataModel>) : RecyclerView.Adapter<PatientReportAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.txtTitle?.text = courseList[p1].title
        p0?.txtContent?.text = courseList[p1].test.toString()
        p0?.testType?.text = "Recevied Time :- " + courseList[p1].receivedTime.toString()
        p0?.barcode?.text = "Barcode :- " + courseList[p1].barcode.toString()
        p0?.reportStatus?.text = "Status :- " + courseList[p1].status.toString()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.patient_report_list_item, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.appOSTitle_txtVw)
        val txtContent = itemView.findViewById<TextView>(R.id.appOSDetails_txtVw)
        val testType = itemView.findViewById<TextView>(R.id.testType)
        val barcode = itemView.findViewById<TextView>(R.id.barcode)
        val reportStatus = itemView.findViewById<TextView>(R.id.reportStatus)
    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<PatientReportDataModel>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}