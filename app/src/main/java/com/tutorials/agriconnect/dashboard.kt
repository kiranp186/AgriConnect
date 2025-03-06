import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A complete Farmers App screen component that matches the provided UI design
 */
@Composable
fun FarmersAppScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6B8E23)) // Olive green background
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Hello, Farmers",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Sunday, 01 Dec 2024",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                IconButton(onClick = { }) {
                    // Replace with a simple Box instead of Icon with unresolved reference
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(12.dp))
                    )
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
                        .background(Color.Gray.copy(alpha = 0.3f), shape = RoundedCornerShape(12.dp))
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
                        .background(Color.Gray.copy(alpha = 0.3f), shape = RoundedCornerShape(12.dp))
                )
            }
        }

        // Commodity Scroll Component
        CommoditiesSection()

        // My Fields Section
        MyFieldsSection()

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Replace with simple boxes instead of icons with unresolved references
            BottomNavItem(isSelected = true)
            BottomNavItem(isSelected = false)
            BottomNavItem(isSelected = false)
            BottomNavItem(isSelected = false)
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

        // Define commodity items - without resource references
        val commodities = listOf(
            Commodity("Rice"),
            Commodity("Corn"),
            Commodity("Grapes"),
            Commodity("Potato"),
            Commodity("Olive"),
            Commodity("Tomato")
        )

        // Create an infinite list by repeating the original list
        val infiniteList = remember {
            generateSequence { commodities }.flatten().take(1000).toList()
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(infiniteList.size) { index ->
                val commodity = infiniteList[index]
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
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder for image
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray.copy(alpha = 0.5f), shape = RoundedCornerShape(8.dp))
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

@Composable
private fun BottomNavItem(isSelected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        // Replace icon with a box
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = if (isSelected) Color.White else Color.Gray.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(4.dp)
                )
        )
    }
}

/**
 * A data class representing a commodity with just a name
 * Removed the resource ID to fix unresolved references
 */
private data class Commodity(
    val name: String
)