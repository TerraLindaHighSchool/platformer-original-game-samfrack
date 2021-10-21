import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Airplane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Airplane extends Obstacle
{
    private float xVelocity;
    private final float FLYING_SPEED;
    
    public Airplane(float flyingSpeed)
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
