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
	public byte[] readBytes(int index, int size);
	public short[] readShorts(int index, int size);
	public int[] readInts(int index, int size);
	public long[] readLongs(int index, int size);
	public float[] readFloats(int index, int size);
	public double[] readDoubles(int index, int size);
	public char[] readChars(int index, int size);
	public boolean[] readBooleans(int index, int size);
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
