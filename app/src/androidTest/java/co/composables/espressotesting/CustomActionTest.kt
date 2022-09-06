package co.composables.espressotesting

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomActionTest {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun resetClearsCounter() {
        onView(withId(R.id.add))
            .perform(click())

        onView(withId(R.id.counter))
            .perform(ResetCounterAction())

        onView(withId(R.id.counter))
            .check(matches(withText("0")))
    }

}

class ResetCounterAction : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return allOf(isDisplayed(), isAssignableFrom(CounterView::class.java))
    }

    override fun getDescription(): String {
        return "Resets the Counter"
    }

    override fun perform(uiController: UiController, view: View) {
        (view as CounterView).resetCounter()
    }

}
