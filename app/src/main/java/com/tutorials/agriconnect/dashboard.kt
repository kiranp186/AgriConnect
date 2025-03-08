package com.tutorials.agriconnect

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

/**
 * A complete Farmers App screen component with added commodity images
 */
@Composable
fun FarmersAppScreen() {
    val scrollState = rememberScrollState()
    var isSidebarVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Main content with scroll
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF6B8E23)) // Olive green background
                    .verticalScroll(scrollState)
                    .padding(bottom = 72.dp) // Add padding for task bar at bottom
            ) {
                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Menu button for sidebar
                    IconButton(
                        onClick = { isSidebarVisible = true },
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0x33FFFFFF))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Open Menu",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = "Hello, Farmers",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp, 24.dp)
                                .background(Color(0xFF6B8E23), shape = RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                Text(
                                    "Location",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = Color.White)
                                }
                            }
                        }
                    }
                }

                // Search Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0x99FFFFFF))
                        .padding(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Replace icon with a box
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    Color.Gray.copy(alpha = 0.3f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Search here...",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        // Replace icon with a box
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    Color.Gray.copy(alpha = 0.3f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        )
                    }
                }

                // NEW SECTION: Added New Scrollable Section
                NewScrollableSection()

                // Commodity Scroll Component
                CommoditiesSection()

                // My Fields Section
                MyFieldsSection()

                Spacer(modifier = Modifier.weight(1f))
            }

            // Task Bar (always visible)
            TaskBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .zIndex(10f)
            )
        }

        // Sidebar overlay (animated)
        SidebarOverlay(
            isVisible = isSidebarVisible,
            onDismiss = { isSidebarVisible = false }
        )
    }
}

@Composable
fun SidebarOverlay(
    isVisible: Boolean,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(100f)
    ) {
        // Semi-transparent background when sidebar is visible
        if (isVisible) {
            Box(
                modifier = Modifier 
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { onDismiss() }
            )
        }

        // Animated sidebar
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(250.dp)
                    .background(Color(0xFF4A6118))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Farmers App",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 24.dp)
                    )

                    // Sidebar menu items
                    SidebarMenuItem(title = "My Account")
                    SidebarMenuItem(title = "Languages")
                    SidebarMenuItem(title = "Wish List")
                    SidebarMenuItem(title = "My Bookings")
                    SidebarMenuItem(title = "Blogs")

                    Spacer(modifier = Modifier.weight(1f))

                    // Logout at the bottom
                    SidebarMenuItem(
                        title = "Logout",
                        iconBox = {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(
                                        Color.Red.copy(alpha = 0.5f),
                                        RoundedCornerShape(4.dp)
                                    )
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SidebarMenuItem(
    title: String,
    iconBox: @Composable () -> Unit = {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
        )
    }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { /* Handle menu item click */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon placeholder
        iconBox()

        Spacer(modifier = Modifier.width(16.dp))

        // Menu item text
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun TaskBar(modifier: Modifier = Modifier) {
    // Track the selected index
    var selectedIndex by remember { mutableStateOf(0) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
            .shadow(8.dp)
            .background(Color(0xFF2D3A0F))
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Home
        TaskBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(28.dp),
                    tint = if (selectedIndex == 0) Color.White else Color.Gray
                )
            },
            text = "Home",
            isSelected = selectedIndex == 0,
            onClick = { selectedIndex = 0 }
        )

        // Categories
        TaskBarItem(
            icon = {
                // Custom icon from the provided PNG resource
                Image(
                    painter = painterResource(id = R.drawable.categories_icon),
                    contentDescription = "Categories",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(if (selectedIndex == 1) Color.White else Color.Gray)
                )
            },
            text = "Categories",
            isSelected = selectedIndex == 1,
            onClick = { selectedIndex = 1 }
        )

        // My Bookings
        TaskBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "My Bookings",
                    modifier = Modifier.size(28.dp),
                    tint = if (selectedIndex == 2) Color.White else Color.Gray
                )
            },
            text = "My Bookings",
            isSelected = selectedIndex == 2,
            onClick = { selectedIndex = 2 }
        )

        // My Account
        TaskBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "My Account",
                    modifier = Modifier.size(28.dp),
                    tint = if (selectedIndex == 3) Color.White else Color.Gray
                )
            },
            text = "My Account",
            isSelected = selectedIndex == 3,
            onClick = { selectedIndex = 3 }
        )
    }
}

@Composable
fun TaskBarItem(
    icon: @Composable () -> Unit,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(2.dp)
            .clickable(onClick = onClick)
    ) {
        // Icon content
        icon()

        Spacer(modifier = Modifier.height(4.dp))

        // Task name
        Text(
            text = text,
            fontSize = 14.sp,
            color = if (isSelected) Color.White else Color.Gray,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}
@Composable
private fun NewScrollableSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Featured Content",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Define items for the new section
        val featuredItems = listOf(
            "Weather Updates",
            "Market Prices",
            "Farming Tips",
            "Equipment Rental",
            "Community News",
            "Seasonal Crops"
        )

        // Create an infinite list by repeating the original list
        val infiniteList = remember {
            generateSequence { featuredItems }.flatten().take(1000).toList()
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(infiniteList.size) { index ->
                val item = infiniteList[index]
                FeaturedBox(item)
            }
        }
    }
}

@Composable
private fun FeaturedBox(title: String) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0x55FFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            // Placeholder for image/icon
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}

@Composable
private fun CommoditiesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Commodities and Food",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Define commodity items for first row with image resources
        val commoditiesRow1 = listOf(
            Commodity("Rice", R.drawable.rice),
            Commodity("Corn", R.drawable.corn),
            Commodity("Ragi", R.drawable.ragi),
            Commodity("Wheat", R.drawable.wheat),
            Commodity("Potato", R.drawable.potato),
            Commodity("Vegetables", R.drawable.vegetables),
            Commodity("Soyabean", R.drawable.soyabean)
        )

        // Define commodity items for second row with image resources
        val commoditiesRow2 = listOf(
            Commodity("Ginger", R.drawable.ginger),
            Commodity("Areca nut", R.drawable.areca_nut),
            Commodity("Sugarcane", R.drawable.sugarcane),
            Commodity("Cotton", R.drawable.cotton),
            Commodity("Groundnut", R.drawable.groundnut),
            Commodity("ChickPea", R.drawable.chickpea),
            Commodity("Coconut", R.drawable.coconut),
            Commodity("Fruits", R.drawable.fruits)

        )

        // Create an infinite list by repeating the original list
        val infiniteList1 = remember {
            generateSequence { commoditiesRow1 }.flatten().take(1000).toList()
        }

        // First row of commodities
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(infiniteList1.size) { index ->
                val commodity = infiniteList1[index]
                CommodityBox(commodity)
            }
        }

        // Add spacing between rows
        Spacer(modifier = Modifier.height(12.dp))

        // Create an infinite list by repeating the original list
        val infiniteList2 = remember {
            generateSequence { commoditiesRow2 }.flatten().take(1000).toList()
        }

        // Second row of commodities
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(infiniteList2.size) { index ->
                val commodity = infiniteList2[index]
                CommodityBox(commodity)
            }
        }
    }
}

@Composable
private fun CommodityBox(commodity: Commodity) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(64.dp)
    ) {
        // Image container with white background
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            // Load the actual image
            Image(
                painter = painterResource(id = commodity.imageResId),
                contentDescription = commodity.name,
                modifier = Modifier//.fillMaxSize()    //for full size icon
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = commodity.name,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Composable
private fun MyFieldsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "My Fields",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Empty section as requested
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0x22FFFFFF))
        )
    }
}

/**
 * A data class representing a commodity with a name and image resource
 */
private data class Commodity(
    val name: String,
    val imageResId: Int
)

@Preview(showBackground = true)
@Composable
fun Preview() {
    FarmersAppScreen()
}