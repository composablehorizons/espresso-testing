package co.composables.espressotesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class IdlingResourceTest {

    @get:Rule
    val rule = ActivityScenarioRule(NetworkActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(NetworkingIdlingResource.idlingResource)
    }

    @After
    fun clear() {
        IdlingRegistry.getInstance().unregister(NetworkingIdlingResource.idlingResource)
    }

    @Test
    fun displaysResultsAfterNetworkCall() {
        onView(withId(R.id.fetch_data))
            .perform(click())

        onView(withId(R.id.result))
            .check(matches(withText("Balance: $100")))
    }
}