package com.curso.android.marketapp

import android.view.View

interface ItemClickListener {
    fun onCLick(v: View, pos: Int)
}