package pers.crystal.engine.components.physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Fixture;

import pers.crystal.engine.application.CEComponent;

/**
 * CECollision
 */
public class CEPolygonCollision extends CECollision {

    @Override
    public void Start() {
        shape = new PolygonShape();
        super.Start();
    }

    @Override
    public void Update() {

    }
}