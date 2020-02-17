
package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for favorite list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class FavoriteNeighboursListTest {

    // This is fixed
    private ListNeighbourActivity mActivity;

    private class MyTestRule<T extends Activity> extends ActivityTestRule<T> {
        private NeighbourApiService mApiService;

        public MyTestRule(Class<T> activityClass) {
            super(activityClass);
        }

        @Override
        protected void beforeActivityLaunched() {
            super.beforeActivityLaunched();
            mApiService = DI.getNeighbourApiService();
            List<Neighbour> neighbours = mApiService.getNeighbours();
            mApiService.addFavoriteNeighbour(neighbours.get(0));
            mApiService.addFavoriteNeighbour(neighbours.get(1));

        }
    }

    @Rule
    public MyTestRule<ListNeighbourActivity> mActivityRule =
            new MyTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myFavoriteNeighboursList_shouldNotBeEmpty() {
        //When : swipe to left for view favorite list ( optional )
        onView(CoreMatchers.allOf(withId(R.id.container), isDisplayed())).perform(swipeLeft());
        //Then : check if the favorite list count minimum 1 element
        onView(CoreMatchers.allOf(withId(R.id.list_favorite_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }


}