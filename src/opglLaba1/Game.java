package opglLaba1;
import java.awt.DisplayMode;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Game implements GLEventListener {

   public static DisplayMode dm, dm_old;
   private GLU glu = new GLU();
   private float xrot,yrot,zrot;
   private int texture;
      
@Override
   public void display( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
      gl.glLoadIdentity();
      gl.glTranslatef( 0f, 0f, -5.0f ); 

      // Rotate The Cube On X, Y & Z
      gl.glRotatef(xrot, 1.0f, 1.0f, 1.0f); 
      gl.glRotatef(yrot, 0.0f, 1.0f, 0.0f); 
      gl.glRotatef(zrot, 0.0f, 0.0f, 1.0f); 
      
      gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
 
      //giving different colors to different sides
      gl.glBegin(GL2.GL_TRIANGLES); // Start Drawing The Cube
      gl.glColor3f(1f,0f,0f); //red color
      gl.glVertex3f(-0.30902f, -0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glTexCoord2f(0.0f, 0.0f);
      gl.glVertex3f( -1.0f, 0.0f, 0.0f); // Top Left Of The Quad (Top)
      gl.glTexCoord2f(1.0f, 0.0f);
      gl.glVertex3f( 0.0f, 0.0f, 2.0f ); // Bottom Left Of The Quad (Top)
      gl.glTexCoord2f(0.0f, 1.0f);
      
		
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( -1.0f, 0.0f, 0.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f(-0.30902f, 0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( 0.0f, 0.0f, 2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f(-0.30902f, 0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( 0.80902f, 0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 0.0f, 0.0f, 2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 1f,1f,1f ); //yellow (red + green)
      gl.glVertex3f( 0.80902f, 0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 0.80902f, -0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 0.0f, 0.0f, 2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 1f,0.7f,0.4f ); //purple (red + green)
      gl.glVertex3f( 0.80902f, -0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f(-0.30902f, -0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( 0.0f, 0.0f, 2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 0.7f,0.78f,0.15f ); //green color
      gl.glVertex3f(-0.30902f, -0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 0.0f, 0.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( 0.0f, 0.0f, -2.0f ); // Bottom Left Of The Quad (Top)
		
      gl.glColor3f( 0.5f,0.3f,0f ); //green color
      gl.glVertex3f( -1.0f, 0.0f, 0.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f(-0.30902f, 0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( 0.0f, 0.0f, -2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 0.68f,0.23f,1f ); //blue color
      gl.glVertex3f(-0.30902f, 0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( 0.80902f, 0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 0.0f, 0.0f, -2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 1f,0.6f,0.65f ); //yellow (red + green)
      gl.glVertex3f( 0.80902f, 0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 0.80902f, -0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 0.0f, 0.0f, -2.0f ); // Bottom Left Of The Quad (Top)

      gl.glColor3f( 1f,0.35f,0.15f ); //purple (red + green)
      gl.glVertex3f( 0.80902f, -0.587785f, 0.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f(-0.30902f, -0.95106f, 0.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( 0.0f, 0.0f, -2.0f ); // Bottom Left Of The Quad (Top)

      gl.glEnd(); // Done Drawing The Quad
      gl.glFlush();
		
      xrot += 0.2f;
      yrot += 0.0f;
      zrot += 0.0f;
   }
   
   @Override
   public void dispose( GLAutoDrawable drawable ) {
      // TODO Auto-generated method stub
   }
   
   @Override
   public void init( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
      
      gl.glEnable(GL2.GL_TEXTURE_2D);
      
      try {
    	  File im = new File("/home/tdds/javaExamles/opglLaba/sign.jpeg");
    	  Texture t = TextureIO.newTexture(im,true);
    	  texture = t.getTextureObject(gl);
      }catch (IOException e) {
		// TODO: handle exception
    	  e.printStackTrace();
	} 
   }
      
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
      // TODO Auto-generated method stub
      final GL2 gl = drawable.getGL().getGL2();
      if( height == 0 )
         height = 1;
			
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
   }
      
   
	
}
