package com.ethanx94.wearapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import com.ethanx94.wearapp.R
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoSessionSettings
import org.mozilla.geckoview.GeckoView


class MainActivity : ComponentActivity() {

    private lateinit var geckoView: GeckoView
    private lateinit var geckoSession: GeckoSession
    private lateinit var geckoRuntime: GeckoRuntime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize GeckoView
        geckoView = findViewById<GeckoView>(R.id.gecko_view)

        // Create a GeckoRuntime
        val runtimeSettings = GeckoRuntimeSettings.Builder()
            // .automaticFontSizeAdjustment(false) // Disable automatic font size adjustment
            // .fontInflation(true)
            // .fontSizeFactor(9.5f)
            .displayDensityOverride(0.85f)
            // .automaticFontSizeAdjustment(true) // Enable automatic font size adjustment
            .build()
        geckoRuntime = GeckoRuntime.create(this, runtimeSettings)

        // Create GeckoSessionSettings
        val settings = GeckoSessionSettings.Builder()
            .usePrivateMode(false)
            .useTrackingProtection(false)
            //.viewportMode(GeckoSessionSettings.VIEWPORT_MODE_DESKTOP)
            .build()

        // Create a GeckoSession with the settings
        geckoSession = GeckoSession(settings)

        // Open the session in the GeckoView
        geckoSession.open(geckoRuntime)

        // Attach the session to the GeckoView
        geckoView.setSession(geckoSession)
        geckoSession.loadUri("http://coastridetracker.com/")

        // Override onBackPressedDispatcher, prevents closing on swiping left
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do nothing to prevent the activity from closing
            }
        })
    }
}