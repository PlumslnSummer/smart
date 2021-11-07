package com.example.teacherdata.party;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teacherdata.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartyBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyBlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootview=null;
    public PartyBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyBlankFragment newInstance(String param1, String param2) {
        PartyBlankFragment fragment = new PartyBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private TextView tv_party;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        if(rootview==null){
            rootview=inflater.inflate(R.layout.fragment_party_blank, container, false);
        }
        initView();
        return rootview;
    }

    private void initView() {
        tv_party=rootview.findViewById(R.id.tv_party);
        tv_party.setText(mParam1);
    }
}