package com.adacdc.mobile.alertondatausage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by aliH on 12/20/15.
 */
public class FragmentUtils {
    public static void commitFragment(FragmentManager fragmentManager, int ContainerViewID, Fragment destinationFragment) {


        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack if needed
        transaction.replace(ContainerViewID, destinationFragment);


        // Commit the transaction
        transaction.commit();

    }
}
