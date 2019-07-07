package com.example.pselect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

public class picSelect extends AppCompatActivity {


    private final int IMG_REQUEST = 1;
    public Bitmap bitmap;
    static ImageView img_view;
    static Context con;

    public static void loadInto(Context context, ImageView imageView){
        con=context;
        img_view = imageView;

        picSelect pic_select_from_storage=new picSelect();
        pic_select_from_storage.al();
    }

    void al(){
        Intent i = new Intent(con, picSelect.class);
        ((Activity)con).startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        img_view = ((Activity) con).findViewById(img_view.getId());
        Intent i=new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Image"), IMG_REQUEST);

    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Toast.makeText(context, "hhh", Toast.LENGTH_SHORT).show();
        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                //loadImg();
                //Toast.makeText(context, "hhh2", Toast.LENGTH_SHORT).show();
                img_view.setImageBitmap(bitmap);

                finish();

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("IDK", e.toString());
            }
        }
    }

}
