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
        final String[] LotsOfStrings = {"Yes", "Well Done!", "Nope", "I'm supposed to be proud?",
                                        "Good Heavens", "Finally, Jesus Christ Man", "You done good kid"};
        final TextView changingText = (TextView) findViewById(R.id.txtChangeable);
        Button changeTextButton = (Button) findViewById(R.id.btnOne) ;

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (int) (Math.random() * LotsOfStrings.length);
                if (random == oldValue) {
                    random = (int) (Math.random() * LotsOfStrings.length);
                }
                changingText.setText(LotsOfStrings[random]);
                oldValue = random;
            }
        });
    }
}