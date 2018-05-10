package com.example.pc.intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    private String firstName;
    private String lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        // Intent truyền sang.
        Intent intent = this.getIntent();

        this.firstName= intent.getStringExtra("firstName");
        this.lastName = intent.getStringExtra("lastName");

        String greeting = "Hello "+ firstName+" "+ lastName;

        TextView textGreeting =(TextView) this.findViewById(R.id.text_greeting);

        textGreeting.setText(greeting);
    }

    // Khi Activity này hoàn thành,
    // có thể cần gửi phản hồi gì đó về cho Activity đã gọi nó
    @Override
    public void finish() {

        // Chuẩn bị dữ liệu Intent.
        Intent data = new Intent();
        data.putExtra("feedback", "I'm "+ this.firstName+", Hi!");

        // Activity đã hoàn thành OK, trả về dữ liệu.
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }

    // Phương thức được gọi khi người dùng nhấn vào nút Back.
    public void backClicked(View view)  {
        // Gọi phương thức onBackPressed().
        this.onBackPressed();

    }
}
