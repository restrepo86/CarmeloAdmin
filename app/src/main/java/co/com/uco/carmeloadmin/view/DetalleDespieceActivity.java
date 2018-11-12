package co.com.uco.carmeloadmin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class DetalleDespieceActivity extends AppCompatActivity {

    private EditText txtAncho;
    private EditText txtAlto;
    private EditText txtCantidad;
    private ViewUtil viewUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_despiece);
        initComponents();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void initComponents() {
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Área de Despiece");
        txtAlto = findViewById(R.id.txtAlto);
        txtAncho = findViewById(R.id.txtAncho);
        txtCantidad = findViewById(R.id.txtCantidad);

    }

    public void onClickGenerarDespiece(View view) {

        if(validarCampos() && validate()){
            int cantBastidores = 2 * Integer.valueOf(txtCantidad.getText().toString());
            int cantBarrotes = 3 * Integer.valueOf(txtCantidad.getText().toString());
            int cantDivisoresVerticales = 2 * Integer.valueOf(txtCantidad.getText().toString());

            String medidaBastidores = cantBastidores + " bastidores de ".concat(txtAlto.getText().toString()).concat("cm ").concat(" x 12cm x 4cm");
            String medidaBarrotes = cantBarrotes + " barrotes de ".concat(String.valueOf(Double.valueOf(txtAncho.getText().toString()) - 24)).concat("cm ").concat(" x 12cm x 4cm");
            String medidaDivisoresVerticales = cantDivisoresVerticales + " divisores verticales de ".concat(String.valueOf(((Double.valueOf(txtAlto.getText().toString()) - 36)/2) + 8)).concat("cm");

            Intent intent = new Intent(DetalleDespieceActivity.this, DespieceActivity.class);
            intent.putExtra("MEDIDA_BASTIDORES", medidaBastidores);
            intent.putExtra("MEDIDA_BARROTES", medidaBarrotes);
            intent.putExtra("MEDIDA_DIVISORES_VERTICALES", medidaDivisoresVerticales);
            startActivity(intent);
        }
    }


    private boolean validate(){
        boolean isValid = true;
        txtAlto.setError(null);
        txtAncho.setError(null);
        txtCantidad.setError(null);
        if(Double.valueOf(txtAlto.getText().toString()) < 20){
            isValid = false;
            txtAlto.setError("Recuerde que el mínimo valor para la fabricación de una puerta son 20cm de Alto");
        }
        if(Double.valueOf(txtAncho.getText().toString()) < 25){
            isValid = false;
            txtAncho.setError("Recuerde que el mínimo valor para la fabricación de una puerta son 25cm de Ancho");
        }
        if(Integer.valueOf(txtCantidad.getText().toString()) < 1){
            isValid = false;
            txtCantidad.setError("Recuerde que el mínimo valor de cantidad de puertas es 1");
        }

        return  isValid;
    }

    private boolean validarCampos() {
        boolean isValid = true;

        if (txtCantidad.getText().toString().isEmpty() || txtAncho.getText().toString().isEmpty() || txtAlto.getText().toString().isEmpty()) {
            isValid = false;
            Toast.makeText(this,"Se deben diligenciar todos los campos", Toast.LENGTH_SHORT).show();
        }
        return  isValid;
    }
}
