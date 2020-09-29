package com.hackerearth.connectFour.controller;

import com.hackerearth.connectFour.model.ConnectFour;
import com.hackerearth.connectFour.service.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectFourController {
    @Autowired
    ConnectFourService connectFourService;

    @GetMapping("/api")
    public  ConnectFour test(){
       return new ConnectFour();
    }

    @PostMapping("/post")
    public ConnectFour postTest(@RequestBody String name){
        ConnectFour connectFour = new ConnectFour(7,6);
        if(name.equals("Ready")){
        return  connectFourService.isValidChoice(connectFour);
        }else {
          return  connectFour;
        }
    }
    @PostMapping("/play")
    public ConnectFour playGame(@RequestBody ConnectFour connectFour){
        ConnectFour connectFour1 = connectFourService.isValidChoice(connectFour);
         connectFour1 = connectFourService.isWinningPlay(connectFour1);
        return  connectFour1;
    }


}
