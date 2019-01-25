package com.example.remmss.pally;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class JobSearch4 extends Fragment {

    private SwipeMenuListView listView;
    private ArrayList<Data> dataArrayList;
    private ListAdapter listAdapter;
    private Data data;
    private boolean TODO = false;
    private int REQUEST_CALL_PHONE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_job_search4, container, false);

        listView = (SwipeMenuListView) view.findViewById(R.id.listview);
        dataArrayList = new ArrayList<>();


        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));
        dataArrayList.add(data = new Data("John Adams", "Senior Artist"));

        listAdapter = new ListAdapter(getActivity(), dataArrayList);
        listView.setAdapter(listAdapter);

        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:

                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:" + "9429283901"));
                        int checkPermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE);
                        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(
                                    getActivity(),
                                    new String[]{Manifest.permission.CALL_PHONE},
                                    REQUEST_CALL_PHONE);
                        } else {
                            startActivity(callIntent);

                        }
//                          Toast.makeText(JobSearch4.this, "Delete", Toast.LENGTH_SHORT).show();
//                        Log.e("item", String.valueOf(listView.getAdapter().getItem(position)));
//                        Log.e("name", String.valueOf(dataArrayList.get(position).getName()));
//
//                        dataArrayList.remove(position);
//
//                        listAdapter.notifyDataSetChanged();

                        break;
                    case 1:
                        // delete

                        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                        sendIntent.putExtra("sms_body", "Hell0!! How are you?? ");
                        sendIntent.setType("vnd.android-dir/mms-sms");
                        startActivity(sendIntent);
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + "9429283901"));
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(callIntent);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getActivity(), "Permission denied ", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    SwipeMenuCreator creator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {


            // create "delete" item
            SwipeMenuItem deleteItem = new SwipeMenuItem(
                    getActivity().getApplicationContext());
            // set item background
            deleteItem.setBackground(new ColorDrawable(Color.parseColor("#e8e8e8")));
            // set item width
            deleteItem.setWidth(150);

            deleteItem.setIcon(ContextCompat.getDrawable(getActivity(),R.drawable.ic_telephone));
            deleteItem.setTitleColor(Color.WHITE);
            deleteItem.setTitleSize(15);

            // add to menu
            menu.addMenuItem(deleteItem);




            // create "delete" item
            SwipeMenuItem deleteItem1 = new SwipeMenuItem(
                    getActivity().getApplicationContext());
            // set item background
            deleteItem1.setBackground(new ColorDrawable(Color.parseColor("#e8e8e8")));
            // set item width
            deleteItem1.setWidth(150);

            deleteItem1.setIcon(ContextCompat.getDrawable(getActivity(),R.drawable.ic_sms));
            deleteItem1.setTitleColor(Color.WHITE);
            deleteItem1.setTitleSize(15);

            // add to menu
            menu.addMenuItem(deleteItem1);
        }
    };
    }

