package com.gl.globalcalculator.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gl.globalcalculator.R;
import com.gl.globalcalculator.ServiceImpl.GlobalCalculatorServicceImpl;
import com.gl.globalcalculator.service.GlobalCalculatorService;
import com.gl.globalcalculator.validation.FieldValidation;

public class ScientificCalculatorFragment extends Fragment {

    private Button logButton;
    private Button lnButton;

    private EditText firstNumber;

    private Double result;
    private Double number_1;

    private TextView resultText;

    private GlobalCalculatorService globalCalculatorService = new GlobalCalculatorServicceImpl();

    public ScientificCalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scientific_calculator, container, false);

        logButton = view.findViewById(R.id.id_button_log);
        lnButton = view.findViewById(R.id.id_button_ln);
        resultText = view.findViewById(R.id.id_result);

        firstNumber = view.findViewById(R.id.id_scientific_value);

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldValidation.validateFieldScientific(firstNumber.getText().toString(), getContext())) {
                    number_1 = Double.parseDouble(firstNumber.getText().toString().trim());
                    double result1 = globalCalculatorService.logNumber(number_1);
                    resultText.setText(String.valueOf(result1));
                }
            }
        });

        lnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldValidation.validateFieldScientific(firstNumber.getText().toString(), getContext())) {
                    number_1 = Double.parseDouble(firstNumber.getText().toString());
                    result = globalCalculatorService.lognNumber(number_1);
                    resultText.setText(result.toString());
                }
            }
        });

        return view;
    }
}
