package com.geektech.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements IDetailsFragmentListener {

    static final String INFO_KEY = "info_key";
    static final String RESULT_KEY = "result_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent info = getIntent();
        DetailsFragment detailsFragment;
        if (info != null) {
            String s = info.getStringExtra(INFO_KEY);
            detailsFragment = DetailsFragment.newInstance(s);
        } else {
            detailsFragment = DetailsFragment.newInstance(null);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.details_container, detailsFragment);
        transaction.commit();
    }

    @Override
    public void onNewText(String s) {
        Intent result = new Intent();
        result.putExtra(RESULT_KEY, s);
        setResult(RESULT_OK, result);
        finish();
    }
}
