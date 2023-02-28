package com.example.phonecall;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.phonecall.databinding.ActivityMainBinding;

import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        BlurImage();
        //Buttons
        {
            binding.micSwitcher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.micSwitcher.showNext();
                    switch (binding.micSwitcher.getDisplayedChild()) {
                        case 0:
                            binding.textViewMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.mic_off_text_view, 0);
                            break;
                        case 1:
                            binding.textViewMic.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.mic_on_text_view, 0);
                            break;
                    }
                }
            });
            binding.camSwitcher.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    binding.camSwitcher.showNext();
                }

            });
            binding.callEnd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }

            });
            binding.chat.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                }

            });
            binding.wavingHand.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(MainActivity.this).setMessage("Привет").show();
                }

            });
            binding.menu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    View view1 = binding.mainLayout.getChildAt(1);
                    binding.mainLayout.removeViewAt(1);
                    binding.mainLayout.addView(view1, 2);
                }

            });
            binding.people.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, PhoneBook.class);
                    startActivity(intent);
                }
            });
        }
    }

    // blur background images
    void BlurImage() {
        Blurry.with(this).radius(100).sampling(10).from(BitmapFactory.decodeResource(getResources(), R.drawable.j)).into(binding.topAvatar);
        Blurry.with(this).radius(100).sampling(10).from(BitmapFactory.decodeResource(getResources(), R.drawable.b)).into(binding.bottomAvatar);
    }

}