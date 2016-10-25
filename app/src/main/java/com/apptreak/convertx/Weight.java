package com.apptreak.convertx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.RoundingMode;

import static android.content.Context.INPUT_METHOD_SERVICE;



public class Weight extends Fragment implements View.OnClickListener {
    private Button buttonGrams, buttonGramsOut, buttonKg, buttonKgOut, buttonMg, buttonMgOut, buttonTon, buttonTonOut, buttonPound, buttonPoundout, buttonCarat, buttonCaratOut;
    TextView textWeightUnit, textWeightOut;
    EditText textWeightInput;
    RelativeLayout weightLayout;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#.#####");
    double inputNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        weightLayout = (RelativeLayout) inflater.inflate(R.layout.weight_layout, container, false);

        buttonGrams = (Button) weightLayout.findViewById(R.id.buttonWeightGrams);
        buttonGramsOut = (Button) weightLayout.findViewById(R.id.buttonWeightGramsOut);
        buttonKg = (Button) weightLayout.findViewById(R.id.buttonWeightKg);
        buttonKgOut = (Button) weightLayout.findViewById(R.id.buttonWeightKgOut);
        buttonMg = (Button) weightLayout.findViewById(R.id.buttonWeightMg);
        buttonMgOut = (Button) weightLayout.findViewById(R.id.buttonWeightMgOut);
        buttonTon = (Button) weightLayout.findViewById(R.id.buttonWeightTons);
        buttonTonOut = (Button) weightLayout.findViewById(R.id.buttonWeightTonsOut);
        buttonPound = (Button) weightLayout.findViewById(R.id.buttonWeightPounds);
        buttonPoundout = (Button) weightLayout.findViewById(R.id.buttonWeightPoundsOut);
        buttonCarat = (Button) weightLayout.findViewById(R.id.buttonWeightCarat);
        buttonCaratOut = (Button) weightLayout.findViewById(R.id.buttonWeightCaratOut);

        textWeightInput = (EditText) weightLayout.findViewById(R.id.textWeightInput);
        textWeightUnit = (TextView) weightLayout.findViewById(R.id.textWeightUnit);
        textWeightOut = (TextView) weightLayout.findViewById(R.id.textWeightOut);

        buttonGrams.setOnClickListener(this);
        buttonGramsOut.setOnClickListener(this);
        buttonKg.setOnClickListener(this);
        buttonKgOut.setOnClickListener(this);
        buttonMg.setOnClickListener(this);
        buttonMgOut.setOnClickListener(this);
        buttonTon.setOnClickListener(this);
        buttonTonOut.setOnClickListener(this);
        buttonPound.setOnClickListener(this);
        buttonPoundout.setOnClickListener(this);
        buttonCarat.setOnClickListener(this);
        buttonCaratOut.setOnClickListener(this);

        return weightLayout;
    }

    public void onClick(View v) {
        df.setRoundingMode(RoundingMode.CEILING);
        if (textWeightInput.getText().toString().length() != 0)
            inputNo = Double.parseDouble(textWeightInput.getText().toString());
        else
            inputNo = 0;
        hideSoftKeyboard();

        switch (v.getId()) {
            case R.id.buttonWeightGrams:
                textWeightUnit.setText("gm");
                weightConversion();
                outputCheck();
                break;
            case R.id.buttonWeightKg:
                textWeightUnit.setText("kg");
                weightConversion();
                outputCheck();
                break;
            case R.id.buttonWeightMg:
                textWeightUnit.setText("mg");
                weightConversion();
                outputCheck();
                break;
            case R.id.buttonWeightTons:
                textWeightUnit.setText("ton");
                weightConversion();
                outputCheck();
                break;
            case R.id.buttonWeightPounds:
                textWeightUnit.setText("pound");
                weightConversion();
                outputCheck();
                break;
            case R.id.buttonWeightCarat:
                textWeightUnit.setText("carat");
                weightConversion();
                outputCheck();
                break;

            case R.id.buttonWeightGramsOut:
                weightConversion();
                toGrams();
                break;
            case R.id.buttonWeightKgOut:
                weightConversion();
                toKg();
                break;
            case R.id.buttonWeightMgOut:
                weightConversion();
                toMg();
                break;
            case R.id.buttonWeightTonsOut:
                weightConversion();
                toTons();
                break;
            case R.id.buttonWeightPoundsOut:
                weightConversion();
                toPounds();
                break;
            case R.id.buttonWeightCaratOut:
                weightConversion();
                toCarats();
                break;
        }
    }

    //converting to grams
    void weightConversion() {
        if (textWeightInput.getText().toString().length() != 0) {
            if (textWeightUnit.getText().toString().equalsIgnoreCase("kg"))
                inputNo = inputNo * 1000;
            else if (textWeightUnit.getText().toString().equalsIgnoreCase("mg") )
                inputNo = inputNo / 1000;
            else if (textWeightUnit.getText().toString().equalsIgnoreCase("ton"))
                inputNo = inputNo * 1000000;
            else if (textWeightUnit.getText().toString().equalsIgnoreCase("pound"))
                inputNo = inputNo * 453.592;
            else if (textWeightUnit.getText().toString().equalsIgnoreCase("carat"))
                inputNo = inputNo * 0.2;
        }
    }

    //Checking the Output unit, for instant conversion from input buttons
    void outputCheck() {
        if (textWeightOut.getText().toString().endsWith("gram") | textWeightOut.getText().toString().endsWith("grams"))
            toGrams();
        else if (textWeightOut.getText().toString().endsWith("kg"))
            toKg();
        else if (textWeightOut.getText().toString().endsWith("mg"))
            toMg();
        else if (textWeightOut.getText().toString().endsWith("ton") | textWeightOut.getText().toString().endsWith("tons"))
            toTons();
        else if (textWeightOut.getText().toString().endsWith("pound") | textWeightOut.getText().toString().endsWith("pounds"))
            toPounds();
        else if (textWeightOut.getText().toString().endsWith("carat") | textWeightOut.getText().toString().endsWith("carats"))
            toCarats();
    }

    void toGrams() {
        if (inputNo == 1)
            textWeightOut.setText(String.format("%s", df.format(inputNo) + " gram"));
        else
            textWeightOut.setText(String.format("%s", df.format(inputNo) + " grams"));
    }

    void toKg() {
        textWeightOut.setText(String.format("%s", df.format(inputNo / 1000) + " kg"));
    }

    void toMg() {
        textWeightOut.setText(String.format("%s", df.format(inputNo * 1000) + " mg"));
    }

    void toTons() {
        if ((inputNo / 86400) == 1)
            textWeightOut.setText(String.format("%s", df.format(inputNo / 1000000) + " ton"));
        else
            textWeightOut.setText(String.format("%s", df.format(inputNo / 1000000) + " tons"));
    }

    void toPounds() {
        if ((inputNo / 604800) == 1)
            textWeightOut.setText(String.format("%s", df.format(inputNo / 453.592) + " pound"));
        else
            textWeightOut.setText(String.format("%s", df.format(inputNo / 453.592) + " pounds"));
    }

    void toCarats() {
        if ((inputNo / 2629800) == 1)
            textWeightOut.setText(String.format("%s", df.format(inputNo / 0.2) + " carat"));
        else
            textWeightOut.setText(String.format("%s", df.format(inputNo / 0.2) + " carats"));
    }



    void hideSoftKeyboard(){
        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
