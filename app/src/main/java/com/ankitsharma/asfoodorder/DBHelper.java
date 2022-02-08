package com.ankitsharma.asfoodorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ankitsharma.asfoodorder.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super (context, DBNAME,null,DBVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL (
             "create table orders" + "(id int primary key autoincrement,"+
                     "name text," +
                     "phone text," +
                     "price int," +
                     "quantity int," +
                     "description text," +
                     "foodname text)"
     );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     sqLiteDatabase.execSQL ("DROP table if exists orders ");
     onCreate (sqLiteDatabase);
    }
    public boolean insertOrder(String name, String phone, String image, int price, String quantity , String description, int foodName ){
       SQLiteDatabase database = getReadableDatabase ();
        ContentValues values = new ContentValues ();
        values.put ("name",name);
        values.put ("phone",phone);
        values.put ("price",price);
        values.put("image",image);
        values.put ("description",description);
        values.put ("foodName",foodName);
        values.put ("quantity",quantity);
      long id =  database.insert ("orders",null,values);
       if (id<=0){
           return false;
       }
       else {
           return true;
       }
    }
    public ArrayList<OrderModel> getOrders(){
        ArrayList<OrderModel> orders = new ArrayList<> ();
        SQLiteDatabase database = this.getWritableDatabase ();
        Cursor cursor = database.rawQuery ("Select id,foodName,image,price from orders",null);
        if(cursor.moveToFirst ()){
            while (cursor.moveToNext ()) {
                OrderModel model=new OrderModel ();
                model.setOrderNumber (cursor.getString ( 0 ));
                model.setSoldItemName (cursor.getString (1));
                model.setOrderImage (cursor.getInt (1));
                model.setPrice (cursor.getInt (1) + "");
                orders.add (model);
            }
        }
         cursor.close ();
        database.close ();
        return orders;
    }

}
