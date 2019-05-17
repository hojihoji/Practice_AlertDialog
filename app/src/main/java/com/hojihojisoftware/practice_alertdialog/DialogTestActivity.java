//参考URL:https://android.keicode.com/basics/ui-alertdialog.php

package com.hojihojisoftware.practice_alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogTestActivity extends AppCompatActivity {

    final String TAG = "Dialog Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //シンプルなAlertDialog
        Button button1 = (Button)findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DialogTestActivity.this).setTitle(TAG)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(DialogTestActivity.this,"Yes",Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

        //アイコン付きAlertDialog
        Button button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DialogTestActivity.this).setTitle("Oops! An error occurred.")
                        .setMessage("Want you try again").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogTestActivity.this,"Yes",Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogTestActivity.this,"No",Toast.LENGTH_LONG).show();
                    }
                }).setIcon(R.drawable.error).show();
            }
        });


        //複数選択、単一選択の入力項目を持つ AlertDialog
        final CharSequence[] items = {"Hyundai","Samsung","LG"};
        final boolean[] itemChecked = new boolean[items.length];

        Button button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DialogTestActivity.this).setTitle(TAG).setIcon(R.drawable.nuclear)
                        .setMultiChoiceItems(items, itemChecked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(DialogTestActivity.this,items[which],Toast.LENGTH_LONG).show();
                            }
                        }).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });

        LayoutInflater inflater = LayoutInflater.from(DialogTestActivity.this);
        final View VIEW = inflater.inflate(R.layout.alert_dialog5,null);
        final EditText editText1 = (EditText)findViewById(R.id.etText1);

        Button button4 = (Button)findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DialogTestActivity.this).setTitle(TAG)
                        .setIcon(R.drawable.nuclear).setView(VIEW).setPositiveButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { Toast.makeText(DialogTestActivity.this,editText1.getText().toString(),Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                }).show();
            }
        });


    }
}
