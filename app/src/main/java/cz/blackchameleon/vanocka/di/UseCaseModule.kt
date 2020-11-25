package cz.blackchameleon.vanocka.di

import cz.blackchameleon.usecases.cart.GetCartItems
import cz.blackchameleon.usecases.products.GetProduct
import cz.blackchameleon.usecases.cart.StoreCartItems
import cz.blackchameleon.usecases.products.GetProducts
import cz.blackchameleon.usecases.profile.DeleteProfile
import cz.blackchameleon.usecases.profile.GetProfile
import cz.blackchameleon.usecases.profile.SaveProfile
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
val useCaseModule = module {
    single { GetCartItems(get()) }
    single { StoreCartItems(get()) }
    single { GetProduct(get()) }
    single { GetProducts(get()) }
    single { GetProfile(get()) }
    single { SaveProfile(get()) }
    single { DeleteProfile(get()) }
}