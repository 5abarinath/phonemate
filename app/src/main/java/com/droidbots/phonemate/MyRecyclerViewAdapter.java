package com.droidbots.phonemate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sabari on 5/2/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
	private List<Phone> mDataset;
	private boolean isRecommendation;
	private OnItemClickListener mListener;
	private Context mContext;

	public interface OnItemClickListener {
		void onItemClick(Phone smartphone);
	}

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder{
		// each data item is just a string in this case
		public TextView deviceName, deviceDetails, deviceCost;
		public ImageView deviceThumbnail, flipkartImage;
		public boolean isRecommendation;
		private Context innerContext;
		public ViewHolder(Context context, View view, boolean isRecommendation) {
			super(view);
			innerContext = context;
			deviceName = (TextView) view.findViewById(R.id.deviceName);
			deviceThumbnail = (ImageView) view.findViewById(R.id.deviceThumbnail);
			this.isRecommendation = isRecommendation;
			if(isRecommendation) {
				deviceDetails = view.findViewById(R.id.deviceDetails);
				deviceCost = view.findViewById(R.id.deviceCost);
				flipkartImage = view.findViewById(R.id.flipkartImage);
			}
		}

		public void bind(final Phone smartphoneObj, final OnItemClickListener listener) {
			String name = smartphoneObj.getName();
			String splitArr[] = name.split("\\(");
			deviceName.setText(splitArr[0].trim());
//			deviceName.setText("Google Pixel 2");
			Picasso.get()
					.load(smartphoneObj.getImgsrc())
					.resize(250,500)
					.into(deviceThumbnail);
			if(isRecommendation) {
				deviceDetails.setText(smartphoneObj.getOperatingSystem());
				deviceCost.setText(smartphoneObj.getCost());
//				deviceName.setText("Google Pixel 2");
				flipkartImage.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent();
						intent.setAction(Intent.ACTION_VIEW);
						intent.addCategory(Intent.CATEGORY_BROWSABLE);
						intent.setData(Uri.parse(smartphoneObj.getFlipkartLink()));
						innerContext.startActivity(intent);
					}
				});
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
	public MyRecyclerViewAdapter(Context context, List<Phone> myDataset, OnItemClickListener listener, boolean isRecommendation) {
		mDataset = myDataset;
		this.isRecommendation = isRecommendation;
		mListener = listener;
		mContext = context;
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
		ViewHolder vh = new ViewHolder(mContext, view, isRecommendation);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
//		holder.deviceName.setText(mDataset.get(position).getName());
//		Picasso.get()
//				.load(mDataset.get(position).getImgsrc())
//				.resize(50,50)
//				.centerCrop()
//				.into(holder.deviceThumbnail);
//
//		if(isRecommendation) {
//			holder.deviceDetails.setText(mDataset.get(position).getCost());
//		}
		holder.bind(mDataset.get(position), mListener);
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

}
