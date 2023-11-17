package com.kelompok8.apkpemutaranmusik;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);

        // Mengatur tindakan untuk item yang diklik di NavigationView
        DrawerLayout drawerLayout = rootView.findViewById(R.id.drawerLayout);
        NavigationView navigationView = rootView.findViewById(R.id.navigationView);

        ImageView burgerIcon = rootView.findViewById(R.id.burgerIcon);
        burgerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.menu_settings) {
                // Tindakan yang ingin Anda lakukan saat Settings diklik
                // Misalnya, buka layar pengaturan
                drawerLayout.closeDrawer(GravityCompat.START); // Menutup drawer setelah item diklik
                return true;
            } else if (itemId == R.id.menu_help) {
                // Tindakan yang ingin Anda lakukan saat Help diklik
                // Misalnya, buka layar bantuan
                // Tidak perlu menutup drawer di sini
                return true;
            }

            return false;
        });

        // Mengaktifkan ikon burger untuk membuka dan menutup drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(requireActivity(), drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Inisialisasi fragment dan set fragment awal setelah inisialisasi NavigationView
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        ((MainActivity)requireActivity()).setSupportActionBar(toolbar);

        return rootView;
    }
}
