package com.zhoujian.litepal.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.zhoujian.litepal.R;
import com.zhoujian.litepal.bean.Person;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private Button mCreateDatabase;
    private Button mAddData;
    private Button mUpdateData;
    private Button mDeleteButton;
    private Button mQueryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        clickEvents();
    }


    private void initViews()
    {
        mCreateDatabase = (Button) findViewById(R.id.create_database);
        mAddData = (Button) findViewById(R.id.add_data);
        mUpdateData = (Button) findViewById(R.id.update_data);
        mDeleteButton = (Button) findViewById(R.id.delete_data);
        mQueryButton = (Button) findViewById(R.id.query_data);
    }

    private void clickEvents()
    {
        mCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建数据库
                Connector.getDatabase();
            }
        });


        mAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person person = new Person();
                person.setId(1);
                person.setName("周润发");
                person.setAge(62);
                person.setWeight("80kg");
                person.save();

                person.clearSavedState();
                person.setId(2);
                person.setName("周杰伦");
                person.setAge(45);
                person.setWeight("65kg");
                person.save();

                person.clearSavedState();
                person.setId(3);
                person.setName("周星驰");
                person.setAge(65);
                person.setWeight("70kg");
                person.save();

                Toast.makeText(MainActivity.this, "添加数据成功", Toast.LENGTH_SHORT).show();
            }
        });

        mUpdateData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Person person = new Person();

                //把id = 3 的那个人 姓名更改为周建  年龄改为28   体重改为62kg
                person.setName("周建");
                person.setAge(28);
                person.setWeight("62kg");
                person.updateAll("id = ?", "3");

                Toast.makeText(MainActivity.this, "更新数据成功", Toast.LENGTH_SHORT).show();

            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //删除年龄大于60的人
                DataSupport.deleteAll(Person.class, "age > ?", "60");
                Toast.makeText(MainActivity.this, "删除数据成功", Toast.LENGTH_SHORT).show();
            }
        });



        mQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                List<Person> persons = DataSupport.findAll(Person.class);
                for (Person person: persons) {
                    Log.d("MainActivity", "person name is " + person.getName());
                    Log.d("MainActivity", "person weight is " + person.getWeight());
                    Log.d("MainActivity", "person age is " + person.getAge());
                    Log.d("MainActivity", "person id is " + person.getId());
                }

                Toast.makeText(MainActivity.this, "查询数据成功", Toast.LENGTH_SHORT).show();
            }
        });

        //https://github.com/zeke123/LitePalDemo.git

    }
}
