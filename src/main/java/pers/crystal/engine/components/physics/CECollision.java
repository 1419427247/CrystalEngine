package pers.crystal.engine.components.physics;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Fixture;

import pers.crystal.engine.application.CEBehave;
import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.components.sprite.CESprite;
import java.awt.Graphics;
import java.awt.image.*;

public class CECollision extends CEComponent {
    float density = 1f;
    Shape shape;
    Fixture fixture;

    CESprite sprite = new CESprite();

    BufferedImage bufferedImage;
    Graphics graphics;

    @Override
    public void Start() {
        CEComponent rigidbody = gameObject.componentManager.GetComponent(CERigidbody.class);
        if (rigidbody != null) {
            if (((CERigidbody) rigidbody).body != null) {
                fixture = ((CERigidbody) rigidbody).body.createFixture(shape, density);
            }
        }
        sprite.gameObject = this.gameObject;
        sprite.Start();
    }

    @Override
    public void Update() {

    }

    @Override
    public void Destroy() {
        if (fixture != null) {
            CEComponent rigidbody = gameObject.componentManager.GetComponent(CERigidbody.class);
            if (rigidbody != null) {
                if (((CERigidbody) rigidbody).body != null) {
                    ((CERigidbody) rigidbody).body.destroyFixture(fixture);
                }
            }
        }
        //sprite.Destroy();
    }
}