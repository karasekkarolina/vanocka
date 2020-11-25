package cz.blackchameleon.vanocka.di

import cz.blackchameleon.vanocka.framework.remote.RemoteCartSourceImpl
import cz.blackchameleon.vanocka.framework.remote.RemoteProductSourceImpl
import cz.blackchameleon.vanocka.framework.remote.RemoteProfileSourceImpl
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
val remoteModule = module {
    single { RemoteProductSourceImpl(get()) }
    single { RemoteCartSourceImpl(get()) }
    single { RemoteProfileSourceImpl(get()) }
}