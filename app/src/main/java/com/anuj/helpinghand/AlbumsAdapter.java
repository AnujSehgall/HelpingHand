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

        if (phint.equals("hand")){      //TODO -- ADD Pictures

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

                case 0: Glide.with(mContext).load("http://media2.intoday.in/dailyo//story/embed/201601/saif2mbed_010416021542.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("http://www.india.com/wp-content/uploads/2016/01/Martyr-6-Sepoy-Jagdish-Chand.jpg").into(holder.thumbnail);
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

        else {
            switch (position){

                case 0: Glide.with(mContext).load("http://timesofindia.indiatimes.com/thumb/msid-55169932,width-400,resizemode-4/55169932.jpg").into(holder.thumbnail);
                    break;
                case 1: Glide.with(mContext).load("http://www.india.com/wp-content/uploads/2016/01/Martyr-6-Sepoy-Jagdish-Chand.jpg").into(holder.thumbnail);
                    break;
                case 2: Glide.with(mContext).load("http://media2.intoday.in/dailyo//story/embed/201601/saif2mbed_010416021542.jpg").into(holder.thumbnail);
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
