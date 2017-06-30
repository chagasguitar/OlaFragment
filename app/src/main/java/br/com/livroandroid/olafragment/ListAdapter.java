package br.com.livroandroid.olafragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Hortfrut_Produtos> hf;

    public  ListAdapter(Context context, ArrayList<Hortfrut_Produtos> hf){
        this.context=context;
        this.hf=hf;
    }

    @Override
    public int getCount() {
        return hf.size();
    }

    @Override
    public Object getItem(int position) {

        return  hf.get(position);
    }

    @Override
    public long getItemId(int position) {

        return hf.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hortfrut_Produtos hfl = new Hortfrut_Produtos();
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list,parent,false);
        TextView textView = (TextView)view.findViewById(R.id.textlist);
        textView.setText(hfl.nome);
        return view;
    }
}
