import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Obstacle
{
     private float yVelocity;
    private final float GRAVITY;
    
    public Rock(float gravity)
    {
        GRAVITY = gravity;
    }
    
    public void act()
    {
       fall();
    }
    
    protected void fall()
    {
        yVelocity += GRAVITY;
        setLocation(getX(), getY() + (int) yVelocity);
    }
}
