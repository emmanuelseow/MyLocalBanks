package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button dbs;
    Button ocbc;
    Button uob;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.btndbs);
        ocbc = findViewById(R.id.btnocbc);
        uob = findViewById(R.id.btnuob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.btndbs)
        {selected="dbs";}
        else if(v.getId() == R.id.btnocbc)
        {selected="ocbc";}
        else if(v.getId() == R.id.btnuob)
        {selected="uob";}

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact Bank");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            if(selected.equalsIgnoreCase("dbs")){
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWebsite); //menu item successfully handled
            }
            else if (selected.equalsIgnoreCase("ocbc")){
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWebsite); //menu item successfully handled
            }
            else if (selected.equalsIgnoreCase("uob")){
                //code for action
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWebsite); //menu item successfully handled
            }
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            if(selected.equalsIgnoreCase("dbs")){
                //code for action
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18001111111L));
                startActivity(intentContact);  //menu item successfully handled
            }
            else if(selected.equalsIgnoreCase("ocbc")){
                //code for action
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18003633333L));
                startActivity(intentContact);  //menu item successfully handled
            }
            else if(selected.equalsIgnoreCase("uob")){
                //code for action
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
                startActivity(intentContact);  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBD");
            uob.setText("UOB");
            return true;
        }else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        }else  {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

}
