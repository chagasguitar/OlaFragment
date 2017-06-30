package br.com.livroandroid.olafragment;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;



public class Fragment extends android.support.v4.app.Fragment {


    public Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.grid);
        gridView.setAdapter(new GridAdapter(getActivity()));
        gridView.setOnItemClickListener(onGridViewItemClick());
        return view;
    }

    private  AdapterView.OnItemClickListener onGridViewItemClick(){
        return new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    android.support.v4.app.FragmentManager fm = getFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    Fragment_Hortfrut f = new Fragment_Hortfrut();
                    t.replace(R.id.frag, f, "Fragment_Hortfrut");
                    t.addToBackStack(null);
                    t.commit();
                }else if (position==1){
                    android.support.v4.app.FragmentManager fm = getFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    Fragment_acougue f = new Fragment_acougue();
                    t.replace(R.id.frag, f, "Fragment_acougue");
                    t.addToBackStack(null);
                    t.commit();
                }else if (position==2){
                    android.support.v4.app.FragmentManager fm = getFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    Fragment_Laticinio f = new Fragment_Laticinio();
                    t.replace(R.id.frag, f, "Fragment_Laticinio");
                    t.addToBackStack(null);
                    t.commit();
                }else if (position==3){
                    android.support.v4.app.FragmentManager fm = getFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    Fragment_Laticinio f = new Fragment_Laticinio();
                    t.replace(R.id.frag, f, "Fragment_Laticinio");
                    t.addToBackStack(null);
                    t.commit();
                }else if (position==4){
                    android.support.v4.app.FragmentManager fm = getFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    Fragment_Higiene f = new Fragment_Higiene();
                    t.replace(R.id.frag, f, "Fragment_Higiene");
                    t.addToBackStack(null);
                    t.commit();
                }else if (position==5){
                    android.support.v4.app.FragmentManager fm = getFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    Fragment_Limpeza f = new Fragment_Limpeza();
                    t.replace(R.id.frag, f, "Fragment_Limpeza");
                    t.addToBackStack(null);
                    t.commit();
                }
            }
        };

    }


}
