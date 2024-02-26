package com.example.cosmonaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cosmonaut.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWriteWish.setOnClickListener(v -> {
            binding.etMyWish.setVisibility(View.VISIBLE);
            binding.btnPassWish.setVisibility(View.VISIBLE);

            binding.btnWriteWish.setVisibility(View.INVISIBLE);

        });

        binding.btnPassWish.setOnClickListener(v1 -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My message");

            emailIntent.putExtra(Intent.EXTRA_TEXT, binding.etMyWish.getText().toString());

            startActivity(emailIntent);
        });
    }
}