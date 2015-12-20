package com.adacdc.mobile.alertondatausage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentUtils.commitFragment(getFragmentManager(), getFragmentContainer(), new FragMain());


    }


    private int getFragmentContainer() {
        return R.id.fragment_frame_container;
    }


}
