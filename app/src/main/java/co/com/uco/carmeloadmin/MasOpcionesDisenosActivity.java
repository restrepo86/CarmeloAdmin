package co.com.uco.carmeloadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MasOpcionesDisenosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_opciones_disenos);
    }

    public void ingresarDetallePortonCuatroTableros(View view) {
        Intent intentDetallePortonCuatroTableros = new Intent(MasOpcionesDisenosActivity.this, DetallePortonCuatroTablerosActivity.class);
        startActivity(intentDetallePortonCuatroTableros);
    }
}
