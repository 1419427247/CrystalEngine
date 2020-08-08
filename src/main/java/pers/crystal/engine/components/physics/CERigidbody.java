package pers.crystal.engine.components.physics;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

import pers.crystal.engine.application.CEBehave;
import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.application.CEWorld;

public class CERigidbody extends CEComponent {
    public BodyType type = BodyType.DYNAMIC;
    BodyDef bodyDef = new BodyDef();
    Body body;

    @Override
    public void Start() {
        bodyDef.type = type;
        bodyDef.position = new Vec2((float) gameObject.transform.position.getX(),
                (float) gameObject.transform.position.getY());
        bodyDef.angle = gameObject.transform.angle;
        body = CEWorld.physicalWorld.createBody(bodyDef);

        ArrayList<CEBehave> components = gameObject.componentManager.GetComponentList();
        for (CEBehave behave : components) {
            CEComponent component = (CEComponent) behave;
            if (component instanceof CECollision) {
                CECollision collision = ((CECollision) component);
                if (collision.shape != null) {
                    collision.fixture = body.createFixture(collision.shape, collision.density);
                }
            }
        }
    }

    @Override
    public void Update() {
        gameObject.transform.position.setX((float) body.getPosition().x);
        gameObject.transform.position.setY((float) body.getPosition().y);
        gameObject.transform.angle = (float) (-body.getAngle() * 180f / Math.PI);
    }

    @Override
    public void Destroy() {
        CEWorld.physicalWorld.destroyBody(body);
    }

    public void SetType(BodyType type) {
        body.setType(type);
    }

}