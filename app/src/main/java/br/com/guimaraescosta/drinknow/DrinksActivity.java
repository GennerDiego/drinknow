package br.com.guimaraescosta.drinknow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        String [] drinks = {"Alexander (licor de cacau, conhaque e creme)","Alice (coquetel sem álcool)","Batida cremosa (leite condensado, gelo, vodka)","Esmeralda (licor de menta e soda limonada)","Kir (licor de cassis e champanhe)","Lagoa Azul (blue curaçau e vodka)","Martini com cerejas","SHIRLEY TEMPLE", "VARIAÇÃO DA PIÑA COLADA SEM ÁLCOOL - VIRGIN COLADA", "VIRGIN ON THE BEACH"};
        ListView drinks_list = findViewById(R.id.drinks_list);
        ArrayAdapter<String> drinksArray = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,drinks);
        drinks_list.setAdapter(drinksArray);
    }
}
