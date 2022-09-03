package ro.exemplu.profilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage()
{
    Card(elevation = 6.dp, modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
    ConstraintLayout {
        val (image,nameText,nameText2,RowStats,button1,button2,button3) = createRefs()
        val guideLine = createGuidelineFromTop(0.1f)
       Image(painter = painterResource(id = R.drawable.tedy),
           contentDescription = "Tedy",
       modifier = Modifier
           .size(150.dp)
           .clip(CircleShape)
           .border(
               width = 2.dp,
               color = Color.Black,
               shape = CircleShape
           ).constrainAs(image){
                 top.linkTo(guideLine)
               start.linkTo(parent.start)
               end.linkTo(parent.end)
           }, contentScale = ContentScale.Crop
       )
        Text(text="Profi Page",fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(nameText){
           top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        )
        Text(text= "Tedy",modifier = Modifier.constrainAs(nameText2){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .constrainAs(RowStats){
                top.linkTo(nameText2.bottom)
            }
        )
        {
            ProfileStats("150","Followers")
            ProfileStats("100","Following")
            ProfileStats("30","Posts")
        }

            Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button1){
                top.linkTo(RowStats.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(button2.start)
                width=Dimension.wrapContent
            }
                ) {
                Text(text="Follow user")
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(button2){
                    top.linkTo(RowStats.bottom, margin = 16.dp)
                    start.linkTo(button1.end)
                    end.linkTo(parent.end)
                    width=Dimension.wrapContent
                }
            ) {
                Text(text="Direct Message")
            }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(button3){
                    top.linkTo(button2.bottom)
                    width = Dimension.wrapContent
                }
        )
        {
            Button(onClick = { /*TODO*/ }
            ) {
                Text(text = "Change the Avatar Photo")
            }
        }
    }
}
}
@Composable
fun ProfileStats(count:String,title:String)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}



@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}