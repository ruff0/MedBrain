package com.medbrain.fuzzy.medbrain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//import android.view.View;



public class UserInfo extends ActionBarActivity {
    private static final String TAG = "MedBrain-App";
    private static final int EDIT_USR_REQ = 0;
    CurrentUser currentUser = CurrentUser.getInstance();        // Singleton

    private int userId;
    private Users usrSelected = new Users();
    private DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Intent info = getIntent();
        dbHandler = new DatabaseHandler(this);

        TextView name = (TextView) findViewById(R.id.textView5);
        TextView cedula = (TextView) findViewById(R.id.textView7);
        TextView bDate = (TextView) findViewById(R.id.textView9);

        userId = info.getIntExtra("id", 0);
        //se recupera el user que corresponde al ID y se llena la pantalla
        usrSelected = dbHandler.getUserByID(userId);
        Log.i(TAG, "intent recibido");

        name.setText(usrSelected.getFirstName() + " " + usrSelected.getSecondName() + " " + usrSelected.getThirdName());
        cedula.setText(Integer.toString(usrSelected.getID()));
        bDate.setText(usrSelected.getBirthDay() + " / " + usrSelected.getBirthMonth() + " / " + usrSelected.getBirthYear());

    }

    public void jmpToEdit(View view){
        Intent intent = new Intent(this, EditUserInfo.class);
        intent.putExtra("id", userId);
        startActivityForResult(intent, EDIT_USR_REQ);
    }

    public void cambiarUsr(View view){
        int ID = usrSelected.getID();
        int oldID = currentUser.getID();
        //db.updateOldLog(oldID);
        //db.updateNewLog(ID);

        //2x1
        dbHandler.updateLoggedUser(oldID, ID);
        currentUser.setCurrentUser(ID);
        Context context = getApplicationContext();
        //Toast.makeText(context, "Usuario actual: " + usrSelected.getFirstName() + usrSelected.getSecondName(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Usuario actual: " + usrSelected.getFirstName() + usrSelected.getSecondName());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == EDIT_USR_REQ){
            if(resultCode == RESULT_OK){
                Log.i(TAG, "Usuario modificado o borrado");
                finish();
                startActivity(getIntent());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
