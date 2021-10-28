import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Obstacle
{
    private float yVelocity;
    private final float GRAVITY;
    
    public Meteor(float gravity)
    {
        GRAVITY = gravity;
    }
    
    public void act()
    {
        fall();
        removeOutOfBounds(this);
    }
    
    protected void fall()
    {
        yVelocity += GRAVITY;
        setLocation(getX(), getY() + (int) yVelocity);

    }
}
