package co.com.uco.carmeloadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verMasOpcionesOnClick(View view) {
        Intent verMasOpcionesDisenosIntent = new Intent(MainActivity.this, MasOpcionesDisenosActivity.class);
        startActivity(verMasOpcionesDisenosIntent);
    }

    public void ingresarDetallePortonDobleTablero(View view) {
        Intent ingresarDetallePortonDobleTableroIntent = new Intent(MainActivity.this, DetallePortonDosTablerosActivity.class);
        startActivity(ingresarDetallePortonDobleTableroIntent);
    }

    public void ingresarDetallePortonSeisTableros(View view) {
        Intent ingresarDetalleBotonSeisTablerosIntent = new Intent(MainActivity.this, DetallePortonSeisTablerosActivity.class);
        startActivity(ingresarDetalleBotonSeisTablerosIntent);
    }
}
