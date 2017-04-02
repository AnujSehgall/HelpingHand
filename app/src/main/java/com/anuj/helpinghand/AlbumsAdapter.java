package com.anuj.helpinghand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;
    public int hint;
    public String phint;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
//            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sldier_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        phint=album.getHint();

       loadpics(holder,position,phint);


        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position){

                    case 0 : hint =0;
                        break;
                    case 1: hint=1;
                        break;
                    case 2: hint=2;
                        break;
                    case 3: hint=3;
                        break;
                    case 4: hint=4;
                        break;
                    case 5: hint=5;
                        break;
                    case 6: hint=6;
                        break;
                    case 7: hint=7;
                        break;
                    case 8: hint=8;
                        break;
                    case 9: hint=9;
                        break;
                }
                    SharedPreferences kl = PreferenceManager.getDefaultSharedPreferences(mContext);
                    kl.edit().putInt("pos", hint).apply();
                    Intent i= new Intent(mContext,About_Soldier.class);
                    mContext.startActivity(i);


            }
        });

  /*      holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/
    }

    private void loadpics(MyViewHolder holder, int position, String phint) {

        if (phint.equals("hand")){

            switch (position){

                case 0: Glide.with(mContext).load("http://www.india.com/wp-content/uploads/2016/01/Martyr-6-Sepoy-Jagdish-Chand.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("http://media2.intoday.in/dailyo//story/embed/201601/saif2mbed_010416021542.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("http://timesofindia.indiatimes.com/thumb/msid-55169932,width-400,resizemode-4/55169932.jpg").into(holder.thumbnail);
                    break;
                case 3: Glide.with(mContext).load("http://im.rediff.com/news/2013/jan/25sli1.jpg").into(holder.thumbnail);
                    break;
                case 4: Glide.with(mContext).load("http://i.dailymail.co.uk/i/pix/2013/10/17/article-2463622-18C98DB700000578-464_306x423.jpg").into(holder.thumbnail);
                    break;
                case 5: Glide.with(mContext).load("http://groundreport.com/wp-content/uploads/2014/04/army-major.jpg").into(holder.thumbnail);
                    break;
                case 6: Glide.with(mContext).load("http://im.rediff.com/news/2013/jan/25sli4.jpg").into(holder.thumbnail);
                    break;
                case 7:  Glide.with(mContext).load("http://cloudfront.timesnow.tv/media/SUB_KARNAIL_SINGH.jpg").into(holder.thumbnail);
                    break;
                case 8: Glide.with(mContext).load("http://media2.intoday.in/indiatoday/images/stories/kargil-2_650_081914092446.jpg").into(holder.thumbnail);
                    break;
                case 9: Glide.with(mContext).load("http://www.sainionline.com/_/rsrc/1472780994377/sainis-in-army-and-police/Major%20Harminder%20Pal%20Singh%20Saini%20%28SC%29.jpg").into(holder.thumbnail);
                    break;
            }
        }

        else if (phint.equals("bara")){
            switch (position){

                case 0: Glide.with(mContext).load("http://www.udaipurtimes.com/wp-content/uploads/2011/10/br-dr-cp-joshi.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("https://www.dscsc.mil.bd/images/honourboards/709.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("http://topyaps.com/wp-content/uploads/2016/02/Captain-Pawan-Kumar.jpg").into(holder.thumbnail);
                    break;
                case 3: Glide.with(mContext).load("https://cdn-blogs.tribune.com.pk/2011/06/Yaser-640x480.jpg").into(holder.thumbnail);
                    break;
                case 4: Glide.with(mContext).load("https://www.geo.tv/assets/front/tiny_mce/source/Captain%20Martyred_1_1.jpg").into(holder.thumbnail);
                    break;
                case 5: Glide.with(mContext).load("http://media2.intoday.in/dailyo//story/embed/201601/saif4finalmbed_010416021828.jpg").into(holder.thumbnail);
                    break;
                case 6: Glide.with(mContext).load("http://www.deccanherald.com/images/editor_images1/2011/07/21/army.jpg").into(holder.thumbnail);
                    break;
                case 7:  Glide.with(mContext).load("http://static.dnaindia.com/images/cache/1576193.jpg").into(holder.thumbnail);
                    break;
                case 8: Glide.with(mContext).load("http://www.paramvirchakra.com/images/pvc/Rifleman%20Sanjay%20Kumar.jpg").into(holder.thumbnail);
                    break;
                case 9: Glide.with(mContext).load("http://2.bp.blogspot.com/-qosd4RmoIno/Td-URLFy1NI/AAAAAAAAAlw/uNrEO1qromw/s1600/Major-Ramaswamy-Parameswaran_wm.jpg").into(holder.thumbnail);
                    break;
            }
        }

        else if (phint.equals("uri")){
            switch (position){

                case 0: Glide.with(mContext).load("http://www.answershive.com/wp-content/uploads/2016/09/Subedar-Karam-Singh.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("http://www.vifindia.org/siteimage/5.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/6/6a/Havildar_Abdul_Hamid.jpg").into(holder.thumbnail);
                    break;
                case 3: Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/8/8e/Second_Lieutenant_Arun_Khetarpal.jpg").into(holder.thumbnail);
                    break;
                case 4: Glide.with(mContext).load("https://viralknot.com/wp-content/uploads/2013/04/Albert_Ekka.jpg").into(holder.thumbnail);
                    break;
                case 5: Glide.with(mContext).load("http://3.bp.blogspot.com/-k63NB0g_8N8/Tutjy5SBsCI/AAAAAAAAAI8/PIFYL9HtkEU/s1600/image_arun.jpg").into(holder.thumbnail);
                    break;
                case 6: Glide.with(mContext).load("http://im.rediff.com/news/2015/sep/03col-tarapore1.jpg").into(holder.thumbnail);
                    break;
                case 7:  Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/d/d2/Lt_Col_A_B_Tarapore.jpg").into(holder.thumbnail);
                    break;
                case 8: Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/2/2e/Naik_Jadu_Nath_Singh.jpg").into(holder.thumbnail);
                    break;
                case 9: Glide.with(mContext).load("https://1.bp.blogspot.com/__WJBCpKRfIU/Rbcss8IA-gI/AAAAAAAAAEA/Zw6x4vcdT3E/s320/Subedar+Joginder+Singh+(+8+PVC+).jpg").into(holder.thumbnail);
                    break;
            }
        }

        else if (phint.equals("pam")){
            switch (position){

                case 0: Glide.with(mContext).load("http://www.sangbadpratidin.in/wp-content/uploads/2016/08/Manoj_Kumar_Pandey_Portrait.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("http://media.indiatimes.in/media/content/2015/Mar/anuj-nayyar_1427372308.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("http://1.bp.blogspot.com/-5gtxpK_XOoo/VktxpBJR9lI/AAAAAAAAWEM/8kJbYt2EC_0/s1600/11950839_1027780387244223_1980204632_n.jpg").into(holder.thumbnail);
                    break;
                case 3: Glide.with(mContext).load("http://www.newsgram.com/wp-content/uploads/2015/06/548946_490433394344816_847114203_n.jpg").into(holder.thumbnail);
                    break;
                case 4: Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/2/2e/Naik_Jadu_Nath_Singh.jpg").into(holder.thumbnail);
                    break;
                case 5: Glide.with(mContext).load("http://lazydesiauthor.com/wp-content/uploads/2016/07/haneef-Copy.jpg").into(holder.thumbnail);
                    break;
                case 6: Glide.with(mContext).load("http://static.dnaindia.com/images/cache/1576193.jpg").into(holder.thumbnail);
                    break;
                case 7:  Glide.with(mContext).load("https://i.ytimg.com/vi/xiBmCnpbTHM/maxresdefault.jpg").into(holder.thumbnail);
                    break;
                case 8: Glide.with(mContext).load("http://img01.ibnlive.in/ibnlive/uploads/2010/03/army_gen_630.jpg").into(holder.thumbnail);
                    break;
                case 9: Glide.with(mContext).load("http://i.dailymail.co.uk/i/pix/2013/10/17/article-2463622-18C98DB700000578-464_306x423.jpg").into(holder.thumbnail);
                    break;
            }
        }

        else if (phint.equals("path")){
            switch (position){

                case 0: Glide.with(mContext).load("http://www.udaipurtimes.com/wp-content/uploads/2011/12/cp-joshi.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("http://www.udaipurtimes.com/wp-content/uploads/2011/10/br-dr-cp-joshi.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("https://cdn-blogs.tribune.com.pk/2011/06/Yaser-640x480.jpg").into(holder.thumbnail);
                    break;
                case 3: Glide.with(mContext).load("http://i.ndtvimg.com/mt/2012-06/Purohit_295.jpg?ver-20170202.1").into(holder.thumbnail);
                    break;
                case 4: Glide.with(mContext).load("http://indianewengland.com/wp-content/uploads/2016/01/K.V.-Krishna-Rao.jpg").into(holder.thumbnail);
                    break;
                case 5: Glide.with(mContext).load("https://images.assettype.com/swarajya/2016-02/7adf4289-6676-4b16-8cc8-3c7dc7208257/KV-Krishna-Rao.jpg").into(holder.thumbnail);
                    break;
                case 6: Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/en/c/c4/General_A._A._Niazi.jpg").into(holder.thumbnail);
                    break;
                case 7:  Glide.with(mContext).load("http://ndc.gov.bd/ndc/images/news_events/1469966523-65.jpg").into(holder.thumbnail);
                    break;
                case 8: Glide.with(mContext).load("https://images.assettype.com/swarajya/2016-02/7adf4289-6676-4b16-8cc8-3c7dc7208257/KV-Krishna-Rao.jpg").into(holder.thumbnail);
                    break;
                case 9: Glide.with(mContext).load("http://i.ndtvimg.com/i/2016-04/amit-deswal_650x400_61460576737.jpg").into(holder.thumbnail);
                    break;
            }
        }

        else {
            switch (position){

                case 0: Glide.with(mContext).load("http://www.oneindia.com/img/2014/11/28-ptr-balvinder-singh-1.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("https://www.dscsc.mil.bd/images/honourboards/709.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("http://bangaloremirror.indiatimes.com/thumb/msid-51079665,width-300,resizemode-4/IMG-20160221-WA0029.jpg").into(holder.thumbnail);
                    break;
                case 3: Glide.with(mContext).load("http://2.bp.blogspot.com/-4Vr_-GcshiA/T7rMi0zsTUI/AAAAAAAADEM/5DPwTdyZ3o0/s1600/Indian+armyman+martyr+late+Havildar+Abdul+Hamid+who+was+decorated+with+India's+highest+military+award+for+his+bravery+in+1965+war+against+Pakistan+when+he+destroyed+the+famed+Patton+tanks.jpg").into(holder.thumbnail);
                    break;
                case 4: Glide.with(mContext).load("https://viralknot.com/wp-content/uploads/2013/04/Arun_Khetarpal.jpg").into(holder.thumbnail);
                    break;
                case 5: Glide.with(mContext).load("http://1.bp.blogspot.com/_Rnli_m3i0oE/S0smkKlHx7I/AAAAAAAAAGI/_HLMEcN_euY/s320/Vikram-Batra_Indian-Army.jpg").into(holder.thumbnail);
                    break;
                case 6: Glide.with(mContext).load("http://4.bp.blogspot.com/-7-5C-hr1JeE/VWVi2pMAB9I/AAAAAAAAbis/j1n_Hj3eMsQ/s1600/somnath.jpg").into(holder.thumbnail);
                    break;
                case 7:  Glide.with(mContext).load("http://2.bp.blogspot.com/-Yk4YKNH6IYw/Td-MJrrf0dI/AAAAAAAAAks/ZUwn9xrhPdI/s1600/Naik-Jadu-Nath-Singh-pvc.jpg").into(holder.thumbnail);
                    break;
                case 8: Glide.with(mContext).load("http://1.bp.blogspot.com/-1jEM3UAnR2Y/Td-Lx4ZE5sI/AAAAAAAAAko/9jIKAIcrF-c/s1600/Company_Havildar_Major_Piru_Singh_shekhawat.jpg").into(holder.thumbnail);
                    break;
                case 9: Glide.with(mContext).load("http://techy.ninja/wp-content/uploads/-000//1/Neelakantan-Jayachandran-Nair.jpg").into(holder.thumbnail);
                    break;
            }
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots

     private void showPopupMenu(View view) {
     // inflate menu
     PopupMenu popup = new PopupMenu(mContext, view);
     MenuInflater inflater = popup.getMenuInflater();
     inflater.inflate(R.menu.menu_album, popup.getMenu());
     popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
     popup.show();
     }

     /**
     * Click listener for popup menu items

     class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

     public MyMenuItemClickListener() {
     }

     @Override
     public boolean onMenuItemClick(MenuItem menuItem) {
     switch (menuItem.getItemId()) {
     case R.id.action_add_favourite:
     Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
     return true;
     case R.id.action_play_next:
     Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
     return true;
     default:
     }
     return false;
     }
     }*/

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
