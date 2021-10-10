package com.kanse.myapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kanse.myapp.R
import com.kanse.myapp.data.PriceDataModel

class PriceListAdapter(val context : Context, var courseList: ArrayList<PriceDataModel>) : RecyclerView.Adapter<PriceListAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.txtTitle?.text = courseList[p1].title
        p0?.txtContent?.text = "MRP : ${courseList[p1].price.toString()} - B2B : 50.0"
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.price_list_item, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.appOSTitle_txtVw)
        val txtContent = itemView.findViewById<TextView>(R.id.appOSDetails_txtVw)
    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<PriceDataModel>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}