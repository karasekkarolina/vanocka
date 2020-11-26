# Example Android app for shopping

## Prerequisites
* Android SDK v21 and above
* Compile SDK v30
* Latest Android Build Tools
* Gradle 6.5

## Installation

1. Download or clone this repository
2. Open project in Android Studio
3. Sync project with Gradle files
4. Run 'app' solution on your mobile phone or emulator

## Technlogies

* Android
* Jetpack
* MVVM
* Kotlin
* Live Data
* Kotlin coroutines
* RxKotlin
* Retrofit
* Room
* Picasso
* Mockito

## Architecture
App is developed as a single activity with multiple fragments and is written in Kotlin language.

It uses Android [Navigation Component](https://developer.android.com/guide/navigation) for navigating between screens.

### Async work:
API calls are handled by Retrofit via RxKotlin.
DB calls are handled by Room database via RxKotlin.
Other async tasks are done via Kotlin coroutines.

Both technologies are used just for demonstration.

UI states are held in View Models and propagated via Live data values.

Unit tests are based on Mockito and JUnit.
