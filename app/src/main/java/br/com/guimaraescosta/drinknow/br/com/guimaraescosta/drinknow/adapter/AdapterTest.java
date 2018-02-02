package br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.guimaraescosta.drinknow.R;
import br.com.guimaraescosta.drinknow.activity.DrinksActivity;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.entity.Drink;

/**
 * Created by jguimara on 30/01/2018.
 */

    public class AdapterTest extends ArrayAdapter {

    private final List<Drink> drinks;


    public AdapterTest(Context context, int textViewResourceId, List<Drink> drinks) {
        super(context, textViewResourceId, drinks);
        this.drinks = drinks;

    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.row_layout, null);
//
        final CheckedTextView nome = view.findViewById(R.id.drink_name);
        TextView descricao = view.findViewById(R.id.drink_description);
        ImageView imagem = view.findViewById(R.id.drink_image);
        final CheckedTextView check =  (CheckedTextView) view.findViewById(R.id.drink_name);
        final ListView lista = (ListView) view.findViewById(R.id.drinks_list);
//

        check.setText(drinks.get(position).getName());
//        check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(check.isChecked()) {
//                    check.setChecked(false);
//                } else{
//                    check.setChecked(true);
//                     String teste = (String) check.getText().toString();
//
//                }
//
//            }
//        });


//
//        nome.setText(drinks.get(position).getName());
//        descricao.setText(drinks.get(position).getDescription());
//        imagem.setImageResource(R.drawable.sample_1);
//        imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        if (nome.getText().equals("DAIKIRI")) {
//           imagem.setImageResource(R.drawable.sample_0);
//       }
//



//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Object drink = lista.getItemAtPosition(i);
//
//                String drinkString = drink.toString();
//                String name = nome.getText().toString();
//                if(nome.isChecked()) {
//                    nome.setChecked(false);
//
//
//
//                } else{
//                    nome.setChecked(true);
//                    String teste = nome.getText().toString();
//                    lista.setItemChecked(i,true);
//
//
//                }
//
//            }
//        });





        return view;

    }


}