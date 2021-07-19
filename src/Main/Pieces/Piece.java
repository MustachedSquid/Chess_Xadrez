package Main.Pieces;

import Main.Game;

import java.util.Arrays;

public class Piece {

    private final String team;
    private boolean isAlive, firstMove;
    private int x, y;
    private final String initial;

    public Piece(String team, int x, int y, String initial) {
        this.team = team;
        this.isAlive = true;
        this.x = x;
        this.y = y;
        this.initial = initial;
        this.firstMove = true;
    }

    public void move(int x, int y, Game game) {
        try {
            if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                if (game.getPieceAtLocation(x, y).isAlive()) {
                    game.getPieceAtLocation(x, y).kill();
                    this.x = x;
                    this.y = y;
                    this.firstMove = false;

                }
            }
        } catch (NullPointerException ex) {
            this.x = x;
            this.y = y;
            this.firstMove = false;
        }

    }

    public boolean[][] getPawnMoves(Game game){

        boolean[][] result = new boolean[8][8];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], false);
        }

        int x = this.x;
        int y = this.y;

        try {
            if (team.equals("Black")) {
                if (firstMove) {
                    y++;
                    try {
                        if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                            result[x][y] = false;
                        }
                    } catch (NullPointerException ex) {
                        result[x][y] = true;
                    }

                }
                y++;
                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        result[x][y] = false;
                    }
                } catch (NullPointerException ex) {
                    result[x][y] = true;
                }


            } else {
                if (firstMove) {
                    y--;
                    try {
                        if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                            result[x][y] = false;
                        }
                    } catch (NullPointerException ex) {
                        result[x][y] = true;
                    }

                }
                y--;
                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        result[x][y] = false;
                    }
                } catch (NullPointerException ex) {
                    result[x][y] = true;
                }


            }

            y = this.y;
            if(team.equals("Black")){
                y++;
            }else{
                y--;
            }
            int newX = x-1;
            try {
                if (game.getPieceAtLocation(newX, y).getTeam().equals(getOppositeTeam())) {
                    result[newX][y] = true;
                }
            } catch (NullPointerException ex) {
                //k fine
            }
            newX = x+1;
            try {

                if (game.getPieceAtLocation(newX, y).getTeam().equals(getOppositeTeam())) {
                    result[newX][y] = true;
                }
            } catch (NullPointerException ex) {
                //k fine
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        return result;

    }

    public boolean[][] getRookMoves(Game game){

        boolean[][] result = new boolean[8][8];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], false);
        }

        int x = this.x;
        int y = this.y;


        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                y++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                y--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        return result;

    }

    public boolean[][] getKnightMoves(Game game){

        boolean[][] result = new boolean[8][8];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], false);
        }

        int x = this.x;
        int y = this.y;

        try {
            x = this.x;
            y = this.y;

            y -= 2;
            x -= 1;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            y -= 2;
            x += 1;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
            x = this.x;
            y = this.y;

            y += 2;
            x -= 1;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            y += 2;
            x += 1;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }


        try {
            x = this.x;
            y = this.y;

            y -= 1;
            x -= 2;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            y += 1;
            x -= 2;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }


        try {
            x = this.x;
            y = this.y;

            y -= 1;
            x += 2;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            y += 1;
            x += 2;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }


            } catch (NullPointerException ex) {
                result[x][y] = true;


            }


        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        return result;
    }

    public boolean[][] getBishopMoves(Game game){

        boolean[][] result = new boolean[8][8];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], false);
        }

        int x = this.x;
        int y = this.y;

        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x++;
                y++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x++;
                y--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x--;
                y++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x--;
                y--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        return result;
    }

    public boolean[][] getQueenMoves(Game game){

        boolean[][] result = new boolean[8][8];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], false);
        }

        int x = this.x;
        int y = this.y;


        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x++;
                y++;

                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x++;
                y--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                y++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                y--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x--;
                y++;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;
            boolean move = true;

            for (int i = 0; i < 8; i++) {


                x--;
                y--;


                try {
                    if (game.getPieceAtLocation(x, y).getTeam().equals(this.team)) {
                        move = false;
                    }
                    if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                        if (move) {
                            result[x][y] = true;
                        }
                        move = false;
                    }

                } catch (NullPointerException ex) {
                    if (move) {
                        result[x][y] = true;

                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        return result;
    }

    public boolean[][] getKingMoves(Game game){

        boolean[][] result = new boolean[8][8];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], false);
        }

        int x = this.x;
        int y = this.y;


        try {
            x = this.x;
            y = this.y;

            x++;
            y++;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            x++;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            x++;
            y--;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            y++;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            y--;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            x--;
            y++;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            x--;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            x = this.x;
            y = this.y;

            x--;
            y--;

            try {
                if (game.getPieceAtLocation(x, y).getTeam().equals(getOppositeTeam())) {
                    result[x][y] = true;
                }
            } catch (NullPointerException ex) {
                result[x][y] = true;
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        return result;
    }

    public boolean[][] getValidMoves(Game game) {

        boolean[][] result = new boolean[8][8];

        switch (initial) {
            case "P":

                result = getPawnMoves(game);

                break;

            case "K":

                result = getKingMoves(game);

                break;
            case "Q":

                result = getQueenMoves(game);

                break;
            case "R":

                result = getRookMoves(game);

                break;

            case "B":

                result = getBishopMoves(game);

                break;

            case "N": //KNIGHTS

                result = getKnightMoves(game);

                break;
        }

        return result;

    }

    public String getOppositeTeam() {
        if (this.team.equals("Black")) {
            return "White";

        } else {
            return "Black";
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getInitial() {
        return initial;
    }


    public String getTeam() {
        return team;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
    }
}
