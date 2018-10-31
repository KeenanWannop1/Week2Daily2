package com.example.admin.week2daily2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.week2daily2.model.Person;
import com.example.admin.week2daily2.model.ReadWriteFile;

public class MainActivity extends Activity {
    EditText textmsg;
    TextView textView;
    private EditText etPersonName;
    private EditText etPersonAge;
    private PersonDatabase personDatabase;
    private ListView lvPerson;
    private ArrayAdapter<String> personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
    }

    private void bindViews() {
        textmsg = findViewById(R.id.editText1);

    }


    public void onSQLiteDatabase(View view) {

        String personName = etPersonName.getText().toString();
        String personAge = etPersonAge.getText().toString();
        Person person = new Person(personName, personAge);

        switch (view.getId()) {

            case R.id.btnSavePerson:
                long rowId = personDatabase.savePerson(person);
                Toast.makeText(this, String.valueOf(rowId), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnGetAllPerson:
                for (Person person1 : personDatabase.getPeople()) {
                    personAdapter.add(person1.toString());
                }
                break;
        }
    }

    //Write to file
    public void WriteBtnMain(View view) {
        ReadWriteFile file = new ReadWriteFile();
        file.WriteBtn(view, textmsg, getApplicationContext());
    }

    //Read file
    public void ReadBtnMain(View view) {
        ReadWriteFile file = new ReadWriteFile();
        String s = "";
        textView.setText(file.ReadBtn(view, getApplicationContext()));

    }
}
