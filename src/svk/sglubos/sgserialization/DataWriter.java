package svk.sglubos.sgserialization;

public abstract class DataWriter {
	public abstract int write(byte data, int index, byte[] location);
	public abstract int write(short data, int index, byte[] location);
	public abstract int write(int data, int index, byte[] location);
	public abstract int write(long data, int index, byte[] location);
	public abstract int write(float data, int index, byte[] location);
	public abstract int write(double data, int index, byte[] location);
	public abstract int write(char data, int index, byte[] location);
	public abstract int write(boolean data, int index, byte[] location);
}
