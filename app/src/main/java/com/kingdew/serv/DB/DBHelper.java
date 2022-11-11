package com.kingdew.serv.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.kingdew.serv.Frags.User;
import com.kingdew.serv.Job;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "serv.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE users_t(email TEXT,name TEXT,phone TEXT,password TEXT,type TEXT)");
        DB.execSQL("Create Table jobs(jobID INTEGER PRIMARY KEY AUTOINCREMENT,jobName TEXT,jobPrice TEXT,jobStatus TEXT,jobOwner TEXT,jobCompleter TEXT,jobPhotos TEXT,jobDesc TEXT,jobAddress TEXT,jobTele TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists users_t");
        DB.execSQL("drop Table if exists jobs");
        onCreate(DB);
    }

    public boolean insertUserDatat(){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email","c");
        contentValues.put("name","c");
        contentValues.put("phone","c");
        contentValues.put("password","c");
        contentValues.put("type","Cleaner");




//        contentValues.put("email",email);
//        contentValues.put("name",name);
//        contentValues.put("phone",phone);
//        contentValues.put("password",password);
//        contentValues.put("type",type);
        long result=DB.insert("users",null,contentValues);

        if (result == -1){
            return false;
        }else{

            return true;
        }

    }

    public boolean insertUserData(String email,String name,String phone,String password,String type){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        contentValues.put("type",type);
        long result=DB.insert("users_t",null,contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    public User getUsers(String email){
        SQLiteDatabase DB =this.getReadableDatabase();
        //Cursor cursor=DB.rawQuery("Select * from users_t",null);
        Cursor cursor=DB.rawQuery("Select * from users_t where email= ?",new String[]{email});

        User jobs = null;
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs=new User(
                        cursor.getString(1),
                        cursor.getString(0),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
            }
        }
        return jobs;
    }

    public boolean insertJob(String jobName,Integer jobPrice,String jobStatus,String jobOwner,String jobCompleter,String jobPhotos,String jobDesc,String jobAddress,String jobTele){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("jobName",jobName);
        contentValues.put("jobPrice",jobPrice);
        contentValues.put("jobStatus",jobStatus);
        contentValues.put("jobOwner",jobOwner);
        contentValues.put("jobCompleter",jobCompleter);
        contentValues.put("jobPhotos",jobPhotos);
        contentValues.put("jobName",jobName);
        contentValues.put("jobDesc",jobDesc);
        contentValues.put("jobAddress",jobAddress);
        contentValues.put("jobTele",jobTele);

        long res=DB.insert("jobs",null,contentValues);
        if (res == -1){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Job> getJobs(){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs",null);
        ArrayList<Job> jobs=new ArrayList<>();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs.add(new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                ));
            }
        }
        return jobs;
    }

    public ArrayList<String> login(String email,String password){
        SQLiteDatabase DB =this.getReadableDatabase();

        try {
            Cursor cursor=DB.rawQuery("Select * from users_t where email= ?",new String[]{email});

            if (cursor.getCount()>0){
                Cursor cursor2=DB.rawQuery("Select * from users_t where email=? and password =?",new String[]{email,password});
                    if (cursor2.getCount()>0){
                        cursor2.moveToFirst();
                        ArrayList<String> ret=new ArrayList<>();
                        ret.add(cursor2.getString(4).toString());
                        ret.add("1");
                        ret.add(cursor2.getString(0).toString());
                        return ret;
                    }else{
                        ArrayList<String> ret=new ArrayList<>();
                        ret.add("emp");
                        ret.add("0");
                        ret.add("0");
                        return ret;
                    }

            }else{
                ArrayList<String> ret=new ArrayList<>();
                ret.add("emp");
                ret.add("-1");
                ret.add("0");
                return ret;

            }

        }catch (Exception e){
            ArrayList<String> ret=new ArrayList<>();
            ret.add("emp");
            ret.add("-1");
            ret.add("0");
            return ret;
        }


    }

    public ArrayList<Job> getAceptedJobs(String email){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs where jobCompleter= ? and jobStatus=?",new String[]{email,"pending"});
        ArrayList<Job> jobs=new ArrayList<>();

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs.add(new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                ));
            }
        }
        return jobs;
    }

    public ArrayList<Job> getFinishedJobs(String email){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs where jobCompleter= ? and jobStatus=?",new String[]{email,"finished"});
        ArrayList<Job> jobs=new ArrayList<>();

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs.add(new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                ));
            }
        }
        return jobs;
    }


    public ArrayList<Job> getmyJobs(String email){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs where jobOwner= ?",new String[]{email});
        ArrayList<Job> jobs=new ArrayList<>();

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs.add(new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                ));
            }
        }
        return jobs;
    }

    public ArrayList<Job> getFinishedmyJobs(String email){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs where jobOwner= ? and jobStatus=?",new String[]{email,"finished"});
        ArrayList<Job> jobs=new ArrayList<>();

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs.add(new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                ));
            }
        }
        return jobs;
    }

    public ArrayList<Job> getavimyJobs(String email){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs where jobOwner= ? and jobStatus=?",new String[]{email,"pending"});
        ArrayList<Job> jobs=new ArrayList<>();

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                jobs.add(new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                ));
            }
        }
        return jobs;
    }


    public Job getaJob(int id){
        SQLiteDatabase DB =this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("Select * from jobs where jobID="+id,null);
        Job jobs = null;

        if (cursor.getCount()>0){
                cursor.moveToFirst();
                jobs=new Job(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)
                );

        }
        return jobs;
    }

    public boolean updateJob(int jobID,String jobName,Integer jobPrice,String jobStatus,String jobOwner,String jobCompleter,String jobPhotos,String jobDesc,String jobAddress,String jobTele){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("jobName",jobName);
        contentValues.put("jobPrice",jobPrice);
        contentValues.put("jobStatus",jobStatus);
        contentValues.put("jobOwner",jobOwner);
        contentValues.put("jobCompleter",jobCompleter);
        contentValues.put("jobPhotos",jobPhotos);
        contentValues.put("jobName",jobName);
        contentValues.put("jobDesc",jobDesc);
        contentValues.put("jobAddress",jobAddress);
        contentValues.put("jobTele",jobTele);

        long res=DB.update("jobs",contentValues,"jobID="+8,new String[]{});
        if (res == -1){
            return false;
        }else{
            return true;
        }
    }


}
