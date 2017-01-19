package com.letsplay.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsplay.R;
import com.letsplay.adapters.SongAdapter;
import com.letsplay.models.Song;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by girish on 12/1/17.
 */

public class ChordFragment extends Fragment {

    @BindView(R.id.rv_song_list)
    RecyclerView mRVSongList;

    private Unbinder mUnBinder;

    private SongAdapter mSongAdapter;
    private List<Song> songs = new ArrayList<Song>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chrod_fragment, null);

        mUnBinder = ButterKnife.bind(this, view);

        initView();

        prepareSongData();
        return view;
    }

    private void initView() {

        mSongAdapter = new SongAdapter(songs, getActivity());
        RecyclerView.LayoutManager layourManager =
                new LinearLayoutManager(getActivity().getApplicationContext());

        mRVSongList.setLayoutManager(layourManager);
        DividerItemDecoration divderItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        mRVSongList.addItemDecoration(divderItemDecoration);
        mRVSongList.setAdapter(mSongAdapter);
    }

    private void prepareSongData() {

        Song song1 = new Song("Ae dil hai...", "Sonu Nigam", "2016");
        Song song2 = new Song("Sun le pukar...", "Sonu Nigam", "2015");
        Song song3 = new Song("tu hi hai...", "Sonu Nigam", "2014");
        Song song4 = new Song("Hansi ban gye...", "Arjit Sing", "2016");
        Song song5 = new Song("Be fikre...", "Arjit Sing", "2017");
        Song song6 = new Song("Baby ko base...", "Mikka sing", "2015");
        Song song7 = new Song("Jag ghumeya...", "Arjit singh", "2014");
        Song song8 = new Song("O karam khudaya...", "Arjit Sing", "2016");
        Song song9 = new Song("EK baat khun...", "Arjit Singh", "2016");
        Song song10 = new Song("Rab kre tujhko...", "Sonu Nigam", "2006");

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        songs.add(song10);

        mSongAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Set views to null:
        mUnBinder.unbind();
    }
}
