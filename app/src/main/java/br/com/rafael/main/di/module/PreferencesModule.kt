package br.com.rafael.main.di.module

import android.content.Context
import br.com.rafael.main.repository.preferences.UserPreferencesHelperImpl
import br.com.rafael.main.util.USER_PREFERENCES
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule(val context: Context) {

    @Provides
    internal fun provideUserPreferences():UserPreferencesHelperImpl = UserPreferencesHelperImpl(context,
        USER_PREFERENCES)


}