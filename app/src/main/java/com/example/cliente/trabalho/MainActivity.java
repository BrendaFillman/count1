package com.example.cliente.trabalho;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaginaInicialFragment()).commit();
            navigationView.setCheckedItem(R.id.pagina_inicial);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.pagina_inicial:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaginaInicialFragment()).commit();
                break;
            case R.id.calendario:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarioFragment()).commit();
                break;
            case R.id.analise:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnaliseFragment()).commit();
                break;
            case R.id.monitora:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MonitoraFragment()).commit();
                break;
            case R.id.objetivo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ObjetivoFragment()).commit();
                break;
            case R.id.ajuda:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AjudaFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
