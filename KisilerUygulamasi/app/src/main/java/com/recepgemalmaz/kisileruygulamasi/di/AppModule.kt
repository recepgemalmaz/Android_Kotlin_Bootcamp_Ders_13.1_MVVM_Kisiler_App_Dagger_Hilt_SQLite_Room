package com.recepgemalmaz.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.recepgemalmaz.kisileruygulamasi.data.datasource.KisilerDataSources
import com.recepgemalmaz.kisileruygulamasi.data.repo.KisilerRopository
import com.recepgemalmaz.kisileruygulamasi.room.KisilerDao
import com.recepgemalmaz.kisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerRepository(kds :KisilerDataSources) : KisilerRopository {
        return KisilerRopository(kds)

    }

    @Provides
    @Singleton
    fun provideKisilerDataSources(kdoa: KisilerDao) : KisilerDataSources {
        return KisilerDataSources(kdoa)
    }
    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao {

        val vt = Room.databaseBuilder(context, Veritabani::class.java, "rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return vt.getKisilerDao()
    }

}