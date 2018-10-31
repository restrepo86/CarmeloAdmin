package co.com.uco.carmeloadmin.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.com.uco.carmeloadmin.R;

public class CustomAdapter extends BaseAdapter {

    private List<ItemLista> listaItems;
    private Context context;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<ItemLista> listaItems) {
        this.listaItems = listaItems;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    class ViewHolder{
        ImageView imageView;
        TextView txtId;
        TextView txtAncho;
        TextView txtAlto;
        TextView txtMaterial;
    }

    @Override
    public int getCount() {
        return listaItems.size();
    }

    @Override
    public ItemLista getItem(int position) {
        return listaItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_lista, null);
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.txtId = convertView.findViewById(R.id.txtId);
            holder.txtAncho = convertView.findViewById(R.id.txtAncho);
            holder.txtAlto = convertView.findViewById(R.id.txtAlto);
            holder.txtMaterial = convertView.findViewById(R.id.txtMaterial);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(listaItems.get(position).getIdImage());
        holder.txtId.setText(listaItems.get(position).getId());
        holder.txtAncho.setText(listaItems.get(position).getAncho());
        holder.txtAlto.setText(listaItems.get(position).getAlto());
        holder.txtMaterial.setText(listaItems.get(position).getMaterial());
        return convertView;
    }

}
