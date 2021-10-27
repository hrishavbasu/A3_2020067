package com.hb;

import java.util.*;

class SnakeNLadder {

    final static int WINPOINT = 14;


    static Map<Integer, Integer> Kingcob = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> elevator = new HashMap<Integer, Integer>();

    {
        snake.put(5, 1);
        Kingcob.put(11, 3);

        elevator.put(2, 10);
        ladder.put(8, 12);
    }
    public int rollDice()
    {
        int n = 0; int k =0;
        Random r = new Random();
        n=r.nextInt(2);
        k=n+1;
        return (k);
    }
    public int calculateplayerpos(int player, int dicevalue, int player_val){

        player = player + dicevalue;
        if(player > WINPOINT)
        {
            player = player - dicevalue;
            return player;
       }
        if(null!=Kingcob.get(player)){
            System.out.println("swallowed by King cobra");
            player= Kingcob.get(player);
            return player;
        }
        if(null!=snake.get(player)){
            System.out.println("swallowed by snake");
            player= snake.get(player);

            return player;
        }
         if(null!=ladder.get(player)){
            System.out.println("the player has reached a ladder floor.");
            player= ladder.get(player);
            return player;
        }
        if(null!=elevator.get(player)){
            System.out.println("the player has reached a elevator floor.");
            player= elevator.get(player);
            return player;
        }
        else{
            System.out.println("the player has reached a empty floor.");
        }
        return player;

    }
    public int calculateplayervalue(int player, int dicevalue, int player_val) {

        player = player + dicevalue;

        if (null != Kingcob.get(player)) {
            player_val = player_val - 4;
            return player_val;
        }
        if (null != snake.get(player)) {
            player_val = player_val - 2;
            return player_val;
        }
        if (null != ladder.get(player)) {
            player_val = player_val + 2;
            return player_val;
        }
        if (null != elevator.get(player)) {
            player_val = player_val + 4;
            return player_val;
        } else {
            player_val = player_val + 1;
            return player_val;
        }
    }
    public boolean isWin(int player)
    {
        return WINPOINT == player;
    }
    public void startGame()
    {
        int player =0;
        int player_value=0;
        Scanner s = new Scanner(System.in);
        String str;
        int dicevalue =0;
        do
        {

            System.out.println("Hit enter to roll Dice");
            str = s.nextLine();
            dicevalue = rollDice();



            player = calculateplayerpos(player,dicevalue,player_value);
            player_value=calculateplayervalue(player-dicevalue,dicevalue,player_value);
            System.out.println("player position :: " + player);
            System.out.println("dice vale:: "+dicevalue);
            System.out.println("Total points :: "+ player_value);
            if(isWin(player))
            {
                System.out.println("Game over");
                System.out.println("total points accumulated"+player_value);
                break;
            }

        }while(true);
    }

}
class player{
    private String name;
    private int position;
    // setter func
    public void setName(String naam){
        name = naam;
    }
    public void setPosition(int pos){
        position = pos;
    }
}

public class Main {

    public static void main(String[] args) {
        player obj = new player();
        System.out.println("Enter player name and hit enter: ");
        Scanner sc = new Scanner(System.in);
        String naam= sc.nextLine();
        obj.setName(naam);
        SnakeNLadder obj1 = new SnakeNLadder();
       while(true) {

        int k=obj1.rollDice();
           if(k==1){
                System.out.println(k);
                SnakeNLadder s = new SnakeNLadder();
                s.startGame();
            }

        }

    }
}
