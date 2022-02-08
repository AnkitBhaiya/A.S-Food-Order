package com.ankitsharma.asfoodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.ankitsharma.asfoodorder.Adapters.OrderAdapter;
import com.ankitsharma.asfoodorder.Models.OrderModel;
import com.ankitsharma.asfoodorder.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = ActivityOrderBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());

        DBHelper helper = new DBHelper (this);
        ArrayList<OrderModel> list = helper.getOrders ();

        OrderAdapter adapter = new OrderAdapter (list,this);
        binding.orderRecyclerView.setAdapter (adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        binding.orderRecyclerView.setLayoutManager (layoutManager);


    }
}