import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private final float GRAVITY = 0.11f;
    private final GreenfootSound MUSIC = new 
                  GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_POWERUP = 4;
    private int MAX_HEALTH = 3;
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
        removeObject(brickWall2);
        removeObject(smBrickWall6);
        removeObject(smBrickWall7);
        removeObject(brickWall3);
        removeObject(smBrickWall5);
        removeObject(powerup);
        removeObject(powerup2);
        removeObject(brickWall);
        removeObject(door);
        smBrickWall4.setLocation(530,147);
        removeObject(trapDoor3);
        removeObject(smBrickWall7);
        removeObject(smBrickWall4);
        removeObject(smBrickWall3);
        removeObject(bomb3);
        removeObject(bomb2);
        removeObject(bomb);
        BrickWall2 brickWall22 = new BrickWall2();
        addObject(brickWall22,416,683);
        BrickWall2 brickWall23 = new BrickWall2();
        addObject(brickWall23,893,630);
        BrickWallLong brickWallLong = new BrickWallLong();
        addObject(brickWallLong,536,491);
        addObject(smBrickWall3,845,387);
        BrickWall2 brickWall24 = new BrickWall2();
        addObject(brickWall24,544,276);
        removeObject(brickWall24);
        removeObject(brickWallLong);
        addObject(smBrickWall4,591,535);
        removeObject(smBrickWall3);
        addObject(brickWallLong,503,524);
        removeObject(smBrickWall4);
        addObject(smBrickWall3,772,427);
        addObject(brickWall24,494,338);
        addObject(smBrickWall4,840,264);
        addObject(smBrickWall7,1067,210);
        Door door2 = new Door();
        addObject(door2,1068,150);
        removeObject(smBrickWall3);
        addObject(smBrickWall3,848,429);
        removeObject(smBrickWall4);
        addObject(smBrickWall4,894,285);
        addObject(new TrapDoor(GRAVITY),195, 450);
        Powerup powerup3 = new Powerup();
        addObject(powerup3,1063,422);
        Powerup powerup4 = new Powerup();
        addObject(powerup4,1115,421);
        removeObject(powerup3);
        removeObject(powerup4);
        Gem gem = new Gem();
        addObject(gem,1064,417);
        Gem gem2 = new Gem();
        addObject(gem2,1119,417);
        Gem gem3 = new Gem();
        addObject(gem3,268,639);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.003)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
}
