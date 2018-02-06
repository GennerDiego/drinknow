package br.com.guimaraescosta.drinknow.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.guimaraescosta.drinknow.R;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter.AdapterTest;
import br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.entity.Drink;

public class DrinksActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ListView lista;
    List<Drink> drinks;
    AdapterTest adapterT;
    ArrayList<String> selectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        //Fixed event image
        ImageView event_image = findViewById(R.id.event_image);
        event_image.setImageResource(R.drawable.marriage1);

       // Fixed event name
        final TextView event_name = findViewById(R.id.event_name);
        event_name.setText("(Jousiane e Romildo)");

        //For newborns
//        Typeface tf = ResourcesCompat.getFont(this,R.font.good_morning);
//        event_name.setTypeface(tf);


        lista = findViewById(R.id.drinks_list);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        drinks = allDrinks();

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.header,lista,false);
        header.bringToFront();
        lista.addHeaderView(header);
        ViewGroup footer = (ViewGroup)inflater.inflate(R.layout.footer,lista,false);
        lista.addFooterView(footer);





        adapterT = new AdapterTest(this, android.R.layout.simple_list_item_multiple_choice, drinks);
        lista.setAdapter(adapterT);

//        lista.setAdapter(new GenericAdapter<Drink>(getApplicationContext(),R.layout.row_layout,drinks) {
//
//            @Override
//            public View getMyView(int position, View convertView, ViewGroup parent, Drink drink) {
//
//
//
//                return viewDrink(parent, drink);
//            }
//        });
//

}

    private List<Drink> allDrinks() {
        return new ArrayList<>(Arrays.asList(
                new Drink("Daikiri", "Licor de cacau, conhaque, creme, avelã, pimenta, chocolate e pinãta pinãtapinãta pinãta  "),
                new Drink("Alice", "Blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka"),
                new Drink("Lagoa Azul","blue curaçau e vodka")));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        int pos = lista.getPositionForView(compoundButton);
        int posCorrect = pos -1 ;
        if (posCorrect != ListView.INVALID_POSITION) {
            Drink d = drinks.get(posCorrect);
            d.setSelected(isChecked);

            if(selectedItems.contains(d.getName())){
                selectedItems.remove(d.getName());
            } else {
                selectedItems.add(d.getName());
            }

//            Toast.makeText(
//                    this,
//                    "Clicked on item: " + d.getName() + ". State: is "
//                            + isChecked, Toast.LENGTH_SHORT).show();
        }


    }



//    private View viewDrink(ViewGroup parent, Drink drink){
//
//
//        View view = getLayoutInflater().inflate(R.layout.row_layout, parent, false);
//       final TextView nome = view.findViewById(R.id.drink_name);
//        TextView descricao = view.findViewById(R.id.drink_description);
//      ImageView imagem = view.findViewById(R.id.drink_image);
//
//
//        final ListView lista = findViewById(R.id.drinks_list);
//        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//
//            nome.setText(drink.getName());
//            descricao.setText(drink.getDescription());
//            imagem.setImageResource(R.drawable.sample_2);
//            imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//            if(nome.getText().equals("Daikiri")) {
//               imagem.setImageResource(R.drawable.sample_0);
//            }
//
//            if(nome.getText().equals("Lagoa Azul")) {
//                imagem.setImageResource(R.drawable.sample_1);
//            }
//
//        return view;
//    }


}





