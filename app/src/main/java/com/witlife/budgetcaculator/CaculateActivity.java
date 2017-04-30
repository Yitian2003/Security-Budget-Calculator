package com.witlife.budgetcaculator;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.text.NumberFormat;

public class CaculateActivity extends AppCompatActivity {

    EditText editIPC1;
    EditText editIPC2;
    EditText editIPC3;
    EditText editIPC4;
    EditText editPort4;
    EditText editPort8;
    EditText editPort16;
    EditText editPort32;
    EditText editHdd2;
    EditText editHdd3;
    EditText editHdd4;
    EditText editHdd6;
    EditText editSwitch;
    EditText editBracket;
    EditText editAccessaries;
    TextView tvFreight;
    TextView tvTotal;
    Switch switchGST;
    CheckBox ipc1Checkbox;
    CheckBox ipc2Checkbox;
    CheckBox ipc3Checkbox;
    CheckBox ipc4Checkbox;
    CheckBox tb2Checkbox;
    CheckBox tb3Checkbox;
    CheckBox tb4Checkbox;
    CheckBox tb6Checkbox;
    CheckBox port4Checkbox;
    CheckBox port8Checkbox;
    CheckBox port16Checkbox;
    CheckBox port32Checkbox;
    MenuItem btnSend;

    int ipc1, ipc2, ipc3, ipc4;
    int tb2, tb3, tb4, tb6;
    int port4, port8, port16,port32;
    int switchs;
    int bracket;
    double freight;
    double accessaries;
    double total;
    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculate);

        inputMethodManager =  (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        initView();
        initActionBar();
        calculate();
        setChangeListener();
    }

    private void initView(){

        editIPC1 = (EditText) findViewById(R.id.editIPC1);
        editIPC2 = (EditText) findViewById(R.id.editIPC2);
        editIPC3 = (EditText) findViewById(R.id.editIPC3);
        editIPC4 = (EditText) findViewById(R.id.editIPC4);
        editHdd2 = (EditText) findViewById(R.id.editHdd2);
        editHdd3 = (EditText) findViewById(R.id.editHdd3);
        editHdd4 = (EditText) findViewById(R.id.editHdd4);
        editHdd6 = (EditText) findViewById(R.id.editHdd6);
        editPort4 = (EditText) findViewById(R.id.editPort4);
        editPort8 = (EditText) findViewById(R.id.editPort8);
        editPort16 = (EditText) findViewById(R.id.editPort16);
        editPort32 = (EditText) findViewById(R.id.editPort32);
        editSwitch = (EditText) findViewById(R.id.editSwitch);
        editBracket = (EditText) findViewById(R.id.editBracket);
        editAccessaries = (EditText) findViewById(R.id.editAccessaries);
        tvFreight = (TextView) findViewById(R.id.tvFreight);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        switchGST = (Switch) findViewById(R.id.switchGST);
        ipc1Checkbox = (CheckBox) findViewById(R.id.ipc1Checkbox);
        ipc2Checkbox = (CheckBox) findViewById(R.id.ipc2Checkbox);
        ipc3Checkbox = (CheckBox) findViewById(R.id.ipc3Checkbox);
        ipc4Checkbox = (CheckBox) findViewById(R.id.ipc4Checkbox);
        tb2Checkbox = (CheckBox) findViewById(R.id.tb2Checkbox);
        tb3Checkbox = (CheckBox) findViewById(R.id.tb3Checkbox);
        tb4Checkbox = (CheckBox) findViewById(R.id.tb4Checkbox);
        tb6Checkbox = (CheckBox) findViewById(R.id.tb6Checkbox);
        port4Checkbox = (CheckBox) findViewById(R.id.port4Checkbox);
        port8Checkbox = (CheckBox) findViewById(R.id.port8Checkbox);
        port16Checkbox = (CheckBox) findViewById(R.id.port16Checkbox);
        port32Checkbox = (CheckBox) findViewById(R.id.port32Checkbox);

        editIPC1.setEnabled(false);
        editIPC2.setEnabled(false);
        editIPC3.setEnabled(false);
        editIPC4.setEnabled(false);
        editHdd2.setEnabled(false);
        editHdd3.setEnabled(false);
        editHdd4.setEnabled(false);
        editHdd6.setEnabled(false);
        editPort4.setEnabled(false);
        editPort8.setEnabled(false);
        editPort16.setEnabled(false);
        editPort32.setEnabled(false);
    }

    private void calculate() {

        ipc1 = TextUtils.isEmpty(editIPC1.getText().toString()) ? 0 : Integer.parseInt(editIPC1.getText().toString());
        ipc2 = TextUtils.isEmpty(editIPC2.getText().toString()) ? 0 : Integer.parseInt(editIPC2.getText().toString());
        ipc3 = TextUtils.isEmpty(editIPC3.getText().toString()) ? 0 : Integer.parseInt(editIPC3.getText().toString());
        ipc4 = TextUtils.isEmpty(editIPC4.getText().toString()) ? 0 : Integer.parseInt(editIPC4.getText().toString());
        tb2 = TextUtils.isEmpty(editHdd2.getText().toString()) ? 0 : Integer.parseInt(editHdd2.getText().toString());
        tb3 = TextUtils.isEmpty(editHdd3.getText().toString()) ? 0 : Integer.parseInt(editHdd3.getText().toString());
        tb4 = TextUtils.isEmpty(editHdd4.getText().toString()) ? 0 : Integer.parseInt(editHdd4.getText().toString());
        tb6 = TextUtils.isEmpty(editHdd6.getText().toString()) ? 0 : Integer.parseInt(editHdd6.getText().toString());
        port4 = TextUtils.isEmpty(editPort4.getText().toString()) ? 0 : Integer.parseInt(editPort4.getText().toString());
        port8 = TextUtils.isEmpty(editPort8.getText().toString()) ? 0 : Integer.parseInt(editPort8.getText().toString());
        port16 = TextUtils.isEmpty(editPort16.getText().toString()) ? 0 : Integer.parseInt(editPort16.getText().toString());
        port32 = TextUtils.isEmpty(editPort32.getText().toString()) ? 0 : Integer.parseInt(editPort32.getText().toString());
        switchs = TextUtils.isEmpty(editSwitch.getText().toString()) ? 0 : Integer.parseInt(editSwitch.getText().toString());
        bracket = TextUtils.isEmpty(editBracket.getText().toString()) ? 0 : Integer.parseInt(editBracket.getText().toString());
        accessaries = TextUtils.isEmpty(editAccessaries.getText().toString()) ? 0.00 : Double.parseDouble(editAccessaries.getText().toString());
        freight = ((port4 + port8 + port16 + port32) * 2 + ipc1 + ipc2 + ipc3 + ipc4) * getResources().getInteger(R.integer.freight_unit_price);

        total = ipc1 * getResources().getInteger(R.integer.ipc1_price) +
                ipc2 * getResources().getInteger(R.integer.ipc2_price) +
                ipc3 * getResources().getInteger(R.integer.ipc3_price) +
                ipc4 * getResources().getInteger(R.integer.ipc4_price) +
                port4 * getResources().getInteger(R.integer.port4_price) +
                port8 * getResources().getInteger(R.integer.port8_price) +
                port16 * getResources().getInteger(R.integer.port16_price) +
                port32 * getResources().getInteger(R.integer.port32_price) +
                tb2 * getResources().getInteger(R.integer.tb2_price) / 100 +
                tb3 * getResources().getInteger(R.integer.tb3_price) / 100 +
                tb4 * getResources().getInteger(R.integer.tb4_price) / 100 +
                tb6 * getResources().getInteger(R.integer.tb6_price) / 100 +
                switchs * getResources().getInteger(R.integer.switch_price) +
                bracket * getResources().getInteger(R.integer.bracket_price) +
                freight + accessaries ;

        if (switchGST.isChecked()) {
            total = 1.15 * total;
        }

        NumberFormat format = NumberFormat.getCurrencyInstance();

        tvFreight.setText(format.format(freight));
        tvTotal.setText(format.format(total));
    }

    private void initActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.cctv_system);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_send, menu);
        btnSend = menu.findItem(R.id.action_send);
        btnSend.setEnabled(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_send:
                sendEmail();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sendEmail(){
        String[] TO = {"hhhhhhh@gmail.com"};
        String[] CC = {""};
        String emailBody = createEmailBody();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "CCTV Budget");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
        //emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //startActivity(emailIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(CaculateActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private String createEmailBody() {
        StringBuilder builder = new StringBuilder();
        NumberFormat format = NumberFormat.getCurrencyInstance();

        if (ipc1 != 0) {
            builder.append("DS-2CD3T36WD-I8  " + ipc1 + "\n");
        }
        if (ipc2 != 0) {
            builder.append("DS-2CD3336WD-I    " + ipc1 + "\n");
        }
        if (ipc3 != 0) {
            builder.append("DS-2CD3345F-I     " + ipc1 + "\n");
        }
        if (ipc4 != 0) {
            builder.append("DS-2CD3345-I      " + ipc1 + "\n");
        }
        if (port4 != 0) {
            builder.append("4 Channel NVR     " + port4 + "\n");
        }
        if (port8 != 0) {
            builder.append("8 Channel NVR     " + port8 + "\n");
        }
        if (port16 != 0) {
            builder.append("16 Channel NVR    " + port16 + "\n");
        }
        if (port32 != 0) {
            builder.append("32 Channel NVR    " + port32 + "\n");
        }
        if (tb2 != 0) {
            builder.append("2 TB HDD          " + tb2 + "\n");
        }
        if (tb3 != 0) {
            builder.append("3 TB HDD          " + tb3 + "\n");
        }
        if (tb4 != 0) {
            builder.append("4 TB HDD          " + tb4 + "\n");
        }
        if (tb6 != 0) {
            builder.append("6 TB HDD          " + tb6 + "\n");
        }
        if (switchs != 0) {
            builder.append("Switch(es)        " + switchs + "\n");
        }
        if ( freight!= 0.0) {
            builder.append("Freight Fee       " + format.format(freight) + "\n");
        }
        if (bracket != 0) {
            builder.append("Mount Bracket     " + bracket + "\n");
        }
        if (accessaries != 0) {
            builder.append("Cable and Accessaries  $" + accessaries + "\n");
        }
        if (total !=0.0) {
            if (switchGST.isChecked()) {
                builder.append("Total       " + format.format(total) + " inc GST");
            } else {
                builder.append("Total       " + format.format(total) + " exc GST");
            }
        }
        return builder.toString();
    }

    private void setChangeListener(){

        editIPC1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editIPC2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editIPC3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editIPC4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editPort4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editPort8.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editPort16.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editPort32.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editHdd2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editHdd3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editHdd4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editHdd6.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editSwitch.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editBracket.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        editAccessaries.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
                btnSend.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        ipc1Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ipc1Checkbox.isChecked()) {
                    editIPC1.setEnabled(true);
                    editIPC1.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editIPC1.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editIPC1.setEnabled(false);
                    editIPC1.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        ipc2Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ipc2Checkbox.isChecked()) {
                    editIPC2.setEnabled(true);
                    editIPC2.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editIPC2.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editIPC2.setEnabled(false);
                    editIPC2.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        ipc3Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ipc3Checkbox.isChecked()) {
                    editIPC3.setEnabled(true);
                    editIPC3.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editIPC3.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editIPC3.setEnabled(false);
                    editIPC3.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        ipc4Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ipc4Checkbox.isChecked()) {
                    editIPC4.setEnabled(true);
                    editIPC4.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editIPC4.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editIPC4.setEnabled(false);
                    editIPC4.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        port4Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (port4Checkbox.isChecked()) {
                    editPort4.setEnabled(true);
                    editPort4.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editPort4.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                    //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                } else {
                    editPort4.setEnabled(false);
                    editPort4.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        port8Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (port8Checkbox.isChecked()) {
                    editPort8.setEnabled(true);
                    editPort8.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editPort8.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editPort8.setEnabled(false);
                    editPort8.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        port16Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (port16Checkbox.isChecked()) {
                    editPort16.setEnabled(true);
                    editPort16.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editPort16.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editPort16.setEnabled(false);
                    editPort16.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        port32Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (port32Checkbox.isChecked()) {
                    editPort32.setEnabled(true);
                    editPort32.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editPort32.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editPort32.setEnabled(false);
                    editPort32.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        tb2Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb2Checkbox.isChecked()) {
                    editHdd2.setEnabled(true);
                    editHdd2.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editHdd2.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editHdd2.setEnabled(false);
                    editHdd2.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        tb3Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb3Checkbox.isChecked()) {
                    editHdd3.setEnabled(true);
                    editHdd3.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editHdd3.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editHdd3.setEnabled(false);
                    editHdd3.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        tb4Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb4Checkbox.isChecked()) {
                    editHdd4.setEnabled(true);
                    editHdd4.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editHdd4.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editHdd4.setEnabled(false);
                    editHdd4.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        tb6Checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb6Checkbox.isChecked()) {
                    editHdd6.setEnabled(true);
                    editHdd6.requestFocus();
                    inputMethodManager.toggleSoftInputFromWindow(editHdd6.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                } else {
                    editHdd6.setEnabled(false);
                    editHdd6.setText("");
                }
                calculate();
                btnSend.setEnabled(true);
            }
        });

        switchGST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                btnSend.setEnabled(true);
            }
        });
    }
}
