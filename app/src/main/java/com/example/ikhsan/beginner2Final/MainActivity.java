package com.example.ikhsan.beginner2Final;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ikhsan.beginner2.R;


public class MainActivity extends AppCompatActivity {

    int jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Increment_btn(View v){
        if (jumlah==5){
            Toast.makeText(this, "full",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        jumlah = ++jumlah;
        Update(jumlah);
    }

    public void Decrement_btn(View v){
        if (jumlah==0){
            Toast.makeText(this, "full",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        jumlah = --jumlah;
        Update(jumlah);
    }

    private void Update(int j) {
        TextView tv = findViewById(R.id.jumlah_tv);
        tv.setText(""+ j);
    }

    public void Pesan_btn (View v){
        CheckBox WhippedCream = (CheckBox) findViewById(R.id.WhippedCream_id);
        boolean hasWhippedCream = WhippedCream.isChecked();

        CheckBox Chocolate = (CheckBox) findViewById(R.id.Chocolate_id);
        boolean hasChocholate = Chocolate.isChecked();

        EditText nama = (EditText) findViewById(R.id.Nama_id);
        String n = nama.getText().toString();

        String p = "Halo " + n +
                "\nTambah whipped cream = "+ hasWhippedCream +
                "\nTambah chocolate = "+ hasChocholate +
                "\n$"+ hitungHarga(hasWhippedCream,hasChocholate)+
                "\nTerimakasih";
//        displayMessage(p);
//    INTENT
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pesanan untuk "+ n);
        intent.putExtra(Intent.EXTRA_TEXT, p);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private int hitungHarga(boolean hasWhippedCream, boolean hasChocholate) {
        int harga = 5;
        if(hasWhippedCream){
            harga = harga + 1;
        }
        if (hasChocholate){
            harga = harga + 2;
        }
        return jumlah * harga;
    }

    private void displayMessage(String p) {
        TextView tv = findViewById(R.id.harga_tv);
        tv.setText(p);
    }

}
