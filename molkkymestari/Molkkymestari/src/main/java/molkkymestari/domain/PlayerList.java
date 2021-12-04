package molkkymestari.domain;

import java.util.ArrayList;

public class PlayerList {
    ArrayList<Player> players;
    ArrayList<Player> playersForPointTable;
        
    public PlayerList() {
        
        this.players = new ArrayList<>();    
        this.playersForPointTable = new ArrayList<>();
    }
       
    public Player getPlayerWithIndex(int index) {
        
        Player player = this.players.get(index);
        return player;
    }

    public Player getPlayerWithName(String name) {
        
        int playersIndex = -1;
        for (int index = 0; index < this.players.size(); index++) {
                
            if (this.players.get(index).toString().equals(name)) {
                    
                playersIndex = index;
            }
        }
        if (playersIndex == -1) {
                
            return null;
        }
        return this.players.get(playersIndex);                       
    }
           
    
    public void addNewPlayer(String name) {
        
        //Lisää jokin tarkastus, jos sama nimi on jo käytössä
        Player newPlayer = new Player(name);
        this.players.add(newPlayer);
        this.playersForPointTable.add(newPlayer);
        
        int indexForThisGame = this.players.indexOf(newPlayer);
        newPlayer.setIndexInThisGame(indexForThisGame);        
        newPlayer.setPointsInThisGame(0);
        newPlayer.setMissedThrowsInThisGame(0);
        
        
    }
   
    public int getHowManyPointDoesPlayerHave(Player player) {
        
        return player.getPointsInThisGame();
    }
     
    public int getHowManyPlayers() {
        
        return this.players.size();
    }   
    
    public void removePlayer(Player player) {
        this.players.remove(player);
    }
    
    @Override
    public String toString() {
        
        if (this.players.isEmpty()) {
            
            return "Ei pelaajia";
        } else {
            
            String printOut = "";
            for (int index = 0; index < this.players.size(); index++) {
                
                printOut = printOut + this.players.get(index) + "\n";
            }
            return printOut;
        }
    } 
    
}
