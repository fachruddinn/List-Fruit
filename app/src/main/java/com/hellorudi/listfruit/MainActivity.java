package com.hellorudi.listfruit;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hellorudi.listfruit.adapter.ListFruitAdapter;
import com.hellorudi.listfruit.model.Fruit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFruits;
    private ArrayList<Fruit> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFruits = findViewById(R.id.rv_fruit);
        rvFruits.setHasFixedSize(true);

        list.addAll(getListFruits());
        showRecyclerList();
    }

    public ArrayList<Fruit> getListFruits() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPicture = getResources().getStringArray(R.array.data_picture);

        ArrayList<Fruit> listFruit = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Fruit fruit = new Fruit();
            fruit.setName(dataName[i]);
            fruit.setDescription((dataDescription[i]));
            fruit.setPicture(dataPicture[i]);

            listFruit.add(fruit);
        }
        return listFruit;
    }

    private void showRecyclerList() {
        rvFruits.setLayoutManager(new LinearLayoutManager(this));
        ListFruitAdapter listFruitAdapter = new ListFruitAdapter(list);
        rvFruits.setAdapter(listFruitAdapter);

        listFruitAdapter.setOnItemClickCallback(new ListFruitAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Fruit data) {
//                showSelectedFruit(data);

                toDetailFruit(data);
            }
        });
    }

    private void toDetailFruit(Fruit data) {
        Fruit fruit = new Fruit();
        fruit.setName(data.getName());
        fruit.setDescription(data.getDescription());
        fruit.setPicture(data.getPicture());

        Intent detailFruitIntent = new Intent(MainActivity.this, DetailFruitActivity.class);
        detailFruitIntent.putExtra(DetailFruitActivity.EXTRA_FRUIT, fruit);
        startActivity(detailFruitIntent);
    }

    /*private void showSelectedFruit(Fruit fruit) {
        Toast.makeText(this, "Kamu memilih " + fruit.getName(), Toast.LENGTH_SHORT).show();
    }*/

}
