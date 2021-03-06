import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Health[] health;
    private Powerup[] powerup;
    private int powerupCount;
    private int healthCount;
    private int speed;
    private int walkIndex;
    private int frame;
    private float yVelocity;
    private boolean isWalking; 
    private boolean isJumping;
    private boolean isFacingLeft;
    private final GreenfootImage[] WALK_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    private final float JUMP_FORCE;
    private final float GRAVITY;
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    
    public Player(int speed, float jumpForce, float gravity, int maxHealth, 
                  int maxPowerUp, Class nextLevel, GreenfootSound music)
    {
        this.speed = speed;
        JUMP_FORCE = jumpForce;
        GRAVITY = gravity;
        NEXT_LEVEL = nextLevel;
        MUSIC = music;
        
        healthCount = maxHealth;
        health = new Health[maxHealth];
        
        powerup = new Powerup[maxPowerUp];
        
        
        STANDING_IMAGE = getImage();
        WALK_ANIMATION = new GreenfootImage[]
                         {
                             new GreenfootImage("walk0.png"),
                             new GreenfootImage("walk1.png"),
                             new GreenfootImage("walk2.png"),
                             new GreenfootImage("walk3.png"),
                             new GreenfootImage("walk4.png"),
                             new GreenfootImage("walk5.png"),
                         };
                
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walk();
        jump();
        fall();
        onCollision();
        removeOutOfBounds();
        gameOver();
    }
    
    public void addedToWorld(World world)
    {
        health[0] = new Health();
        world.addObject(health[0], 30, 36);
        health[1] = new Health();
        world.addObject(health[1], 72, 36);
        health[2] = new Health();
        world.addObject(health[2], 114, 36);
        
        powerup[0] = new Powerup();
        powerup[1] = new Powerup();
        powerup[2] = new Powerup();
    }
    
    private void walk() 
    {
        if (isWalking)
        {
            animator();
        }
        else
        {
            setImage(STANDING_IMAGE);
            walkIndex = 0;
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            if(!MUSIC.isPlaying())
            {
                MUSIC.playLoop();
            }
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isWalking = true;
            isFacingLeft = false;
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isWalking = true;
            isFacingLeft = true;
            move(-speed);
        }
        
        if(!Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("a"))
        {
            isWalking = false;
        }
    }
    private void jump() 
    {
        if(Greenfoot.isKeyDown("space") && isOnGround())
        {
            Greenfoot.playSound("jump.wav");
            yVelocity = JUMP_FORCE;
            isJumping = true;
        }
        
        if(isJumping && yVelocity > 0)
        {
           setLocation(getX(), getY() - (int) yVelocity);
           yVelocity -= GRAVITY;
        }
        else
        {
            isJumping = false;    
        }
    }
    private void fall() 
    {
        if(!isJumping && !isOnGround())
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
    }
    private void animator() 
    {
        if(frame % (15 - 2 * speed) == 0)
        {
            if(walkIndex < WALK_ANIMATION.length)
            {
                setImage(WALK_ANIMATION[walkIndex]);
                walkIndex++;
            }
            else
            {
                walkIndex = 0;
            }
        }
        frame++;
    }
    private void onCollision() 
    {
        if(isTouching(Door.class))
        {
            Greenfoot.playSound("door_open.wav");
            MUSIC.stop();
            World world = null;
            try
            {
                world = (World) NEXT_LEVEL.newInstance();
            }
            catch (InstantiationException e)
            {
                 System.out.println("Class cannot be instantiated");    
            }  catch(IllegalAccessException e) {
                 System.out.println("Cannot access class constructor");
            }
            Greenfoot.setWorld(world);
        }
        
        if(isTouching(Collectable.class))
        {
            if(powerupCount < 2)
            {
                removeTouching(Collectable.class); 
                Greenfoot.playSound("collectable.wav");
                getWorld().addObject(powerup[powerupCount], 
                                     156 + powerupCount * 42, 36);
                powerupCount++;
            }
        }
        
        if(isTouching(Obstacle.class))
        {
            removeTouching(Obstacle.class);
            if(powerupCount > 0)
            {
                getWorld().removeObject(powerup[powerupCount - 1]);
                powerupCount--;
            }
            else
            {
                Greenfoot.playSound("explosionSmall.wav");
                removeTouching(Obstacle.class);
                getWorld().removeObject(health[healthCount - 1]);
                healthCount--;
            }
        }
        
        // hit platform but not on ground
        if(isTouching(Platform.class) && !isOnGround())
        {
            yVelocity = -1;
            fall();
        }
    }
    
    private void mirrorImages() 
    {
        for(int i = 0; i < WALK_ANIMATION.length; i++)
        {
            WALK_ANIMATION[i].mirrorHorizontally();
        }
    }
    
    private void gameOver() 
    {
        if(healthCount == 0)
        {
            MUSIC.stop();
            Greenfoot.setWorld(new Level1());
        }
    }
    
    private boolean isOnGround() 
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        return ground != null;
    }
    
    protected void removeOutOfBounds()
    {
        
        if(getX() > getWorld().getWidth())
                             
        {
            setLocation(0, getY());
        }
        
        if(getX() < 0)
                             
        {
            setLocation(40, 760);
        }
        
        if(getY() > getWorld().getHeight())
        {
            setLocation(70, 710);
        }
    }
    
}
    