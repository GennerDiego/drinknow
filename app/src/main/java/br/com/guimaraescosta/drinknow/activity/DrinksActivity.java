package br.com.guimaraescosta.drinknow.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter.AdapterTest;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter.GenericAdapter;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.entity.Drink;
import br.com.guimaraescosta.drinknow.R;

public class DrinksActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ListView lista;
        final ArrayAdapter<Drink> adapter;
        final List<Drink> drinks;
        final AdapterTest adapterT;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        //Fixed event image
        ImageView event_image = findViewById(R.id.event_image);
        event_image.setImageResource(R.drawable.marriage2);

       // Fixed event name
        TextView event_name = findViewById(R.id.event_name);
        event_name.setText("(Camila)");



        lista = findViewById(R.id.drinks_list);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        drinks = allDrinks();

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.header,lista,false);
        header.bringToFront();
        lista.addHeaderView(header);



//        ArrayAdapter<Drink> adapterRE = new ArrayAdapter<Drink>(this,android.R.layout.simple_list_item_multiple_choice, drinks) ;
//        lista.setAdapter(adapterRE);


//        adapterT = new AdapterTest(this, android.R.layout.simple_list_item_multiple_choice, drinks);
//        lista.setAdapter(adapterT);


//        if(nome != null) {
//            nome.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (nome.isChecked()) {
//                        nome.setChecked(false);
//                    } else {
//                        nome.setChecked(true);
//                        String teste = (String) nome.getText().toString();
//
//                    }
//
//                }
//            });
//        }

        lista.setAdapter(new GenericAdapter<Drink>(getApplicationContext(),R.layout.row_layout,drinks) {

            @Override
            public View getMyView(int position, View convertView, ViewGroup parent, Drink drink) {



                return viewDrink(parent, drink);
            }
        });




}

    private List<Drink> allDrinks() {
        return new ArrayList<>(Arrays.asList(
                new Drink("Daikiri", "Licor de cacau, conhaque e creme"),
                new Drink("Alice", "Blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka")));
    }

    private View viewDrink(ViewGroup parent, Drink drink){

        View view = getLayoutInflater().inflate(R.layout.row_layout, parent, false);
       final CheckedTextView nome = view.findViewById(R.id.drink_name);
        TextView descricao = view.findViewById(R.id.drink_description);
      ImageView imagem = view.findViewById(R.id.drink_image);


        final ListView lista = findViewById(R.id.drinks_list);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

            nome.setText(drink.getName());
            descricao.setText(drink.getDescription());
            imagem.setImageResource(R.drawable.sample_2);
            imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);

            if(nome.getText().equals("Daikiri")) {
               imagem.setImageResource(R.drawable.sample_0);
            }

            if(nome.getText().equals("Lagoa Azul")) {
                imagem.setImageResource(R.drawable.sample_1);
            }





            nome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(nome.isChecked()) {
                        nome.setChecked(false);

                    } else{
                        nome.setChecked(true);
                        String teste = nome.getText().toString();

                    }

                }
            });
//
//        OnItemClickListener itemClickListener = new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Object drink = lista.getItemAtPosition(i);
//                String drinkString = drink.toString();
//                if(nome.isChecked()) {
//                    nome.setChecked(false);
//                    lista.setItemChecked(i,false);
//
//                } else{
//                    nome.setChecked(true);
//                    String teste = nome.getText().toString();
//                    lista.setItemChecked(i,true);
//
//                }
//            }
//        };
//
//        lista.setOnItemClickListener(itemClickListener);



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
//
////



        return view;
    }



}





