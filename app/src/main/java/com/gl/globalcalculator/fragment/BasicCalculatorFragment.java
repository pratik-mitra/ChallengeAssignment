package com.gl.globalcalculator.fragment;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
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

public class BasicCalculatorFragment extends Fragment {

    private Button addButton;
    private Button subButton;
    private Button mltButton;
    private Button divButton;

    private TextView resultText;

    private EditText firstNumber = null;
    private EditText secondNumber = null;

    private Double result;
    private Double number_1;
    private Double number_2;

    private GlobalCalculatorService globalCalculatorService = new GlobalCalculatorServicceImpl();

    public BasicCalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basic_calculator, container, false);

        addButton = view.findViewById(R.id.id_button_add);
        subButton = view.findViewById(R.id.id_button_sub);
        mltButton = view.findViewById(R.id.id_button_mlt);
        divButton = view.findViewById(R.id.id_button_div);

        resultText = view.findViewById(R.id.id_result);

        firstNumber = ((EditText)view.findViewById(R.id.id_first_value));
        secondNumber = ((EditText)view.findViewById(R.id.id_second_value));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldValidation.validateFieldBasic(firstNumber.getText().toString(),secondNumber.getText().toString(), getContext())) {
                    number_1 = Double.parseDouble(firstNumber.getText().toString());
                    number_2 = Double.parseDouble(secondNumber.getText().toString());
                    result = globalCalculatorService.addNumber(number_1, number_2);
                    resultText.setText(result.toString());
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldValidation.validateFieldBasic(firstNumber.getText().toString(),secondNumber.getText().toString(), getContext())) {
                    number_1 = Double.parseDouble(firstNumber.getText().toString());
                    number_2 = Double.parseDouble(secondNumber.getText().toString());
                    result = globalCalculatorService.substractionNumber(number_1, number_2);
                    resultText.setText(result.toString());
                }
            }
        });

        mltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldValidation.validateFieldBasic(firstNumber.getText().toString(),secondNumber.getText().toString(), getContext())) {
                    number_1 = Double.parseDouble(firstNumber.getText().toString());
                    number_2 = Double.parseDouble(secondNumber.getText().toString());
                    result = globalCalculatorService.multiplicationNumber(number_1, number_2);
                    resultText.setText(result.toString());
                }
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FieldValidation.validateFieldBasic(firstNumber.getText().toString(),secondNumber.getText().toString(), getContext()) &&
                        FieldValidation.validateFieldZero(secondNumber.getText().toString(), getContext())) {
                    number_1 = Double.parseDouble(firstNumber.getText().toString());
                    number_2 = Double.parseDouble(secondNumber.getText().toString());
                    result = globalCalculatorService.divisionNumber(number_1, number_2);
                    resultText.setText(result.toString());
                }
            }
        });
        return view;
    }
}
