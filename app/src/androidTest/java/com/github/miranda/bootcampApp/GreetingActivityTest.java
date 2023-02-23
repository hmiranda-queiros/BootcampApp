package com.github.miranda.bootcampApp;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {
    @Test
    public void receivedIntentWithNameExtraDisplaysCorrectGreeting() {
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra("name", "John");
        try (ActivityScenario<GreetingActivity> scenario = ActivityScenario.launch(intent)) {
            androidx.test.espresso.Espresso.onView(withId(R.id.greetingMessage))
                    .check(matches(withText("Hello John!")));
        }
    }

    @Test
    public void receivedIntentWithNoNameExtraDisplaysCorrectGreeting() {
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        try (ActivityScenario<GreetingActivity> scenario = ActivityScenario.launch(intent)) {
            androidx.test.espresso.Espresso.onView(withId(R.id.greetingMessage))
                    .check(matches(withText("Hello !")));
        }
    }
}

