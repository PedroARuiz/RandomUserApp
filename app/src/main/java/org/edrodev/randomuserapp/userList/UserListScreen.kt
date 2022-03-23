package org.edrodev.randomuserapp.userList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.model.fake.fakeUser
import org.edrodev.randomuserapp.ui.theme.RandomUserAppTheme
import org.koin.androidx.compose.viewModel

@Composable
internal fun UserListScreen(
    onUserClicked: (User) -> Unit,
) {
    val viewModel: UserListViewModel by viewModel()
    val state by viewModel.state.collectAsState()
    val snackbarHostState = rememberScaffoldState().snackbarHostState

    LaunchedEffect(key1 = state.error) {
        state.error?.also { snackbarHostState.showSnackbar("Something went wrong") }
    }

    Content(
        state = state,
        snackbarHostState = snackbarHostState,
        onLoadUsers = viewModel::loadUsers,
        onUserClicked = onUserClicked,
        onDeleteUser = viewModel::removeUser,
        onQueryChanged = viewModel::filter,
    )
}

@Composable
private fun Content(
    state: UserListViewModel.State,
    snackbarHostState: SnackbarHostState = rememberScaffoldState().snackbarHostState,
    onLoadUsers: () -> Unit,
    onUserClicked: (User) -> Unit,
    onDeleteUser: (User) -> Unit,
    onQueryChanged: (String) -> Unit,
) {
    val scaffoldState = rememberScaffoldState(
        snackbarHostState = snackbarHostState,
    )
    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.filter,
                onValueChange = onQueryChanged,
            )

            if (state.isFetchingUsers) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
            if (state.users.isNotEmpty()) {
                UsersList(
                    state = state,
                    onLoadUsers = onLoadUsers,
                    onUserClicked = onUserClicked,
                    onDeleteUser = onDeleteUser,
                )
            } else {
                EmptyState(
                    onLoadUsersClick = onLoadUsers,
                )
            }
        }
    }
}

@Composable
private fun UsersList(
    modifier: Modifier = Modifier,
    state: UserListViewModel.State,
    onLoadUsers: () -> Unit,
    onUserClicked: (User) -> Unit,
    onDeleteUser: (User) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    lazyListState.OnBottomReached { onLoadUsers() }

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(state.users, key = User::email) { user ->
            UserItemList(
                user = user,
                onUserClicked = onUserClicked,
                onDeleteUser = onDeleteUser,
            )
        }

        item {
            if(state.isFetchingUsers) {
                CircularProgressIndicator()
            } else {
                Button(onClick = onLoadUsers) {
                    Text(text = "Load Users")
                }
            }
        }
    }
}

@Composable
fun LazyListState.OnBottomReached(
    threshold: Int = 5,
    loadMore : () -> Unit,
){
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - threshold
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore){
        snapshotFlow { shouldLoadMore.value }
            .collect {
                // if should load more, then invoke loadMore
                if (it) loadMore()
            }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun UserItemList(
    user: User,
    onUserClicked: (User) -> Unit,
    onDeleteUser: (User) -> Unit,
) {
    Card(
        onClick = { onUserClicked(user) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(42.dp, 42.dp),
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(user.picture.thumbnail)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build(),
                    placeholder = rememberVectorPainter(image = Icons.Default.AccountCircle),
                ),
                contentDescription = null,
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = user.fullName,
                    fontWeight = FontWeight.Bold,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                    Text(text = user.email)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                    Text(text = user.phone)
                }
            }

            IconButton(onClick = { onDeleteUser(user) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Red,
                )
            }
        }
    }

}

@Composable
private fun EmptyState(
    onLoadUsersClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(text = "There aren't users")
        Button(onClick = onLoadUsersClick) {
            Text(text = "Load Users")
        }
    }
}

internal class FakeStateProvider: PreviewParameterProvider<UserListViewModel.State> {
    override val values: Sequence<UserListViewModel.State> = sequenceOf(
        UserListViewModel.State(),
        UserListViewModel.State(
            users = listOf(fakeUser),
        ),
    )
}

@Preview
@Composable
private fun ContentPreview(@PreviewParameter(FakeStateProvider::class) state: UserListViewModel.State) {
    RandomUserAppTheme {
        Content(
            state = state,
            onLoadUsers = {},
            onUserClicked = {},
            onDeleteUser = {},
            onQueryChanged = {},
        )
    }

}