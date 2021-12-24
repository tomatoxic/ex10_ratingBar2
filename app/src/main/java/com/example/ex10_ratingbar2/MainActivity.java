package com.example.ex10_ratingbar2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++) {
            voteCount[i] = 0;
        }

        ImageView img[] = new ImageView[9];
        Integer imgId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르앙", "잠자는 소녀", "테라스의 두 자매",
                "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};

        // 이미지를 클릭할 때마다 해당 이미지의 투표수가 증가하도록 onClickListner 설정
        for (int i = 0; i < imgId.length; i++) {
            final int index = i; // 반드시 필요함!! // 내부 클래스 사용위해 final 선언
            img[index] = (ImageView) findViewById(imgId[index]);
            img[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트에 ResultActivity.java 연결
                Intent intent1 = new Intent(MainActivity.this, ResultActivity.class);
                // 인텐트에 투표 수 배열과 그림 이름 배열을 넣는다
                intent1.putExtra("VoteCount", voteCount);
                intent1.putExtra("ImageName", imgName);
                // 인텐트 실행
                startActivity(intent1);
            }
        });


    }
}