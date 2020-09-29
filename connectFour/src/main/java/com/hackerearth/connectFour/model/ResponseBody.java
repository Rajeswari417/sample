package com.hackerearth.connectFour.model;

public class ResponseBody {
    private  ConnectFour connectFour;
    private  String status;

    public ConnectFour getConnectFour() {
        return connectFour;
    }

    public void setConnectFour(ConnectFour connectFour) {
        this.connectFour = connectFour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
