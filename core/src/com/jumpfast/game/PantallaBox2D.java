package com.jumpfast.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Carlos Prieto on 08/02/2017.
 */

public class PantallaBox2D extends PantallaInicio{

    private World world;

    private Box2DDebugRenderer renderer;

    //Creamos una camara 2D
    private OrthographicCamera camera;

    private Body cuboBody;
    private Fixture cuboFixture;

    public PantallaBox2D(MainGame juego) {
        super(juego);
    }

    @Override
    public void show() {

        //Instanciamos el nuevo mundo con la gravedad -10
        world = new World(new Vector2(0, -10), true);

        //Dubujar mundo por pantalla
        renderer = new Box2DDebugRenderer();

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        BodyDef cuboDef = createCuboBodyDef();
        cuboBody = world.createBody(cuboDef);

        PolygonShape cuboShape = new PolygonShape();
        //se mide en metros
        cuboShape.setAsBox(1, 1);
        cuboFixture = cuboBody.createFixture(cuboShape, 1);
        cuboShape.dispose();

    }

    private BodyDef createCuboBodyDef() {

        BodyDef def = new BodyDef();
        def.position.set(0, 10);
        def.type = BodyDef.BodyType.DynamicBody;
        return def;

    }

    @Override
    public void dispose() {

        world.dispose();
        renderer.dispose();
        world.destroyBody(cuboBody);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Simular mundo
        world.step(delta, 6, 2);

        //Actualiza las fisicas y dibuja el mundo
        camera.update();
        renderer.render(world, camera.combined);

    }
}
