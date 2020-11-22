package com.example.TecFresh;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class categorySpecific extends AppCompatActivity {

    private GridView grid;
    private TextView cText;
    private ArrayList<String> productName= new ArrayList<>();
    private ArrayList<String> productPrice= new ArrayList<>();
    private ArrayList<String> productImgURL= new ArrayList<>();
    private GridViewAdapter adapter;
    private String category;
    private DatabaseReference Rootref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_gridview);

        grid = (GridView)findViewById(R.id.gridview);
        category = getIntent().getStringExtra("cName");
        cText = findViewById(R.id.category_text);
        cText.setText(category);

        Rootref = FirebaseDatabase.getInstance().getReference(category).child("Products");
        LoadDataFromFirebase();
        adapter = new GridViewAdapter(productName,productPrice,productImgURL,getApplicationContext());
        grid.setAdapter(adapter);

    }

    private void LoadDataFromFirebase() {
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot product : snapshot.getChildren()) {
                    productName.add(product.child("Product Name").getValue().toString());
                    productPrice.add(product.child("Product Price").getValue().toString());
                    productImgURL.add(product.child("IMG").getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
