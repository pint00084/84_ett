public class Vertex implements Comparable<Vertex> {
	public enum Color {
		WHITE, 
		GREY, 
		BLACK
	}
	
	public String name;  
	public Vertex predecessor;
	public static final int INFINITY = Integer.MAX_VALUE;
	public Color color;

	public Vertex(String v) {
		name = v;
		predecessor = null;
		color = Color.WHITE;
	}

	public int hashCode() {
		return name.hashCode();
	}
	
	public String toString() { 
		return name;
	}
	
	public int compareTo(Vertex other) {
	    return name.compareTo(other.name);
	}
}