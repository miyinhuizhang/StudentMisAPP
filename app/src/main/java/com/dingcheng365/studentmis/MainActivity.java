package com.dingcheng365.studentmis;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // 变量 *********************************************************************
    private DB db = null;
    private TextView tvMainInfo = null;

    // 函数重载 *******************************************************************
    // 创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        tvMainInfo = (TextView)findViewById(R.id.tvMainInfo);
    }

    // 函数自定义 ******************************************************************
    // 创建数据库
    public void btnMainCreateDB_Click(View view)
    {
        Log.d("StudentMis","调用MainActivity.btnMainCreateDB_Click()");
        db = new DB(this,"dbStudentMis.db",null,1);

        Log.d("StudentMis","调用db.getReadableDatabase");
        db.getReadableDatabase();

    }

    // 插入数据1
    public void btnMainInsertData1_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        strSql = "insert into Student values('101','张三')";
        dbo.execSQL(strSql);

    }

    // 插入数据2
    public void btnMainInsertData2_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        strSql = "insert into Student values('102','李四')";
        dbo.execSQL(strSql);
    }

    // 删除数据1
    public void btnMainDeleteData1_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        strSql = "delete from Student where ID='101'";
        dbo.execSQL(strSql);

    }

    // 删除数据1
    public void btnMainDeleteData2_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        strSql = "delete from Student where ID='102'";
        dbo.execSQL(strSql);

    }

    // 显示数据
    public void btnMainShowData_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";
        strSql = "select * from Student";
        Cursor cursor;
        cursor = dbo.rawQuery(strSql,null);

        String strTemp = "";

        while (cursor.moveToNext())
        {
            String strID = "";
            String strName = "";
            strID = cursor.getString(cursor.getColumnIndex("ID"));
            strName = cursor.getString(cursor.getColumnIndex("Name"));

            if (strTemp == "")
            {
                strTemp = "[" + strID + "," + strName + "]";
            }
            else
            {
                strTemp += ",[" + strID + "," + strName + "]";
            }
        }

        tvMainInfo.setText(strTemp);

    }



}
