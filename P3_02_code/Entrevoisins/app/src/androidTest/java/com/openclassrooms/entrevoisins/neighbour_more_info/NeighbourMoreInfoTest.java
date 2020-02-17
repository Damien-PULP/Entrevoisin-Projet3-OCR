package com.openclassrooms.entrevoisins.neighbour_more_info;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_info.InfoNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class NeighbourMoreInfoTest {

    private NeighbourApiService mApiService;
    private List<Neighbour> listNeighbour;

    @Rule
    public ActivityTestRule<InfoNeighbourActivity> mActivityRule =
            new ActivityTestRule<>(InfoNeighbourActivity.class);

    @Before
    public void setUp (){
        mApiService = DI.getNeighbourApiService();
        listNeighbour = mApiService.getNeighbours();
    }
    /**
     * When activity ( InfoNeighbourActivity ) is loaded
     */
    @Test
    public void myNeighbour_text_shouldNotEmpty (){
        // Given : we create intent with extra for charge activity more info with neighbour 0
        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = new Intent(targetContext, InfoNeighbourActivity.class);
        intent.putExtra("BUNDLE_INDEX_CURRENT_NEIGHBOUR_INFO", 0);
        //when : we intended the activity
        mActivityRule.launchActivity(intent);
        //Then : we check value of text name Neighbour with name of neighbour
        onView(ViewMatchers.withId(R.id.activity_info_neighbour_text_name)).check(matches(withText(listNeighbour.get(0).getName())));
    }
}
