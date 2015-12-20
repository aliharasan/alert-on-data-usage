package com.adacdc.mobile.alertondatausage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragMain.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragMain extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View _mainLayout;

    private TextView red_green_status;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragMain.
     */
    // TODO: Rename and change types and number of parameters
    public static FragMain newInstance(String param1, String param2) {
        FragMain fragment = new FragMain();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragMain() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        _mainLayout = inflater.inflate(R.layout.fragment_main, container, false);
        red_green_status = (TextView) _mainLayout.findViewById(R.id.red_green_status);
        ShowDataAlert(dataCheck());
        return _mainLayout;
    }


    private boolean dataCheck (){

        return ConnectivityUtils.isConnectedMobile(getActivity().getApplicationContext());

    }

    private void ShowDataAlert(boolean datacheck){

        if (datacheck){
            new AlertDialog.Builder(getActivity())
                    .setTitle("Mobile data check")
                    .setMessage("Mobile data is on , it will cost you , do you want to use it ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            MakePositiveDecision();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            MakeNegativeDecision();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else {
            MakeDestructiveDecsion();
        }

    }

    private void MakePositiveDecision() {
        red_green_status.setText("data Usage permission Granted");
        red_green_status.setTextColor(getResources().getColor(R.color.green));
    }

    private void MakeNegativeDecision() {
        red_green_status.setText("data usage permission denied");
        red_green_status.setTextColor(getResources().getColor(R.color.red));

    }

    private void MakeDestructiveDecsion(){
        red_green_status.setText("connected to WIFI");
        red_green_status.setTextColor(getResources().getColor(R.color.black));
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
