package co.com.uco.carmeloadmin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.domain.Puerta;
import co.com.uco.carmeloadmin.persistencia.dao.PuertaDAO;
import co.com.uco.carmeloadmin.util.GlobalState;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class NuevaPuertaActivity extends AppCompatActivity {

    private GlobalState globalState;
    private PuertaDAO puertaDAO;
    private EditText txtId;
    private EditText txtAncho;
    private EditText txtAlto;
    private EditText txtMaterial;
    private Puerta puerta;
    private ViewUtil viewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_puerta);
        initComponents();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void initComponents() {
        globalState= (GlobalState) getApplication();
        puertaDAO = new PuertaDAO(globalState.getDataBaseHelper().getWritableDatabase());
        txtId = findViewById(R.id.txtId);
        txtAncho = findViewById(R.id.txtAncho);
        txtAlto = findViewById(R.id.txtAlto);
        txtMaterial = findViewById(R.id.txtMaterial);
        puerta = new Puerta();
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Registrar Disenio");
    }


    public void onClickCrearNuevaPuerta(View view) {
        Integer id = "".equals(txtId.getText().toString())?0: Integer.parseInt(txtId.getText().toString());
        puerta.setId(id); //Consultar UUID para generar autoincremento del id
        puerta.setAncho(Float.parseFloat(txtAncho.getText().toString()));
        puerta.setAlto(Float.parseFloat(txtAlto.getText().toString()));
        puerta.setMaterial(txtMaterial.getText().toString());
        if(validate()){
            puertaDAO.insertar(puerta);
            Toast.makeText(this, "El registro de la puerta fue satisfactorio", Toast.LENGTH_SHORT).show();
            borrarCampos();
        }
    }

    private void borrarCampos(){
        txtId.setText("");
        txtAncho.setText("");
        txtAlto.setText("");
        txtMaterial.setText("");
    }

    public Boolean validate() {
        boolean esValido = true;
        if (puerta.getId() == 0) {
            txtId.setError(getString(R.string.requerido));
            esValido = false;
        }
        return esValido;
    }


}
