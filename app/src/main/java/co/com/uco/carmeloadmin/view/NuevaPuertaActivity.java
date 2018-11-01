package co.com.uco.carmeloadmin.view;

import android.content.Intent;
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
    private EditText txtNombrePuerta;
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
        txtNombrePuerta = findViewById(R.id.txtNombrePuerta);
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Registrar Disenio");

    }

    public void onClickCrearNuevaPuerta(View view) {

        Integer id = "".equals(txtId.getText().toString())?0: Integer.parseInt(txtId.getText().toString());
        Puerta puerta = new Puerta();
        puerta.setId(id); //Consultar UUID para generar autoincremento del id
        puerta.setNombrePuerta(txtNombrePuerta.getText().toString());
        if(validate(puerta.getId())){
            puertaDAO.insertar(puerta);
            Toast.makeText(this, "El registro de la puerta fue satisfactorio", Toast.LENGTH_SHORT).show();
            borrarCampos();
            Intent intent = new Intent(NuevaPuertaActivity.this, PresentacionActivity.class);
            startActivity(intent);
        }

    }

    private void borrarCampos(){
        txtId.setText("");
        txtNombrePuerta.setText("");
    }

    private Boolean validate(Integer id) {
        boolean esValido = true;
        if (id == 0) {
            txtId.setError(getString(R.string.requerido));
            esValido = false;
        }
        return esValido;
    }


}
