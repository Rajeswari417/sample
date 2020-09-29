package com.hackerearth.connectFour.model;

import java.util.Arrays;

public class ConnectFour {
    private String status = "Ready";
    private String[][] grid;
    private String[] players = {"R", "Y"};
    private int lastTop = -1;
    private int lastCol = -1;
    private boolean isValidChoice = false;
    private  String gameStatus = null;
    private int width = 0;
    private int height = 0;
    private Integer choice= null ;
    private int playerId ;

    public int getPlayerId() {
        return playerId;
    }

    public String[] getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    public ConnectFour() {}

    public ConnectFour(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new String[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i] = new String[width], "0");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }



    public int getLastTop() {
        return lastTop;
    }

    public void setLastTop(int lastTop) {
        this.lastTop = lastTop;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public boolean isValidChoice() {
        return isValidChoice;
    }

    public void setValidChoice(boolean validChoice) {
        isValidChoice = validChoice;
    }

    public String getGamestatus() {
        return gameStatus;
    }

    public void setGamestatus(String gamestatus) {
        this.gameStatus = gamestatus;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
