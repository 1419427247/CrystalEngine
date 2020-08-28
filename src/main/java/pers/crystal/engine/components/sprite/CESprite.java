package pers.crystal.engine.components.sprite;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import pers.crystal.engine.application.CEComponent;

public class CESprite extends CEComponent implements Comparable {

    public static TreeSet<CESprite> sprites = new TreeSet<CESprite>();

    public BufferedImage image;

    public void SetImage(File file) {
        try {
            image = ImageIO.read(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SetImage(BufferedImage bufferedImage) {
        image = bufferedImage;
    }

    @Override
    public void Start() {
        sprites.add(this);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Destroy() {
        sprites.remove(this);
    }

    @Override
    public int compareTo(Object object) {
       CESprite sprite = (CESprite)object;
        if (sprite == this) {
            return 0;
        }else if(sprite.gameObject.depth > gameObject.depth){
            return -1;
        }else{
            return 1;
        }
    }
}