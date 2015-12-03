package com.arena.model;

import com.arena.model.common.Printer;
import com.arena.model.player.Player;

/**
 * Created by jason on 15-11-28.
 */
public class Arena {
    private Player playerA;
    private Player playerB;
    private Player winner;
    private Printer printer;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }



    public void start() {
        while (true) {
            if (playerA.isAlive()) {
                printer.printToConsol( playerA.attack(playerB));
            }
            if (playerB.isAlive()) {
                printer.printToConsol( playerB.attack(playerA));
            }
            if (!playerB.isAlive()) {
                setWinner(playerA);
                printer.printToConsol(playerB.getName() + "被打败了");
                break;
            }
            if (!playerA.isAlive()) {
                setWinner(playerB);
                printer.printToConsol(playerA.getName() + "被打败了");
                break;
            }
        }
    }

    public Player getWinner() {
        return winner;
    }

    private void setWinner(Player winner) {
        this.winner = winner;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
