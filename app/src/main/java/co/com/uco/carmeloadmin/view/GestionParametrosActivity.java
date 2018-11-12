package co.com.uco.carmeloadmin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class GestionParametrosActivity extends AppCompatActivity {

    private ViewUtil viewUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_parametros);
        initComponents();
    }

    private void initComponents() {
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Gestión de Parametros");
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    Intent intent = null;

    public void onClicListarParamtros(View view) {
        intent = new Intent(GestionParametrosActivity.this, GestionParametrosActivity.class);
        startActivity(intent);
    }

    public void onClickAgregarParametro(View view) {
        intent = new Intent(GestionParametrosActivity.this, GestionParametrosActivity.class);
        startActivity(intent);
    }

    public void onClickEliminarParametro(View view) {
        intent = new Intent(GestionParametrosActivity.this, GestionParametrosActivity.class);
        startActivity(intent);
    }

    public void onClickBuscarParametro(View view) {
        intent = new Intent(GestionParametrosActivity.this, GestionParametrosActivity.class);
        startActivity(intent);
    }
}
