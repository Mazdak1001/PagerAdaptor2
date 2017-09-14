package com.sbm.user.pageradaptor;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Firstfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Firstfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String Country;
    private String City;
    private int flag;
    Button submit;
    View view;
    Spinner emotionspinner;
String [] mood={"Select","Good","bad","ugly"};
    PageWrapper intpagewraper;
EditText editText;

    public Firstfragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Firstfragment newInstance(PageWrapper pageWrapper) {
        Firstfragment fragment = new Firstfragment();
        Bundle args = new Bundle();
        args.putString("countries", pageWrapper.county);
        args.putString("City", pageWrapper.capital);
        args.putInt("Flag",pageWrapper.imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Country = getArguments().getString("countries");
            City = getArguments().getString("City");
            flag=getArguments().getInt("Flag",0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view= inflater.inflate(R.layout.fragment_firstfragment, container, false);
        TextView City1=(TextView)view.findViewById(R.id.City);
        TextView country=(TextView)view.findViewById(R.id.Country);
        City1.setText(City);
        country.setText(Country);
        ImageView imageview=(ImageView)view.findViewById(R.id.flag);
        imageview.setImageResource(flag);
        initialize();
        clicklistener();
        spinneronclicklistener();
        spinner();

        return view;

    }
   private  void clicklistener(){

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),SubmitActivity.class);
               startActivity(intent);

           }
       });
   }
    private void spinner(){


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,mood);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        emotionspinner.setAdapter(arrayAdapter);
        intpagewraper =new PageWrapper();
        emotionspinner.setSelection(intpagewraper.spinnerposition);

    }
    private void spinneronclicklistener() {

      emotionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

              switch (position)
              {
                  case 0:
                      submit.setEnabled(false);
                      break;
                  case 1:
                      onitemclick(1);
                      break;
                  case 2:
                      onitemclick(2);
                      break;
                  case 3:
                      onitemclick(3);
                      break;
              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {


          }
      });

    }
private  void initialize(){
    emotionspinner=(Spinner)view.findViewById(R.id.mood);
    submit=(Button)view.findViewById(R.id.buttonsubmit);
    editText=(EditText)view.findViewById(R.id.displayedittext);
}
    private void onitemclick(int counter) {
        submit.setEnabled(true);
        editText.setText(mood[counter]);
    }

}
