package pers.crystal.engine.components.physics;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Fixture;

import pers.crystal.engine.application.CEComponent;
import java.awt.image.*;

public class CERectCollision extends CECollision {
    public int width = 32;
    public int height = 32;

    @Override
    public void Start() {
        shape = new PolygonShape();
        ((PolygonShape) shape).setAsBox(width / 2, height / 2);

        // bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // graphics = bufferedImage.getGraphics();
        // graphics.drawRect(0, 0, width-1, height-1);


        // gameObject.componentManager.add

        // sprite.SetImage(bufferedImage);

        super.Start();
    }
}