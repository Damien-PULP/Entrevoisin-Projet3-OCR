package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.RemoveFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.StartInfoActivityEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFavoriteNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyFavoriteNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;

    public MyFavoriteNeighbourRecyclerViewAdapter(List<Neighbour> items) {
        mNeighbours = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_favorite_neighbour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(v -> EventBus.getDefault().post(new RemoveFavoriteNeighbourEvent(neighbour)));

        holder.mItemInstance.setOnClickListener(v -> EventBus.getDefault().post(new StartInfoActivityEvent(neighbour)));

    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_list_avatar_favoris)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name_favoris)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_remove_favoris_button)
        public ImageButton mDeleteButton;
        @BindView(R.id.item_favoris)
        public ConstraintLayout mItemInstance;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
