package com.medbrain.fuzzy.medbrain;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Clase ListFragment que maneja el despliegue de las recetas activas en MainActivity
 * @author Andres Bejarano
 */
public class MyListFragment extends ListFragment {

    private static final String TAG = "MedBrain-App";
    private SimpleCursorAdapter adapter;
    private DatabaseHandler dbHandler;
    private Cursor cursor;
    private CurrentUser user = CurrentUser.getInstance();



    /**
     * Se ejecuta al crear la actividad asociada al Fragment
     * Obtiene todas las recetas en la BD y se las da al Adapter para que las despliegue
     * Configura el evento de click en cada receta individual
     * De momento solo se despliega un mensaje informativo
     * @param savedInstanceState Bundle con informacion de la Activity
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        Log.i(TAG, "Entered onActivityCreated fragment");
        super.onCreate(savedInstanceState);

        dbHandler = new DatabaseHandler(getActivity());

        //cursor = dbHandler.getAllPrescriptions();
        cursor = dbHandler.getUserPrescriptions(user.getID());
        adapter = new SimpleCursorAdapter(getActivity(), R.layout.list_item_view,
                cursor, new String[]{MedDBContract.PrescriptionContract._ID,
                MedDBContract.PrescriptionContract.COLUMN_NAME_MOTIVE}, new int[]{R.id.recetaId, R.id.motivo}, 0);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                TextView presc = (TextView)view.findViewById(R.id.recetaId);
                int prescId = Integer.parseInt(presc.getText().toString());
                Intent intent = new Intent(getActivity(), PrescriptionViewActivity.class);
                intent.putExtra("id", prescId);
                startActivity(intent);

            }

        });
    }



    /**
     * Metodo ejecutado al crear el view en el que se encuentra el fragment
     * @param inflater LayoutInflater usado para "inflar" el layout del fragment
     * @param container ViewGroup contenedor donde se encontrara el fragment
     * @param savedInstanceState Bundle con informacion de la Activity
     * @return View creado
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.i(TAG, "Entered onCreateView fragment");
        View view = inflater.inflate(R.layout.list_fragment, container);

        return view;
    }

    public void refresh(){
        Log.i(TAG, "Refreshing cursor");
        //adapter.swapCursor(dbHandler.getAllPrescriptions());
        adapter.swapCursor(dbHandler.getUserPrescriptions(user.getID()));
    }

    @Override
    public void onResume(){
        Log.i(TAG, "Entered onResume");
        super.onResume();
        refresh();
    }

}
