package com.example.productlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApp {
    private Mycomponent mycomponent;
    @Autowired
   public MyApp(Mycomponent mycomponent){
        this.mycomponent=mycomponent;
    }
    public void run(){
      mycomponent.getMessage();
    }
}
