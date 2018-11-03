package co.com.uco.carmeloadmin.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.FileNameMap;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

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
    private ImageView imagenId;
    private Button btnCargarImagen;

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
        imagenId = findViewById(R.id.imagenId);
        btnCargarImagen = findViewById(R.id.btnCargarImagen);

        if (tienePermisos()) {
            btnCargarImagen.setEnabled(true);
        } else {
            btnCargarImagen.setEnabled(false);
        }

    }

    private boolean tienePermisos() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if ((checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                && (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)){
            return true;
        }
        if ((shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE))
                || (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))) {
            cargarDialogoRecomendacion();
        } else {
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 100);
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                btnCargarImagen.setEnabled(true);
            }
        }
    }


    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(NuevaPuertaActivity.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 100);
                }
            }
        });
        dialogo.show();
    }

    public void onClickCrearNuevaPuerta(View view) {

        validarCampos();
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

    private void validarCampos() {

        if (txtId.getText() == null || txtNombrePuerta == null) {
            Toast.makeText(this, "Debe diligenciar todos los campos", Toast.LENGTH_SHORT).show();
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


    public void onClickCargarImagen(View view) {
        cargarImagen();
    }

    private void cargarImagen() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicacion"), 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK) {
            Uri path = data.getData();
            imagenId.setImageURI(path);
        }
    }
}
