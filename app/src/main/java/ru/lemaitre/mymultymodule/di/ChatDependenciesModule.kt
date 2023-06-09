package ru.lemaitre.mymultymodule.di

import com.example.api.ChatDeps
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey

@Module
object ChatDependenciesModule {

    @Provides
    fun provideChatDeps(): ChatDeps {
        return object : ChatDeps {}
    }

    @Provides
    @IntoMap
    @DependenciesKey(ChatDeps::class)
    fun bindChatDe(impl: AppComponent): Dependencies = impl
}