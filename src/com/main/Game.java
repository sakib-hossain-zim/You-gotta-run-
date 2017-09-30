package com.main;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH/12 * 9;
    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;



    private Game() {

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));        //asking the game to be ready for the keys pressed
        new GameWindow(WIDTH, HEIGHT, "Gotta Run!", this);


        hud = new HUD();
        spawner = new Spawn(handler,hud);
        r = new Random();



        handler.addObject(new Player((WIDTH/2-32), (HEIGHT/2-32), Identity.Player,handler));

        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),Identity.BasicEnemy,handler));



    }


    public synchronized  void start(){
        //will start our thread

        thread = new Thread(this);
        thread.start();
        running = true;

    }

    public synchronized  void stop(){
        try{
            thread.join();
            running = false;


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void run(){     //the game loop which updates all the things in the game[taken from google]
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }

            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();

    }

    private void render(){

        BufferStrategy bs = this.getBufferStrategy();
        if(bs ==null){
            this.createBufferStrategy(3);  //putting three buffers in the game
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);           //sets the background color of the game
        g.fillRect(0,0,WIDTH,HEIGHT);     // fills the whole background of the game with the color



        handler.render(g);

        hud.render(g);



        g.dispose();     //dispose anything there is in the VM
        bs.show();


    }


    public static int clamp(int val,int min,int max){
        if(val >= max)
            return val = max;

        else if (val <= min){
            return val = min;
        }
       else
        return val;

    }


    public static void main(String[] args){

        new Game();




    }
}

