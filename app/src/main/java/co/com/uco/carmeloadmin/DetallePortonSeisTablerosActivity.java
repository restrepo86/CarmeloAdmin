package co.com.uco.carmeloadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetallePortonSeisTablerosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_porton_seis_tableros);
    }

    public void generarDespieceClick(View view) {
        Intent generarDespieceIntent = new Intent(DetallePortonSeisTablerosActivity.this, DespieceActivity.class);
        startActivity(generarDespieceIntent);
    }
}
