package com.example.pc.intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitActivity extends AppCompatActivity {

    private EditText textFirstName;
    private EditText textLastName;
    private TextView textFeedback;

    public static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        this.textFirstName = (EditText)this.findViewById(R.id.text_firstName);
        this.textLastName = (EditText)this.findViewById(R.id.text_lastName);
        this.textFeedback = (TextView)this.findViewById(R.id.text_feedback);
    }

    // Khi GreetingActivity hoàn thành, nó gửi phản hồi lại.
    // (Nếu bạn đã start nó bằng cách sử dụng startActivityForResult()  )
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE ) {
            String feedback = data.getStringExtra("feedback");
            this.textFeedback.setText(feedback);
        } else {
            this.textFeedback.setText("!?");
        }
    }

    // Phương thức được gọi khi người dùng click vào
    // button "Show Greeting".
    public void showGreeting(View view)  {
        String firstName= this.textFirstName.getText().toString();
        String lastName= this.textLastName.getText().toString();

        Intent intent = new Intent(this,GreetingActivity.class);
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);

        // Yêu cầu start Activity chỉ định trong Intent.
        // (Gửi yêu cầu mà không cần phản hồi).
        // this.startActivity(intent);

        // Yêu cầu start Activity và chờ phản hồi.
        this.startActivityForResult(intent, MY_REQUEST_CODE);
    }
}
