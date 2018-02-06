package br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.guimaraescosta.drinknow.R;
import br.com.guimaraescosta.drinknow.activity.DrinksActivity;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.entity.Drink;

/**
 * Created by jguimara on 30/01/2018.
 */

public class AdapterTest extends ArrayAdapter {

    private final List<Drink> drinks;
    private final Context context;


    public AdapterTest(Context context, int textViewResourceId, List<Drink> drinks) {
        super(context, textViewResourceId, drinks);
        this.drinks = drinks;
        this.context = context;

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


        TextView name = view.findViewById((R.id.drink_name));
        TextView descricao = view.findViewById(R.id.drink_description);
        ImageView imagem = view.findViewById(R.id.drink_image);
        final CheckBox check = (CheckBox) view.findViewById(R.id.drink_check);


        name.setText(drinks.get(position).getName());

        descricao.setText(drinks.get(position).getDescription());
        imagem.setImageResource(R.drawable.sample_2);
        imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if (name.getText().equals("Daikiri")) {
            imagem.setImageResource(R.drawable.sample_0);
        }

        if (name.getText().equals("Lagoa Azul")) {
            imagem.setImageResource(R.drawable.sample_1);
        }

        Drink d = drinks.get(position);
        check.setChecked(d.isSelected());
        check.setTag(d);
        check.setOnCheckedChangeListener((DrinksActivity) context);

        return view;

    }


}