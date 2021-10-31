package com.example.wassapppractice.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wassapppractice.models.SampleData
import com.example.wassapppractice.ui.theme.liteGrayColor
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WhatsAppChat(){
    val date = SimpleDateFormat("hh.mm.a")
    val strDate : String = date.format(Date())

    val listOfData = listOf(
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate),
        SampleData("Name 1","Its is description","img url",strDate)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ){
            items(listOfData.size) { index ->
                SampleDataListener(listOfData[index])
            }
        }
    }


}

@Composable
fun SampleDataListener(data: SampleData) {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = com.example.wassapppractice.R.drawable.ic_baseline_cruelty_free_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = data.name,
                        modifier = Modifier.weight(1.0f),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                    )

                    Text(
                        text = data.createdDate,
                        modifier = Modifier.weight(0.5f),
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.End,
                        fontSize = 12.sp,
                    )
                }

                Spacer(
                    modifier = Modifier.padding(5.dp)
                )


                Text(
                    text = data.des,
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal

                )

                Spacer(
                    modifier = Modifier.padding(5.dp)
                )

                Divider(color = liteGrayColor,
                thickness = 1.dp)
            }

        }
    }
}










@Composable
fun WhatsAppStatus(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WhatsApp Status",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )

    }
}







@Composable
fun WhatsAppCalls(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WhatsApp Calls",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )

    }
}

