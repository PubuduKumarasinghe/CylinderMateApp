package com.example.user.cylindermate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerform extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button registerUser;
    EditText uName;
    EditText uAddress;
    EditText uCity;
    EditText uPhone;
    Spinner uType;

    String name;
    String address;
    String city;
    String phone;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerform);
        Intent intent = getIntent();
        Spinner spinner = (Spinner) findViewById(R.id.typeSpinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        registerUser = (Button)findViewById(R.id.btnReg);
        uName   = (EditText)findViewById(R.id.enterName);
        uAddress   = (EditText)findViewById(R.id.enterAddress);
        uPhone   = (EditText)findViewById(R.id.enterPhone);
        uType   = (Spinner) findViewById(R.id.typeSpinner);
        uCity = (EditText)findViewById(R.id.enterCity);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        type = spinnerLabel;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void registerUser(View view) {
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = uName.getText().toString();
                address = uAddress.getText().toString();
                phone = uPhone.getText().toString();
                city = uCity.getText().toString();

                Log.v("Name",name);
                Log.v("Ad",address);
                Log.v("phon",phone);
                Log.v("typ",type);
                Log.v("cit",city);

                Customer customer = new Customer(name,address,city,phone,type);

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("customer");
                myRef.child(name).setValue(customer);
                Toast.makeText(registerform.this,"Registered",Toast.LENGTH_LONG).show();
            }
        });
    }
}

