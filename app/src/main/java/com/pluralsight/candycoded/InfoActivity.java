package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    public static final String LOCATION_STORE = "geo:0,0?q=618 E South St Orlando, FL 32801";
    public static final String GOOGLE_MAPS_INTENT = "com.google.android.apps.maps";
    public static final String TELEPHONE_NUM = "tel:0123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    public void createMapIntent(View view) {

        final Uri mapUri = Uri.parse( LOCATION_STORE );
        final Intent mapIntent = new Intent( Intent.ACTION_VIEW, mapUri );
        mapIntent.setPackage( GOOGLE_MAPS_INTENT );
        if( mapIntent.resolveActivity( getPackageManager() ) != null ) {

            startActivity( mapIntent );
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view) {

        final Intent dialIntent = new Intent( Intent.ACTION_DIAL );
        final Uri number = Uri.parse( TELEPHONE_NUM );
        dialIntent.setData( number );
        startActivity( dialIntent );
    }
}
