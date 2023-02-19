package dev.amol.spacexrockets

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpaceXRocketsApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}