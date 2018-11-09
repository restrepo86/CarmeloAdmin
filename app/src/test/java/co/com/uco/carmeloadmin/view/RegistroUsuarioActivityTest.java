package co.com.uco.carmeloadmin.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.uco.carmeloadmin.exception.RegistroUsuarioException;
import co.com.uco.carmeloadmin.persistencia.dao.UsuarioDAO;

@RunWith(MockitoJUnitRunner.class)
public class RegistroUsuarioActivityTest {

    public static final Integer NUMERO_IDENTIFICACION = 12343354;
    public static final String NOMBRE_USUARIO = "Juan";

    @InjectMocks
    private RegistroUsuarioActivity registroUsuarioActivity;

    @Mock
    private UsuarioDAO usuarioDAO;

    @Test
    public void debeValidarSiExisteIdentificacion() throws RegistroUsuarioException {

        Mockito.when(usuarioDAO.consultarPorId(NUMERO_IDENTIFICACION)).thenReturn(null);
        registroUsuarioActivity.validarExisteIdentificacion(NUMERO_IDENTIFICACION);

    }

    @Test
    public void debeValidarSiExisteNombreDeUsuario() throws RegistroUsuarioException {

        Mockito.when(usuarioDAO.consultarPorNombreUsuario(NOMBRE_USUARIO)).thenReturn(null);
        registroUsuarioActivity.validarExisteNombreDeUsuario(NOMBRE_USUARIO);

    }

    @Test
    public void debeValidarContraseniaTieneTamanioValido() throws RegistroUsuarioException {

        registroUsuarioActivity.validarContraseniaTieneTamanioValido("12345678");

    }

}
