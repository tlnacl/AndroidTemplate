package nz.co.sush.simplelistdetail.view.activity;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;

import nz.co.sush.simplelistdetail.RestServiceTestHelper;
import nz.co.sush.simplelistdetail.di.modules.NetworkModule;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by tomt on 12/04/17.
 */
@RunWith(AndroidJUnit4.class)
public class EventListActivityTest extends InstrumentationTestCase {
	@Rule
	public ActivityTestRule<EventListActivity> mActivityRule =
		new ActivityTestRule<>(EventListActivity.class, true, false);
	private MockWebServer server;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		server = new MockWebServer();
		server.start();
		injectInstrumentation(InstrumentationRegistry.getInstrumentation());
		NetworkModule.END_POINT = server.url("/").toString();
	}

	@After
	public void tearDown() throws Exception {
		server.shutdown();
	}

	@Test
	public void testEventList() throws Exception{
		server.enqueue(new MockResponse()
			.setResponseCode(HttpURLConnection.HTTP_OK)
			.setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "events_200_response.json")));

		Intent intent = new Intent();
		mActivityRule.launchActivity(intent);

		onView(withText("yinchuanqi")).check(matches(isDisplayed()));
	}
}
