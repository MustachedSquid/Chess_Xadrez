package Main;

import Main.Pieces.*;

import java.util.Arrays;

public class Game {

    private final String[][] gameArea;
    private final String[][] colorArea;
    private final King[] kings;
    private final Queen[] queens;
    private final Bishop[] bishops;
    private final Knight[] knights;
    private final Rook[] rooks;
    private final Pawn[] pawns;

    private String currentTeam;

    public Game() {

        currentTeam = "White";
        gameArea = new String[8][8];
        colorArea = new String[8][8];
        kings = new King[2];
        queens = new Queen[2];
        bishops = new Bishop[4];
        rooks = new Rook[4];
        knights = new Knight[4];
        pawns = new Pawn[16];

        String black = "Black";
        String white = "White";

        for (String[] strings : gameArea) {
            Arrays.fill(strings, "");
        }
        for (int i = 0; i < gameArea.length; i++) {
            for (int j = 0; j < gameArea[i].length; j++) {
                colorArea[i][j] = "";
            }
        }


        for (int i = 0; i < 8; i++) {
            pawns[i] = new Pawn(black, i, 1);
        }
        for (int i = 0; i < 8; i++) {
            pawns[i + 8] = new Pawn(white, i, 6);
        }

        rooks[0] = new Rook(black, 0, 0);
        rooks[1] = new Rook(black, 7, 0);
        rooks[2] = new Rook(white, 0, 7);
        rooks[3] = new Rook(white, 7, 7);

        knights[0] = new Knight(black, 1, 0);
        knights[1] = new Knight(black, 6, 0);
        knights[2] = new Knight(white, 1, 7);
        knights[3] = new Knight(white, 6, 7);

        bishops[0] = new Bishop(black, 2, 0);
        bishops[1] = new Bishop(black, 5, 0);
        bishops[2] = new Bishop(white, 2, 7);
        bishops[3] = new Bishop(white, 5, 7);

        queens[0] = new Queen(black, 3, 0);
        queens[1] = new Queen(white, 3, 7);

        kings[0] = new King(black, 4, 0);
        kings[1] = new King(white, 4, 7);
    }


    public void updateGame() {
        for (int i = 0; i < gameArea.length; i++) {
            for (int j = 0; j < gameArea[i].length; j++) {
                gameArea[i][j] = "";
                colorArea[i][j] = "";
            }
        }

        for (Pawn pawn : pawns) {
            if (pawn.isAlive()) {
                gameArea[pawn.getX()][pawn.getY()] = pawn.getInitial();
                colorArea[pawn.getX()][pawn.getY()] = pawn.getTeam();

            }
        }

        for (King king : kings) {
            if (king.isAlive()) {
                gameArea[king.getX()][king.getY()] = king.getInitial();
                colorArea[king.getX()][king.getY()] = king.getTeam();
            }
        }

        for (Queen queen : queens) {
            if (queen.isAlive()) {
                gameArea[queen.getX()][queen.getY()] = queen.getInitial();
                colorArea[queen.getX()][queen.getY()] = queen.getTeam();
            }
        }
        for (Rook rook : rooks) {
            if (rook.isAlive()) {
                gameArea[rook.getX()][rook.getY()] = rook.getInitial();
                colorArea[rook.getX()][rook.getY()] = rook.getTeam();
            }
        }
        for (Knight knight : knights) {
            if (knight.isAlive()) {
                gameArea[knight.getX()][knight.getY()] = knight.getInitial();
                colorArea[knight.getX()][knight.getY()] = knight.getTeam();
            }
        }

        for (Bishop bishop : bishops) {
            if (bishop.isAlive()) {
                gameArea[bishop.getX()][bishop.getY()] = bishop.getInitial();
                colorArea[bishop.getX()][bishop.getY()] = bishop.getTeam();
            }
        }




    }

    public String[][] getGameArea() {
        updateGame();
        return gameArea;
    }

    public String[][] getColorArea() {
        updateGame();
        return colorArea;
    }


    public String getCurrentTeam() {

        return currentTeam;
    }

    public void changeCurrentTeam() {
        if(currentTeam.equals("Black")){
            currentTeam="White";
        }else{
            currentTeam="Black";
        }
    }

    public Piece getPieceAtLocation(int x, int y) {

        Piece pieceToMove = null;

        for (Pawn pawn : pawns) {
            if (pawn.isAlive()) {
                if (pawn.getX() == x && pawn.getY() == y) {
                    pieceToMove = pawn;
                }
            }
        }
        for (King king : kings) {
            if (king.isAlive()) {
                if (king.getX() == x && king.getY() == y) {
                    pieceToMove = king;
                }
            }
        }

        for (Queen queen : queens) {
            if (queen.isAlive()) {
                if (queen.getX() == x && queen.getY() == y) {
                    pieceToMove = queen;
                }
            }
        }
        for (Rook rook : rooks) {
            if (rook.isAlive()) {
                if (rook.getX() == x && rook.getY() == y) {
                    pieceToMove = rook;
                }

            }
        }
        for (Knight knight : knights) {
            if (knight.isAlive()) {
                if (knight.getX() == x && knight.getY() == y) {
                    pieceToMove = knight;
                }
            }
        }

        for (Bishop bishop : bishops) {
            if (bishop.isAlive()) {
                if (bishop.getX() == x && bishop.getY() == y) {
                    pieceToMove = bishop;
                }
            }
        }

        return pieceToMove;


    }


}
