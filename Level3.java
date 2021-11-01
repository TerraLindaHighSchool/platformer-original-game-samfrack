import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private final float GRAVITY = 0.09f;
    private final GreenfootSound MUSIC = new 
                  GreenfootSound("newdawn.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.5f;
    private final int MAX_POWERUP = 3;
    private final float FLYING_SPEED = 0.05f; 
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
        Rainbow rainbow2 = new Rainbow();
        addObject(rainbow2,832,644);
        SmRainbow smRainbow3 = new SmRainbow();
        addObject(smRainbow3,841,506);
        SmRainbow smRainbow4 = new SmRainbow();
        addObject(smRainbow4,603,428);
        Rainbow rainbow3 = new Rainbow();
        addObject(rainbow3,237,354);
        SmRainbow smRainbow5 = new SmRainbow();
        addObject(smRainbow5,612,256);
        SmRainbow smRainbow6 = new SmRainbow();
        addObject(smRainbow6,1015,255);
        SmRainbow smRainbow7 = new SmRainbow();
        addObject(smRainbow7,1129,97);
        SmRainbow smRainbow8 = new SmRainbow();
        addObject(smRainbow8,244,196);
        SmRainbow smRainbow9 = new SmRainbow();
        addObject(smRainbow9,579,108);
        SmRainbow smRainbow10 = new SmRainbow();
        addObject(smRainbow10,866,120);
        removeObject(smRainbow10);
        removeObject(smRainbow9);
        Rainbow rainbow4 = new Rainbow();
        addObject(rainbow4,705,97);
        removeObject(smRainbow7);
        removeObject(smRainbow6);
        addObject(smRainbow6,877,286);
        addObject(smRainbow7,1103,180);
        removeObject(door);
        addObject(door,1152,120);
        removeObject(smRainbow5);
        addObject(new RainbowTrapdoor(GRAVITY),625, 250);
        Gem gem = new Gem();
        addObject(gem,1013,597);
        Gem gem2 = new Gem();
        addObject(gem2,876,239);
        Gem gem3 = new Gem();
        addObject(gem3,65,304);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.003)
        {
            addObject(new Meteor(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
        
        if(Math.random() < 0.003)
        {
            addObject(new Lander(GRAVITY), Greenfoot.getRandomNumber(1200), 
                      -30);
        }
        
        if(Math.random() < 0.005)
        {
            addObject(new Shuttle(FLYING_SPEED),     
                     -30, Greenfoot.getRandomNumber(740) + 30);
        }
    }
    
}
