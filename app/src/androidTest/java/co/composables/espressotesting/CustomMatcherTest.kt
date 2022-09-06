package co.composables.espressotesting

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomMatcherTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun hasExpectedBackgroundColor() {
        Espresso.onView(withId(R.id.recycler_view))
            .check(matches(hasBackgroundColor(Color.WHITE)))
    }

    private fun hasBackgroundColor(expectedColor: Int): Matcher<View> {
        return BackgroundColorMatcher(expectedColor)
    }
}

class BackgroundColorMatcher(
    @ColorInt private val colorValue: Int,
) : BoundedMatcher<View, View>(View::class.java) {
    override fun describeTo(description: Description) {
        description.appendText("with Background Color")
            .appendValue(colorValue)
    }

    override fun matchesSafely(item: View): Boolean {
        val colorDrawable = item.background as? ColorDrawable
        return if (colorDrawable != null) {
            colorDrawable.color == colorValue
        } else {
            false
        }
    }
}
