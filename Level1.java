import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.1f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
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
        Player player = new Player();
        addObject(player,50,759);

        Floor floor = new Floor();
        addObject(floor,600,792);
        BrickWall brickWall = new BrickWall();
        addObject(brickWall,960,100);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,569,664);
        TrapDoor trapDoor = new TrapDoor(GRAVITY);
        addObject(trapDoor,869,664);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,1139,498);
        BrickWall brickWall3 = new BrickWall();
        addObject(brickWall3,662,384);
        TrapDoor trapDoor2 = new TrapDoor(GRAVITY);
        addObject(trapDoor2,191,315);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,58,311);
        removeObject(trapDoor2);
        removeObject(smBrickWall2);

        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,153,245);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,384,104);
        TrapDoor trapDoor3 = new TrapDoor(GRAVITY);
        addObject(trapDoor3,660,99);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,1140,238);
        Bomb bomb = new Bomb(GRAVITY);
        addObject(bomb,613,618);
        Bomb bomb2 = new Bomb(GRAVITY);
        addObject(bomb2,659,337);
        Bomb bomb3 = new Bomb(GRAVITY);
        addObject(bomb3,116,198);
        Powerup powerup = new Powerup();
        addObject(powerup,1103,201);
        Powerup powerup2 = new Powerup();
        addObject(powerup2,1165,200);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.007)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
        
        if(Math.random() < 0.001)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
}
