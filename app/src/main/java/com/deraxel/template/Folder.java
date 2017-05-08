package com.deraxel.template;
import java.io.Serializable;

/**
 * Created by Derxe on 4/6/2017.
 */

public class Folder implements Serializable{
    private String name;
    private int folderNum=0;
    private int fileNum=0;
    private Folder[] folders;
    private Files[] files;
    public String getName(){
        return name;
    }
    public void setName(String x){
        name=x;
    }
    public int getFolderNum(){
        return folderNum;
    }
    public void setFolderNum(int x){
        folderNum=x;
    }
    public int getFileNum(){
        return fileNum;
    }
    public void setFileNum(int x){
        fileNum=x;
    }

    public void createFolder(String x){
        if (folderNum<=5) {
            folderNum=folderNum+1;
            if(folderNum==1) {
                folders=new Folder[5];
                Folder folderTemp=new Folder();
                folderTemp.setFolderNum(0);
                folderTemp.setFileNum(0);
                folderTemp.setName(x);
                folders[0]=folderTemp;
            }else{
                Folder folderTemp=new Folder();
                folderTemp.setFolderNum(0);
                folderTemp.setFileNum(0);
                folderTemp.setName(x);
                folders[folderNum-1]=folderTemp;
            }
        }
    }

    public void createFile(String x, String y){
        if (fileNum<=5) {
            fileNum=fileNum+1;
            if(fileNum==1) {
                files=new Files[5];
                Files fileTemp=new Files();
                fileTemp.setName(x);
                fileTemp.setData(y);
                files[0]=fileTemp;
            }else{
                Files fileTemp=new Files();
                fileTemp.setName(x);
                fileTemp.setData(y);
                files[fileNum-1]=fileTemp;
            }
        }
    }


    public Folder[] getFolderList(int y,String x){
        String tempDir[]=x.split("/");
        if(y==tempDir.length-2) {
            return getFolders();
        }else {
            int temp=0;
            while(!getFolders()[temp].getName().equals(tempDir[y+1])){
                temp=1+temp;
            }
            return getFolders()[temp].getFolderList(y + 1, x);
        }
    }

    public Folder getsingleFolderInfo(String x){
        if(x.equals("A:")||x.equals("B:")||x.equals("C:")){
            return this;
        }else{
            String tempDir[]=x.split("/");
            int dirs=tempDir.length;
            int other=0;
            while(!getFolderList(0,x)[other].getName().equals(tempDir[dirs-1])){
                other=1+other;
            }
            return getFolderList(0,x)[other];
        }
    }

    public void setFolderName(String x, String y){
        getsingleFolderInfo(x).createFolder(y);
    }

    public void setAllFile(String x, String y, String z){
        getsingleFolderInfo(x).createFile(y,z);
    }

    public String getAllFolderName(String x, int y){
        return getsingleFolderInfo(x).getFolders()[y].getName();
    }

    public int getAllFolderNum(String x){
        return getsingleFolderInfo(x).getFolderNum();
    }

    public int getAllFileNum(String x){
        return getsingleFolderInfo(x).getFileNum();
    }

    public String getAllFileName(String x, int y){
        return getsingleFolderInfo(x).getFiles()[y].getName();
    }

    public String getAllData(String x, int y){
        return getsingleFolderInfo(x).getFiles()[y].getData();
    }

    public void deleteFile(String x, int y){
        for(int i=y;i<getsingleFolderInfo(x).getFileNum()-1;i=i+1){
            getsingleFolderInfo(x).getFiles()[i]=getsingleFolderInfo(x).getFiles()[i+1];
        }
        getsingleFolderInfo(x).getFiles()[getsingleFolderInfo(x).getFileNum()-1]=null;
        getsingleFolderInfo(x).setFileNum(getAllFileNum(x)-1);
    }

    public boolean isThereFolder(String x, String y){
        boolean temp=true;
        for(int i=0;i<getAllFolderNum(x);i=i+1){
            if(y.equals(getAllFolderName(x,i))){
                temp=false;
            }
        }
        return temp;
    }

    public boolean isThereFile(String x, String y){
        boolean temp=true;
        for(int i=0;i<getAllFileNum(x);i=i+1){
            if(y.equals(getAllFileName(x,i))){
                temp=false;
            }
        }
        return temp;
    }

    public Folder[] getFolders(){
        return folders;
    }

    public Files[] getFiles(){
        return files;
    }
}
