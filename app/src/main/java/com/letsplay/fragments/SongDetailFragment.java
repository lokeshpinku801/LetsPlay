package com.letsplay.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.letsplay.R;
import com.letsplay.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by girish on 17/1/17.
 */

public class SongDetailFragment extends Fragment {

    @BindView(R.id.tv_info)
    TextView mTVInfo;

    @BindView(R.id.button1)
    Button mBtnTab;

    @BindView(R.id.button2)
    Button mBtnChord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_song_detail,container,false);

        ButterKnife.bind(this,view);
        initData();
        return view;
    }
    private void initData() {

        Bundle bundle = getArguments();
        String info = bundle.getString(Constants.SONG_DETAIL_INFO);
        String tab = bundle.getString(Constants.SONG_DETAIL_TAB);
        String chord = bundle.getString(Constants.SONG_DETAIL_CHORD);

        mTVInfo.setText(info);
        mBtnTab.setText(tab);
        mBtnChord.setText(chord);

    }
}
