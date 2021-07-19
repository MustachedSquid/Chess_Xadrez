package Main;

import Main.Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Board {
    private JPanel panel;
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JButton a5;
    private JButton a6;
    private JButton a7;
    private JButton a8;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton c1;
    private JButton c2;
    private JButton c3;
    private JButton c4;
    private JButton c5;
    private JButton c6;
    private JButton c7;
    private JButton c8;
    private JButton d1;
    private JButton d2;
    private JButton d3;
    private JButton d4;
    private JButton d5;
    private JButton d6;
    private JButton d7;
    private JButton d8;
    private JButton e1;
    private JButton e2;
    private JButton e3;
    private JButton e4;
    private JButton e5;
    private JButton e6;
    private JButton e7;
    private JButton e8;
    private JButton f1;
    private JButton f2;
    private JButton f3;
    private JButton f4;
    private JButton f5;
    private JButton f6;
    private JButton f7;
    private JButton f8;
    private JButton g1;
    private JButton g2;
    private JButton g3;
    private JButton g4;
    private JButton g5;
    private JButton g6;
    private JButton g7;
    private JButton g8;
    private JButton h1;
    private JButton h2;
    private JButton h3;
    private JButton h4;
    private JButton h5;
    private JButton h6;
    private JButton h7;
    private JButton h8;
    private JPanel teamColor;

    private JButton[][] buttons;
    //Game Vars
    private final Game game;
    private Piece pieceToMove;
    private String currentTeam;


    public Board() {

        //Set game vars
        game = new Game();
        currentTeam = "Black";
        //Make it look like windows 10 UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //Make form
        JFrame frame = new JFrame("gameWindow");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Chess");

        makeButtonArray();
    }

    private void makeButtonArray() {
        buttons = new JButton[][]{
                {a1, b1, c1, d1, e1, f1, g1, h1},
                {a2, b2, c2, d2, e2, f2, g2, h2},
                {a3, b3, c3, d3, e3, f3, g3, h3},
                {a4, b4, c4, d4, e4, f4, g4, h4},
                {a5, b5, c5, d5, e5, f5, g5, h5},
                {a6, b6, c6, d6, e6, f6, g6, h6},
                {a7, b7, c7, d7, e7, f7, g7, h7},
                {a8, b8, c8, d8, e8, f8, g8, h8}};


        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                final int finalI = i;
                final int finalJ = j;


                buttons[i][j].addActionListener(e -> {


                    for (JButton[] button : buttons) {
                        for (JButton jButton : button) {
                            jButton.setBackground(null);
                        }
                    }

                    String[][] colors = game.getColorArea();

                    for (int k = 0; k < colors.length; k++) {
                        for (int l = 0; l < colors[k].length; l++) {

                            if (colors[k][l].equals("Black")) {
                                buttons[k][l].setForeground(Color.white);
                                buttons[k][l].setBackground(Color.black);
                            } else if (colors[k][l].equals("White")) {
                                buttons[k][l].setForeground(Color.black);
                                buttons[k][l].setBackground(Color.white);
                            }


                        }

                    }
                    String initial = buttons[finalI][finalJ].getText();

                    if (initial.trim().equals("")) {

                        for (JButton[] button : buttons) {
                            for (JButton jButton : button) {

                                for (ActionListener al : jButton.getActionListeners()) {
                                    jButton.removeActionListener(al);
                                }
                            }
                        }
                    }
                    if (!initial.trim().equals("")) {
                        for (JButton[] button : buttons) {
                            for (JButton jButton : button) {

                                for (ActionListener al : jButton.getActionListeners()) {
                                    if (jButton.getText().equals("")) {
                                        jButton.removeActionListener(al);

                                    }
                                }
                            }
                        }
                        buttons[finalI][finalJ].setBackground(Color.GREEN);
                        pieceToMove = game.getPieceAtLocation(finalI, finalJ);

                        boolean[][] validMoves = pieceToMove.getValidMoves(game);


                        for (int k = 0; k < validMoves.length; k++) {
                            for (int l = 0; l < validMoves[k].length; l++) {
                                final int finalK = k;
                                final int finalL = l;
                                ActionListener actionListener = e9 -> {

                                    pieceToMove.move(finalK, finalL, game);
                                    game.changeCurrentTeam();
                                    currentTeam = game.getCurrentTeam();
                                    for (JButton[] button : buttons) {
                                        for (JButton jButton : button) {
                                            jButton.setBackground(null);
                                            for (ActionListener al : jButton.getActionListeners()) {
                                                jButton.removeActionListener(al);
                                            }

                                        }
                                    }
                                    updateForm();


                                };
                                if (pieceToMove != null) {
                                    if (validMoves[k][l] && pieceToMove.getTeam().equals(currentTeam)) {
                                        buttons[k][l].setBackground(Color.YELLOW);


                                        buttons[k][l].addActionListener(actionListener);


                                    } else {
                                        buttons[k][l].removeActionListener(actionListener);
                                    }
                                } else {
                                    buttons[k][l].removeActionListener(actionListener);

                                }

                            }
                        }

                    } else {
                        updateForm();
                    }
                });
            }
        }
    }


    public void updateForm() {
        makeButtonArray();
        String[][] area = game.getGameArea();

        String[][] colors = game.getColorArea();
        currentTeam = game.getCurrentTeam();
        System.out.println(currentTeam);
        if (game.getCurrentTeam().equals("Black")) {

            teamColor.setBackground(Color.black);
        } else {
            teamColor.setBackground(Color.white);
        }

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {

                buttons[i][j].setText(area[i][j]);
                if (colors[i][j].equals("Black")) {
                    buttons[i][j].setForeground(Color.white);
                    buttons[i][j].setBackground(Color.black);
                } else if (colors[i][j].equals("White")) {
                    buttons[i][j].setForeground(Color.black);
                    buttons[i][j].setBackground(Color.white);
                }


            }

        }


    }


}
