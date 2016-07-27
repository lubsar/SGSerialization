package svk.sglubos.sgserialization;

public interface PrimiArrReader {
	public byte[] readBytes(int index, int size, byte[] source);
	public short[] readShorts(int index, int size, byte[] source);
	public int[] readInts(int index, int size, byte[] source);
	public long[] readLongs(int index, int size, byte[] source);
	public float[] readFloats(int index, int size, byte[] source);
	public double[] readDoubles(int index, int size, byte[] source);
	public char[] readChars(int index, int size, byte[] source);
	public boolean[] readBooleans(int index, int size, byte[] source);
	
	public int read(byte[] location, int index, byte[] source);
	public int read(short[] location, int index, byte[] source);
	public int read(int[] location, int index, byte[] source);
	public int read(long[] location, int index, byte[] source);
	public int read(float[] location, int index, byte[] source);
	public int read(double[] location, int index, byte[] source);
	public int read(char[] location, int index, byte[] source);
	public int read(boolean[] location, int index, byte[] source);
}
