package com.example.mherhallproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    public RecViewAdapter(List<ItemModel> modelList) {
        this.modelList = modelList;
    }

    List<ItemModel> modelList;

    @NonNull
    @Override
    public RecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_view_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewAdapter.ViewHolder viewHolder, int position) {
        ItemModel itemModel = modelList.get(position);
        viewHolder.name.setText(itemModel.getName());
        viewHolder.price.setText((itemModel.getPrice() + "$"));
        Picasso.get().load(itemModel.getImage()).into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView name;
        TextView price;
        ImageButton like;
        ImageButton basket;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.circle_image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            like = itemView.findViewById(R.id.like);
            basket = itemView.findViewById(R.id.basket);


            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (modelList.get(getAdapterPosition()).getLiked()) {
                        like.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                        modelList.get(getAdapterPosition()).setLiked(false);
                    } else {
                        like.setImageResource(R.drawable.ic_favorite_black_24dp);
                        modelList.get(getAdapterPosition()).setLiked(true);
                    }
                }
            });

            basket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (modelList.get(getAdapterPosition()).getToBasket()) {
                        basket.setImageResource(R.drawable.ic_shopping_cart_black_24dp);
                        modelList.get(getAdapterPosition()).setToBasket(false);
                    } else {
                        basket.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                        modelList.get(getAdapterPosition()).setToBasket(true);
                    }
                }
            });

        }
    }
}
