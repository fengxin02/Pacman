package Project.Layout;

import java.awt.*;
//use for not overriding all the methods in LayoutManager
public abstract class LayoutAdapter implements LayoutManager2
{

    @Override
    public void addLayoutComponent(String name, Component comp) {}

    @Override
    public void removeLayoutComponent(Component comp) {}

    @Override
    public void layoutContainer(Container parent) {}

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(0, 0); //return default size
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(0, 0); //return default size
    }

    @Override
    public Dimension maximumLayoutSize(Container parent) {
        return new Dimension(0, 0); //return default size
    }

    @Override
    public float getLayoutAlignmentX(Container parent) {
        return 0.5f; //return default size
    }

    @Override
    public float getLayoutAlignmentY(Container parent) {
        return 0.5f; //return default size
    }

    @Override
    public void invalidateLayout(Container parent) {}

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {}
}
