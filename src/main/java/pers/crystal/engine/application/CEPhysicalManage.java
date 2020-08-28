package pers.crystal.engine.application;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class CEPhysicalManage extends CEBehave {
    private World world = new World(new Vec2());

    @Override
    protected void Start() {

    }

    @Override
    protected void Update() {
        world.step(0.02f, 8, 3);
    }

    @Override
    protected void Destroy() {
        // TODO Auto-generated method stub

    }
    public Body CreateBody(BodyDef def){
        return world.createBody(def);
    }

    public void DestroyBody(Body body) {
        world.destroyBody(body);
    }

}