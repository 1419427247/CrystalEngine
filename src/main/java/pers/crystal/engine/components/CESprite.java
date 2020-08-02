package pers.crystal.engine.components;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pers.crystal.engine.application.CEComponent;

public class CESprite extends CEComponent {

    public static ArrayList<CESprite> sprites = new ArrayList<CESprite>();
    public BufferedImage image;

    public void SetImage(File file){
        try {
            image = ImageIO.read(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SetImage(BufferedImage bufferedImage){
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
}