package cz.blackchameleon.vanocka.di

import cz.blackchameleon.data.repository.DataRepository
import org.koin.dsl.module

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

val dataModule = module {
    single { DataRepository() }
}