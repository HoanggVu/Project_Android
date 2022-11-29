package com.example.doantest.Activity;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doantest.Activity.Menu.MenuAdapter;
import com.example.doantest.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import com.example.doantest.Activity.Card.Card;
import com.example.doantest.Activity.Card.SlideCard;
import com.example.doantest.Activity.Card.SlideCardAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    Toolbar toolbar;
    RecyclerView rcvSlide, rcvMenu;
    SlideCardAdapter slideCardAdapter;
    MenuAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa ID
        getID();
        //set view
        setActionViewFlipper();
        //set slide
        setSlide();
        //set menu
        setMenu();
        //set nav menu
        setNav();
        //set toolbar
        setToolbar();

    }


    private void setToolbar() {
        setSupportActionBar(toolbar);

        //set logo
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);

        //set button menu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable= getResources().getDrawable(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    private void setNav() {
        //list menu
        //navigationView.bringToFront();
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_dra_open, R.string.nav_dra_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/
        navigationView.setNavigationItemSelectedListener(this);

        Menu menu = navigationView.getMenu();

        navigationView.setCheckedItem(R.id.nav_home);
    }

    private void setMenu() {
        getID();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcvMenu.setLayoutManager(gridLayoutManager);
        menuAdapter.setData(getListMenu(), new MenuAdapter.IClickAddToCart() {
            @Override
            public void OnClickAddToCart(ImageView imgAddToCart, com.example.doantest.Activity.Menu.Menu menu) {

                Toast.makeText(MainActivity.this, "Đã Thêm Vào Giỏ Hàng", Toast.LENGTH_SHORT).show();
            }
        });
        rcvMenu.setAdapter(menuAdapter);
    }

    private List<com.example.doantest.Activity.Menu.Menu> getListMenu() {
        List<com.example.doantest.Activity.Menu.Menu> listMenu = new ArrayList<>();

        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview1, "Trà Sữa Trân Trâu", "30.000 VND"));
        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview2, "Trà Sửa Matcha", "35.000 VND"));
        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview3, "Nước Cam", "49.000 VND"));

        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview4, "Trà Sửa Thái Xanh", "30.000 VND"));
        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview5, "Trà Sửa Socola", "30.000 VND"));
        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview6, "Trà Sửa Khoai Môn", "30.000 VND"));

        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview7, "Trà Đào", "25.000 VND"));
        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview8, "Trà Sửa Việt Quất", "30.000 VND"));
        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview9, "Trà Sửa Truyền Thống", "25.000 VND"));

        listMenu.add(new com.example.doantest.Activity.Menu.Menu(R.drawable.cardview10, "Nước Chanh", "20.000 VND"));
        return listMenu;
    }

    private void setSlide() {
        getID();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvSlide.setLayoutManager(linearLayoutManager);

        slideCardAdapter.setData(getListSlideCard());
        rcvSlide.setAdapter(slideCardAdapter);
    }

    private List<SlideCard> getListSlideCard() {
        List<SlideCard> listSildeCard = new ArrayList<>();

        List<Card> listCard = new ArrayList<>();
        listCard.add(new Card(R.drawable.cardview2, "Trà Sửa Matcha", "35000 VND"));
        listCard.add(new Card(R.drawable.cardview3, "Nước Cam", "49000 VND"));
        listCard.add(new Card(R.drawable.cardview4, "Trà Sửa Thái Xanh", "30000 VND"));
        listCard.add(new Card(R.drawable.cardview6, "Trà Sửa Khoai Môn", "30000 VND"));
        listCard.add(new Card(R.drawable.cardview8, "Trà Sửa Việt Quất", "30000 VND"));


        listSildeCard.add(new SlideCard("Hot", listCard));

        return listSildeCard;
    }


    private void setActionViewFlipper() {
        List<String> listview = new ArrayList<>();
        listview.add("https://thuthuatnhanh.com/wp-content/uploads/2021/11/background-tra-sua-thiet-ke-banner-poster-quang-cao.jpg");
        listview.add("https://thuthuatnhanh.com/wp-content/uploads/2021/11/background-tra-sua-3d.jpg");
        listview.add("https://thuthuatnhanh.com/wp-content/uploads/2021/11/background-tra-sua-da-mat-lanh-giai-nhiet-mua-he.jpg");
        for (int i = 0; i < listview.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(listview.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }

    private void getID() {
        viewFlipper = findViewById(R.id.viewflipper);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.my_toolbar);
        navigationView = findViewById(R.id.nav_menu_view);
        rcvSlide = findViewById(R.id.rcv_slide);
        rcvMenu = findViewById(R.id.rcv_menu);
        slideCardAdapter = new SlideCardAdapter(this);
        menuAdapter = new MenuAdapter(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.lienhe:
                Intent intentFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/HoangVu0506"));
                startActivity(intentFacebook);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_order:
                Intent intent = getIntent();
                Bundle bundleOrder = intent.getExtras();
                if (bundleOrder != null){
                    int idLoginOrder = bundleOrder.getInt("ID_LOGIN");
                    Intent intentOrder = new Intent(MainActivity.this, Order.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID_LOGIN_ORDER", idLoginOrder);
                    intentOrder.putExtras(bundle);
                    startActivity(intentOrder);
                }
                break;
            case R.id.nav_fb:
                Intent intentFeedBack = new Intent(Intent.ACTION_SENDTO);
                String feedback = "mailto: " + Uri.encode("vu050620@gmail.com") + "?subject=" + Uri.encode("FeedBack: Gửi Ảnh Và Góp Ý") + Uri.encode("");
                Uri uri = Uri.parse(feedback);
                intentFeedBack.setData(uri);
                startActivity(intentFeedBack);
                break;
            case R.id.nav_profile:
                Intent intent1 = getIntent();
                Bundle bundleProfile = intent1.getExtras();
                if (bundleProfile != null) {
                    int idLoginProfile = bundleProfile.getInt("ID_LOGIN");
                    Intent intentProfile = new Intent(MainActivity.this, Profile.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID_LOGIN_PROFILE", idLoginProfile);
                    intentProfile.putExtras(bundle);
                    startActivity(intentProfile);
                }
                break;
            case R.id.nav_Logout:
                Intent intentLogin = new Intent(MainActivity.this, Login.class);
                startActivity(intentLogin);
                break;
        }
        return true;
    }
}