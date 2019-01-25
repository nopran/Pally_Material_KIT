package Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.remmss.pally.R;

import java.util.List;

import BeanClass.BeanClassForHomeJobNetwork;


/**
 * Created by Rp on 6/14/2016.
 */
public class RecycleAdapter_JobNetwork_Hori extends RecyclerView.Adapter<RecycleAdapter_JobNetwork_Hori.MyViewHolder> {
Context context;

    boolean showingFirst = true;

    private List<BeanClassForHomeJobNetwork> moviesList;


    ImageView NormalImageView;
    Bitmap ImageBit;
    float ImageRadius = 40.0f;




    public class MyViewHolder extends RecyclerView.ViewHolder {




        ImageView image;
        TextView title;
        TextView number_folllowers;



        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);

        }

    }



    public RecycleAdapter_JobNetwork_Hori(Context mainActivityContacts, List<BeanClassForHomeJobNetwork> moviesList) {
        this.moviesList = moviesList;
       this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_job_network_hori_list, parent, false);



        return new MyViewHolder(itemView);


    }




    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        BeanClassForHomeJobNetwork movie = moviesList.get(position);
        holder.image.setImageResource(movie.getImage());
        holder.title.setText(movie.getTitle());


//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
//                // You can pass your own memory cache implementation
//                .discCacheFileNameGenerator(new HashCodeFileNameGenerator())
//                .build();
//
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .displayer(new RoundedBitmapDisplayer(5)) //rounded corner bitmap
//                .cacheInMemory(true)
//                .cacheOnDisc(true)
//                .build();
//
//        ImageLoader imageLoader = ImageLoader.getInstance();
//        imageLoader.init(config);
//        imageLoader.displayImage("drawable://"+movie.getImage(),holder.image, options );









    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }






}


