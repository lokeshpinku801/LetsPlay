package com.letsplay.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by girish on 17/1/17.
 */

public class PageInfo {

    public final String pageClass;
    public final String title;
    public final Bundle arguments;
    public final long id;

    public PageInfo( Class<? extends Fragment> clss,  String title,  Bundle arguments )
    {
        this.pageClass = clss.getName();
        this.title = title;
        this.arguments = arguments;

        // create a unique id for FragmentManager
        this.id = pageClass.hashCode() ^ title.hashCode() ^ arguments.hashCode();
    }




}
