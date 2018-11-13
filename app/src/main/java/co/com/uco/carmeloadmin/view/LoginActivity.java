package co.com.uco.carmeloadmin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.domain.Usuario;
import co.com.uco.carmeloadmin.persistencia.dao.UsuarioDAO;
import co.com.uco.carmeloadmin.persistencia.util.DataBaseHelper;
import co.com.uco.carmeloadmin.util.GlobalState;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class LoginActivity extends AppCompatActivity {


    private GlobalState globalState;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private EditText txtNombreUsuario;
    private EditText txtContrasenia;
    private ViewUtil viewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        globalState= (GlobalState) getApplication();
        DataBaseHelper db = new DataBaseHelper(this,getString(R.string.local),null, 1);
        globalState.setDataBaseHelper(db);
        initComponents();
    }

    public void initComponents() {
        globalState = (GlobalState) getApplication();
        usuarioDAO = new UsuarioDAO(globalState.getDataBaseHelper().getWritableDatabase());
        txtNombreUsuario = findViewById(R.id.txtNombreUsuario);
        txtContrasenia = findViewById(R.id.txtContrasenia);
        viewUtil = new ViewUtil(this);

    }

    public void onClickIngresar(View view) {
        String nombreUsuario = txtNombreUsuario.getText().toString();
        String contrasenia = txtContrasenia.getText().toString();

        if (validate(nombreUsuario, contrasenia)) {
            usuario = usuarioDAO.consultarPorNombreYContrasenia(nombreUsuario, contrasenia);
            if (usuario != null) {
                Intent intent =  new Intent(LoginActivity.this, PresentacionActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.datos_no_encontrados, Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean validate(String nombreUsuario, String contrasenia) {
        boolean esValido = true;
        if("".equals(nombreUsuario)){
            txtNombreUsuario.setError(getString(R.string.nombre_usuario_requerido));
            esValido= false;
        }else if("".equals(contrasenia)) {
            txtContrasenia.setError(getString(R.string.contrasenia_requerida));
            esValido = false;
        }
        return esValido;
    }

    public void onClickCrearNuevaCuenta(View view) {
        Intent intent =  new Intent(LoginActivity.this, RegistroUsuarioActivity.class);
        startActivity(intent);
    }
}
