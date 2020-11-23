package cz.blackchameleon.vanocka.di

import cz.blackchameleon.data.repository.CartRepository
import cz.blackchameleon.data.repository.ProductRepository
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

val dataModule = module {
    single { CartRepository(get(), get()) }
    single { ProductRepository(get(), get()) }
}