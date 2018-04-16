package cn.gcrth.chatroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsend=null;
    EditText messagetosend=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsend=this.findViewById(R.id.btnsend);
        messagetosend=this.findViewById(R.id.messagetosend);
        btnsend.setOnClickListener(new View.OnClickListener(){
            private int counter=0;
            public void onClick(View v) {
                Button clickedButton=(Button)v;
                counter++;
                //在手机上显示短暂的信息
                Toast info=Toast.makeText(MainActivity.this, "Button "+v.getId()+" has been clicked "+ counter + " times!", Toast.LENGTH_SHORT);
                info.setDuration(100);
                info.show();




            }
        });
    }


}
