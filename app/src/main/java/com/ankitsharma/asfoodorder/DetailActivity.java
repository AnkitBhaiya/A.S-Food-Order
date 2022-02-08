package com.ankitsharma.asfoodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ankitsharma.asfoodorder.databinding.ActivityDetailBinding;


public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = ActivityDetailBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());
        getSupportActionBar ().hide ();

        final int image = getIntent ().getIntExtra ("image",0);
       final String price = getIntent ().getStringExtra ("price");
       final String name = getIntent ().getStringExtra ("name");
       final String description = getIntent ().getStringExtra ("description");
        binding.DetailImage.setImageResource (image);
        binding.pricelabel.setText (price);
        binding.NameBox.setText (name);
        binding.ItemDescription.setText (description);
        DBHelper helper = new DBHelper (this);
        binding.Insertbutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
           boolean isInserted =  helper.insertOrder (binding.Name.getText ().toString (), binding.Phone.getText ().toString (), price, image, name, description, Integer.parseInt (binding.quantity.getText ().toString()));
               if(isInserted == true){
                   Toast.makeText (DetailActivity.this,"Data Successful",Toast.LENGTH_SHORT).show ();
               }
               else {
                   Toast.makeText (DetailActivity.this,"Data Success ",Toast.LENGTH_SHORT).show ();
               }
            }
        });
    }
}