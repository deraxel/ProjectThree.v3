package com.deraxel.template;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    Folder[] folders;
    int currentDrive;
    ImageView driveA, driveB, driveC;
    String directory;
    ImageButton folder1, folder2, folder3, folder4, folder5, file1, file2, file3, file4, file5;
    Button folder1text, folder2text, folder3text, folder4text, folder5text, file1text, file2text, file3text, file4text, file5text;
    EditText fileTitle, fileData;
    TextView fDirectory;
    boolean deleteFilr=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Intent i=getIntent();
        folders=(Folder[])i.getSerializableExtra("folders");
        currentDrive=Integer.parseInt((String)i.getSerializableExtra("drive"));
        directory=(String)i.getSerializableExtra("directory");

        driveA=(ImageView) findViewById(R.id.driveA);
        driveB=(ImageView) findViewById(R.id.driveB);
        driveC=(ImageView) findViewById(R.id.driveC);

        if(currentDrive==0){
            driveA.setVisibility(View.VISIBLE);
            driveB.setVisibility(View.INVISIBLE);
            driveC.setVisibility(View.INVISIBLE);
        }else if(currentDrive==1){
            driveA.setVisibility(View.INVISIBLE);
            driveB.setVisibility(View.VISIBLE);
            driveC.setVisibility(View.INVISIBLE);
        }else if(currentDrive==2){
            driveA.setVisibility(View.INVISIBLE);
            driveB.setVisibility(View.INVISIBLE);
            driveC.setVisibility(View.VISIBLE);
        }
        fileTitle=(EditText) findViewById(R.id.fileTitle);
        fileData=(EditText) findViewById(R.id.fileData);

        fDirectory=(TextView) findViewById(R.id.fDirectory);

        folder1=(ImageButton) findViewById(R.id.folder1);
        folder2=(ImageButton) findViewById(R.id.folder2);
        folder3=(ImageButton) findViewById(R.id.folder3);
        folder4=(ImageButton) findViewById(R.id.folder4);
        folder5=(ImageButton) findViewById(R.id.folder5);
        file1=(ImageButton) findViewById(R.id.file1);
        file2=(ImageButton) findViewById(R.id.file2);
        file3=(ImageButton) findViewById(R.id.file3);
        file4=(ImageButton) findViewById(R.id.file4);
        file5=(ImageButton) findViewById(R.id.file5);

        folder1text=(Button) findViewById(R.id.folder1text);
        folder2text=(Button) findViewById(R.id.folder2text);
        folder3text=(Button) findViewById(R.id.folder3text);
        folder4text=(Button) findViewById(R.id.folder4text);
        folder5text=(Button) findViewById(R.id.folder5text);
        file1text=(Button) findViewById(R.id.file1text);
        file2text=(Button) findViewById(R.id.file2text);
        file3text=(Button) findViewById(R.id.file3text);
        file4text=(Button) findViewById(R.id.file4text);
        file5text=(Button) findViewById(R.id.file5text);

        if(directory.equals("A:/")||directory.equals("B:/")||directory.equals("C:/")){
            directory=directory.split("/")[0];
        }
        fixDirectory();
        fDirectory.setText(directory);
        displayItems();
    }

    public void addFolder(View view){
        if(folders[currentDrive].getAllFolderNum(directory)<5 && folders[currentDrive].isThereFolder(directory,fileTitle.getText().toString())) {
            deleteFilr = true;
            if (!fileTitle.getText().toString().isEmpty()) {
                folders[currentDrive].setFolderName(directory, fileTitle.getText().toString());
            } else {
                Toast.makeText(getBaseContext(), "MUST ENTER TEXT IN TITLE BOX", Toast.LENGTH_LONG).show();
            }
            setAllBlank();
            displayItems();
        }else{
            Toast.makeText(getBaseContext(), "MAX FOLDERS 5 AND NO SAME NAMES", Toast.LENGTH_LONG).show();
        }
    }

    public void addFile(View view) {
        if(folders[currentDrive].getAllFileNum(directory)<5 && folders[currentDrive].isThereFile(directory,fileTitle.getText().toString())) {
            deleteFilr = true;
            if (!fileTitle.getText().toString().isEmpty() && !fileData.getText().toString().isEmpty()) {
                folders[currentDrive].setAllFile(directory, fileTitle.getText().toString(), fileData.getText().toString());
            } else {
                Toast.makeText(getBaseContext(), "MUST ENTER TEXT IN TITLE BOX AND DATA BOX", Toast.LENGTH_LONG).show();
            }
            setAllBlank();
            displayItems();
        }else{
                Toast.makeText(getBaseContext(), "MAX FILES 5 AND NO SAME NAMES", Toast.LENGTH_LONG).show();
            }
    }

    private void setAllBlank(){
        fileTitle.setText("");
        fileData.setText("");
    }

    private void displayItems(){try{
        if(folders[currentDrive].getAllFolderNum(directory)==1){
            folder1visible();
        }else if(folders[currentDrive].getAllFolderNum(directory)==2){
            folder2visible();
        }else if(folders[currentDrive].getAllFolderNum(directory)==3){
            folder3visible();
        }else if(folders[currentDrive].getAllFolderNum(directory)==4){
            folder4visible();
        }else if(folders[currentDrive].getAllFolderNum(directory)==5){
            folder5visible();
        }}catch (Exception e){Toast.makeText(getBaseContext(),"here1",Toast.LENGTH_LONG).show();}try{
        if(folders[currentDrive].getAllFileNum(directory)==1){
            file1visible();
        }else if(folders[currentDrive].getAllFileNum(directory)==2){
            file2visible();
        }else if(folders[currentDrive].getAllFileNum(directory)==3){
            file3visible();
        }else if(folders[currentDrive].getAllFileNum(directory)==4){
            file4visible();
        }else if(folders[currentDrive].getAllFileNum(directory)==5){
            file5visible();
        }}catch (Exception e){Toast.makeText(getBaseContext(),String.valueOf(folders[currentDrive].getAllFileNum(directory)),Toast.LENGTH_LONG).show();}
    }

    private void file1visible(){
        file1.setVisibility(View.VISIBLE);
        file1text.setVisibility(View.VISIBLE);
        file1text.setText(folders[currentDrive].getAllFileName(directory,0));
    }

    private void file2visible(){
        file1visible();
        file2.setVisibility(View.VISIBLE);
        file2text.setVisibility(View.VISIBLE);
        file2text.setText(folders[currentDrive].getAllFileName(directory,1));
    }

    private void file3visible(){
        file2visible();
        file3.setVisibility(View.VISIBLE);
        file3text.setVisibility(View.VISIBLE);
        file3text.setText(folders[currentDrive].getAllFileName(directory,2));
    }

    private void file4visible(){
        file3visible();
        file4.setVisibility(View.VISIBLE);
        file4text.setVisibility(View.VISIBLE);
        file4text.setText(folders[currentDrive].getAllFileName(directory,3));
    }

    private void file5visible(){
        file4visible();
        file5.setVisibility(View.VISIBLE);
        file5text.setVisibility(View.VISIBLE);
        file5text.setText(folders[currentDrive].getAllFileName(directory,4));
    }

    private void folder1visible(){
        folder1.setVisibility(View.VISIBLE);
        folder1text.setVisibility(View.VISIBLE);
        folder1text.setText(folders[currentDrive].getAllFolderName(directory, 0));
    }

    private void folder2visible(){
        folder1visible();
        folder2.setVisibility(View.VISIBLE);
        folder2text.setVisibility(View.VISIBLE);
        folder2text.setText(folders[currentDrive].getAllFolderName(directory, 1));
    }

    private void folder3visible(){
        folder2visible();
        folder3.setVisibility(View.VISIBLE);
        folder3text.setVisibility(View.VISIBLE);
        folder3text.setText(folders[currentDrive].getAllFolderName(directory, 2));
    }

    private void folder4visible(){
        folder3visible();
        folder4.setVisibility(View.VISIBLE);
        folder4text.setVisibility(View.VISIBLE);
        folder4text.setText(folders[currentDrive].getAllFolderName(directory, 3));
    }

    private void folder5visible(){
        folder4visible();
        folder5.setVisibility(View.VISIBLE);
        folder5text.setVisibility(View.VISIBLE);
        folder5text.setText(folders[currentDrive].getAllFolderName(directory, 4));
    }

    public void file1(View view){
        if(deleteFilr) {
            Intent Main3Activity = new Intent(getApplicationContext(), Main3Activity.class);
            Main3Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Main3Activity.putExtra("folders", folders);
            Main3Activity.putExtra("drive", String.valueOf(currentDrive));
            Main3Activity.putExtra("directory", directory);
            Main3Activity.putExtra("fileNumber", "0");
            startActivity(Main3Activity);
        }else{
            goDeleteFilr(0);
        }
    }

    public void file2(View view){
        if(deleteFilr) {
            Intent Main3Activity = new Intent(getApplicationContext(), Main3Activity.class);
            Main3Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Main3Activity.putExtra("folders", folders);
            Main3Activity.putExtra("drive", String.valueOf(currentDrive));
            Main3Activity.putExtra("directory", directory);
            Main3Activity.putExtra("fileNumber", "1");
            startActivity(Main3Activity);
        }else{
            goDeleteFilr(1);
        }
    }

    public void file3(View view){
        if(deleteFilr) {
            Intent Main3Activity = new Intent(getApplicationContext(), Main3Activity.class);
            Main3Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Main3Activity.putExtra("folders", folders);
            Main3Activity.putExtra("drive", String.valueOf(currentDrive));
            Main3Activity.putExtra("directory", directory);
            Main3Activity.putExtra("fileNumber", "2");
            startActivity(Main3Activity);
        }else{
            goDeleteFilr(2);
        }
    }

    public void file4(View view){
        if(deleteFilr) {
            Intent Main3Activity = new Intent(getApplicationContext(), Main3Activity.class);
            Main3Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Main3Activity.putExtra("folders", folders);
            Main3Activity.putExtra("drive", String.valueOf(currentDrive));
            Main3Activity.putExtra("directory", directory);
            Main3Activity.putExtra("fileNumber", "3");
            startActivity(Main3Activity);
        }else{
            goDeleteFilr(3);
        }
    }

    public void file5(View view){
        if(deleteFilr) {
            Intent Main3Activity = new Intent(getApplicationContext(), Main3Activity.class);
            Main3Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Main3Activity.putExtra("folders", folders);
            Main3Activity.putExtra("drive", String.valueOf(currentDrive));
            Main3Activity.putExtra("directory", directory);
            Main3Activity.putExtra("fileNumber", "4");
            startActivity(Main3Activity);
        }else{
            goDeleteFilr(4);
        }
    }

    private void goDeleteFilr(int x){
        deleteFilr=true;
        folders[currentDrive].deleteFile(directory, x);
        invisibleItems();
        displayItems();
    }

    private void invisibleItems(){
        file1.setVisibility(View.INVISIBLE);
        file1text.setVisibility(View.INVISIBLE);
        file2.setVisibility(View.INVISIBLE);
        file2text.setVisibility(View.INVISIBLE);
        file3.setVisibility(View.INVISIBLE);
        file3text.setVisibility(View.INVISIBLE);
        file4.setVisibility(View.INVISIBLE);
        file4text.setVisibility(View.INVISIBLE);
        file5.setVisibility(View.INVISIBLE);
        file5text.setVisibility(View.INVISIBLE);
    }

    private void fixDirectory(){
        String tempDirs[]=directory.split("/");
        directory=tempDirs[0];
        for(int i=1;i<tempDirs.length;i=i+1) {
            directory = directory + "/" + tempDirs[i];
        }
    }

    public void folder1(View view){
        fixDirectory();
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", String.valueOf(currentDrive));
        Main2Activity.putExtra("directory", directory+"/"+folder1text.getText());
        startActivity(Main2Activity);
    }

    public void folder2(View view){
        fixDirectory();
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", String.valueOf(currentDrive));
        Main2Activity.putExtra("directory", directory+"/"+folder2text.getText());
        startActivity(Main2Activity);
    }

    public void folder3(View view){
        fixDirectory();
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", String.valueOf(currentDrive));
        Main2Activity.putExtra("directory", directory+"/"+folder3text.getText());
        startActivity(Main2Activity);
    }

    public void folder4(View view){
        fixDirectory();
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", String.valueOf(currentDrive));
        Main2Activity.putExtra("directory", directory+"/"+folder4text.getText());
        startActivity(Main2Activity);
    }

    public void folder5(View view){
        fixDirectory();
        Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
        Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Main2Activity.putExtra("folders", folders);
        Main2Activity.putExtra("drive", String.valueOf(currentDrive));
        Main2Activity.putExtra("directory", directory+"/"+folder5text.getText());
        startActivity(Main2Activity);
    }

    public void deleteFile(View view){
        if(deleteFilr) {
            Toast.makeText(getBaseContext(), "CLICK FILE TO DELETE", Toast.LENGTH_LONG).show();
            deleteFilr = false;
        }else{
            Toast.makeText(getBaseContext(), "NO LONGER DELETING", Toast.LENGTH_LONG).show();
            deleteFilr = true;
        }
    }

    public void back(View view){
        goBack();
    }

    @Override
    public void onBackPressed(){
        goBack();
    }

    private void goBack(){
        if(directory.equals("A:")||directory.equals("B:")||directory.equals("C:")){
            Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
            MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            MainActivity.putExtra("folders", folders);
            MainActivity.putExtra("drive", "2");
            MainActivity.putExtra("firstGo", "true");
            startActivity(MainActivity);
        }else{
            String tempDirs[]=directory.split("/");
            directory=tempDirs[0];
            for(int i=1;i<tempDirs.length-1;i=i+1){
                directory=directory+"/"+tempDirs[i];
            }
            Intent Main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
            Main2Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Main2Activity.putExtra("folders", folders);
            Main2Activity.putExtra("drive", String.valueOf(currentDrive));
            Main2Activity.putExtra("directory", directory);
            startActivity(Main2Activity);
        }
    }
}
