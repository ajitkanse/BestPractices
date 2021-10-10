package com.kanse.myapp.data

import android.icu.text.CaseMap

data class PatientDataModel(
    var id: Int,
    var patientID: Int,
    var patientName: String,
    var status: String,
    var details: String
)
