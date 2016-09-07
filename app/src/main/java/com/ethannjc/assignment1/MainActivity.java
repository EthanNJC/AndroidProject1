package com.ethannjc.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> bases = new ArrayList<Integer>();
        for (int a = 1; a < 17; a++) bases.add(a);

        final Spinner baseListSpinner1 = (Spinner) findViewById(R.id.base_spinner_1);
        final Spinner baseListSpinner2 = (Spinner) findViewById(R.id.base_spinner_2);
        final TextView output = (TextView) findViewById(R.id.output_text);
        final EditText input = (EditText) findViewById(R.id.input_text);
        final Button convertButton = (Button) findViewById(R.id.convert_button);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bases);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        baseListSpinner1.setAdapter(adapter);
        baseListSpinner2.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int base1 = (int) baseListSpinner1.getSelectedItem();
                int base2 = (int) baseListSpinner2.getSelectedItem();
                String original = input.getText().toString();

                int result = Integer.parseInt(original, base1);
                output.setText(Integer.toString(result, base2));
            }
        });

    }
}
