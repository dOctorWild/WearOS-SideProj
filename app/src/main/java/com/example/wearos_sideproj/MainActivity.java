package com.example.wearos_sideproj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wearos_sideproj.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    int oldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.txtChangeable;

        TestButton();
    }

    public void TestButton() {
        final String[] SurfReport= {"Kommetjie has no waves today", "Go surf pebbles its 4-6ft",
                                    "Too big today, got 12-14ft heading through.", "Best waves near " +
                                    "you are in Llandudno. (2-4ft Offshore Winds)", "Go to Dunes now!",
                                    "Swell Direction looking good for Ledge right now", "Flat all round buddy."};
        final TextView changingText = (TextView) findViewById(R.id.txtChangeable);
        Button changeTextButton = (Button) findViewById(R.id.btnOne) ;

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (int) (Math.random() * SurfReport.length);
                if (random == oldValue) {
                    random = (int) (Math.random() * SurfReport.length);
                }
                changingText.setText(SurfReport[random]);
                oldValue = random;
                changeTextButton.setVisibility(view.INVISIBLE);
            }
        });
    }
}