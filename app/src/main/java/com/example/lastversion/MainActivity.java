package com.example.lastversion;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lastversion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 12.05.2020 Buradaki setContentView metodunu neden degistirdim?
        //neden baseFragment içinde değil burada sorusuyla paralel buraya taşıdık ondan setContet i güncelledik buraya taşımamızın sebebi
        //fragmentler çoğaldıkça ve özelleştikçe kod kalabalığı olmadan
        //ben bunu FragmentBase içinde yapmaya çalışıyordum activity_main içindeki include erişmek için binding e burada bağlandı
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.toolbarLayout.toolbarBackBtn.setOnClickListener(v -> onBackPressed());
        //setActionBar(binding.toolbar); neden kullanılmadı

        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG);

    }

    public void addFragment(Fragment fragment, String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }

    public void replaceFragment(Fragment fragment, String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment, fragmentTag)
                .addToBackStack("BACK_STACK_ROOT_TAG")
                .commitAllowingStateLoss();
    }

}
