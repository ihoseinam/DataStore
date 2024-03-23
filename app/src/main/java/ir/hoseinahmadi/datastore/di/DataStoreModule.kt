package ir.hoseinahmadi.datastore.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.hoseinahmadi.datastore.datastore.DataStoreRepository
import ir.hoseinahmadi.datastore.datastore.DataStoreRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext app: Context
    ):DataStoreRepository = DataStoreRepositoryImpl(app)



}