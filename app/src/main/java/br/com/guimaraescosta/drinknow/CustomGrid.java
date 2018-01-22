package br.com.guimaraescosta.drinknow;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jguimara on 21/01/2018.
 */

public class CustomGrid extends BaseAdapter{

    private final List<Drinks> drinks;
    private final Activity act;

    public CustomGrid(List<Drinks> drinks, Activity act) {
        this.drinks = drinks;
        this.act = act;
    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public Object getItem(int position) {
        return drinks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.activity_drinks, parent, false);

        Drinks drink = drinks.get(position);

        TextView nome = view.findViewById(R.id.drink_name);
        TextView descricao = view.findViewById(R.id.drink_description);
        ImageView imagem = view.findViewById(R.id.drink_image);

        nome.setText(drink.getName());
        descricao.setText(drink.getDescription());

        imagem.setImageResource(R.drawable.sample_1);
        imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if(nome.equals("DAIKIRI")) {
            imagem.setImageResource(R.drawable.sample_0);
        }

        return view;
    }
}
