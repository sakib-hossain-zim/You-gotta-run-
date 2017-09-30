package com.main;

import java.awt.*;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public abstract class GameObject {

    protected int x,y;     //protected means it can be only accessed by the class that extends or inherits it

    //Gotta id enemies and players

    protected Identity id;

    protected int velX, velY;  //the speed of the game


    public GameObject(int x, int y, Identity id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();


    public void setX(int x){
        this.x = x;

    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setId(Identity id){
        this.id = id;
    }

    public Identity getId(){
        return id;
    }

    public void setVelX(int velX){
        this.velX = velX;
    }

    public void setVelY(int velY){
        this.velY = velY;
    }

    public int getVelX(){
        return velX;
    }

    public int getVelY(){
        return velY;
    }





}
