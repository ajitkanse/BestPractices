package com.kanse.myapp.data

import android.icu.text.CaseMap

data class PatientReportDataModel(
    var id: Int,
    var patientID: Int,
    var patientName: String,
    var title: String,
    var test: String,
    var receivedTime: String,
    var barcode: String,
    var status: String
)
