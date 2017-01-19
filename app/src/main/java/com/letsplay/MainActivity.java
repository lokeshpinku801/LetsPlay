package com.letsplay;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.letsplay.fragments.ChordFragment;
import com.letsplay.fragments.NearByInstituteFragment;
import com.letsplay.utils.EnumFragments;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;

    private Handler mHandler = new Handler();


     // Whether or not we're showing the back of the card (otherwise showing the front).
        private boolean mShowingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        if (savedInstanceState == null) {
            // If there is no saved instance state, add a fragment representing
            // the front of the card to this activity. If there is saved instance
            // state, this fragment will have already been added to the activity.
            getFragmentManager().beginTransaction()
                    .add(R.id.layout_container, new ChordFragment()).commit();
        } else {
            mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);
        }
        getFragmentManager().addOnBackStackChangedListener(MainActivity.this);
    }


    @OnClick(R.id.iv_next)
    public void gotoNextFragement(){
        flipCard();
    }

    public void setFragment(EnumFragments enumFragments){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = null;

        switch (enumFragments){
            case CHORDS_FRAGMENT:
                 fragment = new ChordFragment();
                break;
            case NEARBYINSTITUTE_FRAGMENT:
                fragment = new NearByInstituteFragment();
                fragmentTransaction.setCustomAnimations(R.animator.card_flip_right_in,
                    R.animator.card_flip_right_out,
                    R.animator.card_flip_left_in,
                    R.animator.card_flip_left_out) ;
                break;

        }
        if(fragment!=null){
            fragmentTransaction.replace(R.id.layout_container,fragment);
            if(enumFragments==EnumFragments.NEARBYINSTITUTE_FRAGMENT)
                fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }


    private void flipCard() {
        if (mShowingBack) {
            getFragmentManager().popBackStack();
            return;
        }
        mShowingBack = true;
        setFragment(EnumFragments.NEARBYINSTITUTE_FRAGMENT);
    }

    @Override
    public void onBackStackChanged() {

        mShowingBack = (getFragmentManager().getBackStackEntryCount()>0);

    }
}
