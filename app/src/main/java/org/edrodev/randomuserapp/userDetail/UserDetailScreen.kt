package org.edrodev.randomuserapp.userDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import org.edrodev.randomuserapp.domain.user.model.Gender
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.model.fake.fakeUser
import org.edrodev.randomuserapp.extensions.format
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun UserDetailScreen(
    userEmail: String,
    navigateUp: () -> Unit,
    viewModel: UserDetailViewModel = getViewModel { parametersOf(userEmail) },
) {
    val user by viewModel.user.collectAsState()
    user?.also { 
        Content(
            user = it,
            onBackClick = navigateUp,
        )
    }
}

@Composable
private fun Content(
    user: User,
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
                title = { Text(text = user.fullName) }
            )
        }
    ) {
        Card(Modifier.padding(16.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Image(
                    modifier = Modifier
                        .size(124.dp, 124.dp)
                        .align(CenterHorizontally),
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(user.picture.medium)
                            .crossfade(true)
                            .transformations(CircleCropTransformation())
                            .build(),
                        placeholder = rememberVectorPainter(image = Icons.Default.AccountCircle),
                    ),
                    contentDescription = null,
                )

                Row(
                    modifier = Modifier.align(CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(
                        imageVector = if(user.gender == Gender.male) Icons.Default.Male
                        else Icons.Default.Female,
                        contentDescription = null,
                    )
                    Text(text = user.fullName)
                }

                Divider(Modifier.fillMaxWidth())

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                    Text(text = user.email)
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                    Text(text = "${user.location.street.fullName}, ${user.location.city}, ${user.location.state}")
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null)
                    Text(text = "Registration date: ${user.registeredDate.format()}")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ContentPreview() {
    Content(
        user = fakeUser,
        onBackClick = {},
    )
}