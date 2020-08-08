package pers.crystal.engine.components.sprite;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pers.crystal.engine.application.CEComponent;

public class CESprite extends CEComponent {

    public static ArrayList<CESprite> sprites = new ArrayList<CESprite>();
    public BufferedImage image;
    
    private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

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

    public void SetImages(File... files){
        for (int i = 0; i < files.length; i++) {
            try {
                images.add(ImageIO.read(new FileInputStream(files[i])));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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