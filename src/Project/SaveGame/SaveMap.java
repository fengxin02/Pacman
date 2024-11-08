package Project.SaveGame;

import Project.Character.GameElement;
import Project.Frame.MenuFrame;
import Project.Layout.MenuLayout;
import Project.Panel.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//saves the game to JSON
public class SaveMap {
    JFrame menu;
    public SaveMap(GameElement[][] map, JFrame menuFrame) {
        menu = menuFrame;



        // save somehow



        //end the game with first elem be null
        map[0][0] = null;

        //not a good solution to copy and paste the hole code to there, i need to write a new class
        //for Menu JPanel ini
        JPanel root = new JPanel();
        menu.add(root);
        menu.setContentPane(root);
        root.setFocusable(true);
        root.setLayout(new MenuLayout());
        root.setBackground(Color.BLACK);
        menu.setVisible(true);
        JLabel title = new JLabel("PAC-MAN");
        title.setFont(new Font("Copper Black", Font.BOLD, 50));
        title.setForeground(new Color(230,242,86));
        root.add(title);

        root.revalidate();
        root.repaint();

        //Start button
        JButton startButton = new JButton("Start");
        root.add(startButton);
        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                root.removeAll();
                root.revalidate();
                root.repaint();
                menuFrame.remove(root);
                GamePanel game = new GamePanel(menuFrame);
                //check if everything is done
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        game.startGame();
                    }
                });
            }
        });

        //Leaderboard button
        JButton leaderBoardButton = new JButton("Load Game"); //leaderboard
        root.add(leaderBoardButton);
        leaderBoardButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Leaderboard Button clicked");
            }
        });


        //Exit button
        JButton exitButton = new JButton("Exit");
        root.add(exitButton);
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //?????????????????????
                System.out.println("Exit Button clicked");
                System.exit(0);
            }
        });

        root.setVisible(true);
        root.revalidate();
        root.repaint();


    }
}
