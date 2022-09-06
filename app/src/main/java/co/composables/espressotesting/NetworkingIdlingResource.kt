package co.composables.espressotesting

import androidx.test.espresso.idling.CountingIdlingResource

object NetworkingIdlingResource {
    val idlingResource = CountingIdlingResource("fetch-data")
}