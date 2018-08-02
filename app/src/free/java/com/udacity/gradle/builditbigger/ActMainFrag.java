package com.udacity.gradle.builditbigger;
import android.view.View;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import com.google.android.gms.ads.AdView;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdRequest;



/**
 * Created on july 2018
 */

public class ActMainFrag extends Fragment {

    public ActMainFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.lotfragmain, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
