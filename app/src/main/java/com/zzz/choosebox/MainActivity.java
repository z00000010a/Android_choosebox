package com.zzz.choosebox;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("选择是或者否");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"---是---",Toast.LENGTH_SHORT);
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "---否---", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void click2(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("选择你的性别");
        final String[] items={"男","女"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"您的性别"+ items[which],Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }
    public void click3(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("选择水果");
        final String[] items={"苹果","梨","桃","香蕉"};
        final boolean[] checkeds={true,false,true,false};
        builder.setMultiChoiceItems(items, checkeds, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this,items[which]+isChecked,Toast.LENGTH_SHORT);
            }
        });
        builder.setPositiveButton("提交", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < checkeds.length; i++) {
                    if (checkeds[i]==true){
                        sb.append(items[i]+" ");
                    }
                }
                Toast.makeText(MainActivity.this,"你喜欢吃 ："+sb.toString(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void click4(View view){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("进度条");
        pd.setMessage("正在读取...");
        pd.show();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pd.dismiss();
            }
        }.start();
    }
    public void click5(View view){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("进度条");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在读取...");
        pd.setMax(100);
        pd.show();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <100; i++) {
                    try {
                        Thread.sleep(200);
                        pd.setProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pd.dismiss();
            }
        }.start();
    }

}
