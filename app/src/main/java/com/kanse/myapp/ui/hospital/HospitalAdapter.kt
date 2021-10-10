package com.kanse.myapp.ui.hospital

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kanse.myapp.R
import com.kanse.myapp.data.HospitalDataModel


class HospitalAdapter() : RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    lateinit var courseList: ArrayList<HospitalDataModel>
    lateinit var context: Context


    constructor(context1 : Context, courseList1: ArrayList<HospitalDataModel>) : this() {
        courseList = courseList1
        context = context1


    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.txtTitle?.text = courseList[p1].name
        p0?.txtContent?.text = "Address :- " + courseList[p1].address.toString()
        p0?.testType?.text = "Contact Number :- " + courseList[p1].contactNumber.toString()
        

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.hospital_list_item, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.appOSTitle_txtVw)
        val txtContent = itemView.findViewById<TextView>(R.id.appOSDetails_txtVw)
        val testType = itemView.findViewById<TextView>(R.id.testType)

    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<HospitalDataModel>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}