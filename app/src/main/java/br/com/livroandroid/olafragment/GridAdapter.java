package br.com.livroandroid.olafragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridAdapter extends BaseAdapter {

    private Context ctx;
    public GridAdapter (Context ctx){
        this.ctx = ctx;


    }

    private String[] secoes = new String[]{"Hortifrut","Açougue","Laticíneos","Bebidas", "Higiene", "Limpeza"};
    private int[] img = new int[]{R.drawable.hortfrut,R.drawable.acougue, R.drawable.leite, R.drawable.bebidas, R.drawable.higiene, R.drawable.limpeza};
    @Override
    public int getCount() {
        return secoes.length;
    }

    @Override
    public Object getItem(int i) {
        return img[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i,View View, ViewGroup viewGroup) {
        String secao = secoes[i];
        int imagem = img[i];
        View view =  LayoutInflater.from(ctx).inflate(R.layout.adaptergrid, viewGroup,false);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(secao);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(imagem);
        return view;
    }
}
