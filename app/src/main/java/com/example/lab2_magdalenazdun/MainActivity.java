package com.example.lab2_magdalenazdun;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
public class MainActivity extends FragmentActivity{

    private int[] frames;
    private boolean hiden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            frames = new int[]{R.id.frame1, R.id.frame2, R.id.frame3, R.id.frame4};
            hiden = false;
            Fragment[] fragments = new Fragment[]{new Fragment1(), new Fragment2(), new Fragment3(), new Fragment4()};
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            for (int i = 0; i < 4; i++) {
                transaction.add(frames[i], fragments[i]);
            }
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            frames = savedInstanceState.getIntArray("FRAMES");
            hiden = savedInstanceState.getBoolean("HIDEN");
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("FRAMES", frames);
        outState.putBoolean("HIDEN", hiden);
    }