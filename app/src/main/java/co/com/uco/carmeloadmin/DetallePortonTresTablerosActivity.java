package co.com.uco.carmeloadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetallePortonTresTablerosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_porton_tres_tableros);
    }

    public void generarDespieceClick(View view) {
        Intent generarDespieceIntent = new Intent(DetallePortonTresTablerosActivity.this, DespieceActivity.class);
        startActivity(generarDespieceIntent);
    }
}
