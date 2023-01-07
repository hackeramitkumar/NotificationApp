package com.example.notificationapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notificationapp.R;
import com.example.notificationapp.data.network.model.IntroSlide;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class IntroSliderAdapter extends RecyclerView.Adapter<IntroSliderAdapter.ViewHolder> {

    private final List<IntroSlide> mIntroSlides;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textTitle;
        private final TextView textDescription;
        private final ShapeableImageView imageIcon;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            //TextView textTitle = (TextView)findViewById(R.id.textTitle);
            textDescription = (TextView) view.findViewById(R.id.textDescription);
            imageIcon = (ShapeableImageView) view.findViewById(R.id.imageSlideIcon);
            textTitle = (TextView) view.findViewById(R.id.textTitle);
        }

        public TextView getTextTitle() {
            return textTitle;
        }

        public TextView getTextDescription() {
            return textDescription;
        }

        public ShapeableImageView getImageIcon() {
            return imageIcon;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView
     */
    public IntroSliderAdapter(List<IntroSlide> dataSet) {
        mIntroSlides = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_slide, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextTitle().setText(mIntroSlides.get(position).getTitle());
        viewHolder.getTextDescription().setText(mIntroSlides.get(position).getDescription());
        viewHolder.getImageIcon().setImageResource(mIntroSlides.get(position).getIcon());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mIntroSlides.size();
    }
}
