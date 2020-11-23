package cz.blackchameleon.vanocka.di

import cz.blackchameleon.vanocka.ui.cart.CartViewModel
import cz.blackchameleon.vanocka.ui.products.ProductsViewModel
import cz.blackchameleon.vanocka.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

val viewModelModule = module {
    viewModel { CartViewModel(get()) }
    viewModel { ProductsViewModel() }
    viewModel { ProfileViewModel() }
}