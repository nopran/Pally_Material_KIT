package fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.remmss.pally.R;

import java.util.ArrayList;

import Adapter.RecycleAdapter_JobNetwork_Hori;
import Adapter.RecycleAdapter_PeopleNetwork_Hori;
import BeanClass.BeanClassForHomeJobNetwork;

public class Home_Fragment extends Fragment {

    private View view;

    private ArrayList<BeanClassForHomeJobNetwork> beanClassForHomeJobNetworks;
    private RecyclerView recyclerView;
    private RecycleAdapter_JobNetwork_Hori mAdapter;


    private Integer[] image ={R.drawable.apple,R.drawable.ibm,R.drawable.apple,R.drawable.ibm};
    private String [] title= {"Sr.Crative Lead","Sr.Manager","UIUX Designer","Sr.Manager"};



    private ArrayList<BeanClassForHomeJobNetwork> beanClassForHomeJobNetworks1;
    private RecyclerView recyclerView1;
    private RecycleAdapter_PeopleNetwork_Hori mAdapter1;


    private Integer[] image1 ={R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img};
    private String [] title1= {"Gautam Rokade","Zing Ving","Devansh","Martin"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_home__fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);

        beanClassForHomeJobNetworks = new ArrayList<>();


        for (int i = 0; i < image.length; i++) {
            BeanClassForHomeJobNetwork beanClassForLocal = new BeanClassForHomeJobNetwork(image[i],title[i]);

            beanClassForHomeJobNetworks.add(beanClassForLocal);
        }


        mAdapter = new RecycleAdapter_JobNetwork_Hori(getActivity(), beanClassForHomeJobNetworks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




        recyclerView1 = (RecyclerView) view.findViewById(R.id.recycleview1);

        beanClassForHomeJobNetworks1 = new ArrayList<>();


        for (int i = 0; i < image1.length; i++) {
            BeanClassForHomeJobNetwork beanClassForLocal = new BeanClassForHomeJobNetwork(image1[i],title1[i]);

            beanClassForHomeJobNetworks1.add(beanClassForLocal);
        }


        mAdapter1 = new RecycleAdapter_PeopleNetwork_Hori(getActivity(), beanClassForHomeJobNetworks1);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        recyclerView1.setLayoutManager(mLayoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mAdapter1);


        return  view;
    }
}
