package pers.crystal.engine.components.physics;

import org.jbox2d.collision.shapes.CircleShape;

import java.awt.Graphics;
import java.awt.image.*;

public class CECircleCollision extends CECollision {
    public int radius = 10;

    @Override
    public void Start() {
        shape = new CircleShape();

        ((CircleShape) shape).setRadius(radius);

        bufferedImage = new BufferedImage(radius, radius, BufferedImage.TYPE_INT_ARGB);
        graphics = bufferedImage.getGraphics();
        graphics.drawOval(radius / 2, radius / 2, radius, radius);
        sprite.SetImage(bufferedImage);

        super.Start();
    }
}