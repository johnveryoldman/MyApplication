package com.geektech.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IMainFragmentListener {

    static final int DETAILS_ACTIVITY = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_container, new MainFragment(), MainFragment.TAG);
        transaction.commit();
    }

    @Override
    public void openDetails(String s) {
        Intent openDetails = new Intent(this, DetailsActivity.class);
        openDetails.putExtra(DetailsActivity.INFO_KEY, s);
        startActivityForResult(openDetails, DETAILS_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DETAILS_ACTIVITY && resultCode == RESULT_OK) {
            String s = data.getStringExtra(DetailsActivity.RESULT_KEY);
            textToFragment(s);
        }
    }

    private void textToFragment(String s) {
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);
        mainFragment.addNewText(s);
    }
}
