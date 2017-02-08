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

    private Body cuboBody, sueloBody, pinchoBody;
    private Fixture cuboFixture, sueloFixture, pinchoFixture;

    public PantallaBox2D(MainGame juego) {
        super(juego);
    }

    @Override
    public void show() {

        //Instanciamos el nuevo mundo con la gravedad -10
        world = new World(new Vector2(0, -10), true);

        //Dubujar mundo por pantalla
        renderer = new Box2DDebugRenderer();

        //camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera = new OrthographicCamera(7.11f, 4);
        //movemos la camara 1m hacia arriba
        camera.translate(0, 1);

        cuboBody = world.createBody(createCuboBodyDef());
        sueloBody = world.createBody(createSueloBodyDef());
        pinchoBody = world.createBody(createPinchoBodyDef(1));

        PolygonShape cuboShape = new PolygonShape();
        //se mide en metros
        cuboShape.setAsBox(0.5f, 0.5f);
        cuboFixture = cuboBody.createFixture(cuboShape, 1);
        cuboShape.dispose();

        PolygonShape sueloShape = new PolygonShape();
        sueloShape.setAsBox(500, 1);
        sueloFixture = sueloBody.createFixture(sueloShape, 1);
        sueloShape.dispose();

        //PolygonShape pinchoShape = new PolygonShape();
        //pinchoShape.setAsBox(500, 1);
        //pinchoFixture = pinchoBody.createFixture(pinchoShape, 1);
        //pinchoShape.dispose();

        pinchoFixture = createPinchoFixture(pinchoBody);

    }

    private BodyDef createPinchoBodyDef(float x) {

        BodyDef def = new BodyDef();
        def.position.set(x, 0.5f);
        return def;

    }

    /**
     * Creamos el tipo suelo de forma estática
     * @return
     */
    private BodyDef createSueloBodyDef() {

        BodyDef def = new BodyDef();
        def.position.set(0, -1);
        return def;

    }

    /**
     * Creamos el tipo cubo de forma dinamica
     * @return
     */
    private BodyDef createCuboBodyDef() {

        BodyDef def = new BodyDef();
        def.position.set(0, 10);
        def.type = BodyDef.BodyType.DynamicBody;
        return def;

    }

    private Fixture createPinchoFixture(Body pinchoBody){

        Vector2[] vertices = new Vector2[3];
        vertices[0] = new Vector2(-0.5f, -0.5f);
        vertices[1] = new Vector2(0.5f, -0.5f);
        vertices[2] = new Vector2(0, 0.5f);

        PolygonShape shape = new PolygonShape();
        shape.set(vertices);
        Fixture fix = pinchoBody.createFixture(shape, 1);
        shape.dispose();

        return fix;

    }

    @Override
    public void dispose() {

        renderer.dispose();
        world.dispose();
        world.destroyBody(cuboBody);
        world.destroyBody(sueloBody);
        world.destroyBody(pinchoBody);
        cuboBody.destroyFixture(cuboFixture);
        sueloBody.destroyFixture(sueloFixture);
        pinchoBody.destroyFixture(pinchoFixture);

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
