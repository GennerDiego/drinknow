package br.com.guimaraescosta.drinknow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrinksActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        ListView lista = findViewById(R.id.drinks_list);
        List<Drinks> drinks = allDrinks();
        CustomGrid adapter = new CustomGrid(drinks, this);
        lista.setAdapter(adapter);
    }

    private List<Drinks> allDrinks() {
        return new ArrayList<>(Arrays.asList(
                new Drinks("DAIKIRI", "Licor de cacau, conhaque e creme"),
                new Drinks("Alice", "Blue curaçau e vodka"),
                new Drinks("Lagoa Azul","blue curaçau e vodka" )));


    }
}
