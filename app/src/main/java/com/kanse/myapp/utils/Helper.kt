package com.kanse.myapp.utils

import com.kanse.myapp.data.HospitalDataModel
import com.kanse.myapp.data.PatientDataModel
import com.kanse.myapp.data.PatientReportDataModel
import com.kanse.myapp.data.PriceDataModel

class Helper{
    companion object {
        fun <ArrayList> getPriceList(): ArrayList {
            var courseList = ArrayList<PriceDataModel>()
            courseList.add(PriceDataModel(1,234,"Fungal Stain (KOH Mount)", "Test"))
            courseList.add(PriceDataModel(2,234,"Fungal Stain (KOH Mount)", "Test"))
            courseList.add(PriceDataModel(3,234,"Fungal Stain (KOH Mount)", "Test"))
            courseList.add(PriceDataModel(4,234,"Fungal Stain (KOH Mount)", "Test"))
            courseList.add(PriceDataModel(5,234,"Fungal Stain (KOH Mount)", "Test"))

            return courseList as ArrayList
        }

        fun <ArrayList> getPatientList(): ArrayList {
            var courseList = ArrayList<PatientDataModel>()
            courseList.add(PatientDataModel(1,234,"Ajit Kanse", "View Report",""))
            courseList.add(PatientDataModel(2,235,"Ajit Kanse", "View Report",""))
            courseList.add(PatientDataModel(3,236,"Ajit Kanse", "View Report",""))
            courseList.add(PatientDataModel(4,237,"Ajit Kanse", "View Report",""))
            courseList.add(PatientDataModel(5,238,"Ajit Kanse", "View Report",""))

            return courseList as ArrayList
        }

        fun <ArrayList> getPatientReportList(): ArrayList {
            var courseList = ArrayList<PatientReportDataModel>()
            courseList.add(PatientReportDataModel(1,234,"Ajit Kanse", "Thyroid Profile - Total T3, Total T4, TSH (TFT)","Pathalogy Test","2021-07-18 17:25:12","782382382","Report Generated"))
            courseList.add(PatientReportDataModel(2,234,"Ajit Kanse", "Thyroid Profile - Total T3, Total T4, TSH (TFT)","Pathalogy Test","2021-07-18 17:25:12","782382382","Report Generated"))
            courseList.add(PatientReportDataModel(3,234,"Ajit Kanse", "Thyroid Profile - Total T3, Total T4, TSH (TFT)","Pathalogy Test","2021-07-18 17:25:12","782382382","Report Generated"))
            courseList.add(PatientReportDataModel(4,234,"Ajit Kanse", "Thyroid Profile - Total T3, Total T4, TSH (TFT)","Pathalogy Test","2021-07-18 17:25:12","782382382","Report Generated"))
            courseList.add(PatientReportDataModel(5,234,"Ajit Kanse", "Thyroid Profile - Total T3, Total T4, TSH (TFT)","Pathalogy Test","2021-07-18 17:25:12","782382382","Report Generated"))

            return courseList as ArrayList
        }

        fun <ArrayList> getHospitalList(): ArrayList {
            var courseList = ArrayList<HospitalDataModel>()
            courseList.add(HospitalDataModel(1,"Pune","Lokamanya Hospital", "909668663","Lokamanya Hospital"))
            courseList.add(HospitalDataModel(1,"Pune","Lokamanya Hospital", "909668663","Lokamanya Hospital"))
            courseList.add(HospitalDataModel(1,"Pune","Lokamanya Hospital", "909668663","Lokamanya Hospital"))
            courseList.add(HospitalDataModel(1,"Pune","Lokamanya Hospital", "909668663","Lokamanya Hospital"))
            courseList.add(HospitalDataModel(1,"Pune","Lokamanya Hospital", "909668663","Lokamanya Hospital"))

            return courseList as ArrayList
        }
    }
}