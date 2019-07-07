package com.example.pictureselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pselect.picSelect;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        img = (ImageView)findViewById(R.id.img);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pselect.Show(MainActivity.this);
//                pic_select_from_storage.imgSelect(R.id.img, MainActivity.this);
//                    pic_select.caller(R.id.img, MainActivity.this);
                //pSelect.imgSelect(R.id.img, MainActivity.this);
                picSelect.loadInto(MainActivity.this, img);
//                Intent i=new Intent(MainActivity.this, pic_select_from_storage.class);
//                startActivity(i);
                //img.setImageBitmap(pic_select_from_storage.loadImg());
                // pSelect.show(MainActivity.this);
            }
        });
    }
}
