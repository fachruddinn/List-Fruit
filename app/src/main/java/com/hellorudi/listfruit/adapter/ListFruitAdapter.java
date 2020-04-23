package com.hellorudi.listfruit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hellorudi.listfruit.R;
import com.hellorudi.listfruit.model.Fruit;

import java.util.ArrayList;

public class ListFruitAdapter extends RecyclerView.Adapter<ListFruitAdapter.ListViewHolder> {
    private ArrayList<Fruit> listFruit;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListFruitAdapter(ArrayList<Fruit> list) {
        this.listFruit = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_fruit, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Fruit fruit = listFruit.get(position);

        Glide.with(holder.itemView.getContext())
                .load(fruit.getPicture())
                .apply(new RequestOptions().override(40, 40))
                .into(holder.imgPicture);

        holder.tvName.setText(fruit.getName());
        holder.tvDescription.setText(fruit.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listFruit.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return  listFruit.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPicture;
        TextView tvName, tvDescription;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPicture = itemView.findViewById(R.id.img_item_picture);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Fruit data);
    }
}
