package com.bing.lan.lambdademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Unbinder mViewBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        mTv = (TextView) findViewById(R.id.tv);

       mViewBind = ButterKnife.bind(MainActivity.this);
    }

    public void testLambda() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    public void testLambda2() {
        // 使用匿名内部类
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.setListener(() -> System.out.print("I am a listener"));

        lambdaTest.setListener(new LambdaTest.LambdaListener() {
            @Override
            public void listener() {
                System.out.print("I am a listener");
            }
        });

        lambdaTest.setListener(new LambdaTest.LambdaListener() {
            @Override
            public void listener() {
                System.out.print("I am a listener");
                for (int i = 0; i < 5; i++) {
                    System.out.print("I am a listener " + i + " \n");
                }
            }
        });

        lambdaTest.setListener(() -> {
            System.out.print("I am a listener");
            for (int i = 0; i < 5; i++) {
                System.out.print("I am a listener " + i + " \n");
            }
        });
    }
}
