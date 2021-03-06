package nu.sebka.main;

import java.util.Random;

import nu.sebka.main.blocks.AirBlock;
import nu.sebka.main.blocks.CobbleBlock;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;


public class Block extends Instance {

    private static float size = 0.04f;
    public Texture[] textures = new Texture[6];
    public Texture[] originalTextures = new Texture[6];
    Random random = new Random();

    public Block(float x, float y, float z) {
        super(x, y, z);
        originalTextures = textures;

    }

    @Override
    public void tick() {

    }

    @Override
    public void draw() {


        if (textures[0] != null) {
            textures[0].bind();
        }


        // White side - BACK
        GL11.glBegin(GL11.GL_POLYGON);


        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glNormal3f(-1, 0, 0);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + size, y + -size, z + size);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + size, y + size, z + size);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + -size, y + size, z + size);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + -size, y + -size, z + size);
        GL11.glEnd();


        if (textures[1] != null) {
            textures[1].bind();
        }

        // White side - FRONT
        GL11.glBegin(GL11.GL_POLYGON);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glNormal3f(1, 0, 0);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + size, y + -size, z - size);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + size, y + size, z - size);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + -size, y + size, z - size);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + -size, y + -size, z - size);
        GL11.glEnd();


        if (textures[2] != null) {
            textures[2].bind();
        }

        // Purple side - RIGHT
        GL11.glBegin(GL11.GL_POLYGON);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glNormal3f(0, -1, 0);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + size, y + -size, z + -size);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + size, y + size, z + -size);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + size, y + size, z + size);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + size, y + -size, z + size);
        GL11.glEnd();


        if (textures[3] != null) {
            textures[3].bind();
        }


        // Green side - LEFT
        GL11.glBegin(GL11.GL_POLYGON);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glNormal3f(0, 0, -1);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + -size, y + -size, z + size);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + -size, y + size, z + size);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + -size, y + size, z + -size);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + -size, y + -size, z + -size);
        GL11.glEnd();


        if (textures[4] != null) {
            textures[4].bind();
        }

        // Blue side - TOP
        GL11.glBegin(GL11.GL_POLYGON);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glNormal3f(0, 0, 1);

        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + size, y + size, z + size);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + size, y + size, z + -size);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + -size, y + size, z + -size);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + -size, y + size, z + size);
        GL11.glEnd();

        if (textures[5] != null) {
            textures[5].bind();
        }

        // Red side - BOTTOM
        GL11.glBegin(GL11.GL_POLYGON);

        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glNormal3f(0, 1, 0);


        for (int i = 0; i < 32; i++) {
            if (!(Main.getCurrentWorld().getBlockAtPrecise(x, y - Block.getSize() - Block.getSize() * i, z) instanceof AirBlock)) {
                GL11.glColor3f(0.6f, 0.6f, 0.6f);
                break;

            } else {
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }


            //else if(!(Main.getCurrentWorld().getBlockAtPrecise(x,y-Block.getSize()*3, z) instanceof AirBlock)){
            //GL11.glColor3f(0.8f, 0.8f, 0.8f);

            //}

        }


        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + size, y + -size, z + -size);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + size, y + -size, z + size);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + -size, y + -size, z + size);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + -size, y + -size, z + -size);
        GL11.glEnd();


    }

    public static float getSize() {
        return size * 2;
    }


}
