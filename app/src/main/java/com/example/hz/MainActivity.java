package com.example.hz;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_first) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FirstFragment()).commit();
                return true;
            } else if (itemId == R.id.nav_second) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SecondFragment()).commit();
                return true;
            }
            return false;
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_first);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        if (itemId == R.id.option_first_fragment) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FirstFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.nav_first);
            return true;
        } else if (itemId == R.id.option_second_fragment) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SecondFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.nav_second);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
