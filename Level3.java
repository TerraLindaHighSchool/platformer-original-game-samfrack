import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private final float GRAVITY = 0.06f;
    private final GreenfootSound MUSIC = new 
                  GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.5f;
    private final int MAX_POWERUP = 3;
    private int MAX_HEALTH = 3;
    private final Class NEXT_LEVEL = WinSplash.class;
    
    
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level3()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }
    
    public void act()
    {
        spawn();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);
        Door door = new Door();
        addObject(door,1175,41);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, MAX_HEALTH, 
                MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,50,759);

        Rainbow rainbow = new Rainbow();
        addObject(rainbow,864,609);
        removeObject(rainbow);
        player.setLocation(78,689);
        player.setLocation(77,711);
        SmRainbow smRainbow = new SmRainbow();
        addObject(smRainbow,80,769);
        SmRainbow smRainbow2 = new SmRainbow();
        addObject(smRainbow2,404,714);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.003)
        {
            addObject(new Meteor(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
}
