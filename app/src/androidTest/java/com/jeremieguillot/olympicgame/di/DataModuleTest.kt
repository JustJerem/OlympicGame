package com.jeremieguillot.olympicgame.di

import com.jeremieguillot.olympicgame.data.repository.fake.FakeGameRepository
import com.jeremieguillot.olympicgame.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
class DataModuleTest {
    @Singleton
    @Provides
    fun provideAthleteRepository(
    ): GameRepository {
        return FakeGameRepository()
    }
}
