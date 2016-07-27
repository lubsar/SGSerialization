package svk.sglubos.sgserialization;

public interface PrimiArrWriter {
	public int write(byte[] data, int index, byte[] destination);
	public int write(short[] data, int index, byte[] destination);
	public int write(int[] data, int index, byte[] destination);
	public int write(long[] data, int index, byte[] destination);
	public int write(float[] data, int index, byte[] destination);
	public int write(double[] data, int index, byte[] destination);
	public int write(char[] data, int index, byte[] destination);
	public int write(boolean[] data, int index, byte[] destination);
}
