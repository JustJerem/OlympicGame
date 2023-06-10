package com.jeremieguillot.olympicgame.di

import android.content.Context
import com.jeremieguillot.olympicgame.data.network.client.OlympicApiClient
import com.jeremieguillot.olympicgame.data.network.util.NetworkHandlerImpl
import com.jeremieguillot.olympicgame.data.repository.AthleteRepositoryImpl
import com.jeremieguillot.olympicgame.data.repository.GameRepositoryImpl
import com.jeremieguillot.olympicgame.domain.repository.AthleteRepository
import com.jeremieguillot.olympicgame.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideAthleteRepository(
        networkHandler: NetworkHandlerImpl,
        apiClient: OlympicApiClient,
    ) : AthleteRepository {
        return AthleteRepositoryImpl(
            networkHandler,
            apiClient
        )
    }

    @Singleton
    @Provides
    fun provideGameRepository(
        networkHandler: NetworkHandlerImpl,
        apiClient: OlympicApiClient
    ): GameRepository {
        return GameRepositoryImpl(
            networkHandler,
            apiClient
        )
    }

    @Singleton
    @Provides
    fun providesNetworkHandler(@ApplicationContext context: Context): NetworkHandlerImpl {
        return NetworkHandlerImpl(context)
    }
}