package com.apptreak.convertx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.RoundingMode;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class Area extends Fragment implements View.OnClickListener {
    private Button btnCmSqr, btnMSqr, btnMmSqr, btnKmSqr, btnCmSqrOp, btnMSqrop, btnMmSqrOp, btnKmSqrOp, btnAcre, btnAcreOp, btnMicrometerSqrOp, btnMicrometerSqr, btnSqrFt, btnSqrFtOp, btnSqrInch, btnSqrInchOp;
    TextView areaInputUnit, areaOutput, areaOutputUnit;
    EditText txtAreaInput;
    RelativeLayout areaLayout;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#.#########");
    double areaInputNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        areaLayout = (RelativeLayout) inflater.inflate(R.layout.area_layout, container, false);

        btnCmSqr = (Button) areaLayout.findViewById(R.id.btnCmSqr);
        btnCmSqrOp = (Button) areaLayout.findViewById(R.id.btnCmOpSqr);
        btnMSqr = (Button) areaLayout.findViewById(R.id.btnMSqr);
        btnMSqrop = (Button) areaLayout.findViewById(R.id.btnMOpSqr);
        btnMmSqr = (Button) areaLayout.findViewById(R.id.btnMmSqr);
        btnMmSqrOp = (Button) areaLayout.findViewById(R.id.btnMmOpSqr);
        btnKmSqr = (Button) areaLayout.findViewById(R.id.btnKmSqr);
        btnKmSqrOp = (Button) areaLayout.findViewById(R.id.btnKmOpSqr);
        btnMicrometerSqr = (Button) areaLayout.findViewById(R.id.btnMicrometerSqr);
        btnMicrometerSqrOp = (Button) areaLayout.findViewById(R.id.btnMicrometerOpSqr);
        btnAcre = (Button) areaLayout.findViewById(R.id.btnAcre);
        btnAcreOp = (Button) areaLayout.findViewById(R.id.btnAcreOp);
        btnSqrFt = (Button) areaLayout.findViewById(R.id.btnFootSqr);
        btnSqrFtOp = (Button) areaLayout.findViewById(R.id.btnFootOpSqr);
        btnSqrInch = (Button) areaLayout.findViewById(R.id.btnInchSqr);
        btnSqrInchOp = (Button) areaLayout.findViewById(R.id.btnInchOpSqr);


        areaInputUnit = (TextView) areaLayout.findViewById(R.id.inputUnitArea);
        areaOutput = (TextView) areaLayout.findViewById(R.id.txtOpArea);
        areaOutputUnit = (TextView) areaLayout.findViewById(R.id.areaOutputUnit);
        txtAreaInput = (EditText) areaLayout.findViewById(R.id.txtInputArea);


        btnCmSqr.setOnClickListener(this);
        btnCmSqrOp.setOnClickListener(this);
        btnMSqr.setOnClickListener(this);
        btnMSqrop.setOnClickListener(this);
        btnKmSqr.setOnClickListener(this);
        btnKmSqrOp.setOnClickListener(this);
        btnMmSqr.setOnClickListener(this);
        btnMmSqrOp.setOnClickListener(this);
        btnMicrometerSqr.setOnClickListener(this);
        btnMicrometerSqrOp.setOnClickListener(this);
        btnAcre.setOnClickListener(this);
        btnAcreOp.setOnClickListener(this);
        btnSqrFt.setOnClickListener(this);
        btnSqrFtOp.setOnClickListener(this);
        btnSqrInch.setOnClickListener(this);
        btnSqrInchOp.setOnClickListener(this);


        return areaLayout;
    }

    @Override
    public void onClick(View v) {
        df.setRoundingMode(RoundingMode.CEILING);
        if (txtAreaInput.getText().toString().length() != 0) {
            areaInputNo = Double.parseDouble(txtAreaInput.getText().toString());
        } else {
            areaInputNo = 0;
        }
        hideSoftKeyboard();
        switch (v.getId()) {
            case R.id.btnCmSqr:
                areaInputUnit.setText(R.string.btn_cm_sqr);
                checkOp();
                break;
            case R.id.btnMSqr:
                areaInputUnit.setText(R.string.btn_m_sqr);
                checkOp();
                break;
            case R.id.btnKmSqr:
                areaInputUnit.setText(R.string.btn_km_sqr);
                checkOp();
                break;
            case R.id.btnMmSqr:
                areaInputUnit.setText(R.string.btn_mm_sqr);
                checkOp();
                break;
            case R.id.btnCmOpSqr:
                convertToCmSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" cm<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" cm<sup><small>2</small></sup>"));
                }
                break;
            case R.id.btnMmOpSqr:
                convertToMmSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" mm<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" mm<sup><small>2</small></sup>"));
                }
                break;
            case R.id.btnKmOpSqr:
                convertToKmSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" km<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" km<sup><small>2</small></sup>"));
                }
                break;
            case R.id.btnMOpSqr:
                convertToMSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" m<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" m<sup><small>2</small></sup>"));
                }
                break;
            case R.id.btnMicrometerSqr:
                areaInputUnit.setText(R.string.btn_μm_sqr);
                checkOp();
                break;
            case R.id.btnAcre:
                areaInputUnit.setText(R.string.btn_acre);
                checkOp();
                break;
            case R.id.btnFootSqr:
                areaInputUnit.setText(R.string.btn_ft_sqr);
                checkOp();
                break;
            case R.id.btnInchSqr:
                areaInputUnit.setText(R.string.btn_inch_sqr);
                checkOp();
                break;
            case R.id.btnMicrometerOpSqr:
                convertToMicroSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" μm<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" μm<sup><small>2</small></sup>"));
                }
                break;
            case R.id.btnAcreOp:
                convertToAcre();
                areaOutputUnit.setText(R.string.btn_acre);
                break;
            case R.id.btnFootOpSqr:
                convertToFootSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" ft<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" ft<sup><small>2</small></sup>"));
                }
                break;
            case R.id.btnInchOpSqr:
                convertToInchSqr();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    areaOutputUnit.setText(Html.fromHtml(" in<sup><small>2</small></sup>", 0));
                } else {
                    areaOutputUnit.setText(Html.fromHtml(" in<sup><small>2</small></sup>"));
                }
                break;
        }
    }


    void hideSoftKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void checkOp() {
        if (areaOutputUnit.getText().toString().contains("mm")) {
            convertToMmSqr();
        } else if (areaOutputUnit.getText().toString().contains(" m")) {
            convertToMSqr();
        } else if (areaOutputUnit.getText().toString().contains("cm")) {
            convertToCmSqr();
        } else if (areaOutputUnit.getText().toString().contains("km")) {
            convertToKmSqr();
        } else if (areaOutputUnit.getText().toString().contains("μm")) {
            convertToMicroSqr();
        } else if (areaOutputUnit.getText().toString().endsWith("acre")) {
            convertToAcre();
        } else if (areaOutputUnit.getText().toString().contains("ft")) {
            convertToFootSqr();
        } else if (areaOutputUnit.getText().toString().contains("in")) {
            convertToInchSqr();
        }
    }


    private void convertToInchSqr() {
        if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.15500031)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0015500031)));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1550003100)));
        } else if (areaInputUnit.getText().toString().contains("μm")) {

            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 645160000)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 6272640)));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 144)));
        } else if (areaInputUnit.getText().toString().contains(" m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1550.0031)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo)));
        }

    }

    private void convertToFootSqr() {
        if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.001076391)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0000107639)));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 10763910.417)));
        } else if (areaInputUnit.getText().toString().contains("μm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 92903040000L)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 43560)));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0069444444)));
        } else if (areaInputUnit.getText().toString().contains("m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 10.763910417)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo)));
        }
    }

    private void convertToAcre() {
        if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 40468564.224)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 4046856422.4)));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 247.10538147)));
        } else if (areaInputUnit.getText().toString().contains("μm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 4046856422400000L)));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0000229568)));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0000229568)));
        } else if (areaInputUnit.getText().toString().contains(" m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0002471054)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo) + " acre"));
        }
    }


    private void convertToMicroSqr() {
        if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 100000000)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1000000)));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1000000000000000000L)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 4046856422400000L)));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 92903040000L)));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 645160000)));
        } else if (areaInputUnit.getText().toString().contains(" m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1000000000000L)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo)));
        }
    }

    private void convertToCmSqr() {
        if (areaInputUnit.getText().toString().contains("μm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 100000000)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.01)));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 10000000000L)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 40468564.224)));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 929.0304)));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 6.4516)));
        } else if (areaInputUnit.getText().toString().contains(" m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 10000)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo)));
        }
    }

    private void convertToMSqr() {
        if (areaInputUnit.getText().toString().contains("μm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 1000000000000L)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.000001)));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1000000)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 4046.8564224) ));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.09290304)));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.00064516)));
        } else if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.0001) ));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo) ));
        }
    }

    private void convertToMmSqr() {
        if (areaInputUnit.getText().toString().contains("μm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 0.000001) ));
        } else if (areaInputUnit.getText().toString().contains(" m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1000000) ));
        } else if (areaInputUnit.getText().toString().contains("km")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 1000000000000L)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 4046856422.4) ));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 92903.04) ));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 645.16)));
        } else if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo * 100)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo) ));
        }
    }

    private void convertToKmSqr() {
        if (areaInputUnit.getText().toString().contains("μm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 1000000000000000000L) ));
        } else if (areaInputUnit.getText().toString().contains(" m")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 1000000L)));
        } else if (areaInputUnit.getText().toString().contains("mm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 1000000000000L)));
        } else if (areaInputUnit.getText().toString().equalsIgnoreCase("acre")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 247.10538147) ));
        } else if (areaInputUnit.getText().toString().contains("ft")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 10763910.417)));
        } else if (areaInputUnit.getText().toString().contains("in")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 1550003100)));
        } else if (areaInputUnit.getText().toString().contains("cm")) {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo / 10000000000L)));
        } else {
            areaOutput.setText(String.format("%s ", df.format(areaInputNo)));
        }
    }
}
