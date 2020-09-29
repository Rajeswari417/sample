package com.hackerearth.connectFour.service;

import com.hackerearth.connectFour.model.ConnectFour;
import com.hackerearth.connectFour.model.ResponseBody;
import com.hackerearth.connectFour.utilities.Constants;
import org.springframework.stereotype.Service;

@Service
public class ConnectFourService {

    public ConnectFour isValidChoice(ConnectFour connectFour) {
        boolean isColFilled = true;
        String[][] grid = connectFour.getGrid();
        Integer choice = connectFour.getChoice();
        if ( choice!= null && 0 <= choice && choice < connectFour.getWidth()) {
            connectFour.setValidChoice(true);
            connectFour.setLastCol(choice);
            for (int i = connectFour.getHeight() - 1; i >= 0; i--) {
                if (grid[i][choice].equals("0")) {
                    isColFilled = false;
                    grid[i][choice] = connectFour.getPlayers()[connectFour.getPlayerId()];
                    connectFour.setPlayerId(1-connectFour.getPlayerId());
                    connectFour.setLastTop(i);
                    connectFour.setGrid(grid);
                    break;
                }
            }
            if(isColFilled){
                connectFour.setGamestatus("Column"+connectFour.getChoice()+"is Filled");
            }
        } else {
            connectFour.setValidChoice(false);
        }
        return connectFour;
}


    public ConnectFour isWinningPlay(ConnectFour connectFour) {
        if(connectFour.getLastCol() == -1) {
          connectFour.setGamestatus(Constants.GAME_NOT_YET_STARTED);
            return connectFour;
        }

        String sym = connectFour.getGrid()[connectFour.getLastTop()][connectFour.getLastCol()];
       // String result =  sym+ sym+ sym+ sym;
        String result =  sym+ sym;
        printGrid(connectFour);
        int id = connectFour.getPlayerId();
        System.out.println("id ="+id);
       boolean sucess = contains(checkHorizontalCondition(connectFour), result) ||
              contains(checkVerticalCondition(connectFour), result) ||
               contains(checkSlashDiagonalCondition(connectFour), result) ||
                contains(checkBackslashDiagonalCondition(connectFour), result);
        if(sucess){
            connectFour.setGamestatus(connectFour.getPlayers()[connectFour.getPlayerId()]+Constants.WINS);
            return connectFour;
        }else{
            return connectFour;
        }
    }

    public static boolean contains(String str, String substring) {
        return str.indexOf(substring) >= 0;
    }

    public  String checkHorizontalCondition(ConnectFour connectFour){
        return new String(String.valueOf(connectFour.getGrid()[connectFour.getLastTop()]));
    }

    public String checkVerticalCondition(ConnectFour connectFour) {
        StringBuilder sb = new StringBuilder(connectFour.getHeight());

        for (int h = 0; h < connectFour.getHeight(); h++) {
            sb.append(connectFour.getGrid()[h][connectFour.getLastCol()]);
        }
        return sb.toString();
    }

    public String checkSlashDiagonalCondition(ConnectFour connectFour) {
        StringBuilder sb = new StringBuilder(connectFour.getHeight());
        for (int h = 0; h < connectFour.getHeight(); h++) {
            int w = connectFour.getLastCol() + connectFour.getLastTop() - h;

            if (0 <= w && w < connectFour.getWidth()) {
                sb.append(connectFour.getGrid()[h][w]);
            }
        }
        return sb.toString();
    }


    public String checkBackslashDiagonalCondition(ConnectFour connectFour) {
        StringBuilder sb = new StringBuilder(connectFour.getHeight());

        for (int h = 0; h < connectFour.getHeight(); h++) {
            int w = connectFour.getLastCol() - connectFour.getLastTop() + h;

            if (0 <= w && w < connectFour.getWidth()) {
                sb.append(connectFour.getGrid()[h][w]);
            }
        }

        return sb.toString();
    }



    public void printGrid(ConnectFour connectFour){
        for(int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                System.out.print(connectFour.getGrid()[i][j]);
                System.out.print("\t");
            }
            System.out.println();

        }
        System.out.println("**********************************************");
    }

}
