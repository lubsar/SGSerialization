package svk.sglubos.sgserialization;

public interface Writable {
	public int write(byte data, int index);
	public int write(short data, int index);
	public int write(int data, int index);
	public int write(long data, int index);
	public int write(float data, int index);
	public int write(double data, int index);
	public int write(char data, int index);
	public int write(boolean data, int index);
	public int write(byte[] data, int index);
	public int write(short[] data, int index);
	public int write(int[] data, int index);
	public int write(long[] data, int index);
	public int write(float[] data, int index);
	public int write(double[] data, int index);
	public int write(char[] data, int index);
	public int write(boolean[] data, int index);
	public int write(Serializable data, int index);
	public int write(Serializable[] data, int index);
}