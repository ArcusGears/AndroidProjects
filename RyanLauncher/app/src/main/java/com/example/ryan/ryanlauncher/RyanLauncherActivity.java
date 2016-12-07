package com.example.ryan.ryanlauncher;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RyanLauncherActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return RyanLauncherFragment.newInstance();
    }
}