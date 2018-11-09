package co.com.uco.carmeloadmin.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.domain.Usuario;
import co.com.uco.carmeloadmin.exception.RegistroUsuarioException;
import co.com.uco.carmeloadmin.persistencia.dao.UsuarioDAO;
import co.com.uco.carmeloadmin.util.GlobalState;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class RegistroUsuarioActivity extends AppCompatActivity {

    private GlobalState globalState;
    private UsuarioDAO usuarioDAO;
    private EditText txtId;
    private EditText txtNombreUsuario;
    private EditText txtContrasenia;
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
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Registrar");

    }

    public void onClickRegistrarse(View view) {

        Integer id = "".equals(txtId.getText().toString()) ? 0 : Integer.parseInt(txtId.getText().toString());
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombreUsuario(txtNombreUsuario.getText().toString());
        usuario.setContrasenia(txtContrasenia.getText().toString());

        if(validate(usuario)){

            usuarioDAO.insertar(usuario);
            Toast.makeText(this, R.string.usuario_registrado, Toast.LENGTH_SHORT).show();
            borrarCampos();

        }

    }

    private Boolean validate(Usuario usuario){

        boolean esValido = true;

        if (camposRequeridosEstanLlenos(usuario)) {

            try {

                validarExisteIdentificacion(usuario.getId());
                validarExisteNombreDeUsuario(usuario.getNombreUsuario());
                validarContraseniaTieneTamanioValido(usuario.getContrasenia());

            } catch (RegistroUsuarioException registroUsuarioException) {
                Toast.makeText(this, registroUsuarioException.getMessage(), Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            return false;
        }

        return esValido;
    }

    public boolean camposRequeridosEstanLlenos(Usuario usuario) {

        boolean esValido = true;

        if(usuario.getId() == 0){
            esValido= false;
            txtId.setError(getString(R.string.id_requerido));
        }else if("".equals(usuario.getNombreUsuario())){
            esValido= false;
            txtNombreUsuario.setError(getString(R.string.nombre_usuario_requerido));
        }else if("".equals(usuario.getContrasenia())){
            esValido= false;
            txtContrasenia.setError(getString(R.string.contrasenia_requerida));
        }

        return esValido;

    }

    public void validarExisteIdentificacion(Integer numeroIdentificacion) throws RegistroUsuarioException {

        boolean existeNumeroDeIdentificacion = usuarioDAO.consultarPorId(numeroIdentificacion) != null;
        if(existeNumeroDeIdentificacion){
            throw new RegistroUsuarioException(getString(R.string.existe_usuario_con_id));
        }

    }

    public void validarExisteNombreDeUsuario(String nombreUsuario) throws RegistroUsuarioException {

        boolean existeNombreDeUsuario = usuarioDAO.consultarPorNombreUsuario(nombreUsuario) != null;
        if(existeNombreDeUsuario) {
            throw new RegistroUsuarioException(getString(R.string.existe_nombre_usuario));
        }

    }

    public void validarContraseniaTieneTamanioValido(String contrasenia) throws RegistroUsuarioException {

        if (contrasenia.length() < 8) {
            throw new RegistroUsuarioException(getString(R.string.tamanio_constrasenia));
        }

    }


    private void borrarCampos(){

        txtId.setText("");
        txtNombreUsuario.setText("");
        txtContrasenia.setText("");

    }
}
