package svk.sglubos.sgserialization;

public interface Readable {
	public byte readByte(int index);
	public short readShort(int index);
	public int readInt(int index);
	public long readLong(int index);
	public float readFloat(int index);
	public double readDouble(int index);
	public char readChar(int index);
	public boolean readBoolean(int index);
	public byte[] readBytes(int size, int index);
	public short[] readShorts(int size, int index);
	public int[] readInts(int size, int index);
	public long[] readLongs(int size, int index);
	public float[] readFloats(int size, int index);
	public double[] readDoubles(int size, int index);
	public char[] readChars(int size, int index);
	public boolean[] readBooleans(int size, int index);
	public int read(byte[] location, int index);
	public int read(short[] location, int index);
	public int read(int[] location, int index);
	public int read(long[] location, int index);
	public int read(float[] location, int index);
	public int read(double[] location, int index);
	public int read(char[] location, int index);
	public int read(boolean[] location, int index);
	public <T extends Serializable> T readSerializable(T type, int index);
	public int readSerializable2(Serializable destination, int index);
}
