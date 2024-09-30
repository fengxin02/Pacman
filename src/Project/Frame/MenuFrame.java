package Project.Frame;

import Project.GamePanel;
import Project.Layout.MenuLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame
{
    //root panel
    JPanel root = new JPanel();

    public MenuFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //size setting
        setSize(500,500);

        //put the frame to the middle of the screen
        setLocationRelativeTo(null);
        setContentPane(root);

        //Frame is visible
        setVisible(true);
    }
    public void startSetUp()
    {
        //set black background
        root.setBackground(Color.BLACK);

        root.setLayout(new MenuLayout());

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
               gamePanelIni();
            }
        });

        //Leaderboard button
        JButton leaderBoardButton = new JButton("Leaderboard");
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

    public void gamePanelIni()
    {
        //removes the buttons and labels in the panel
        root.removeAll();
        root.revalidate();
        root.repaint();
        GamePanel game = new GamePanel(root);


    }


}
