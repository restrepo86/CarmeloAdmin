package co.com.uco.carmeloadmin.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.domain.Usuario;
import co.com.uco.carmeloadmin.persistencia.dao.UsuarioDAO;
import co.com.uco.carmeloadmin.util.GlobalState;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class RegistroUsuarioActivity extends AppCompatActivity {

    private GlobalState globalState;
    private UsuarioDAO usuarioDAO;
    private EditText txtId;
    private EditText txtNombreUsuario;
    private EditText txtContrasenia;
    private Usuario usuario;
    private ViewUtil viewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        initComponents();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
    private void initComponents(){
        globalState = (GlobalState) getApplication();
        usuarioDAO = new UsuarioDAO(globalState.getDataBaseHelper().getWritableDatabase());

        txtId = findViewById(R.id.txtId);
        txtNombreUsuario = findViewById(R.id.txtNombreUsuario);
        txtContrasenia = findViewById(R.id.txtContrasenia);
        usuario = new Usuario();
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Registrar");
    }

    public void onClickRegistrarse(View view) {
        Integer id = "".equals(txtId.getText().toString())?0: Integer.parseInt(txtId.getText().toString());
        usuario.setId(id);
        usuario.setNombreUsuario(txtNombreUsuario.getText().toString());
        usuario.setContrasenia(txtContrasenia.getText().toString());
        if(validate()){
            usuarioDAO.insertar(usuario);
            Toast.makeText(this, R.string.usuario_registrado, Toast.LENGTH_SHORT).show();
            borrarCampos();
        }
    }

    public Boolean validate(){
        boolean esValido = true;
        if(usuario.getId()==0){
            esValido= false;
            txtId.setError(getString(R.string.id_requerido));
            }else if("".equals(usuario.getNombreUsuario())){
            esValido= false;
            txtNombreUsuario.setError(getString(R.string.nombre_usuario_requerido));
        }else if("".equals(usuario.getContrasenia())){
            esValido= false;
            txtContrasenia.setError(getString(R.string.contrasenia_requerida));
        }else if(usuarioDAO.consultarPorId(usuario.getId())!= null){
            esValido= false;
            txtId.setError(getString(R.string.existe_usuario_con_id));
        }
        else if(usuarioDAO.consultarPorNombreUsuario(usuario.getNombreUsuario())!= null){
            esValido= false;
            txtNombreUsuario.setError(getString(R.string.existe_nombre_usuario));
        } if (usuario.getContrasenia().length()< 8) {
            esValido = false;
            Toast.makeText(this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
        }
        try {
            Long.parseLong(usuario.getContrasenia());
            esValido = false;
            Toast.makeText(this, "La contraseña debe tener caracteres", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            esValido = true;
        }
        return esValido;
    }

    private void borrarCampos(){
        txtId.setText("");
        txtNombreUsuario.setText("");
        txtContrasenia.setText("");
    }
}
