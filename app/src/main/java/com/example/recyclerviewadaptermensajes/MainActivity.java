package com.example.recyclerviewadaptermensajes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewadaptermensajes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SQLiteDatabase db=new OpenHelper(this,"dbMessage",null,1).getWritableDatabase();
        Cursor c=db.rawQuery("SELECT idMessage,Message,User,Receptor FROM Messages",null);
        MessagesAdapter adapter=new MessagesAdapter(this,R.layout.linea_mensaje,c);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);
    }
}