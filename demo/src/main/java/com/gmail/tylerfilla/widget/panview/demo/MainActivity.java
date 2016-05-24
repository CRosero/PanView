package com.gmail.tylerfilla.widget.panview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView sampleText;
    private SwitchCompat wordWrapSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate main layout and set as content view
        setContentView(R.layout.activity_main);

        // Get stuff
        sampleText = (TextView) findViewById(R.id.sampleText);
        wordWrapSwitch = (SwitchCompat) findViewById(R.id.wordWrapSwitch);

        // Set sample text
        sampleText.setText(Html.fromHtml(getString(R.string.sample_text_1)));

        // Listen for word wrap switch toggles
        wordWrapSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setWordWrap(isChecked);
            }

        });
    }

    private void setWordWrap(boolean wordWrap) {
        ViewGroup.LayoutParams layoutParams = sampleText.getLayoutParams();

        if (wordWrap) {
            // Matching parent width wraps text at screen edge
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        } else {
            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }

        sampleText.setLayoutParams(layoutParams);
    }

}
