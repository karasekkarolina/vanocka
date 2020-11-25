package cz.blackchameleon.vanocka.di

import cz.blackchameleon.vanocka.framework.local.LocalCartSourceImpl
import cz.blackchameleon.vanocka.framework.local.LocalProductSourceImpl
import cz.blackchameleon.vanocka.framework.local.LocalProfileSourceImpl
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
val localModule = module {
    single { LocalProductSourceImpl(get()) }
    single { LocalCartSourceImpl(get()) }
    single { LocalProfileSourceImpl(get()) }
}