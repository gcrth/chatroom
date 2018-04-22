package cn.gcrth.chatroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.gcrth.chatroom.dao.DaoSession;
import cn.gcrth.chatroom.dao.MassageDao;
import cn.gcrth.chatroom.entity.Massage;

public class MainActivity extends AppCompatActivity {

    private final String userfrom="userfrom",userto="userto";////////////
    private long id=500;

    private List<Msg> msgList = new ArrayList<Msg>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    private MassageDao massageDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        massageDao = daoSession.getMassageDao();

        setUpViews();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行
                    inputText.setText(""); // 清空输入框中的内容

                }
            }
        });
    }

    private void setUpViews(){
        initMsgs(); // 初始化消息数据!!!!!!!!!!!!db
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
    }

    private void initMsgs() {///////////////////////
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    private void addmessagetodb(String content) {
        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        Date date=new Date();
        Massage massage=new Massage(id++,userfrom,userto, date.toString(),content);
        massageDao.insert(massage);
    }

}
