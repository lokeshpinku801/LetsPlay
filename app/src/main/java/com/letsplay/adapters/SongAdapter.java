package com.letsplay.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsplay.R;
import com.letsplay.models.Song;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by girish on 12/1/17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{

    private List<Song> songList = new ArrayList<Song>();
    private Context mContext;

public SongAdapter(List<Song> songList, Context mContext){
    this.songList = songList;
    this.mContext= mContext;

}

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_row,parent,false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.mTVSongName.setText(song.getSongName());
        holder.mTVComposerName.setText(song.getComposer());
        holder.mTVReleaseYear.setText(song.getReleaseYear());

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_song_name)
        TextView mTVSongName;

        @BindView(R.id.tv_composer_name)
        TextView mTVComposerName;

        @BindView(R.id.tv_release_year)
        TextView mTVReleaseYear;

        @BindView(R.id.iv_album_poster)
        ImageView mIVSongPoster;

        public SongViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
