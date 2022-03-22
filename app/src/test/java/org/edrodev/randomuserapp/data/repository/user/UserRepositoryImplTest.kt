package org.edrodev.randomuserapp.data.repository.user

import androidx.room.Room
import app.cash.turbine.test
import kotlinx.coroutines.runBlocking
import org.edrodev.randomuserapp.data.local.RandomUsersDataBase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UserRepositoryImplTest : KoinTest {

    private val usersCount = 5

    private lateinit var sut: UserRepositoryImpl

    private val testModule = module {
        single {
            Room.inMemoryDatabaseBuilder(androidContext(), RandomUsersDataBase::class.java)
                .build()
        }
    }

    @Before
    fun setUp() {
        loadKoinModules(testModule)

        sut = UserRepositoryImpl(
            userLocalDataSource = get(),
            userRemoteDataSource = get(),
        )
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `findUsers post updates after fetch users`(): Unit = runBlocking {
        sut.findUsers().test {
            assert(awaitItem().isEmpty())
            sut.fetchUsers(usersCount)
            assert(awaitItem().size == usersCount)

            cancelAndIgnoreRemainingEvents()
        }
    }
}