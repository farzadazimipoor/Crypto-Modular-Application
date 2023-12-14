package com.example.data.di

import com.example.data.repository.CoinRepositoryImpl
import com.example.data.util.AirplaneModeChangeProviderImpl
import com.example.data.util.NetworkMonitorImpl
import com.example.domain.repository.CoinRepository
import com.example.domain.util.AirplaneModeChangeProvider
import com.example.domain.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    @Binds
    fun bindsNetworkMonitor(impl: NetworkMonitorImpl): NetworkMonitor

    @Binds
    fun bindsAirplaneModeChangeProvider(impl: AirplaneModeChangeProviderImpl): AirplaneModeChangeProvider
}