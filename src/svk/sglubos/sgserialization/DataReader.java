package svk.sglubos.sgserialization;

public abstract class DataReader {
	public abstract byte readByte(int index, byte[] source);
	public abstract short readShort(int index, byte[] source);
	public abstract int readInt(int index, byte[] source);
	public abstract long readLong(int index, byte[] source);
	public abstract float readFloat(int index, byte[] source);
	public abstract double readDouble(int index, byte[] source);
	public abstract char readChar(int index, byte[] source);
	public abstract boolean readBoolean(int index, byte[] source);
}
