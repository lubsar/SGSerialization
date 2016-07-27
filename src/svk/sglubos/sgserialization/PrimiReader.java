package svk.sglubos.sgserialization;

public interface PrimiReader {
	public byte readByte(int index, byte[] source);
	public short readShort(int index, byte[] source);
	public int readInt(int index, byte[] source);
	public long readLong(int index, byte[] source);
	public float readFloat(int index, byte[] source);
	public double readDouble(int index, byte[] source);
	public char readChar(int index, byte[] source);
	public boolean readBoolean(int index, byte[] source);
}
