package ussrfantom.com.example.bullinventorybyscanner.selectionmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.replacementke.ReplacementKe;
import ussrfantom.com.example.bullinventorybyscanner.searchke.employess.SearchKe;

public class SelectionMenu extends AppCompatActivity {
    private ImageView imageViewSearch;
    private ImageView imageViewRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_menu);

        imageViewSearch = findViewById(R.id.imageViewSearch);
        imageViewRecording = findViewById(R.id.imageViewRecording);


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

        //Нажатие на картинку с записью ке начало
        imageViewRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionMenu.this, ReplacementKe.class);
                startActivity(intent);
                finish();
            }
        });
        //Нажатие на картинку с записью ке конец

    }
}