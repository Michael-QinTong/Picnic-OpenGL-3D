package objects3D;

import GraphicsObjects.Utils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import javax.xml.soap.Text;

public class Human {

    // basic colours
    static float black[] = {0.0f, 0.0f, 0.0f, 1.0f};
    static float white[] = {1.0f, 1.0f, 1.0f, 1.0f};

    static float grey[] = {0.5f, 0.5f, 0.5f, 1.0f};
    static float spot[] = {0.1f, 0.1f, 0.1f, 0.5f};

    // primary colours
    static float red[] = {1.0f, 0.0f, 0.0f, 1.0f};
    static float green[] = {0.0f, 1.0f, 0.0f, 1.0f};
    static float green2[] = {0.0f, 0.5f, 0.5f, 1.0f, 1.0f};
    static float blue[] = {0.0f, 0.0f, 1.0f, 1.0f};

    // secondary colours
    static float yellow[] = {0.8f, 0.6f, 0.3f, 1.0f};
    static float magenta[] = {1.0f, 0.0f, 1.0f, 1.0f};
    static float cyan[] = {0.0f, 1.0f, 1.0f, 1.0f};

    // other colours
    static float orange[] = {1.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    static float brown[] = {0.5f, 0.25f, 0.0f, 1.0f, 1.0f};
    static float dkgreen[] = {0.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    static float pink[] = {1.0f, 0.6f, 0.6f, 1.0f, 1.0f};

    public Human() {

    }

    // Draw a human
    // Implement using notes  in Animation lecture
    public void DrawHuman(float delta, boolean moveStatus, boolean SwingStatus, boolean watching, int dancing, Texture text1, Texture text2) {
        float theta = (float) (delta * 2 * Math.PI);
//        System.out.println(dancing);
        float LimbRotation;
        float WatchingRotation;
        float DancingRotation;
        if (moveStatus) {
            LimbRotation = (float) Math.cos(theta) * 45;
            if (dancing == 2){
                DancingRotation = (float) Math.cos(theta) * 20;;
                LimbRotation = (float) Math.cos(theta) * 60;
            }else{
                DancingRotation = 0;
            }
        } else {
            LimbRotation = 0;
            DancingRotation = 0;
            if(dancing == 1) {
                DancingRotation = (float) Math.cos(theta) * 10;
            }
        }
        if(watching){
            WatchingRotation = (float) Math.cos(theta) * 15;
        }else{
            WatchingRotation = 0;
        }
//        if(dancing == 1){
//            DancingRotation = (float) Math.cos(theta) * 5;
//        }else if (dancing == 2){
//            DancingRotation = (float) Math.cos(theta) * 20;;
//        }else{
//            DancingRotation = 0;
//        }

        //There classes are used to implement 3D objects that are already realized
        Sphere sphere = new Sphere();
        Cylinder cylinder = new Cylinder();
        TexSphere texsphere = new TexSphere();
        TexCube texcube = new TexCube();

        //here is the pelvis of this human
        //the animation here is used to make human jump up and down when run
        GL11.glTexParameteri(
                GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                GL11.GL_CLAMP);

        Color.white.bind();
        text1.bind();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        texsphere.DrawTexSphere(0.5f, 32, 32, text1);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
        GL11.glPushMatrix();
        {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            sphere.DrawSphere(0.5f, 32, 32);
            //  chest
            GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
            GL11.glPushMatrix();
            {
                GL11.glTranslatef(0.0f, 0.0f, -0.6f);
                GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
                GL11.glTexParameteri(
                        GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                        GL11.GL_CLAMP);

                Color.white.bind();
                text1.bind();
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                texsphere.DrawTexSphere(0.5f, 32, 32, text1);
                GL11.glDisable(GL11.GL_TEXTURE_2D);


                // neck
                GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                GL11.glPushMatrix();
                {
                    GL11.glTranslatef(0.0f, 0.0f, 0.28f);
                    GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
                    cylinder.DrawCylinder(0.15f, 1.0f, 32);

                    // head
                    GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green2));
                    GL11.glPushMatrix();
                    {
                        if(dancing == 1){
                            GL11.glRotatef(DancingRotation,1,0,0);
                        } else if(dancing == 2){
                            GL11.glRotatef(DancingRotation,0,0,1);
                        }
                        GL11.glTranslatef(0.0f, 0.0f, 0.68f);
                        sphere.DrawSphere(0.45f, 32, 32);

                        //right tentacles
                        GL11.glColor3f(green[0], green[1], green[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(60, 0.0f, 1.0f, 1.0f);
                            GL11.glTranslatef(0.0f, 0.0f, 0.3f);
                            cylinder.DrawCylinder(0.05f, 0.5f, 8);

                            // small ball
                            GL11.glColor3f(green[0], green[1], green[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green));
                            GL11.glPushMatrix();
                            {
                                GL11.glRotatef(0f, 0.0f, 0.0f, 0.0f);
                                GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                                sphere.DrawSphere(0.08f, 32.0f, 32.0f);
                                GL11.glPopMatrix();
                            }

                            GL11.glPopMatrix();
                        }
                        //left tentacless
                        GL11.glColor3f(green[0], green[1], green[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(60, 0.0f, -1.0f, -1.0f);
                            GL11.glTranslatef(0.0f, 0.0f, 0.3f);
                            cylinder.DrawCylinder(0.05f, 0.5f, 8);

                            // small ball
                            GL11.glColor3f(green[0], green[1], green[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green));
                            GL11.glPushMatrix();
                            {
                                GL11.glRotatef(0f, 0.0f, 0.0f, 0.0f);
                                GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                                sphere.DrawSphere(0.08f, 32.0f, 32.0f);
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }


                        //right eye
                        GL11.glColor3f(white[0], white[1], white[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.2f, 0.15f, -0.35f);
                            sphere.DrawSphere(0.10f, 32.0f, 32.0f);

                            //eyeball
                            GL11.glColor3f(blue[0], blue[1], blue[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
                            GL11.glPushMatrix();
                            {
                                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                GL11.glTranslatef(0.0f, -0.09f, 0.0f);
                                sphere.DrawSphere(0.07f, 32.0f, 32.0f);
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }


                        //left eye
                        GL11.glColor3f(white[0], white[1], white[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(-0.2f, 0.15f, -0.35f);
                            sphere.DrawSphere(0.10f, 32.0f, 32.0f);

                            //eyeball
                            GL11.glColor3f(blue[0], blue[1], blue[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
                            GL11.glPushMatrix();
                            {
                                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                GL11.glTranslatef(0.0f, -0.09f, 0.0f);
                                sphere.DrawSphere(0.07f, 32.0f, 32.0f);
                                GL11.glPopMatrix();
                            }

                            GL11.glPopMatrix();
                        }


                        //nose
                        GL11.glColor3f(green2[0], green2[1], green2[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(green2));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.0f, 0.0f, -0.45f);
                            sphere.DrawSphere(0.1f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }


                        //mouth
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.1f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.07f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.0f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.09f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(-0.1f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.07f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();


                    // left shoulder
                    GL11.glColor3f(white[0], white[1], white[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.65f, 0.0f, 0.33f);
                        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);

                        if(dancing == 2){
                            GL11.glRotatef(DancingRotation * 1.5f,1,0,0);
                        }else{
                            GL11.glRotatef(LimbRotation, 1.0f, 0.0f, 0.0f);
                        }
                        GL11.glTexParameteri(
                                GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                GL11.GL_CLAMP);
                        Color.white.bind();
                        text2.bind();
                        GL11.glEnable(GL11.GL_TEXTURE_2D);
                        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                        texsphere.DrawTexSphere(0.28f, 32, 32, text2);
                        GL11.glDisable(GL11.GL_TEXTURE_2D);


                        // left arm
                        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, -0.0f, 0.0f);
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            cylinder.DrawCylinder(0.12f, 1.0f, 32);

                            // left elbow
                            GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.9f);
                                //On the swings
                                if(SwingStatus){
                                    GL11.glRotatef(90,1,0,0);
                                }
                                if(dancing == 2){
                                    GL11.glRotatef((35 + (DancingRotation * 1.5f)), 1,0,0);
                                }
                                GL11.glTexParameteri(
                                        GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                        GL11.GL_CLAMP);
                                Color.white.bind();
                                text2.bind();
                                GL11.glEnable(GL11.GL_TEXTURE_2D);
                                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                                texsphere.DrawTexSphere(0.2f, 32, 32, text2);
                                GL11.glDisable(GL11.GL_TEXTURE_2D);
//                                sphere.DrawSphere(0.2f, 32, 32);
//
//                               //left forearm
                                GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                                    GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
//		                                GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
                                    cylinder.DrawCylinder(0.1f, 0.8f, 32);

                                    // left hand
                                    GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                                    GL11.glPushMatrix();
                                    {
                                        GL11.glTranslatef(0.0f, 0.0f, 0.9f);
                                        GL11.glTexParameteri(
                                                GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                                GL11.GL_CLAMP);
                                        Color.white.bind();
                                        text2.bind();
                                        GL11.glEnable(GL11.GL_TEXTURE_2D);
                                        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                                        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                                        texsphere.DrawTexSphere(0.2f, 32, 32, text2);
                                        GL11.glDisable(GL11.GL_TEXTURE_2D);

                                    }
                                    GL11.glPopMatrix();
                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                    // to chest

                    // right shoulder
                    GL11.glColor3f(white[0], white[1], white[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(-0.65f, 0.0f, 0.33f);
                        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                        //Watch the boat go
                        if(dancing == 2){
                            GL11.glRotatef(-DancingRotation * 1.5f,1,0,0);
                        }else{
                            if(watching){
                                GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
                                GL11.glRotatef(WatchingRotation,0,0,1);
                            }
                            else{
                                GL11.glRotatef(-LimbRotation, 1.0f, 0.0f, 0.0f);
                            }
                        }

                        GL11.glTexParameteri(
                                GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                GL11.GL_CLAMP);

                        Color.white.bind();
                        text2.bind();
                        GL11.glEnable(GL11.GL_TEXTURE_2D);
                        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                        texsphere.DrawTexSphere(0.28f, 32, 32, text2);
                        GL11.glDisable(GL11.GL_TEXTURE_2D);


                        // right arm
                        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, -0.0f, 0.0f);
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            cylinder.DrawCylinder(0.12f, 1.0f, 32);

                            // right elbow
                            GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.9f);
                                //On the swings
                                if(SwingStatus){
                                    GL11.glRotatef(90,1,0,0);
                                }
                                if(dancing == 2){
                                    GL11.glRotatef(35- (DancingRotation * 1.5f), 1,0,0);
                                }
                                GL11.glTexParameteri(
                                        GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                        GL11.GL_CLAMP);
                                Color.white.bind();
                                text2.bind();
                                GL11.glEnable(GL11.GL_TEXTURE_2D);
                                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                                texsphere.DrawTexSphere(0.2f, 32, 32, text2);
                                GL11.glDisable(GL11.GL_TEXTURE_2D);

                                //right forearm
                                GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                                    GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
                                    //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
                                    cylinder.DrawCylinder(0.1f, 0.8f, 32);

                                    // right hand
                                    GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                                    GL11.glPushMatrix();
                                    {
                                        GL11.glTranslatef(0.0f, 0.0f, 0.9f);
                                        GL11.glTexParameteri(
                                                GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                                GL11.GL_CLAMP);
                                        Color.white.bind();
                                        text2.bind();
                                        GL11.glEnable(GL11.GL_TEXTURE_2D);
                                        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                                        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                                        texsphere.DrawTexSphere(0.2f, 32, 32, text2);
                                        GL11.glDisable(GL11.GL_TEXTURE_2D);
                                    }
                                    GL11.glPopMatrix();
                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();

                    //chest


                }
                GL11.glPopMatrix();


                // right hip
                GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                GL11.glPushMatrix();
                {
                    GL11.glTranslatef(-0.3f, 0.0f, 0.4f);
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
//                    if (delta < 10) {
                    //On the swings
                    if(SwingStatus){
                        GL11.glRotatef(180, 1,0,0);
                    }
                    else{
                        if (LimbRotation > 0) {
                            GL11.glRotatef((LimbRotation) + 90, 1.0f, 0.0f, 0.0f);
                        } else {
                            GL11.glRotatef((LimbRotation / 2) + 90, 1.0f, 0.0f, 0.0f);
                        }
                    }
                    cylinder.DrawCylinder(0.22f, 0.45f, 32);


                    // right high leg
                    GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.0f, 0.0f, 0.4f);
                        GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
                        cylinder.DrawCylinder(0.15f, 0.6f, 32);


                        // right knee
                        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                            GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
//                            if (delta < 10) {
                            //On the swings
                            if(SwingStatus){
                                GL11.glRotatef(-90, 1,0,0);
                            }
                            else {
                                if (LimbRotation > 0) {
                                    GL11.glRotatef(-LimbRotation, 1.0f, 0.0f, 0.0f);
                                } else {
                                    GL11.glRotatef(LimbRotation / 2, 1.0f, 0.0f, 0.0f);
                                }
                            }
                            GL11.glTexParameteri(
                                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                    GL11.GL_CLAMP);
                            Color.white.bind();
                            text2.bind();
                            GL11.glEnable(GL11.GL_TEXTURE_2D);
                            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                            texsphere.DrawTexSphere(0.25f, 32, 32, text2);
                            GL11.glDisable(GL11.GL_TEXTURE_2D);

                            //right low leg
                            GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.10f);
                                GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);

                                cylinder.DrawCylinder(0.15f, 0.7f, 32);


                                // right foot
                                GL11.glColor3f(white[0], white[1], white[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, -0.05f, 0.6f);
                                    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                    cylinder.DrawCylinder(0.2f, 0.45f, 32);

                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                }
                GL11.glPopMatrix();


                // left hip
                GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                GL11.glPushMatrix();
                {
                    GL11.glTranslatef(0.3f, 0.0f, 0.4f);
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
//                    if (delta < 10) {
                    //On the swings
                    if(SwingStatus){
                        GL11.glRotatef(180, 1,0,0);
                    }
                    else {
                        if (LimbRotation > 0) {
                            GL11.glRotatef((-LimbRotation / 2) + 90, 1.0f, 0.0f, 0.0f);
                        } else {
                            GL11.glRotatef((-LimbRotation) + 90, 1.0f, 0.0f, 0.0f);
                        }
                    }
                    cylinder.DrawCylinder(0.22f, 0.45f, 32);
                    // left high leg
                    GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.0f, 0.0f, 0.4f);
                        GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
                        cylinder.DrawCylinder(0.15f, 0.6f, 32);


                        // left knee
                        GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                            GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
//                            if (delta < 10) {
                            //On the swings
                            if(SwingStatus){
                                GL11.glRotatef(-90, 1,0,0);
                            }
                            else {
                                if (LimbRotation > 0) {
                                    GL11.glRotatef(-LimbRotation / 2, 1.0f, 0.0f, 0.0f);
                                } else {
                                    GL11.glRotatef(LimbRotation, 1.0f, 0.0f, 0.0f);
                                }
                            }
                            GL11.glTexParameteri(
                                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                                    GL11.GL_CLAMP);
                            Color.white.bind();
                            text2.bind();
                            GL11.glEnable(GL11.GL_TEXTURE_2D);
                            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                            texsphere.DrawTexSphere(0.25f, 32, 32, text2);
                            GL11.glDisable(GL11.GL_TEXTURE_2D);

                            //left low leg
                            GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.10f);
                                GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);

                                cylinder.DrawCylinder(0.15f, 0.7f, 32);

                                // left foot
                                GL11.glColor3f(white[0], white[1], white[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, -0.05f, 0.6f);
                                    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                    cylinder.DrawCylinder(0.2f, 0.45f, 32);

                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                }
                GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
        }
    }
}

