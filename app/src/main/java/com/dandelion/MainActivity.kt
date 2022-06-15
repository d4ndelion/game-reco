package com.dandelion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.ActivityMainBinding
import com.dandelion.gamereco.utils.navigation.SCREENS
import com.dandelion.gamereco.utils.navigation.setCurrentScreenWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
    }

    fun navigateToScreen(screen: SCREENS) {
        findNavController(R.id.navHostFragmentContainerView).apply {
            setCurrentScreenWithNavController(screen) {
                setToolbarVisibility(screen.isToolbarVisible)
            }
        }
    }

    fun setToolbarVisibility(isVisible: Boolean) {
        binding.toolbar.isVisible = isVisible
    }
}
