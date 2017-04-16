package com.bing.lan.lambdademo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLambda1() {
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
        players.forEach((player) -> System.out.print(player + ";----------\n"));

        players.forEach((player1) -> System.out.print(player1 + "-------------\n"));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    @Test
    public void testLambda2() {
        // 使用匿名内部类
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.setListener(() -> System.out.print("I am a listener \n"));

        // lambdaTest.setListener(new LambdaTest.LambdaListener() {
        //     @Override
        //     public void listener() {
        //         System.out.print("I am a listener");
        //     }
        // });
        //
        // lambdaTest.setListener(new LambdaTest.LambdaListener() {
        //     @Override
        //     public void listener() {
        //         System.out.print("I am a listener");
        //         for (int i = 0; i < 5; i++) {
        //             System.out.print("I am a listener " + i + " \n");
        //         }
        //     }
        // });

        lambdaTest.setListener(() -> {
            System.out.print("I am a listener \n");
            for (int i = 0; i < 5; i++) {
                System.out.print("I am a listener " + i + " \n");
            }
        });
    }

    @Test
    public void testLambda3() {
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        // 1.2使用 lambda expression
        new Thread(() -> System.out.println("Hello world !")).start();

        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");

        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }

    @Test
    public void testLambda4() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        Arrays.sort(players, (s1, s2) -> (s1.compareTo(s2)));
    }

    @Test
    public void testLambda5() {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
                add(new Person("Elsdon", 2000));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
                add(new Person("Jarrod", 2000));
            }
        };

        System.out.println("所有程序员的姓名:");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getName(), p.getName()));
        phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getName(), p.getName()));
    }
}