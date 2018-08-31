package com.thepensionapp.editablelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button btnAdd,btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);

        editText=(EditText)findViewById(R.id.editText);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnView=(Button)findViewById(R.id.btnView);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry=editText.getText().toString();

                if(newEntry.length() !=0){
                    addData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addData(String newEntry){
        boolean insertData=db.addData(newEntry);
        if(insertData==true)
            Toast.makeText(MainActivity.this,"Data Saved Successfully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Something went wrong!!!",Toast.LENGTH_LONG).show();



    }
}
