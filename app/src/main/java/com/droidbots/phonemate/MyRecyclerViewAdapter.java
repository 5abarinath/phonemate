package com.droidbots.phonemate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by sabari on 5/2/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
	private List<Phone> mDataset;
	private boolean isRecommendation;
	private OnItemClickListener mListener;

	public interface OnItemClickListener {
		void onItemClick(Phone smartphone);
	}

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder{
		// each data item is just a string in this case
		public TextView deviceName, deviceDetails;
		public ImageView deviceThumbnail;
		public boolean isRecommendation;
		public ViewHolder(View view, boolean isRecommendation) {
			super(view);
			deviceName = (TextView) view.findViewById(R.id.deviceName);
			deviceThumbnail = (ImageView) view.findViewById(R.id.deviceThumbnail);
			this.isRecommendation = isRecommendation;
			if(isRecommendation) {
				deviceDetails = view.findViewById(R.id.deviceDetails);
			}
		}

		public void bind(final Phone smartphoneObj, final OnItemClickListener listener) {
			deviceName.setText(smartphoneObj.getName());

			try {
				URL url = new URL(smartphoneObj.getImgsrc());
				Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
				deviceThumbnail.setImageBitmap(image);
			} catch (IOException e) {
				Log.d("TAG", "onBindViewHolder: "+e);
			}
			if(isRecommendation) {
				deviceDetails.setText(smartphoneObj.getCost());
			}
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onItemClick(smartphoneObj);
				}
			});
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyRecyclerViewAdapter(List<Phone> myDataset, OnItemClickListener listener, boolean isRecommendation) {
		mDataset = myDataset;
		this.isRecommendation = isRecommendation;
		mListener = listener;
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
		holder.deviceName.setText(mDataset.get(position).getName());

		try {
			URL url = new URL(mDataset.get(position).getImgsrc());
			Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
			holder.deviceThumbnail.setImageBitmap(image);
		} catch (IOException e) {
			Log.d("TAG", "onBindViewHolder: "+e);
		}
		if(isRecommendation) {
			holder.deviceDetails.setText(mDataset.get(position).getCost());
		}
		holder.bind(mDataset.get(position), mListener);
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
//		return mDataset.size();
		return 5;
	}

}
