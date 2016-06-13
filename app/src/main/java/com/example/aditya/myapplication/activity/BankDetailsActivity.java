package com.example.aditya.myapplication.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aditya.myapplication.R;

public class BankDetailsActivity extends AppCompatActivity
{
    private TextView bankNameText, accountNumberText, accountTypeText, codeIFSCText;
    private EditText bankNameEdit, accountNumberEdit, accountTypeEdit, codeIFSCEdit;
    private Button fab;
    private Toolbar toolbar;
    private ImageView bank_back;
    //private Drawable upArrow;

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha, null);
        else upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        upArrow.setColorFilter(getResources().getColor(R.color.textColorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        fab = (Button) findViewById(R.id.fab);
        bank_back = (ImageView) findViewById(R.id.bank_back);
        bankNameText = (TextView) findViewById(R.id.bankNameText);
        accountNumberText = (TextView) findViewById(R.id.accountNumberText);
        accountTypeText = (TextView) findViewById(R.id.accountTypeText);
        codeIFSCText = (TextView) findViewById(R.id.codeIFSCText);
        bankNameEdit = (EditText) findViewById(R.id.bankNameEdit);
        accountNumberEdit = (EditText) findViewById(R.id.accountNumberEdit);
        accountTypeEdit = (EditText) findViewById(R.id.accountTypeEdit);
        codeIFSCEdit = (EditText) findViewById(R.id.codeIFSCEdit);

        bank_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(BankDetailsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(bankNameText.getVisibility() == View.GONE)
                {
                    bankNameText.setVisibility(View.VISIBLE);
                    bankNameEdit.setVisibility(View.GONE);
                    bankNameText.setText(bankNameEdit.getText().toString());

                    accountNumberText.setVisibility(View.VISIBLE);
                    accountNumberEdit.setVisibility(View.GONE);
                    accountNumberText.setText(accountNumberEdit.getText().toString());

                    accountTypeText.setVisibility(View.VISIBLE);
                    accountTypeEdit.setVisibility(View.GONE);
                    accountTypeText.setText(accountTypeEdit.getText().toString());

                    codeIFSCText.setVisibility(View.VISIBLE);
                    codeIFSCEdit.setVisibility(View.GONE);
                    codeIFSCText.setText(codeIFSCEdit.getText().toString());

                    fab.setVisibility(View.GONE);
                    flag = 0;
                    invalidateOptionsMenu();

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bank, menu);

        /*if(flag == 1)
            menu.getItem(0).setVisible(false);

        else if(flag == 0)
            menu.getItem(0).setVisible(true);*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id==android.R.id.home)
        {
            Intent i = new Intent(BankDetailsActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        else if(id==R.id.action_edit)
        {
            bankNameText.setVisibility(View.GONE);
            bankNameEdit.setVisibility(View.VISIBLE);
            bankNameEdit.setText(bankNameText.getText().toString());

            accountNumberText.setVisibility(View.GONE);
            accountNumberEdit.setVisibility(View.VISIBLE);
            accountNumberEdit.setText(accountNumberText.getText().toString());

            accountTypeText.setVisibility(View.GONE);
            accountTypeEdit.setVisibility(View.VISIBLE);
            accountTypeEdit.setText(accountTypeText.getText().toString());

            codeIFSCText.setVisibility(View.GONE);
            codeIFSCEdit.setVisibility(View.VISIBLE);
            codeIFSCEdit.setText(codeIFSCText.getText().toString());

            fab.setVisibility(View.VISIBLE);
            flag = 1;
            invalidateOptionsMenu();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(BankDetailsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
