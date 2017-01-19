package com.letsplay.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.letsplay.models.PageInfo;

import java.util.List;

/**
 * Created by girish on 17/1/17.
 */

public class SongDetailPagerAdapter extends FragmentPagerAdapter{


    private  Context context;
    private  List<PageInfo> pages;
    private  ViewPager pager;
    private  FragmentManager fragmentManager;


    public SongDetailPagerAdapter( Context context,  FragmentManager fragmentManager,  ViewPager pager, List<PageInfo> pages) {
        super(fragmentManager);
        this.context=context;
        this.fragmentManager=fragmentManager;
        this.pager=pager;
        this.pages=pages;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public Fragment getItem(int position) {
        if( position >= 0 && position < pages.size() ) {
            PageInfo page = pages.get( position );
            Fragment item = Fragment.instantiate(context, page.pageClass, page.arguments);
            return item;
        } else {
            return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
        if( !pages.contains( (Fragment) object) ) {
            return POSITION_NONE;
        } else {
            return POSITION_UNCHANGED;
        }
    }


    @Override
    public long getItemId(int position) {
        return pages.get( position ).id;

    }

}
