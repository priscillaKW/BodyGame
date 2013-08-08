package jogoanatomia.loader;

import com.sun.j3d.loaders.Loader;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseWheelZoom;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Vector;
import javax.media.j3d.*;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class CarregaObj extends Applet {

    SimpleUniverse simpleU;
    static boolean application = false;
    public String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    // Criacao do Universo
    public void init() {
        file = "./coracao27512";
        setLayout(new BorderLayout());
        Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        add("Center", c);
        simpleU = new SimpleUniverse(c); // Adiciona Universo ao Canvas
        BranchGroup scene = createSceneGraph();
        simpleU.getViewingPlatform().setNominalViewingTransform();
        scene.compile();
        simpleU.addBranchGraph(scene); // Adiciona Grafo de Cena ao Universo
    }

    public BranchGroup createSceneGraph() {

        BranchGroup objRoot = new BranchGroup();
        TransformGroup tg = new TransformGroup();
        TransformGroup tg1 = new TransformGroup();
        Transform3D t3d = new Transform3D();
        Transform3D t3d1 = new Transform3D();

        Scene s = null;
        // Loader .obj
        try {
            ObjectFile f = new ObjectFile();
            f.setFlags(ObjectFile.RESIZE | Loader.LOAD_ALL);
            s = f.load("./" + file + ".obj");
            tg.addChild(s.getSceneGroup());
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.toString());
        }



        // Defini��o de Ilumina��o
        Color3f corLuz = new Color3f(0.9f, 0.9f, 0.9f);
        Vector3f direcaoLuz = new Vector3f(-1.0f, -1.0f, -1.0f);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
                10.0);
        Color3f ambientColor = new Color3f(0.5f, 0.5f, 0.5f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        DirectionalLight luzDir = new DirectionalLight(corLuz, direcaoLuz);
        luzDir.setInfluencingBounds(bounds);
        ambientLightNode.setInfluencingBounds(bounds);

        PointLight point = new PointLight();
        point.setPosition(3.0f, 3.0f, 3.0f);
        point.setInfluencingBounds(bounds);
        objRoot.addChild(point);

        SpotLight spot = new SpotLight();
        spot.setPosition(0.0f, 3.0f, 0.0f);
        spot.setDirection(0.0f, -1.0f, 0.0f);
        spot.setInfluencingBounds(bounds);
        objRoot.addChild(spot);

        // Especifica um background azul e adiciona-o no grafo
        Color3f bgColor = new Color3f(1f, 1f, 1f);
        Background bg = new Background(bgColor);
        bg.setApplicationBounds(bounds);
        objRoot.addChild(bg);

        // Rota��o do mouse
        MouseRotate m1 = new MouseRotate(tg);
        m1.setSchedulingBounds(bounds);

        MouseWheelZoom m2 = new MouseWheelZoom(tg);
        m2.setSchedulingBounds(bounds);

        // Capta��o dados mouse
        t3d.setTranslation(new Vector3f(0f, 0f, -5f));
        t3d.setScale(new Vector3d(3.0, 3.0, 3.0));
        t3d1.setScale(-1.0);
        t3d1.setRotation(new AxisAngle4d(1.0, 0.0, 0.0, 180.0));
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setTransform(t3d);
        tg.setTransform(t3d1);

        objRoot.addChild(tg);
        objRoot.addChild(m1);
        objRoot.addChild(m2);
        objRoot.addChild(ambientLightNode);
        objRoot.addChild(luzDir);
        tg.addChild(tg1);
        return objRoot;
    }

    public BranchGroup branchGroupLeft(Canvas3D Left) {
        BranchGroup bg = new BranchGroup();
        TransformGroup tg = new TransformGroup();
        Transform3D t3d = new Transform3D();
        ViewPlatform vp = new ViewPlatform();

        PhysicalBody pb = new PhysicalBody(new Point3d(0.0f, 0.0f, 0.0f), new Point3d(0.0f, 0.0f, 0.0f));
        PhysicalEnvironment pe = new PhysicalEnvironment();

        View view = new View();
        view.attachViewPlatform(vp);
        view.setPhysicalBody(pb);
        view.setPhysicalEnvironment(pe);
        view.setSceneAntialiasingEnable(true);
        view.addCanvas3D(Left);

        t3d.set(new Vector3f(0.0f, 0.0f, 7.0f));

        tg.setTransform(t3d);

        tg.addChild(vp);
        bg.addChild(tg);

        bg.compile();
        return bg;
    }

    public void destroy() {
        simpleU.removeAllLocales();
    }

    public static void main(String[] args) {
        application = true;
        Frame frame = new MainFrame(new CarregaObj(), 800, 800);

    }
}