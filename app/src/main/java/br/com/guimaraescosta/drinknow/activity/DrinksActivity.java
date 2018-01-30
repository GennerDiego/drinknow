package br.com.guimaraescosta.drinknow.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter.GenericAdapter;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.entity.Drink;
import br.com.guimaraescosta.drinknow.R;

public class DrinksActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);


        ImageView event_image = findViewById(R.id.event_image);

        event_image.setImageResource(R.drawable.marriage);

        ListView lista = findViewById(R.id.drinks_list);
        final List<Drink> drinks = allDrinks();



        lista.setAdapter(new GenericAdapter<Drink>(getApplicationContext(), drinks) {
            @Override
            public View getMyView(int position, View convertView, ViewGroup parent, Drink drink) {
                return viewDrink(parent, drink);
            }
        });
    }

    private List<Drink> allDrinks() {
        return new ArrayList<>(Arrays.asList(
                new Drink("DAIKIRI", "Licor de cacau, conhaque e creme"),
                new Drink("Alice", "Blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka")));
    }

    private View viewDrink(ViewGroup parent, Drink drink){

        View view = getLayoutInflater().inflate(R.layout.activity_drinks, parent, false);
        TextView nome = view.findViewById(R.id.drink_name);
        TextView descricao = view.findViewById(R.id.drink_description);
        ImageView imagem = view.findViewById(R.id.drink_image);



        nome.setText(drink.getName());
        descricao.setText(drink.getDescription());

        imagem.setImageResource(R.drawable.sample_1);
        imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if(nome.getText().equals("DAIKIRI")) {
            imagem.setImageResource(R.drawable.sample_0);
        }

        return view;
    }

}
