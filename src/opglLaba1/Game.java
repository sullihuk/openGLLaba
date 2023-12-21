package opglLaba1;
import java.nio.*;
import javax.swing.*;
import java.lang.Math;
import com.jogamp.common.nio.Buffers;
import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.math.Matrix4f;
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GLContext;
import org.joml.*;

 
public class Game extends JFrame implements GLEventListener{
	//private static final long serialVersionUID = 1L;
	
	private GLCanvas myCanvas;
	
	private int renderingProgram;
	private int vao[] = new int[1];
	private int vbo[] = new int[2];
	private float cameraX,cameraY,cameraZ;
	private float cubeLocX,cubeLocY,cubeLocZ;
	
	private FloatBuffer vals = Buffers.newDirectFloatBuffer(16); 
	private Matrix4f pMat = new Matrix4f(); 
	private Matrix4f vMat = new Matrix4f(); 
	private Matrix4f mMat = new Matrix4f(); 
	private Matrix4f mvMat = new Matrix4f(); 
	private int mvLoc, pLoc; 
	private float aspect; 
	
	
	final private int width = 800;
	final private int height = 600;

	public Game () {
		setTitle("CUBE");
		setSize(width, height);
		//GLProfile profile = GLProfile.get(GLProfile.GL4);
		//GLCapabilities capabilities = new GLCapabilities(profile);
		
		GLCanvas canvas = new GLCanvas();
		canvas.addGLEventListener(this);
		
		//this.setName("Laba OpenGL");
		//this.getContentPane().add(canvas);
		
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		//canvas.requestFocusInWindow();
	}
	

	public void play () {
	}
	
	@Override
	public void display (GLAutoDrawable drawable) {
		
		GL4 gl = drawable.getGL().getGL4();
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT |GL4.GL_DEPTH_BUFFER_BIT);
		gl.glFlush();
	}

	@Override
	public void dispose (GLAutoDrawable drawable) {
		
	}

	@Override
	public void init (GLAutoDrawable drawable) {
		GL4 gl = (GL4)GLContext.getCurrentGL();
		renderingProgram = Utils.createShaderProgram("vertShader.glsl", "fragShader.glsl");
		setupVertices();
		gl.glClearColor(0.392f, 0.584f, 0929f, 1.0f);
	}

	@Override
	public void reshape (GLAutoDrawable drawable, int x, int y, int width, int height) {
		
	}
}
