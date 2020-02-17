package com.openclassrooms.entrevoisins.ui.neighbour_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoNeighbourActivity extends AppCompatActivity {

    //UI Component
    @BindView(R.id.activity_info_neighbour_text_name)
    TextView mTextView_NameNeighbour;
    @BindView(R.id.activity_info_neighbour_text_a_description)
    TextView mTextView_About;
    @BindView(R.id.activity_info_neighbour_text_adress)
    TextView mTextView_location;
    @BindView(R.id.activity_info_neighbour_text_phone_number)
    TextView mTextView_number_phone;
    @BindView(R.id.activity_info_neighbour_profil_facebook)
    TextView mTextView_profil_facebook;
    @BindView(R.id.toolbar_layout_extended_image)
    ImageView imgCollapsingHeader;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private NeighbourApiService mApiService;

    private boolean favoriteNeighbour = false;

    private static final String BUNDLE_INDEX_CURRENT_NEIGHBOUR_INFO = "BUNDLE_INDEX_CURRENT_NEIGHBOUR_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_neighbour);

        ButterKnife.bind(this);

        mApiService = DI.getNeighbourApiService();

        Intent intent = getIntent();

        if (intent != null) {

            this.chargeNeighbourToView(intent);

        }else{
            Log.e("InfoNeighbourActivity","Nothing Intent recover");
        }

        /** Fixe Toolbar */
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void chargeNeighbourToView (Intent intent){

        int idNeighbour = intent.getIntExtra(BUNDLE_INDEX_CURRENT_NEIGHBOUR_INFO, 0);

        Neighbour neighbour = mApiService.findNeighbourWithId(idNeighbour);

        /** Favorite Neighbour checking */
        favoriteNeighbour = mApiService.checkFavoriteNeighbour(neighbour);

        UpdateUINeighbour(neighbour);
    }
    private void UpdateUINeighbour (Neighbour neighbour){

        String nameNeigbour = neighbour.getName();
        String description = neighbour.getAbout();
        String location = neighbour.getAddress();
        String number_phone = neighbour.getPhoneNumber();
        String profil_facebook = neighbour.getProfilFacebook();

        /** Update LAYOUT */
        toolbar.setTitle(nameNeigbour);

        Glide.with(imgCollapsingHeader.getContext())
                .load(neighbour.getAvatarUrl())
                .fitCenter()
                .into(imgCollapsingHeader);

        mTextView_NameNeighbour.setText(nameNeigbour);
        mTextView_About.setText(description);
        mTextView_location.setText(location);
        mTextView_number_phone.setText(number_phone);
        mTextView_profil_facebook.setText(profil_facebook);

        /** Configure Listener Button Favorite */
        if(favoriteNeighbour){
            fab.setImageDrawable(getDrawable(R.drawable.ic_star_yellow_completed_24dp));
        }else{
            fab.setImageDrawable(getDrawable(R.drawable.ic_star_border_yellow_24dp));
        }

        fab.setOnClickListener(view -> {

            favoriteNeighbour = !favoriteNeighbour;

            if(favoriteNeighbour){
                fab.setImageDrawable(getDrawable(R.drawable.ic_star_yellow_completed_24dp));
                mApiService.addFavoriteNeighbour(neighbour);
                Snackbar.make(view, "Voisin ajouté au favoris", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }else{
                fab.setImageDrawable(getDrawable(R.drawable.ic_star_border_yellow_24dp));
                mApiService.removeFavoriteNeighbour(neighbour);
                Snackbar.make(view, "Voisin retiré des favoris", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                Intent intent = new Intent(this, ListNeighbourActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ListNeighbourActivity.class);
        startActivity(intent);
    }
}
