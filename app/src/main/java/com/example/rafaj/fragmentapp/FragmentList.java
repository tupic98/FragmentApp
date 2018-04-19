package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    private Planet planet[] = new Planet[9];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] titles = getResources().getStringArray(R.array.Planets);
        String[] mindesc = getResources().getStringArray(R.array.minDesc);
        String[] desc = getResources().getStringArray(R.array.Desc);
        TypedArray img = getResources().obtainTypedArray(R.array.img);
        for(int i = 0; i<planet.length; i++){
            planet[i] = new Planet(titles[i],desc[i],mindesc[i], img.getResourceId(i, -1));
        }
       /* planet[0] = new Planet(titles[0],"dfhdshklashgfs","hfhf", R.drawable.sun);
        planet[1] = new Planet(titles[1],"dfhdshklashgfs","hfhf", R.drawable.mercury);
        planet[2] = new Planet(titles[2],"dfhdshklashgfs","hfhf", R.drawable.venus);
        planet[3] = new Planet(titles[3],"dfhdshklashgfs","hfhf", R.drawable.earth);
        planet[4] = new Planet(titles[4],"dfhdshklashgfs","hfhf", R.drawable.mars);
        planet[5] = new Planet(titles[5],"dfhdshklashgfs","hfhf", R.drawable.jupiter);
        planet[6] = new Planet(titles[6],"dfhdshklashgfs","hfhf", R.drawable.saturn);
        planet[7] = new Planet(titles[7],"dfhdshklashgfs","hfhf", R.drawable.uranus);
        planet[8] = new Planet(titles[8],"dfhdshklashgfs","hfhf", R.drawable.neptune);*/

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY", planet[i]);
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.putExtras(bundle);
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY", planet[i]);
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
