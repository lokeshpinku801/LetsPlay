package com.letsplay;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.letsplay.adapters.SongDetailPagerAdapter;
import com.letsplay.fragments.SongDetailFragment;
import com.letsplay.models.PageInfo;
import com.letsplay.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongDetailActivity extends AppCompatActivity {


    @BindView(R.id.view_pager_song_detail)
    ViewPager mVPSongDetail;

    List<PageInfo> pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        Fragment fragment = null;
        Bundle bundle = null;

        pages = new ArrayList<PageInfo>();
        for(int i=0;i<5; i++)
        {
             fragment = new SongDetailFragment();
             bundle = new Bundle();
            bundle.putString(Constants.SONG_DETAIL_INFO,"Song "+i);
            bundle.putString(Constants.SONG_DETAIL_TAB, "TAB "+i);
            bundle.putString(Constants.SONG_DETAIL_CHORD,"CHORD "+i);
            fragment.setArguments(bundle);
            pages.add(new PageInfo(fragment.getClass(),"",bundle));
        }


        mVPSongDetail.setAdapter(new SongDetailPagerAdapter(this,getSupportFragmentManager(),mVPSongDetail,pages));
    }
}
