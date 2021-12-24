package com.example.ex10_ratingbar2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        // MainActivity에서 putExtra로 보낸 데이터를 받는다.
        Intent intent2 = getIntent();
        int[] voteResult = intent2.getIntArrayExtra("VoteCount");
        String[] imgName = intent2.getStringArrayExtra("ImageName");

        // 초기값 설정
        TextView tv[] = new TextView[imgName.length];
        RatingBar rBar[] = new RatingBar[imgName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rBarID[] = {R.id.rBar1, R.id.rBar2, R.id.rBar3, R.id.rBar4, R.id.rBar5,
                R.id.rBar6, R.id.rBar7, R.id.rBar8, R.id.rBar9};

        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rBar[i] = (RatingBar) findViewById(rBarID[i]);
        }
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imgName[i]);
            rBar[i].setRating((float) voteResult[i]);
        }


        // 가장 많이 투표받은 이미지 출력
        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        TextView resultText = findViewById(R.id.resultTv1);
        ImageView resultImg = findViewById(R.id.resultImg1);
        int max = -1;

        for (int i = 0; i < voteResult.length; i++) {
            if (max < voteResult[i]) {
                max = voteResult[i];
            }
            if (voteResult[i] == max) {
                if (i == 0) {
                    resultImg.setImageResource(imageFileId[0]);
                } else if (i == 1) {
                    resultImg.setImageResource(imageFileId[1]);
                } else if (i == 2) {
                    resultImg.setImageResource(imageFileId[2]);
                } else if (i == 3) {
                    resultImg.setImageResource(imageFileId[3]);
                } else if (i == 4) {
                    resultImg.setImageResource(imageFileId[4]);
                } else if (i == 5) {
                    resultImg.setImageResource(imageFileId[5]);
                } else if (i == 6) {
                    resultImg.setImageResource(imageFileId[6]);
                } else if (i == 7) {
                    resultImg.setImageResource(imageFileId[7]);
                } else if (i == 8) {
                    resultImg.setImageResource(imageFileId[8]);
                }
                resultText.setText(imgName[i]);
            }
        }
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}