package CEComponents;

import java.util.ArrayList;

import javax.imageio.ImageIO;

import CEApplication.CEComponent;
import java.awt.image.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CESprite extends CEComponent {

    public static ArrayList<CESprite> sprites = new ArrayList<CESprite>();
    public BufferedImage image;

    public void setImage(String path){
        try {
            image = ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
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

    }
}