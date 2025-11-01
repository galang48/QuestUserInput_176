package com.example.questuserinput

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDaftar(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val status: List<String> = listOf("Janda", "Lajang", "Duda")

    // --- PALETTE THEME "modern sore masa depan" ---
    val sunsetGradient = Brush.verticalGradient(
        listOf(
            Color(0xFF2B1B3A), // ungu gelap futuristik
            Color(0xFF4D1F4F), // magenta pekat
            Color(0xFFFF6F3C)  // oranye sunset neon
        )
    )

    val cardBg = Color(0xFF1A1A24) // gelap elegan buat panel form
    val labelColor = Color(0xFFFFB69E) // oranye peach hangat (sinar sore)
    val textPrimary = Color(0xFFF2EFFA) // hampir putih, sedikit violet
    val outlineColor = Color(0xFF6E4AFF) // ungu neon lembut
    val radioSelected = Color(0xFFFF6F3C) // oranye sunset
    val radioUnselected = Color(0xFF8B6FFF) // ungu neon redup
    val headerTextColor = Color.White
    val headerGradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFF8A3D),
            Color(0xFFFF4F8B),
            Color(0xFF704BFF)
        )
    )

    val buttonGradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFF8A3D),
            Color(0xFF704BFF)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(sunsetGradient) // <-- background full screen
            .padding(top = dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    ) {

        // HEADER BAR
        Box(
            Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    brush = headerGradient,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
        ) {
            Text(
                "Formulir Pendaftaran",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    ),
                color = headerTextColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = dimensionResource(R.dimen.padding_small))
        ) {

            // CARD FORM
            Surface(
                shape = RoundedCornerShape(22.dp),
                tonalElevation = 8.dp,
                shadowElevation = 12.dp,
                color = cardBg.copy(alpha = 0.9f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    Modifier.padding(dimensionResource(R.dimen.padding_small_medium))
                ) {

                    SectionLabel(
                        text = "NAMA LENGKAP",
                        color = labelColor
                    )

                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_small),
                                bottom = dimensionResource(R.dimen.padding_small_medium)
                            ),
                        placeholder = { Text("tulis nama lengkap", color = textPrimary.copy(alpha = 0.4f)) },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(color = textPrimary),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = outlineColor,
                            unfocusedBorderColor = outlineColor.copy(alpha = 0.4f),
                            cursorColor = outlineColor,
                            focusedTextColor = textPrimary,
                            unfocusedTextColor = textPrimary,
                            focusedContainerColor = cardBg,
                            unfocusedContainerColor = cardBg
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    SectionLabel(
                        text = "JENIS KELAMIN",
                        color = labelColor
                    )

                    Column {
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    )
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = { textJK = item },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = radioSelected,
                                        unselectedColor = radioUnselected,
                                        disabledUnselectedColor = radioUnselected
                                    )
                                )
                                Text(
                                    item,
                                    color = textPrimary,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    SectionLabel(
                        text = "STATUS PERKAWINAN",
                        color = labelColor
                    )

                    Column {
                        status.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    )
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = radioSelected,
                                        unselectedColor = radioUnselected,
                                        disabledUnselectedColor = radioUnselected
                                    )
                                )
                                Text(
                                    item,
                                    color = textPrimary,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    SectionLabel(
                        text = "ALAMAT",
                        color = labelColor
                    )

                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = dimensionResource(R.dimen.padding_small)),
                        placeholder = { Text("Alamat", color = textPrimary.copy(alpha = 0.4f)) },
                        minLines = 2,
                        maxLines = 4,
                        textStyle = LocalTextStyle.current.copy(color = textPrimary),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = outlineColor,
                            unfocusedBorderColor = outlineColor.copy(alpha = 0.4f),
                            cursorColor = outlineColor,
                            focusedTextColor = textPrimary,
                            unfocusedTextColor = textPrimary,
                            focusedContainerColor = cardBg,
                            unfocusedContainerColor = cardBg
                        )
                    )

                    Spacer(Modifier.height(20.dp))

                    // SUBMIT BUTTON FUTURISTIC
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(28.dp))
                            .background(buttonGradient)
                            .padding(vertical = dimensionResource(R.dimen.padding_small)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            stringResource(R.string.submit),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // HASIL PREVIEW CARD
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0E0E14) // hampir hitam tapi ada hint ungu
                ),
                modifier = Modifier
                    .height(120.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp, vertical = 14.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Nama               : $nama",
                        color = Color(0xFFFFB69E),
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Jenis Kelamin      : $textJK",
                        color = Color(0xFFF2EFFA),
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Status Perkawinan  : $textStatus",
                        color = Color(0xFFF2EFFA),
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Alamat             : $alamat",
                        color = Color(0xFFF2EFFA),
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionLabel(
    text: String,
    color: Color = Color(0xFF6B6B6B)
) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = color,
        letterSpacing = 0.2.sp
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFormDaftar() {
    FormDaftar()
}
