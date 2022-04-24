package com.dandelion

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.dandelion.gamereco.R
import com.dandelion.gamereco.utils.navigation.SCREENS
import com.dandelion.gamereco.utils.navigation.setCurrentScreenWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }

    fun navigateToScreen(screen: SCREENS) {
        findNavController(R.id.navHostFragmentContainerView).apply {
            setCurrentScreenWithNavController(screen)
        }
    }
}
