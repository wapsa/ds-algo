package edu.sau;

import java.util.Objects;

public class Triangle {

	private static class TriangleCoordinate {
		private int x;
		private int y;

		public TriangleCoordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TriangleCoordinate other = (TriangleCoordinate) obj;
			return x == other.x && y == other.y;
		}

	}

	private TriangleCoordinate v1;
	private TriangleCoordinate v2;
	private TriangleCoordinate v3;

	public Triangle(int v1x, int v1y, int v2x, int v2y, int v3x, int v3y) {
		super();
		this.v1 = new TriangleCoordinate(v1x, v1y);
		this.v2 = new TriangleCoordinate(v2x, v2y);
		this.v3 = new TriangleCoordinate(v3x, v3y);
	}

	public TriangleCoordinate getV1() {
		return v1;
	}

	public TriangleCoordinate getV2() {
		return v2;
	}

	public TriangleCoordinate getV3() {
		return v3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(v1, v2, v3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Objects.equals(v1, other.v1) && Objects.equals(v2, other.v2) && Objects.equals(v3, other.v3);
	}

}
