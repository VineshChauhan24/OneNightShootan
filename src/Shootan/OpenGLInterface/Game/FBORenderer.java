package Shootan.OpenGLInterface.Game;

import Shootan.OpenGLInterface.Graphics.Shader;
import Shootan.OpenGLInterface.Graphics.VertexArray;
import Shootan.OpenGLInterface.Math.Matrix4f;


public class FBORenderer {


	public static float width = Camera.size;
	public static float height = Camera.size;

	private static float[] vertices = new float[]{
			-width, -height, 0.2f,
			-width,  height, 0.2f,
			width,  height, 0.2f,
			width, -height, 0.2f

	};

	private static float[] texCoords = new float[]{
			0, 1,
			0, 0,
			1, 0,
			1, 1
	};

	private static int[] indices = new int[]{
			0,1,2,
			2,3,0
	};

	private static VertexArray VAO;

	static {
		VAO = new VertexArray(vertices, indices, texCoords);
	}

	public FBORenderer() {
	}

	public void render(Matrix4f position, Shader s) {
		s.setUniformMat4f(s.modelMatrixUniformId, position);
		VAO.render();
	}

		public void render(float x, float y, Shader s) {
		s.setUniformMat4f(s.modelMatrixUniformId, Matrix4f.translate(x, y, 0));
		VAO.render();
	}

	
}