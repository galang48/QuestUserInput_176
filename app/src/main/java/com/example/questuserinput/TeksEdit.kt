package com.example.questuserinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable

fun FormDataDiri(modifier: Modifier
){
    //variabel-variabel untuk mengingat nilai masukkan dari keyboard

    var textNama by remember {mutableStateOf("") }
}