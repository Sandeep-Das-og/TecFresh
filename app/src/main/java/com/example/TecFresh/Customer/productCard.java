package com.example.TecFresh.Customer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.TecFresh.R;

public class productCard extends AppCompatActivity {
    private String imUrl,cat,price,name;
    private ImageView prodImg;
    private TextView prodPrice,prodName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_card);

        cat = getIntent().getStringExtra("catg");
        imUrl = getIntent().getStringExtra("pimg");
        name = getIntent().getStringExtra("pName");
        price = getIntent().getStringExtra("pPrice");

        prodImg = (ImageView) findViewById(R.id.prod_card_img);
        prodName = (TextView) findViewById(R.id.prod_card_name);
        prodPrice = (TextView) findViewById(R.id.prod_card_price);

        Glide.with(getApplicationContext()).load(imUrl).into(prodImg);
        prodName.setText(name);
        prodPrice.setText(price);
    }
}
