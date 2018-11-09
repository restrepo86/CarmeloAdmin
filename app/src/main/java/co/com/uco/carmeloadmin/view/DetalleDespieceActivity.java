package co.com.uco.carmeloadmin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.uco.carmeloadmin.R;

public class DetalleDespieceActivity extends AppCompatActivity {

    private EditText txtAncho;
    private EditText txtAlto;
    private EditText txtCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_despiece);
        initComponents();
    }

    private void initComponents() {

        txtAlto = findViewById(R.id.txtAlto);
        txtAncho = findViewById(R.id.txtAncho);
        txtCantidad = findViewById(R.id.txtCantidad);

    }

    public void onClickGenerarDespiece(View view) {

        validarCampos();
        int cantBastidores = 2 * Integer.valueOf(txtCantidad.getText().toString());
        int cantBarrotes = 3 * Integer.valueOf(txtCantidad.getText().toString());
        int cantDivisoresVerticales = 2 * Integer.valueOf(txtCantidad.getText().toString());

        String medidaBastidores = cantBastidores + " bastidores de ".concat(txtAlto.getText().toString()).concat(" x 12cm x 4cm");
        String medidaBarrotes = cantBarrotes + " barrotes de ".concat(String.valueOf(Double.valueOf(txtAncho.getText().toString()) - 24)).concat(" x 12cm x 4cm");
        String medidaDivisoresVerticales = cantDivisoresVerticales + " divisores verticales de ".concat(String.valueOf(((Double.valueOf(txtAlto.getText().toString()) - 36)/2) + 8));

        Intent intent = new Intent(DetalleDespieceActivity.this, DespieceActivity.class);
        intent.putExtra("MEDIDA_BASTIDORES", medidaBastidores);
        intent.putExtra("MEDIDA_BARROTES", medidaBarrotes);
        intent.putExtra("MEDIDA_DIVISORES_VERTICALES", medidaDivisoresVerticales);
        startActivity(intent);

    }

    private void validarCampos() {
        if (txtCantidad.getText().toString().isEmpty() || txtAncho.getText().toString().isEmpty() || txtAlto.getText().toString().isEmpty()) {
            Toast.makeText(this,"Se deben diligenciar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
