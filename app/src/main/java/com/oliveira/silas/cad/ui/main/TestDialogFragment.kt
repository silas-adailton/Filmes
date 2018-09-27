package com.oliveira.silas.cad.ui.main

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.oliveira.silas.cad.R

class TestDialogFragment : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity?.layoutInflater?.inflate(R.layout.teste_dialog_fragment, null)

        val alert = activity?.let { AlertDialog.Builder(it) }
        alert?.setView(view)



        return alert?.create()!!
    }
}