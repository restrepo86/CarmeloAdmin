package co.com.uco.carmeloadmin.util;

import android.app.Application;

import co.com.uco.carmeloadmin.persistencia.util.DataBaseHelper;

public class GlobalState extends Application {

    private DataBaseHelper dataBaseHelper;

    public DataBaseHelper getDataBaseHelper() {
        return dataBaseHelper;
    }

    public void setDataBaseHelper(DataBaseHelper dataBaseHelper) {
        this.dataBaseHelper = dataBaseHelper;
    }
}
