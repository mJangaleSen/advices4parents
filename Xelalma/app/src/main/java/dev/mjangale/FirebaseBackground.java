package dev.mjangale;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by BIAYE on 29/06/2017.
 */

public class FirebaseBackground extends Application {

        @Override
        public void onCreate() {
            super.onCreate();

            // Setup firebase to cache data locally
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }


