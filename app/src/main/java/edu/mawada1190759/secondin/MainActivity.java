package edu.mawada1190759.secondin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtAuth;
    private EditText txtPage;
    private Button btnAdd;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Books book ;
    private static final String DATA = "DATA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
        setUpShared();

    }

    private void setUpShared() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setUp() {
        txtName = findViewById(R.id.txtName);
        txtAuth = findViewById(R.id.txtAuth);
        txtPage = findViewById(R.id.txtPage);
        btnAdd = findViewById(R.id.btnAdd);

    }

    public void btnAddOnClick(View view) {

        book = new Books(txtName.getText().toString(),
              txtAuth.getText().toString(), txtPage.getText().toString());

    }

    public void btnSaveOnClick(View view) {


        String booksString = book.toString();

        editor.putString(DATA, booksString);
        editor.commit();

    }
}