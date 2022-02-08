package com.ankitsharma.asfoodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.ankitsharma.asfoodorder.Adapters.MainAdapter;
import com.ankitsharma.asfoodorder.Models.MainModel;
import com.ankitsharma.asfoodorder.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = ActivityMainBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());

        ArrayList<MainModel> list = new ArrayList<> ();
        list.add (new MainModel (R.drawable.images,"Burger","100Rs","Burger combo with cold drinks"));
        list.add (new MainModel (R.drawable.pizza,"Pizza","200Rs","Pizza with great cheese and extra vegetables"));
        list.add (new MainModel (R.drawable.frenchfry,"French Fries","250Rs","French fry with less oil and better taste"));
        list.add (new MainModel (R.drawable.choumin,"Choumin","25Rs","Choumin with less oil and better taste"));
        MainAdapter adapter = new MainAdapter (list,this);
        binding.recyclerView.setAdapter (adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        binding.recyclerView.setLayoutManager (layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.menu,menu);
        return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId ()){
           case R.id.orders:
               startActivity (new Intent (MainActivity.this,OrderActivity.class));
               break;
       }
        return super.onOptionsItemSelected (item);
    }
}