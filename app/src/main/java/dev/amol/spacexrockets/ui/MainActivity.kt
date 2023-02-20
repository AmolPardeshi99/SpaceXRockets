package dev.amol.spacexrockets.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.spacexrockets.databinding.ActivityMainBinding
import dev.amol.spacexrockets.viewmodel.RocketsViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private lateinit var rocketsViewModel: RocketsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        rocketsViewModel = ViewModelProvider(this)[RocketsViewModel::class.java]
    }

}