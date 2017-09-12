package com.dingcheng365.studentmis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by yzg on 2017/3/20.
 */

public class DB extends SQLiteOpenHelper
{
    // 函数 *********************************************************************
    // 构造
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        Log.d("StudentMis","调用DB构造函数");
    }

    // 创建
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String strSQL = "create table student("
                + "ID text not null,"
                + "Name text not null,"
                + "constraint PK_Studnet primary key(ID)"
                + ")";

        db.execSQL(strSQL);

        Log.d("StudentMis","调用DB.onCreate()");
    }

    // 升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d("StudentMis","调用DB.onUpgrade()");
    }


}
