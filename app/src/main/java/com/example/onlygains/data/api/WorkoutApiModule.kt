package com.example.onlygains.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WorkoutApiModule {

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): WorkoutApi{
        return builder. build() . create(WorkoutApi::class.java)
    }



    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder() .baseUrl(ApiConstants.BASE_URL)

            .addConverterFactory(MoshiConverterFactory.create())
    }


}