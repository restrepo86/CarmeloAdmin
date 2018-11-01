package co.com.uco.carmeloadmin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.domain.Puerta;
import co.com.uco.carmeloadmin.persistencia.dao.PuertaDAO;
import co.com.uco.carmeloadmin.persistencia.util.DataBaseHelper;
import co.com.uco.carmeloadmin.util.CustomAdapter;
import co.com.uco.carmeloadmin.util.GlobalState;
import co.com.uco.carmeloadmin.util.ItemLista;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class PresentacionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GlobalState globalState;
    private ViewUtil viewUtil;
    private EditText txtBuscar;
    private PuertaDAO puertaDAO;
    private Puerta puerta;

    private ListView listViewListaPuertas;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        globalState = (GlobalState) getApplication();
        DataBaseHelper db= new DataBaseHelper(this,"local",null, 1);
        globalState.setDataBaseHelper(db);
        initComponents();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        cargarLista();
    }

    private void initComponents() {
        puertaDAO = new PuertaDAO(globalState.getDataBaseHelper().getWritableDatabase());
        puerta = new Puerta();
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Carmelo Admin");
        listViewListaPuertas = findViewById(R.id.listView);
        txtBuscar = findViewById(R.id.txtBuscar);
    }

    private void cargarLista() {
        List<ItemLista> listaPuertas = new ArrayList<>();
        List<Puerta> listaDePuertas = puertaDAO.listar();
        for (Puerta puerta : listaDePuertas) {
            listaPuertas.add(new ItemLista(R.drawable.ic_launcher_background,
                    puerta.getId().toString(), puerta.getNombrePuerta()));
        }

        customAdapter = new CustomAdapter(this, listaPuertas);
        listViewListaPuertas.setAdapter(customAdapter);
        listViewListaPuertas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemLista itemLista = (ItemLista) listViewListaPuertas.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), itemLista.getIdImage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.presentacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent= null;
        if (id == R.id.nav_camera) {
            intent= new Intent(PresentacionActivity.this, NuevaPuertaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClickCrearNuevaPuerta(View view) {
        Intent intent = new Intent(PresentacionActivity.this, NuevaPuertaActivity.class);
        startActivity(intent);
    }
}
