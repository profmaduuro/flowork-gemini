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
        }else if(item.getItemId() == R.id.nav_buyer) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BuyerFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_selling_point) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new SellingPointFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_grades) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new GradesFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_connections) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new ConnectionsFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_tickets) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new TicketsFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_batching) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BatchingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_backup) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BackupFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_parameters) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new ParametersFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_processing) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new ProcessingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_verification) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new VerificationFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_internals) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new InternalsFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_purchases) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new PurchasesFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_banking) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new BankingFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_captureinternals) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new CaptureInternalsFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_revenues) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new RevenuesFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_schedules) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new SchedulesFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_invoices) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new InvoicesFragment()
            ).commit();
        }else if(item.getItemId() == R.id.nav_timb) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment_container, new TimbFragment()
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