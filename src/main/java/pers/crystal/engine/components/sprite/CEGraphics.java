package pers.crystal.engine.components.sprite;

import java.awt.image.BufferedImage;
import java.awt.*;

public class CEGraphics extends CESprite{
    public int width = 60;
    public int height = 40;

    private Graphics2D graphics;
    @Override
    public void Start() {
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        graphics = (Graphics2D)image.getGraphics();

        // graphics.fillRect(0,0, width-1, height-1);

        super.Start();
    }

    @Override
    public void Update() {
        super.Update();
    }
    @Override
    public void Destroy() {
        super.Destroy();
    }

    public Graphics2D GetGraphics() {
        return graphics;
    }
}