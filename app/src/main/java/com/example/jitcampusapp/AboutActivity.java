package com.example.jitcampusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imageSlider = findViewById(R.id.image_slider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel("https://www.jcmcsiit.ac.in/img/College/1.jpg",null));
        images.add(new SlideModel("https://www.jcmcsiit.ac.in/img/College/Picture%20032.jpg",null));
        images.add(new SlideModel("https://www.jcmcsiit.ac.in/img/College/4.jpg",null));
        images.add(new SlideModel("https://www.jcmcsiit.ac.in/img/College/3.jpg",null));
        images .add(new SlideModel("https://www.jcmcsiit.ac.in/img/College/8.jpg",null));
        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
    }
}