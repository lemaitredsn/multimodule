package ru.lemaitre.mymultymodule.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.lemaitre.common.utils.ResourceManager

@Module
class AppModule {

    @Provides
    fun provideResourceManager(context: Context) = ResourceManager(context)
}