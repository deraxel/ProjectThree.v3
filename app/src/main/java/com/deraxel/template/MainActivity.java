package com.deraxel.template;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Folder[] folders=new Folder[3];
    boolean firstGo=false;
    String directory;
    Button population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        population=(Button) findViewById(R.id.population);
        Intent i=getIntent();
        firstGo=Boolean.parseBoolean((String)i.getSerializableExtra("firstGo"));
        if(!firstGo) {
            folders[0] = new Folder();
            folders[0].setName("A:");
            folders[0].setFileNum(0);
            folders[0].setFolderNum(0);
            folders[1] = new Folder();
            folders[1].setName("B:");
            folders[1].setFileNum(0);
            folders[1].setFolderNum(0);
            folders[2] = new Folder();
            folders[2].setName("C:");
            folders[2].setFileNum(0);
            folders[2].setFolderNum(0);
        }else{
            folders=(Folder[])i.getSerializableExtra("folders");
            population.setVisibility(View.INVISIBLE);
        }

    }

    public void Adrive (View view){
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", "0");
        Main2Activity.putExtra("directory", "A:");
        startActivity(Main2Activity);
    }

    public void Bdrive (View view){
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", "1");
        Main2Activity.putExtra("directory", "B:");
        startActivity(Main2Activity);
    }

    public void Cdrive (View view){
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", "2");
        Main2Activity.putExtra("directory", "C:");
        startActivity(Main2Activity);
    }

    public void prePopulate(View view){
        folders[0].setFolderName("A:", "gamesFPS");
        folders[0].setFolderName("A:", "gamesSIM");
        folders[0].setFolderName("A:", "gamesAPPS");

        folders[0].setAllFile("A:", "gamesFPS", "Shooter games played from the first person perspective");
        folders[0].setAllFile("A:", "gamesSIM", "Games played with simulated people in simulated situations");
        folders[0].setAllFile("A:", "gamesAPPS", "Games available on the phone");


        folders[0].setAllFile("A:/gamesFPS", "DOOM", "loading daemon...");
        folders[0].setFolderName("A:/gamesFPS", "DOOM");
        folders[0].setAllFile("A:/gamesFPS/DOOM", "Setting", "Satalites of Mars");
        folders[0].setAllFile("A:/gamesFPS/DOOM", "Protagonist", "Doom Marine");
        folders[0].setAllFile("A:/gamesFPS/DOOM", "Best Weapon", "BFG");


        folders[0].setAllFile("A:/gamesFPS", "Golden Eye", "duel wielding rocket launchers");
        folders[0].setFolderName("A:/gamesFPS", "Golden Eye");
        folders[0].setAllFile("A:/gamesFPS/Golden Eye", "Setting", "Russia");
        folders[0].setAllFile("A:/gamesFPS/Golden Eye", "Protagonist", "James Bond");
        folders[0].setAllFile("A:/gamesFPS/Golden Eye", "Best Weapon", "RCP90");


        folders[0].setAllFile("A:/gamesFPS", "Halo", "Where's Cortana");
        folders[0].setFolderName("A:/gamesFPS", "Halo");
        folders[0].setAllFile("A:/gamesFPS/Halo", "Setting", "Halo Ring in Galactic Space ");
        folders[0].setAllFile("A:/gamesFPS/Halo", "Protagonist", "Spartan 117");
        folders[0].setAllFile("A:/gamesFPS/Halo", "Best Weapon", "Battle Rifle");

        folders[0].setAllFile("A:/gamesSIM", "sims", "Don't kill my sims");
        folders[0].setAllFile("A:/gamesSIM", "Sim City", "!&*% tornados");

        folders[0].setAllFile("A:/gamesAPPS", "Angrey Birds", "get them piggies");
        folders[0].setAllFile("A:/gamesAPPS", "Fallout Shelter", "OOOH Power armor");
        folders[0].setAllFile("A:/gamesAPPS", "Two Dots", "Just one more move ;(");

        folders[1].setFolderName("B:", "Games");
        folders[1].setFolderName("B:/Games", "Table Top");
        folders[1].setFolderName("B:/Games/Table Top", "Games Workshop");
        folders[1].setFolderName("B:/Games/Table Top/Games Workshop", "Warhammer 40k");
        folders[1].setFolderName("B:/Games/Table Top/Games Workshop/Warhammer 40k", "Space Marines");
        folders[1].setAllFile("B:/Games/Table Top/Games Workshop/Warhammer 40k/Space Marines", "Dante", "Chapter Master of the Blood Angels");


        folders[2].setFolderName("C:", "music");
        folders[2].setAllFile("C:/music", "system of a down", "Question1\nChop Sewie\nAriels");
        folders[2].setAllFile("C:/music", "Korn", "All in the Family\nTwisted\nFollow the leader");

        population.setVisibility(View.INVISIBLE);
    }
}
