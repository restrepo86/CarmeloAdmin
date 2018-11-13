package co.com.uco.carmeloadmin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import co.com.uco.carmeloadmin.R;
import co.com.uco.carmeloadmin.util.ViewUtil;

public class DespieceActivity extends AppCompatActivity {


    private ViewUtil viewUtil;
    private EditText txtDespiece;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despiece);
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar(getString(R.string.generacion_despiece));

        Bundle bundle = getIntent().getExtras();

        String medidaBastidores = bundle.getString("MEDIDA_BASTIDORES");
        String medidaBarrotes = bundle.getString("MEDIDA_BARROTES");
        String medidaDivisoresVerticales = bundle.getString("MEDIDA_DIVISORES_VERTICALES");

        txtDespiece = findViewById(R.id.txtDespiece);
        txtDespiece.setText(medidaBastidores.concat("\n\n").concat(medidaBarrotes).concat("\n\n").concat(medidaDivisoresVerticales).concat("\n\n"));
        txtDespiece.setEnabled(false);
    }


}
