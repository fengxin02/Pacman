package Project.Layout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameOverLayout extends LayoutAdapter{
    //stores the objects, and add to the panel
    /**
     * Stores Component which is added
     */
    List<Component> lis = new ArrayList<Component>();

    /**
     * Add layouts
     * @param comp the component to be added
     * @param constraints  where/how the component is added to the layout.
     */
    @Override
    public void addLayoutComponent(Component comp, Object constraints)
    {
        lis.add(comp);
    }

    /**
     * remove layout
     * @param comp the component to be removed
     */
    @Override
    public void removeLayoutComponent(Component comp)
    {
        lis.remove(comp);
    }

    /**
     * set the layout
     * @param parent the container to be laid out
     */
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
