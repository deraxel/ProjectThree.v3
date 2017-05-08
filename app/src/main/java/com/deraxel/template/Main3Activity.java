package com.deraxel.template;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Folder[] folders;
    int currentDrive, currentFile;
    String directory;
    TextView title, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Intent i=getIntent();
        folders=(Folder[])i.getSerializableExtra("folders");
        currentDrive=Integer.parseInt((String)i.getSerializableExtra("drive"));
        directory=(String)i.getSerializableExtra("directory");
        currentFile=Integer.parseInt((String)i.getSerializableExtra("fileNumber"));
        title=(TextView) findViewById(R.id.titleOfFile);
        data=(TextView) findViewById(R.id.dataOfFile);
        title.setText(folders[currentDrive].getAllFileName(directory,currentFile));
        data.setText(folders[currentDrive].getAllData(directory,currentFile));
    }

    public void delete(View view){
        folders[currentDrive].deleteFile(directory, currentFile);
        goBack();
    }

    public void back(View view){
        goBack();
    }

    @Override
    public void onBackPressed(){
        goBack();
    }

    private void goBack() {
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", String.valueOf(currentDrive));
        Main2Activity.putExtra("directory", directory);
        startActivity(Main2Activity);

    }
}

