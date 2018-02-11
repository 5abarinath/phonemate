package com.droidbots.phonemate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sabari on 5/2/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
	private Smartphone[] mDataset;
	private boolean isRecommendation;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView deviceName, deviceDetails;
		public ImageView deviceThumbnail;
		public ViewHolder(View view, boolean isRecommendation) {
			super(view);
			deviceName = (TextView) view.findViewById(R.id.deviceName);
			deviceThumbnail = (ImageView) view.findViewById(R.id.deviceThumbnail);
			if(isRecommendation) {
				deviceDetails = view.findViewById(R.id.deviceDetails);
			}
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyRecyclerViewAdapter(Smartphone[] myDataset, boolean isRecommendation) {
		mDataset = myDataset;
		this.isRecommendation = isRecommendation;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
												   int viewType) {
		// create a new view
        View view;
		if(isRecommendation){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_cardview_recommend, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_cardview_home, parent, false);
        }
        // set the view's size, margins, paddings and layout parameters
		ViewHolder vh = new ViewHolder(view, isRecommendation);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.deviceName.setText(mDataset[position].getDeviceName());
		holder.deviceThumbnail.setImageDrawable(mDataset[position].getThumbnail());
		if(isRecommendation) {
			holder.deviceDetails.setText(mDataset[position].getPrice());
		}
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.length;
	}

}
