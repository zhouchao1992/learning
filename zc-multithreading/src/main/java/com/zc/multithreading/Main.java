package com.zc.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) throws Exception {
      /*  MyThread myThread = new MyThread();
        new Thread(myThread).start();*/
      /* FutureTask<Map<String,Object>> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        System.out.println("线程启动，准备执行！");
        Map<String,Object> call = futureTask.get();
        System.out.println("查询结果返回成功！");
        call.forEach((key,value)-> System.out.println("key:"+key+"------------->vlaue:"+value));
        System.err.println("-----------------------主线程执行完毕！-----------------------------");*/
    }

    public static  class MyCallable implements Callable{
        @Override
        public Object call() throws Exception {
            Map<String,Object> map = new HashMap<>();
            for (int i = 0; i <10 ; i++) {
                map.put(i+"", "knife4j是为Java MVC框架集成Swagger生成Api文档的增强解决方案（在非Java项目中也提供了前端UI的增强解决方案），前身是swagger-bootstrap-ui,取名knife4j是希望她能像一把匕首一样小巧,轻量,并且功能强悍!");
            }
            Thread.sleep(10000);
            return map;
        }
    }


    public  static  class  MyThread implements  Runnable{

        @Override
        public void run() {
            Map<String,Object> map = new HashMap<>();
            for (int i = 0; i <10 ; i++) {
                map.put(i+"", "knife4j是为Java MVC框架集成Swagger生成Api文档的增强解决方案（在非Java项目中也提供了前端UI的增强解决方案），前身是swagger-bootstrap-ui,取名knife4j是希望她能像一把匕首一样小巧,轻量,并且功能强悍!");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("数据查询完毕！");
        }
    }


    public void show(){

    }
}
