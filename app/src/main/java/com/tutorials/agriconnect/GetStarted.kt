//package com.tutorials.agriconnect

// MainActivity.kt
package com.example.agriconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgriConnectApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgriConnectApp() {
    val backgroundColor = Color(0xFFFFF8E1) // Light cream color background
    val primaryColor = Color(0xFFBFA265) // Gold color for accents
    val textColor = Color(0xFF5D4037) // Dark brown for text

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Background image with wheat field
            Image(
                painter = painterResource(id = R.drawable.wheat_field),
                contentDescription = "Wheat field background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Content overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Logo at the top
                    Image(
                        painter = painterResource(id = R.drawable.agriconnect_logo),
                        contentDescription = "AgriConnect Logo",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(top = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Main headline text
                    Text(
                        text = "THE NEW ERA OF\nAGRICULTURE",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryColor,
                        textAlign = TextAlign.Center,
                        lineHeight = 36.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Subtitle text
                    Text(
                        text = "Sustainable farming solutions for a better tomorrow.",
                        fontSize = 16.sp,
                        color = textColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Stat cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Growth stat card
                        StatCard(
                            icon = R.drawable.growth_icon,
                            label = "Growth",
                            value = "12 cm"
                        )

                        // Moisture stat card
                        StatCard(
                            icon = R.drawable.moisture_icon,
                            label = "Moisture",
                            value = "75%"
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Get Started button
                    Button(
                        onClick = { /* Handle button click */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryColor
                        ),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text(
                            text = "Get Started",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun StatCard(icon: Int, label: String, value: String) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.8f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgriConnectPreview() {
    AgriConnectApp()
}