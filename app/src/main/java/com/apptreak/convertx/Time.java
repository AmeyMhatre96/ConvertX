package com.apptreak.convertx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.AttributeSet;

import java.math.RoundingMode;

import static android.content.Context.INPUT_METHOD_SERVICE;



public class Time extends Fragment implements View.OnClickListener {
    private Button buttonSeconds, buttonSecondsOut, buttonMinutes, buttonMinutesOut, buttonHours, buttonHoursOut, buttonDays, buttonDaysOut, buttonWeeks, buttonWeeksOut, buttonMonths, buttonMonthsOut, buttonYears, buttonsYearsOut;
    TextView textTimeUnit, textTimeOut;
    EditText textTimeInput;
    RelativeLayout timeLayout;
    java.text.DecimalFormat df;
    double inputNo;
    double inp;
    boolean flag = false;
    String unit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        timeLayout = (RelativeLayout) inflater.inflate(R.layout.time_layout, container, false);

        buttonSeconds = (Button) timeLayout.findViewById(R.id.buttonTimeSeconds);
        buttonSecondsOut = (Button) timeLayout.findViewById(R.id.buttonTimeSecondsOut);
        buttonMinutes = (Button) timeLayout.findViewById(R.id.buttonTimeMinutes);
        buttonMinutesOut = (Button) timeLayout.findViewById(R.id.buttonTimeMinutesOut);
        buttonHours = (Button) timeLayout.findViewById(R.id.buttonTimeHours);
        buttonHoursOut = (Button) timeLayout.findViewById(R.id.buttonTimeHoursOut);
        buttonDays = (Button) timeLayout.findViewById(R.id.buttonTimeDays);
        buttonDaysOut = (Button) timeLayout.findViewById(R.id.buttonTimeDaysOut);
        buttonWeeks = (Button) timeLayout.findViewById(R.id.buttonTimeWeeks);
        buttonWeeksOut = (Button) timeLayout.findViewById(R.id.buttonTimeWeeksOut);
        buttonMonths = (Button) timeLayout.findViewById(R.id.buttonTimeMonths);
        buttonMonthsOut = (Button) timeLayout.findViewById(R.id.buttonTimeMonthsOut);
        buttonYears = (Button) timeLayout.findViewById(R.id.buttonTimeYears);
        buttonsYearsOut = (Button) timeLayout.findViewById(R.id.buttonTimeYearsOut);

        textTimeInput = (EditText) timeLayout.findViewById(R.id.timeInput);
        textTimeUnit = (TextView) timeLayout.findViewById(R.id.timeInputUnit1);
        textTimeOut = (TextView) timeLayout.findViewById(R.id.timeOutput);

        buttonSeconds.setOnClickListener(this);
        buttonSecondsOut.setOnClickListener(this);
        buttonMinutes.setOnClickListener(this);
        buttonMinutesOut.setOnClickListener(this);
        buttonHours.setOnClickListener(this);
        buttonHoursOut.setOnClickListener(this);
        buttonDays.setOnClickListener(this);
        buttonDaysOut.setOnClickListener(this);
        buttonWeeks.setOnClickListener(this);
        buttonWeeksOut.setOnClickListener(this);
        buttonMonths.setOnClickListener(this);
        buttonMonthsOut.setOnClickListener(this);
        buttonYears.setOnClickListener(this);
        buttonsYearsOut.setOnClickListener(this);

        Context context = getContext();


       return timeLayout;
    }

    void decimalFormat(double input,String unit) {
        df = new java.text.DecimalFormat("#.#####");

        if (String.format("%s", df.format(input)).length() > 12)  {
            df = new java.text.DecimalFormat("0.#####E0");
        }



    }


    public void onClick(View v) {
        if (textTimeInput.getText().toString().length() != 0)
            inputNo = Double.parseDouble(textTimeInput.getText().toString());
        else
            inputNo = 0;
        hideSoftKeyboard();


        switch (v.getId()) {
            case R.id.buttonTimeSeconds:
                textTimeUnit.setText("sec");
                timeConversion();
                outputCheck();
                break;
            case R.id.buttonTimeMinutes:
                textTimeUnit.setText("min");
                timeConversion();
                outputCheck();
                break;
            case R.id.buttonTimeHours:
                textTimeUnit.setText("hour");
                timeConversion();
                outputCheck();
                break;
            case R.id.buttonTimeDays:
                textTimeUnit.setText("day");
                timeConversion();
                outputCheck();
                break;
            case R.id.buttonTimeWeeks:
                textTimeUnit.setText("week");
                timeConversion();
                outputCheck();
                break;
            case R.id.buttonTimeMonths:
                textTimeUnit.setText("month");
                timeConversion();
                outputCheck();
                break;
            case R.id.buttonTimeYears:
                textTimeUnit.setText("year");
                timeConversion();
                outputCheck();
                break;

            case R.id.buttonTimeSecondsOut:
                timeConversion();
                toSeconds();
                break;
            case R.id.buttonTimeMinutesOut:
                timeConversion();
                toMinutes();
                break;
            case R.id.buttonTimeHoursOut:
                timeConversion();
                toHours();
                break;
            case R.id.buttonTimeDaysOut:
                timeConversion();
                toDays();
                break;
            case R.id.buttonTimeWeeksOut:
                timeConversion();
                toWeeks();
                break;
            case R.id.buttonTimeMonthsOut:
                timeConversion();
                toMonths();
                break;
            case R.id.buttonTimeYearsOut:
                timeConversion();
                toYears();
                break;
        }
    }

    //converting to seconds
    void timeConversion() {
        if (textTimeInput.getText().toString().length() != 0) {
            if (textTimeUnit.getText().toString().equalsIgnoreCase("min"))
                inputNo = inputNo * 60;
            else if (textTimeUnit.getText().toString().equalsIgnoreCase("hour") )
                inputNo = inputNo * 3600;
            else if (textTimeUnit.getText().toString().equalsIgnoreCase("day"))
                inputNo = inputNo * 86400;
            else if (textTimeUnit.getText().toString().equalsIgnoreCase("week"))
                inputNo = inputNo * 604800;
            else if (textTimeUnit.getText().toString().equalsIgnoreCase("month"))
                inputNo = inputNo * 2629800;
            else if (textTimeUnit.getText().toString().equalsIgnoreCase("year"))
                inputNo = inputNo * 31557600;
        }
    }
    //Checking the LengthOutput unit, for instant conversion from input buttons
    void outputCheck() {
        if (textTimeOut.getText().toString().endsWith("seconds") | textTimeOut.getText().toString().endsWith("seconds"))
            toSeconds();
        else if (textTimeOut.getText().toString().endsWith("minutes") | textTimeOut.getText().toString().endsWith("minute"))
            toMinutes();
        else if (textTimeOut.getText().toString().endsWith("hours") | textTimeOut.getText().toString().endsWith("hour"))
            toHours();
        else if (textTimeOut.getText().toString().endsWith("days") | textTimeOut.getText().toString().endsWith("day"))
            toDays();
        else if (textTimeOut.getText().toString().endsWith("weeks") | textTimeOut.getText().toString().endsWith("week"))
            toWeeks();
        else if (textTimeOut.getText().toString().endsWith("months") | textTimeOut.getText().toString().endsWith("month"))
            toMonths();
        else if (textTimeOut.getText().toString().endsWith("years") | textTimeOut.getText().toString().endsWith("year"))
            toYears();
    }

    void toSeconds() {

        if (inputNo == 1)
           unit  = " second";
        else
            unit = " seconds";
        decimalFormat(inputNo, unit);
        textTimeOut.setText(String.format("%s", df.format(inputNo) + unit));
    }

    void toMinutes() {
        inp = inputNo/60;
        if (inp == 1)
            unit  = " minute";
        else
            unit = " minutes";
        decimalFormat(inp, unit);
        textTimeOut.setText(String.format("%s", df.format(inp) + unit));
    }


    void toHours() {
       inp = inputNo/3600;
        if (inp == 1)
            unit  = " hour";
        else
            unit = " hours";
        decimalFormat(inp, unit);
        textTimeOut.setText(String.format("%s", df.format(inp) + unit));
    }



    void toDays() {
        inp = inputNo/86400;
        if (inp == 1)
            unit  = " day";
        else
            unit = " days";
        decimalFormat(inp, unit);
        textTimeOut.setText(String.format("%s", df.format(inp) + unit));
    }


    void toWeeks() {
        inp = inputNo/604800;
        if (inp == 1)
            unit  = " week";
        else
            unit = " weeks";
        decimalFormat(inp, unit);
        textTimeOut.setText(String.format("%s", df.format(inp) + unit));
    }


    void toMonths() {
        inp = inputNo/2629800;
        if (inp == 1)
            unit  = " month";
        else
            unit = " months";
        decimalFormat(inp, unit);
        textTimeOut.setText(String.format("%s", df.format(inp) + unit));
    }



    void toYears() {
        inp = inputNo/31557600;
        if (inp == 1)
            unit  = " year";
        else
            unit = " years";
        decimalFormat(inp, unit);
        textTimeOut.setText(String.format("%s", df.format(inp) + unit));
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
