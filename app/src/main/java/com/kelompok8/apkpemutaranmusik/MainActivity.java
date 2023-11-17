package com.kelompok8.apkpemutaranmusik;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kelompok8.apkpemutaranmusik.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Map<Integer, Fragment> fragmentMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inisialisasi peta fragment
        fragmentMap.put(R.id.home, new HomeFragment());
        fragmentMap.put(R.id.account, new AccountFragment());
        fragmentMap.put(R.id.list, new listFragment());

        // Set fragment awal
        replaceFragment(fragmentMap.get(R.id.home));

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            // Ganti fragment menggunakan peta fragment
            replaceFragment(fragmentMap.get(itemId));

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        // Cek apakah fragment yang sedang aktif adalah fragment home
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.frame_layout);
        if (currentFragment instanceof HomeFragment) {
            // Jika ya, panggil setupRecyclerView
            setupRecyclerView();
        }

        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Pindahkan setupRecyclerView ke sini untuk memastikan bahwa recyclerView tidak null
        // Tidak perlu memanggil setupRecyclerView di sini karena sudah dipanggil di replaceFragment
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Coldplay", "band legendaris dengan melodi epik dan lirik yang mendalam. Musik mereka menjadi pengantar sempurna untuk perasaan dan momen berharga. \uD83C\uDF0C\uD83C\uDFB5 #Coldplay #EpicSoundscapes\"",R.drawable.coldplay));
        items.add(new Item("Queen B, Beyoncé", "penguasa panggung dengan vokal yang luar biasa dan pesona yang tak tertandingi. \uD83D\uDC51\uD83C\uDFA4 #Beyonce #SlayQueen",R.drawable.beyonce));
        items.add(new Item("Ed Sheeran", "si penyanyi penulis lagu multi-talenta yang menghadirkan melodi yang menghanyutkan dan lirik yang menyentuh hati. \uD83C\uDFB8\uD83D\uDCDD #EdSheeran #MusikPenuhEmosi",R.drawable.edsheeran));
        items.add(new Item("Khalid", "penyanyi dengan suara yang hangat dan lagu-lagu yang menggambarkan perjalanan hidup. Musiknya menjadi teman setia di setiap momen. \uD83C\uDF05\uD83C\uDFB6 #Khalid #SoulfulVibes",R.drawable.khalid));
        items.add(new Item("Katy Perry ", "ratu pop dengan lagu-lagu penuh keceriaan dan kekuatan. Musiknya membawa semangat positif dan kegembiraan. \uD83C\uDF38\uD83C\uDFA4 #KatyPerry #PopPrism",R.drawable.katy));
        items.add(new Item("Billie Ellish", "inovator musik muda dengan gaya yang unik dan suara yang memberikan warna baru dalam industri musik. \uD83C\uDF08\uD83C\uDFA4 #BillieEilish #FutureOfMusic",R.drawable.elish));
        items.add(new Item("Rihanna", "ikon mode dan musik yang selalu berani mengeksplorasi. Dengan gaya yang khas, beliau adalah inspirasi bagi jutaan penggemar di seluruh dunia. \uD83D\uDC83\uD83C\uDFB6 #Rihanna #FashionIcon",R.drawable.rihanna));
        items.add(new Item("Ariana Grande", "sang diva dengan suara luar biasa dan gaya musik yang selalu menghipnotis pendengarnya. \uD83C\uDF08\uD83C\uDFB5 #ArianaGrande #PopPrincess",R.drawable.ariana));
        items.add(new Item("Bruno Mars", "penyanyi dan penulis lagu serbabisa dengan energi panggung yang mengguncang. Setiap penampilannya adalah pesta yang tak terlupakan. \uD83D\uDD7A\uD83C\uDFB6 #BrunoMars #FunkMaster",R.drawable.bruno));
        items.add(new Item("Drake", "rapper dan penyanyi papan atas yang memadukan rap dan R&B dengan gaya uniknya. Hit-nya selalu menjadi soundtrack kehidupan kita. \uD83C\uDFA4\uD83D\uDD25 #Drake #HotlineBling",R.drawable.drake));
        items.add(new Item("Shawn Mandes", "penyanyi muda berbakat dengan suara yang lembut dan lagu-lagu yang mengena. Musiknya seperti pelukan hangat. \uD83C\uDF1F\uD83C\uDFB8 #ShawnMendes #TenderMelodies",R.drawable.shawnmandes));
        items.add(new Item("Justin Bieber", "ari bocah penyanyi remaja menjadi megabintang global. Musiknya tetap menjadi pusat perhatian dengan vibe yang selalu fresh. \uD83C\uDF1F\uD83C\uDFA4 #JustinBieber #Belieber",R.drawable.justin));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }
}

