package cz.blackchameleon.vanocka

import android.app.Application
import cz.blackchameleon.vanocka.di.dataModule
import cz.blackchameleon.vanocka.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * App
 * Application class that init dependency injection
 *
 * @see Application
 *
 * @author Karolina Klepackova on 22.11.2020.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Dependency injection made by insert-koin.io (see https://insert-koin.io)
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule,
                    dataModule
                )
            )
        }
    }
}
