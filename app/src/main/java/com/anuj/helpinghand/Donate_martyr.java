package com.anuj.helpinghand;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Donate_martyr extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    ImageView slidingimage;
    public int index=0;
    public String hint;
    ArrayList<String> slid= new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_martyr);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        slid.add("http://free.wallpaperbackgrounds.com/military/fallen%20soldier/124523-33877.jpg");
        slid.add("http://wallpapercave.com/wp/wc1712559.jpg");
        slid.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2013/12/army-wallpaper-6-610x381.jpg");

        SharedPreferences ij = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        hint = ij.getString("hint", "");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {

            final Handler mHandler = new Handler();

            final Runnable mUpdateResults = new Runnable() {
                public void run() {

                    AnimateandSlideShow();

                }
            };

            int delay = 2000; // delay

            int period = 2000; // repeat

            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                    mHandler.post(mUpdateResults);

                }

            }, delay, period);
            Glide.with(this).load(R.drawable.background).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void AnimateandSlideShow() {


        slidingimage = (ImageView) findViewById(R.id.backdrop);
        Glide.with(getApplicationContext()).load(slid.get(index)).into(slidingimage);
        index++;

        if (index == 3) {
            index = 0;
        }
        Animation rotateimage = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        slidingimage.startAnimation(rotateimage);
    }
    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.ic_menu_camera
        };
        if (hint.equals("hand")) {
            Album a = new Album("Const \n" + "Sandeep Kumar ", 13,covers[0],hint );
            albumList.add(a);
            a = new Album("Const Sanjay Dhar ", 8, covers[0],hint);
            albumList.add(a);
            a = new Album(" Const \n" +
                    "Surinder Kumar ", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("ASI Rudal Yadav ", 12, covers[0],hint);
            albumList.add(a);
            a = new Album("HC Subedar Yadav ", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("Const \n" + "Mudassir Nazir ", 1, covers[0],hint);
            albumList.add(a);
            a = new Album("Vishwas Kumar", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC Adil Abbas ", 14, covers[0],hint);
            albumList.add(a);
            a = new Album(" Const \n" + "Rajesh Yadav ", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("Shri Ram Gawaria", 17, covers[0],hint);
            albumList.add(a);
        }
        else if (hint.equals("bara")){
            Album a = new Album("ASI SHOORBIR SINGH", 13,covers[0],hint);
            albumList.add(a);
            a = new Album("HC Vishwas Kumar", 8, covers[0],hint);
            albumList.add(a);
            a = new Album("HC UDAYENDU HALDER", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("COMDT SH J R KHASWAN", 12, covers[0],hint);
            albumList.add(a);
            a = new Album("CT PRASUN KUMAR MISHRA", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("SI SH RAJESH SHARAN", 1, covers[0],hint);
            albumList.add(a);
            a = new Album("HC  HARI PRASAD", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC KOICHUNG ATHAND AIMOL", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("Const Sanjay Dhar", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("INSPR ASHOK KUMAR YADAV", 17, covers[0],hint);
            albumList.add(a);

        }
        else if (hint.equals("uri")){
            Album a = new Album("HC SANT RAM", 13,covers[0],hint );
            albumList.add(a);
            a = new Album("CT CHHATU KUMAR SINGH", 8, covers[0],hint);
            albumList.add(a);
            a = new Album("CT PALA RAM LAMBA", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("CT DERE PRAVIN PRATAP", 12, covers[0],hint);
            albumList.add(a);
            a = new Album("HC VIJAY KUMAR", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("CT HIRA SINGH", 1, covers[0],hint);
            albumList.add(a);
            a = new Album("HC NARESH KUMAR", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC KUBER GOUDA", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("CT/DVR SATYENDRA SHARMA ", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC H T KANTA RAJ", 17, covers[0],hint);
            albumList.add(a);
        }
        else if (hint.equals("pam")){
            Album a = new Album("CT JAI KISHAN", 13,covers[0],hint );
            albumList.add(a);
            a = new Album("HC SURESH KUMAR", 8, covers[0],hint);
            albumList.add(a);
            a = new Album("HC KOICHUNG ATHAND AIMOL", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC UDAYENDU HALDER", 12, covers[0],hint);
            albumList.add(a);
            a = new Album("SI RAM CHANDER SINGH", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("HC SARTAJ SINGH", 1, covers[0],hint);
            albumList.add(a);
            a = new Album("COMDT SH J R KHASWAN", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("SI SH RAJESH SHARAN", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("INSPR ASHOK KUMAR YADAV", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("ASI JITENDER KUMAR", 17, covers[0],hint);
            albumList.add(a);
        }
        else if (hint.equals("path")){
            Album a = new Album("HC SUMER SINGH", 13,covers[0],hint );
            albumList.add(a);
            a = new Album("HC K C SWAIN", 8, covers[0],hint);
            albumList.add(a);
            a = new Album("CT RAM BAHAL", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC RAM CHANDER SINGH", 12, covers[0],hint);
            albumList.add(a);
            a = new Album("CT AMANDEEP SINGH", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("HC DEEPAK KUMAR", 1, covers[0],hint);
            albumList.add(a);
            a = new Album("CT PRASUN KUMAR MISHRA", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("CT CHANDAN RAI", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("HC XAVIER KINDO", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC ASHOK KUMAR", 17, covers[0],hint);
            albumList.add(a);
        }
        else {
            Album a = new Album("ASI SHOORBIR SINGH", 13,covers[0],hint );
            albumList.add(a);
            a = new Album("HC SULTAN ALI ", 8, covers[0],hint);
            albumList.add(a);
            a = new Album("INSPR K HARI PRASAD", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("CT BAJRANGI", 12, covers[0],hint);
            albumList.add(a);
            a = new Album("CT ARUP DAS", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("HC PRAMOD KUMAR SINGH", 1, covers[0],hint);
            albumList.add(a);
            a = new Album("CT BHEEMA SHANKAR", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("CT ANUP RAKSHIT", 14, covers[0],hint);
            albumList.add(a);
            a = new Album("HC  HARI PRASAD", 11, covers[0],hint);
            albumList.add(a);
            a = new Album("HC Subedar Yadav ", 17, covers[0],hint);
            albumList.add(a);
        }
        adapter.notifyDataSetChanged();
    }
    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
