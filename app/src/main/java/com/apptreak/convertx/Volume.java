package com.apptreak.convertx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.Html;
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



public class Volume extends Fragment implements View.OnClickListener {
    private Button buttonM3, buttonM3Out, buttonCm3, buttonCm3Out, buttonMm3, buttonMm3Out, buttonLiter, buttonLiterOut, buttonMl, buttonMlOut, buttonGallon, buttonGallonOut;
    TextView textVolumetUnit, textVolumeOut, textVolumeOutUnit;
    EditText textVolumeInput;
    RelativeLayout volumeLayout;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#.#####");
    double inputNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        volumeLayout = (RelativeLayout) inflater.inflate(R.layout.volume_layout, container, false);

        buttonM3 = (Button) volumeLayout.findViewById(R.id.buttonVolumeCm3);
        buttonM3Out = (Button) volumeLayout.findViewById(R.id.buttonVolumeCm3Out);
        buttonCm3 = (Button) volumeLayout.findViewById(R.id.buttonVolumeM3);
        buttonCm3Out = (Button) volumeLayout.findViewById(R.id.buttonVolumeM3Out);
        buttonMm3 = (Button) volumeLayout.findViewById(R.id.buttonVolumeMm3);
        buttonMm3Out = (Button) volumeLayout.findViewById(R.id.buttonVolumeMm3Out);
        buttonLiter = (Button) volumeLayout.findViewById(R.id.buttonVolumeLiter);
        buttonLiterOut = (Button) volumeLayout.findViewById(R.id.buttonVolumeLiterOut);
        buttonMl = (Button) volumeLayout.findViewById(R.id.buttonVolumeMl);
        buttonMlOut = (Button) volumeLayout.findViewById(R.id.buttonVolumeMlOut);
        buttonGallon = (Button) volumeLayout.findViewById(R.id.buttonVolumeGallon);
        buttonGallonOut = (Button) volumeLayout.findViewById(R.id.buttonVolumeGallonOut);

        textVolumeInput = (EditText) volumeLayout.findViewById(R.id.textVolumeInput);
        textVolumetUnit = (TextView) volumeLayout.findViewById(R.id.textVolumeUnit);
        textVolumeOut = (TextView) volumeLayout.findViewById(R.id.textVolumeOut);
        textVolumeOutUnit = (TextView) volumeLayout.findViewById(R.id.textVolumeOutUnit);

        buttonM3.setOnClickListener(this);
        buttonM3Out.setOnClickListener(this);
        buttonCm3.setOnClickListener(this);
        buttonCm3Out.setOnClickListener(this);
        buttonMm3.setOnClickListener(this);
        buttonMm3Out.setOnClickListener(this);
        buttonLiter.setOnClickListener(this);
        buttonLiterOut.setOnClickListener(this);
        buttonMl.setOnClickListener(this);
        buttonMlOut.setOnClickListener(this);
        buttonGallon.setOnClickListener(this);
        buttonGallonOut.setOnClickListener(this);

        return volumeLayout;
    }

    public void onClick(View v) {
        df.setRoundingMode(RoundingMode.CEILING);
        if (textVolumeInput.getText().toString().length() != 0)
            inputNo = Double.parseDouble(textVolumeInput.getText().toString());
        else
            inputNo = 0;
        hideSoftKeyboard();

        switch (v.getId()) {
            case R.id.buttonVolumeM3:
                textVolumetUnit.setText(R.string.button_cubic_meter);
                volumeConversion();
                outputCheck();
                break;
            case R.id.buttonVolumeCm3:
                textVolumetUnit.setText(R.string.button_cubic_cm);
                volumeConversion();
                outputCheck();
                break;
            case R.id.buttonVolumeMm3:
                textVolumetUnit.setText(R.string.button_cubic_mm);
                volumeConversion();
                outputCheck();
                break;
            case R.id.buttonVolumeLiter:
                textVolumetUnit.setText(R.string.button_liter);
                volumeConversion();
                outputCheck();
                break;
            case R.id.buttonVolumeMl:
                textVolumetUnit.setText(R.string.button_ml);
                volumeConversion();
                outputCheck();
                break;
            case R.id.buttonVolumeGallon:
                textVolumetUnit.setText(R.string.button_gallon);
                volumeConversion();
                outputCheck();


            case R.id.buttonVolumeM3Out:
                volumeConversion();
                toM3();

                break;
            case R.id.buttonVolumeCm3Out:
                volumeConversion();
                toCm3();

                break;
            case R.id.buttonVolumeMm3Out:
                volumeConversion();
                toMm3();

                break;
            case R.id.buttonVolumeLiterOut:
                volumeConversion();
                toLiter();

                break;
            case R.id.buttonVolumeMlOut:
                volumeConversion();
                toMl();

                break;
            case R.id.buttonVolumeGallonOut:
                volumeConversion();
                toGallons();

                break;
        }
    }

    //converting to liter
    void volumeConversion() {
        if (textVolumeInput.getText().toString().length() != 0) {
            if (textVolumetUnit.getText().toString().contains("cm"))
                inputNo = inputNo / 1000;
            else if (textVolumetUnit.getText().toString().contains("mm") )
                inputNo = inputNo / 1000000;
            else if (textVolumetUnit.getText().toString().contains("ml"))
                inputNo = inputNo / 1000;
            else if (textVolumetUnit.getText().toString().contains("m"))
                inputNo = inputNo * 1000;

            else if (textVolumetUnit.getText().toString().contains("gallon"))
                inputNo = inputNo * 3.78541;
        }
    }

    //Checking the Output unit, for instant conversion from input buttons
    void outputCheck() {
        if (textVolumeOutUnit.getText().toString().contains("mm"))
            toMm3();

        else if (textVolumeOutUnit.getText().toString().contains("cm"))
            toCm3();
        else if (textVolumeOutUnit.getText().toString().contains("liter") | textVolumeOut.getText().toString().contains("liters"))
            toLiter();
        else if (textVolumeOutUnit.getText().toString().contains("ml"))
            toMl();
        else if (textVolumeOutUnit.getText().toString().contains("m"))
            toM3();
        else if (textVolumeOutUnit.getText().toString().contains("gallon") | textVolumeOut.getText().toString().contains("gallons"))
            toGallons();
    }

    void toM3() {textVolumeOut.setText(String.format("%s", df.format(inputNo / 1000)));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textVolumeOutUnit.setText(Html.fromHtml(" m<sup><small>3</small></sup>", 0));
        } else {
            textVolumeOutUnit.setText(Html.fromHtml(" m<sup><small>3</small></sup>"));
        }
    }

    void toCm3() {
        textVolumeOut.setText(String.format("%s", df.format(inputNo * 1000)));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textVolumeOutUnit.setText(Html.fromHtml(" cm<sup><small>3</small></sup>", 0));
        } else {
            textVolumeOutUnit.setText(Html.fromHtml(" cm<sup><small>3</small></sup>"));
        }
    }

    void toMm3() {textVolumeOut.setText(String.format("%s", df.format(inputNo * 1000000)));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textVolumeOutUnit.setText(Html.fromHtml(" mm<sup><small>3</small></sup>", 0));
        } else {
            textVolumeOutUnit.setText(Html.fromHtml(" mm<sup><small>3</small></sup>"));
        }
    }

    void toLiter() {
       if (inputNo == 1)
            textVolumeOut.setText(String.format("%s", df.format(inputNo)));
        else
            textVolumeOut.setText(String.format("%s", df.format(inputNo )));
        textVolumeOutUnit.setText(" liter");

    }
    void toMl() {
        textVolumeOut.setText(String.format("%s", df.format(inputNo * 1000)));
        textVolumeOutUnit.setText(" ml");
    }

    void toGallons() {
        if ((inputNo / 3.78541) == 1)
            textVolumeOut.setText(String.format("%s", df.format(inputNo / 3.78541)));
        else
            textVolumeOut.setText(String.format("%s", df.format(inputNo / 3.78541)));
        textVolumeOutUnit.setText(" gallon");

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
