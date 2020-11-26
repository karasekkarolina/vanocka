package cz.blackchameleon.vanocka.di

import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.data.remote.RemoteProductSource
import cz.blackchameleon.data.remote.RemoteProfileSource
import cz.blackchameleon.vanocka.framework.remote.RemoteCartSourceImpl
import cz.blackchameleon.vanocka.framework.remote.RemoteProductSourceImpl
import cz.blackchameleon.vanocka.framework.remote.RemoteProfileSourceImpl
import org.koin.dsl.module

/**
 * Koin module for remote sources
 *
 * @author Karolina Klepackova on 24.11.2020.
 */
val remoteModule = module {
    single { RemoteProductSourceImpl(get()) as RemoteProductSource }
    single { RemoteCartSourceImpl(get()) as RemoteCartSource }
    single { RemoteProfileSourceImpl(get()) as RemoteProfileSource }
}