package jogoanatomia.loader;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.media.j3d.*;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

public class CarregaStereo extends Applet {

    protected Canvas3D c1 = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
    private static MainFrame mf;
    protected SimpleUniverse u = null;
    protected BranchGroup scene = null;
    protected String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    protected float eyeOffset = 0.015F;
    protected static int size = 600;

    public void init() {
        setLayout(new FlowLayout());
        GraphicsConfiguration config =
                SimpleUniverse.getPreferredConfiguration();
        String v = getParameter("url");
        if (v != null) {
            fileName = v;
        }
        c1.setSize(size, size);
        add(c1);
        scene = createSceneGraph();
        u = new SimpleUniverse(c1);
        u.addBranchGraph(scene);

    }

    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        try {
            Transform3D myTransform3D = new Transform3D();
            myTransform3D.setTranslation(new Vector3f(+0.0f, -0.15f, -3.6f));
            TransformGroup objTrans = new TransformGroup(myTransform3D);
            objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            Transform3D t = new Transform3D();
            t.setScale(-1.0);
            t.setRotation(new AxisAngle4d(1.0, 0.0, 0.0, 180.0));
            TransformGroup tg = new TransformGroup(t);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            objTrans.addChild(tg);
            ObjectFile f = new ObjectFile();
            f.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);

            Scene s = f.load(fileName + ".obj");
            Transform3D myTrans = new Transform3D();
            myTrans.setTranslation(new Vector3f(eyeOffset, -eyeOffset, 0F));
            TransformGroup mytg = new TransformGroup(myTrans);
            tg.addChild(mytg);
            Transform3D myTrans2 = new Transform3D();
            myTrans2.setTranslation(new Vector3f(-eyeOffset, +eyeOffset, 0F));
            TransformGroup mytg2 = new TransformGroup(myTrans2);
            Hashtable table = s.getNamedObjects();
            for (Enumeration e = table.keys(); e.hasMoreElements();) {
                Object key = e.nextElement();
                Object obj = table.get(key);
                Shape3D shape = (Shape3D) obj;
                Appearance ap = new Appearance();
                Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
                Color3f red = new Color3f(1.0f, 0.0f, 0.0f);
                Color3f blue = new Color3f(0.0f, 0.0f, 1.0f);
                ap.setMaterial(new Material(blue, black, blue, black, 1.0f));
                Appearance ap2 = new Appearance();
                ap2.setMaterial(new Material(red, black, red, black, 1.0f));
                float transparencyValue = 0.5f;
                TransparencyAttributes t_attr =
                        new TransparencyAttributes(
                        TransparencyAttributes.BLENDED,
                        transparencyValue,
                        TransparencyAttributes.BLEND_SRC_ALPHA,
                        TransparencyAttributes.BLEND_ONE);
                ap2.setTransparencyAttributes(t_attr);
                ap2.setRenderingAttributes(new RenderingAttributes());
                ap.setTransparencyAttributes(t_attr);
                ap.setRenderingAttributes(new RenderingAttributes());
                shape.setAppearance(ap);
                mytg2.addChild(new Shape3D(shape.getGeometry(), ap2));
                mytg.addChild(new Shape3D(shape.getGeometry(), ap));
            }
            tg.addChild(mytg2);
            BoundingSphere bounds =
                    new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
            Color3f light1Color = new Color3f(.9f, 0.9f, 0.9f);
            Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
            DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
            light1.setInfluencingBounds(bounds);
            objTrans.addChild(light1);
            Color3f ambientColor = new Color3f(1.0f, .4f, 0.3f);
            AmbientLight ambientLightNode = new AmbientLight(ambientColor);
            ambientLightNode.setInfluencingBounds(bounds);
            objTrans.addChild(ambientLightNode);


            MouseRotate behavior = new MouseRotate();
            behavior.setTransformGroup(tg);
            objTrans.addChild(behavior);
            MouseTranslate behavior3 = new MouseTranslate();
            behavior3.setTransformGroup(tg);
            objTrans.addChild(behavior3);
            behavior3.setSchedulingBounds(bounds);

            KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(tg);
            keyNavBeh.setSchedulingBounds(new BoundingSphere(
                    new Point3d(), 1000.0));
            objTrans.addChild(keyNavBeh);

            behavior.setSchedulingBounds(bounds);
            objRoot.addChild(objTrans);
        } catch (Throwable t) {
            System.out.println("Error: " + t);
        }
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

    public CarregaStereo() {
    }

    public void destroy() {
        u.removeAllLocales();
    }

    public static void main(String[] args) {

        CarregaStereo s = new CarregaStereo();
        s.setFileName("./coracao");
        mf = new MainFrame(s, size, size);
    }
}