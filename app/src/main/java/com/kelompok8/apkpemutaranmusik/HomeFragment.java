package com.kelompok8.apkpemutaranmusik;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Rect;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Playlist> featuredPlaylist = new ArrayList<>();
    private List<Playlist> recentlyPlayed = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Inisialisasi data contoh
        initFeaturedPlaylist();
        initRecentlyPlayed();

        // Inisialisasi RecyclerView dan Adapter untuk Playlist Unggulan
        RecyclerView recyclerViewFeaturedPlaylist = rootView.findViewById(R.id.recyclerViewFeaturedPlaylist);
        PlaylistAdapter featuredPlaylistAdapter = new PlaylistAdapter(featuredPlaylist);
        recyclerViewFeaturedPlaylist.setAdapter(featuredPlaylistAdapter);

        // Set LayoutManager sebagai GridLayoutManager dengan 2 kolom
        recyclerViewFeaturedPlaylist.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        // Tambahkan ItemDecoration untuk memberikan jarak antar item
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        recyclerViewFeaturedPlaylist.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true));

        // Inisialisasi RecyclerView dan Adapter untuk Baru Dimainkan
        RecyclerView recyclerViewRecentlyPlayed = rootView.findViewById(R.id.recyclerViewRecentlyPlayed);
        PlaylistAdapter recentlyPlayedAdapter = new PlaylistAdapter(recentlyPlayed);
        recyclerViewRecentlyPlayed.setAdapter(recentlyPlayedAdapter);
        recyclerViewRecentlyPlayed.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return rootView;
    }
    private static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private final int spanCount;
        private final int spacing;
        private final boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

    private void initFeaturedPlaylist() {
        // Isi dengan data Playlist Unggulan contoh
        featuredPlaylist.add(new Playlist("Playlist 1", R.drawable.chill));
        featuredPlaylist.add(new Playlist("Playlist 2", R.drawable.fokus));
        featuredPlaylist.add(new Playlist("Playlist 3", R.drawable.instrumental));
    }

    private void initRecentlyPlayed() {
        // Isi dengan data Baru Dimainkan contoh
        recentlyPlayed.add(new Playlist("Song 1", R.drawable.anime));
        recentlyPlayed.add(new Playlist("Song 2", R.drawable.hiphop));
        recentlyPlayed.add(new Playlist("Song 3", R.drawable.tidur));
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}
