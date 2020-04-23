package com.hellorudi.listfruit;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.hellorudi.listfruit.model.Fruit;

public class DetailFruitActivity extends AppCompatActivity {
    public static final String EXTRA_FRUIT = "extra_fruit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fruit);

        ImageView imgFruit = findViewById(R.id.img_item_picture_detail);
        TextView tvFruitName = findViewById(R.id.tv_item_name_detail);
        TextView tvFruitDescription = findViewById(R.id.tv_item_description_detail);

        Fruit fruit = getIntent().getParcelableExtra(EXTRA_FRUIT);

        tvFruitName.setText(fruit.getName());
        tvFruitDescription.setText(fruit.getDescription());

        Glide.with(this).load(fruit.getPicture()).into(imgFruit);
    }
}
