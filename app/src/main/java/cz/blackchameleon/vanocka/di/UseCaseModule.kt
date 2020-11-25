package cz.blackchameleon.vanocka.di

import cz.blackchameleon.usecases.cart.GetCartItems
import cz.blackchameleon.usecases.products.GetProduct
import cz.blackchameleon.usecases.cart.StoreCartItems
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
val useCaseModule = module {
    single { GetCartItems(get()) }
    single { StoreCartItems(get()) }
    single { GetProduct(get()) }
}