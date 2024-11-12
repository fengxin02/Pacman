package Project.Layout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameOverLayout extends LayoutAdapter{
    //stores the objects, and add to the panel
    List<Component> lis = new ArrayList<Component>();
    @Override
    public void addLayoutComponent(Component comp, Object constraints)
    {
        lis.add(comp);
    }

    @Override
    public void removeLayoutComponent(Component comp)
    {
        lis.remove(comp);
    }

    @Override
    public void layoutContainer(Container parent)
    {
        //testing is code running or not
        System.out.println("layoutContainer runs");
        int width = parent.getWidth();
        int height = parent.getHeight();
        int x = width / 2;
        int y = 30;
        for(Component comp : lis)
        {
            if(comp instanceof JLabel)
            {
                comp.setBounds(x-125, y, 300,80);
                y+=100;
            }
            else
            {
                comp.setBounds(x-65, y, 130, 80);
                y += 100;
            }

        }
    }

}
