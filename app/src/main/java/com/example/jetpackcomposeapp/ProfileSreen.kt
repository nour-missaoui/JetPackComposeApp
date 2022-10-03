package com.example.jetpackcomposeapp


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileSreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "NourMissaoui_Instagram", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(25.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))

        ButtonSection(Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.bg_horti),
                    text = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bg_horti),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bg_horti),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.bg_horti),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        PostTabView(
            imageWithTextList = listOf(
                ImageWithText(
                    painterResource(id = R.drawable.bg_horti ) ,
                    text = "Posts"
                ), ImageWithText(
                    painterResource(id = R.drawable.bg_horti ) ,
                    text = "Reels"
                ), ImageWithText(
                    painterResource(id = R.drawable.bg_horti ) ,
                    text = "Profile"
                )
            ), modifier = Modifier.fillMaxWidth()
        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0-> PostSection(post = listOf(
                painterResource(id = R.drawable.bg_horti),
                painterResource(id = R.drawable.bg_horti),
                painterResource(id = R.drawable.bg_horti),
                painterResource(id = R.drawable.bg_horti),
                painterResource(id = R.drawable.bg_horti),
                painterResource(id = R.drawable.bg_horti),
                painterResource(id = R.drawable.bg_horti),
            ) )
        }


    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.bg_horti),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.bg_horti),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.bg_horti),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StateSection(modifier.weight(7f))
        }

        Spacer(modifier = Modifier.height(5.dp))

        ProfileData(
            displayName = "android Developer",
            description = "2 years of coding ",
            url = "https://www.linkedin.com/in/nour-missaoui-33370814b/",
            followedBy = listOf("Ala", "Ahmed"),
            otherCount = 17
        )


    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "ProfilePicture",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StateSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "600", text = "Posts")
        ProfileStat(numberText = "70K", text = "Followers")
        ProfileStat(numberText = "600k", text = "Following")

    }
}

@Composable
fun ProfileStat(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileData(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterStapsing = 0.5.sp
    val lineHight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterStapsing,
            lineHeight = lineHight
        )
        Text(
            text = description,
            letterSpacing = letterStapsing,
            lineHeight = lineHight
        )
        Text(
            text = url,
            color = Color.Blue,
            letterSpacing = letterStapsing,
            lineHeight = lineHight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black, fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1)
                            append(", ")
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterStapsing, lineHeight = lineHight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 100.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .fillMaxWidth()
                .size(height)
                .weight(1f)
                .padding(start = 10.dp, end = 10.dp)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .fillMaxWidth()
                .size(height)
                .weight(1f)
                .padding(start = 10.dp, end = 10.dp)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .fillMaxWidth()
                .size(height)
                .weight(1f)
                .padding(start = 10.dp, end = 10.dp)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = 20.dp)
                .fillMaxWidth()
                .size(height)
                .weight(0.3f)
                .padding(start = 10.dp, end = 10.dp)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(2.dp)
    ) {
        if (text != null)
            Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        if (icon != null)
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(image = highlight[it].image, modifier = Modifier.size(70.dp))
                Text(
                    text = highlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTextList: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inactiveColr = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTextList.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColr,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColr,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)

                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    post: List<Painter>,
    modifier: Modifier =Modifier
) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier.scale(1.01f)) {
        items(post.size) {
            Image(
                painter = post[it], contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, Color.White)
            )
        }
    }
}
