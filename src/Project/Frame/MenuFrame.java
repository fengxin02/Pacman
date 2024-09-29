package Project.Frame;

import Project.Layout.MenuLayout;

import javax.swing.*;
import java.awt.*;

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

        root.setLayout(new MenuLayout());

        JLabel title = new JLabel("PAC-MAN");
        title.setFont(new Font("Copper Black", Font.BOLD, 50));
        root.add(title);

        root.revalidate();
        root.repaint();

        //Start button
        root.add(new JButton("Start"));
        //Leaderboard button
        root.add(new JButton("Leaderboard"));
        //Exit button
        root.add(new JButton("Exit"));
        root.setVisible(true);
        root.revalidate();
        root.repaint();
    }


}
