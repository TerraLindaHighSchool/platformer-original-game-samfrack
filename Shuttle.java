import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shuttle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle extends Obstacle
{
    private float xVelocity;
    private final float FLYING_SPEED;
    
    public Shuttle(float flyingSpeed)
    {
        FLYING_SPEED = flyingSpeed;
    }
    
    public void act()
    {
       fall();
    }
    
    protected void fall()
    {
        xVelocity += FLYING_SPEED;
        setLocation(getX() + (int) xVelocity, getY());
    }
}
