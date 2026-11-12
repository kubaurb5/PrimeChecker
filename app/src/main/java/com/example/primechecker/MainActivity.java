package com.example.primechecker;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PrimeCheckerLog";

    private EditText etNumber;
    private Button btnCalculate;
    private TextView tvResult;
    private ImageView ivMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumber = findViewById(R.id.editTextNumber);
        btnCalculate = findViewById(R.id.buttonCalculate);
        tvResult = findViewById(R.id.textViewResult);
        ivMath = findViewById(R.id.imageViewMath);

        Log.d(TAG, "Aktywność główna została uruchomiona.");

        btnCalculate.setOnClickListener(v -> {
            Log.i(TAG, "Kliknięto przycisk sprawdzania liczby.");
            checkPrimeNumber();
        });
    }

    private void checkPrimeNumber() {
        String inputStr = etNumber.getText().toString().strip();

        if (inputStr.isEmpty()) {
            String msg = "Wprowadź liczbę!";
            tvResult.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            Log.w(TAG, "Próba zatwierdzenia pustego pola.");
            return;
        }

        try {
            int number = Integer.parseInt(inputStr);
            Log.d(TAG, "Pobrano liczbę do analizy: " + number);

            boolean isPrime = FinalPrimeValidator.check(number);
            PrimeNote note;

            if (number <= 1) {
                note = PrimeNote.NIE_JEST_PIERWSZA;
            } else if (isPrime) {
                note = PrimeNote.PIERWSZA;
            } else {
                note = PrimeNote.ZLOZONA;
            }

            PrimeResult3 resultObj = new PrimeResult3(number, note);
            tvResult.setText(resultObj.toString());

            Toast.makeText(this, "Sprawdzono pomyślnie!", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Wynik dla liczby " + number + ": " + note.name());

        } catch (NumberFormatException e) {
            String msg = "Wprowadź poprawną liczbę całkowitą!";
            tvResult.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            Log.e(TAG, "Błąd konwersji liczby: " + e.getMessage());
        }
    }
}