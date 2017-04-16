package com.bing.lan.lambdademo;

/**
 * Created by Administrator on 2017/4/7.
 */

public class LambdaTest {

    public void setListener(LambdaListener listener) {

        if (listener != null) {
            System.out.print("listener is not null \n");
            listener.listener();
        } else {
            System.out.print("listener is null \n");
        }
    }

    public interface LambdaListener {

          void listener();


    }
}
