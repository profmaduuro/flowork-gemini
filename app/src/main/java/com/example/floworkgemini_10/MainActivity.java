package com.example.floworkgemini_10;

import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
//import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
//import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()).toPlatformInsets();
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new HomeFragment()
            ).commit();
        }else if (item.getItemId() == R.id.nav_transporter_dnote) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new TransporterDnoteFragment()
            ).commit();
        } else if (item.getItemId() == R.id.nav_grower_dnote) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new GrowerDnoteFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_holding) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new HoldingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_dispatch) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new DispatchFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_summary) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new SummaryFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_balancing) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BalancingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_capturing) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new CapturingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_baleadjust) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BaleadjustFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_balecheck) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BalecheckFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_rehandling) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new RehandlingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_movebales) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new MovebalesFragment()
            ).commit();
        }else if (item.getItemId() == R.id.nav_logout){
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.getOnBackPressedDispatcher();
        }
    }







}