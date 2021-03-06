package com.jorgereina.pinterestchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgereina.pinterestchallenge.models.PinsResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PinsAdapter extends RecyclerView.Adapter<PinsAdapter.ViewHolder> {

    private List<PinsResponse> pinsResponses;
    private Context context;

    public PinsAdapter(List<PinsResponse> pinsResponses, Context context) {
        this.pinsResponses = pinsResponses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.pin_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context)
                .load(pinsResponses.get(position).getImages().getImage736().getUrl())
                .resize(600,400)
                .centerCrop()
                .into(holder.pinImage);
        holder.titleText.setText(pinsResponses.get(position).getTitle());
        holder.usernameText.setText(pinsResponses.get(position).getPinner().getUsername());

    }

    @Override
    public int getItemCount() {
        return pinsResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pinImage;
        private TextView titleText;
        private TextView usernameText;

        public ViewHolder(View itemView) {
            super(itemView);

            pinImage = itemView.findViewById(R.id.pin_iv);
            titleText = itemView.findViewById(R.id.title_text);
            usernameText = itemView.findViewById(R.id.username_text);
        }
    }
}
