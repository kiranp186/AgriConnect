package com.tutorials.agriconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun CropPage() {
    val scrollState = rememberScrollState()

    // Using the same olive green background as in FarmersAppScreen
    val backgroundColor = Color(0xFF6B8E23)
    val boxBackgroundColor = Color(0x22FFFFFF) // Semi-transparent white as in MyFieldsSection

    // Define equipment items with different images and names
    val equipmentItems = listOf(
        EquipmentItem("Moldboard Plow", R.drawable.moldboardplow),
        EquipmentItem("Tractor", R.drawable.tract4),
        EquipmentItem("Mini Maize harvester", R.drawable.miniharvester)
    )

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
                    .background(backgroundColor)  // Use the olive green background
                    .verticalScroll(scrollState)
                    .padding(16.dp)
                    .padding(bottom = 72.dp)  // Add padding for task bar at bottom
            ) {
                // Crop Heading - No box around it, white text
                Text(
                    text = "Maize",
                    fontSize = 32.sp,  // Slightly larger font
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    color = Color.White,  // Text color set to white for better contrast
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Equipment Detail Boxes - now with different images
                equipmentItems.forEachIndexed { index, item ->
                    EquipmentDetailBox(boxBackgroundColor, item)
                    Spacer(modifier = Modifier.height(24.dp))  // More space between boxes
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

/**
 * Data class to hold equipment information
 */
data class EquipmentItem(
    val name: String,
    val imageResId: Int
)

@Composable
fun EquipmentDetailBox(backgroundColor: Color, equipmentItem: EquipmentItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        // Full-width image with overlay text at bottom
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Image of equipment - filling the entire box
            Image(
                painter = painterResource(id = equipmentItem.imageResId),
                contentDescription = equipmentItem.name,
                contentScale = ContentScale.FillBounds,  // Adjust to fill width while maintaining aspect ratio
                modifier = Modifier
                    .fillMaxWidth()
                    .height(165.dp)
            )

            // Semi-transparent overlay for text at the bottom
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(8.dp)
            ) {
                // Equipment name text
                Text(
                    text = equipmentItem.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCrop() {
    CropPage()
}