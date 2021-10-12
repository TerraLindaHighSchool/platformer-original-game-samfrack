import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private final float GRAVITY = 0.1f;
    private final GreenfootSound MUSIC = new 
                  GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 4;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_POWERUP = 3;
    private int MAX_HEALTH = 5;
    private final Class NEXT_LEVEL = WinSplash.class;
    
    
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
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
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,989,664);
        removeObject(smBrickWall);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,1141,561);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,1001,456);
        trapDoor.setLocation(835,660);
        trapDoor.setLocation(844,573);
        trapDoor.setLocation(823,572);
        removeObject(trapDoor);
        smBrickWall6.setLocation(939,585);
        smBrickWall8.setLocation(1091,438);
        removeObject(smBrickWall7);
        smBrickWall8.setLocation(1092,459);
        smBrickWall3.setLocation(266,280);
        bomb3.setLocation(189,239);
        smBrickWall4.setLocation(480,161);
        smBrickWall4.setLocation(471,160);
        bomb3.setLocation(219,232);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.003)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
        
        if(Math.random() < 0.004)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
}
