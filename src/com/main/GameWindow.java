package com.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public class GameWindow {

    private static final long serialVersionUID = 240840600533728354L;

    public GameWindow(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);      //frame of the game window

        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);    //centers the game
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
