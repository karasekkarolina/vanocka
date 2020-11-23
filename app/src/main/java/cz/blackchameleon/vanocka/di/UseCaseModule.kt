package cz.blackchameleon.vanocka.di

import cz.blackchameleon.usecases.GetCartItems
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
val useCaseModule = module {
    single { GetCartItems(get()) }
}