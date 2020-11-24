package cz.blackchameleon.vanocka.di

import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.data.local.LocalProductSource
import cz.blackchameleon.vanocka.framework.local.LocalCartSourceImpl
import cz.blackchameleon.vanocka.framework.local.LocalProductSourceImpl
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
val localModule = module {
    single { LocalProductSourceImpl(get()) as LocalProductSource }
    single { LocalCartSourceImpl(get()) as LocalCartSource }
}