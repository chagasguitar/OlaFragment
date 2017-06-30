package br.com.livroandroid.olafragment.persistence;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;
import br.com.livroandroid.olafragment.Hortfrut_Produtos;


public class ListaDB extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "Lista_de_compras";
    public static final int VERSAO_BANCO = 1;
    SQLiteDatabase db;

    public ListaDB (Context context){

        super(context,NOME_BANCO,null,VERSAO_BANCO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists hortfrut(_id integer primary key autoincrement,nome text, tipo text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long Salvar(Hortfrut_Produtos hf){
        long id = hf.id;
        try (SQLiteDatabase db = getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nome", hf.nome);
            contentValues.put("tipo", hf.tipo);

            if (id != 0) {
                String _id = String.valueOf(hf.id);
                String[] whereArgs = new String[]{_id};

                int count;
                count = db.update("hortfrut", contentValues, "_id=?", whereArgs);
                return count;
            } else {
                id = db.insert("hortfrut", "", contentValues);
                return id;
            }
        }

    }

    //public List<Hortfrut_Produtos> lista(){

    //    List<Hortfrut_Produtos> hortfrut = new ArrayList<>();
    //    Cursor c = db.query("hortfrut",null, null, null, null, null, null, null);
     //   if (c.moveToFirst()){
         //   do{
           //     Hortfrut_Produtos hf = new Hortfrut_Produtos();
           //     hortfrut.add(hf);
          //      hf.nome = c.getString(c.getColumnIndex("nome"));
          //      hf.tipo = c.getString(c.getColumnIndex("tipo"));
          //  }while (c.moveToNext());

       // }
      //  c.close();
      //   return hortfrut;

      //  }


}



