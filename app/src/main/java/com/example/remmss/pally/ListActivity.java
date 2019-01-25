package com.example.remmss.pally;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView list;
    Context context=ListActivity.this;
    String[] listarray = {"OTP Activity", "Wrong OTP Activity","Profile Activity","Welcome Activity","UploadPhoto Activity","Verification Activity","Sign In Activity","Job search 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView) findViewById(R.id.list);


        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listarray);
        list.setAdapter(stringArrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(context,OTPActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(context,CancelledOTPActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(context,ProfileActivity.class));
                        break;

                    case 3:
                        startActivity(new Intent(context,MainActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(context,UploadPhotoActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(context,VerificationActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(context,SignInActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(context,JobSearch4.class));
                        break;
                }
            }
        });
    }
}
