package com.example.ryan.criminalintent;


import android.support.v4.app.Fragment;

/**
 * Created by Ryan on 9/8/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
