package figure.model;

public class Rettangolo {
	/**
	 * x y indicano la posizione sullo schermo (pixel)
	 */
	private int x,y,base,altezza;

	public Rettangolo(int x, int y, int base, int altezza) {
		this.x = x;
		this.y = y;
		this.base = base;
		this.altezza = altezza;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	
}
