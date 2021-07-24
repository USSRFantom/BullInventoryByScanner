package ussrfantom.com.example.bullinventorybyscanner.selectionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.searchke.employess.SearchKe;

public class SelectionMenu extends AppCompatActivity {
    private ImageView imageViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_menu);

        imageViewSearch = findViewById(R.id.imageViewSearch);


        //Нажатие на картинку с поиском ке начало
            imageViewSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectionMenu.this, SearchKe.class);
                    startActivity(intent);
                    finish();
                }
            });
        //Нажатие на картинку с поиском ке конец
    }
}