package com.tutorials.agriconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutorials.agriconnect.ui.theme.AgriconnectTheme

@Composable
fun ProductDetailsScreen() {
    var quantity by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Top App Bar with back button and cart
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.Black
            )
        }

        // Main product image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tractor), // Replace with your image resource
                contentDescription = "John Deere Tractor",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )
        }

        // Product details card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Product name and category
                Text(
                    text = "John Deere 6135E-135 HP Tractor",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Tractors",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                // Rating
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    repeat(5) { index ->
                        Icon(
                            painter = painterResource(id = R.drawable.tract1),
                            contentDescription = null,
                            tint = Color(0xFFFFC107),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = "4.6 (256)",
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                // Price
                Text(
                    text = "₹ 16,80,590",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF388E3C),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Quantity selector
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "Quantity",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp)
                    ) {
                        IconButton(
                            onClick = { if (quantity > 1) quantity-- },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Text(
                                text = "−",
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                        }

                        Text(
                            text = quantity.toString(),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                        IconButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Text(
                                text = "+",
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                        }
                    }
                }

                // Product details section
                Text(
                    text = "Product Details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )

                Text(
                    text = "This model 75hp 6E is sleek and better than ever. Whether carrying, towing, mowing, field handling, transport—the 6E Series frame glides easily through orchards and vineyards. Completely tackle...",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                TextButton(
                    onClick = { /* TODO: Show more details */ },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Read more",
                        color = Color(0xFF388E3C),
                        fontSize = 14.sp
                    )
                }

                // Reviews section
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = "Review (50)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    TextButton(
                        onClick = { /* TODO: Show all reviews */ }
                    ) {
                        Text(
                            text = "See all",
                            color = Color(0xFF388E3C),
                            fontSize = 14.sp
                        )
                    }
                }

                // Review item
                Row(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    // User avatar
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        // Replace with actual user avatar
                        Text(
                            text = "AS",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Ahmad Saifteen",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Text(
                                text = "Today",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }

                        // Rating stars
                        Row(
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            repeat(5) {
                                Icon(
                                    painter = painterResource(id = R.drawable.tract3),
                                    contentDescription = null,
                                    tint = Color(0xFFFFC107),
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }

                        // Review content
                        Text(
                            text = "Trustful reseller in my experience with its powerful performance. Competitive priced used tractors. The significant cost over brands custom-made is priceless to drive, while ac...",
                            fontSize = 13.sp,
                            color = Color.DarkGray,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        TextButton(
                            onClick = { /* TODO: Show more review */ },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "See more",
                                color = Color(0xFF388E3C),
                                fontSize = 13.sp
                            )
                        }
                    }
                }

                // Review images
                LazyRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(listOf("tractor1", "tractor2", "tractor3", "tractor4")) { item ->
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.LightGray)
                        ) {
                            // Replace with actual review images
                            Image(
                                painter = painterResource(id = R.drawable.tractor), // Replace with your image resource
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = { /* TODO: Contact seller */ },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF388E3C)
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tract4), // Add a chat icon resource
                    contentDescription = null,
                    tint = Color(0xFF388E3C)
                )
            }

            Button(
                onClick = { /* TODO: Add to cart */ },
                modifier = Modifier
                    .weight(3f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF388E3C)
                )
            ) {
                Text(text = "Add to cart")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    AgriconnectTheme {
        ProductDetailsScreen()
    }
}