package com.letsplay.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsplay.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by girish on 13/1/17.
 */

public class NearByInstituteFragment  extends Fragment{


    private Unbinder mUnBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.near_by_institute_fragment,container,false);

        mUnBinder =ButterKnife.bind(this,view);

        return  view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Set views to null:
        mUnBinder.unbind();
    }
}
