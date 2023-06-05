package ru.lemaitre.mymultymodule.di

import com.example.accounts.api.AccountLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AccountDepsModule {

    @Provides
    @Singleton
    fun providesAccountLoader(): AccountLoader = AccountFactory.create()
}