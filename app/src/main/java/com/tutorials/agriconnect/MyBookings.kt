package com.tutorials.agriconnect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun MyBookings() {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        // Fixed header at the top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .shadow(8.dp)
                .background(Color.White)
                .padding(horizontal = 8.dp)
                .zIndex(10f),  // Ensure it stays on top
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = Color.Gray
                )
            }

            Text(
                text = "AgriConnect",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50),
                modifier = Modifier.weight(1f)
            )
        }

        // Scrollable content with padding to account for the fixed header
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp)  // Add padding equal to header height
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .verticalScroll(scrollState)
                    .padding(bottom = 72.dp)  // Add padding for task bar at bottom
            ) {
                // Your scrollable content goes here
                // For example:
                repeat(20) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFE8F5E9)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Booking #${index + 1}",
                            fontSize = 18.sp,
                            color = Color(0xFF4CAF50)
                        )
                    }
                }
            }

            // Task Bar (always visible)
            TaskBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .zIndex(10f)
            )
        }
    }
}