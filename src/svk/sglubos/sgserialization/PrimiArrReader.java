package svk.sglubos.sgserialization;

public interface PrimiArrReader {
	public byte[] readBytes(int size, int index, byte[] source);
	public short[] readShorts(int size, int index, byte[] source);
	public int[] readInts(int size, int index, byte[] source);
	public long[] readLongs(int size, int index, byte[] source);
	public float[] readFloats(int size, int index, byte[] source);
	public double[] readDoubles(int size, int index, byte[] source);
	public char[] readChars(int size, int index, byte[] source);
	public boolean[] readBooleans(int size, int index, byte[] source);
	
	public int read(byte[] location, int index, byte[] source);
	public int read(short[] location, int index, byte[] source);
	public int read(int[] location, int index, byte[] source);
	public int read(long[] location, int index, byte[] source);
	public int read(float[] location, int index, byte[] source);
	public int read(double[] location, int index, byte[] source);
	public int read(char[] location, int index, byte[] source);
	public int read(boolean[] location, int index, byte[] source);
}
