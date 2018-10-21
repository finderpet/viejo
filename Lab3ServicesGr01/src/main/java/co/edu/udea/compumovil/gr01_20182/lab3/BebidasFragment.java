package co.edu.udea.compumovil.gr01_20182.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.udea.compumovil.gr01_20182.lab3.Utilities.Utilities;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BebidasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BebidasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BebidasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;
    EditText fieldName, fieldDescrip, fieldPrice;
    Button btnAdd;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BebidasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BebidasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BebidasFragment newInstance(String param1, String param2) {
        BebidasFragment fragment = new BebidasFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_bebidas, container, false);

        fieldName = view.findViewById(R.id.nomBebida_id);
        fieldDescrip = view.findViewById(R.id.descripBebidas_id);
        fieldPrice = view.findViewById(R.id.precioBebida_id);

        btnAdd=view.findViewById(R.id.id_btnAddDrink);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDrinks();
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void registerDrinks() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "bd_maxipollo", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilities.FIELD_D_NAME, fieldName.getText().toString());
        values.put(Utilities.FIELD_D_DESCRIPTION, fieldDescrip.getText().toString());
        values.put(Utilities.FIELD_D_PRICE, fieldPrice.getText().toString());

        long idResult = db.insert(Utilities.TABLE_DRINKS, Utilities.FIELD_D_NAME, values);
        Toast.makeText(getContext().getApplicationContext(), "Bebida Registrado: "+idResult, Toast.LENGTH_SHORT).show();
        db.close();
        fieldName.setText("");
        fieldPrice.setText("");
        fieldDescrip.setText("");
    }
}
