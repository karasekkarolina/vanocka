package cz.blackchameleon.vanocka.di

import cz.blackchameleon.data.repository.CartRepository
import cz.blackchameleon.data.repository.ProductRepository
import cz.blackchameleon.data.repository.ProfileRepository
import org.koin.dsl.module

/**
 * Koin module for repositories in data module
 *
 * @author Karolina Klepackova on 21.11.2020.
 */
val dataModule = module {
    single { CartRepository(get(), get()) }
    single { ProductRepository(get(), get()) }
    single { ProfileRepository(get(), get()) }
}