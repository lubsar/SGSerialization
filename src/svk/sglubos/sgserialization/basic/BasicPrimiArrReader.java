package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.PrimiArrReader;

public class BasicPrimiArrReader implements PrimiArrReader {

	@Override
	public byte[] readBytes(int index, int size, byte[] source) {
		byte[] data = new byte[size];
		System.arraycopy(source, index, data, 0, size);
		return data;
	}

	@Override
	public short[] readShorts(int index, int size, byte[] source) {
		short[] data = new short[size];
		for(int i = 0; i < size; i++) {
			data[i] = (short)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return data;
	}

	@Override
	public int[] readInts(int index, int size, byte[] source) {
		int[] data = new int[size];
		for(int i = 0; i < size; i++) {
			data[i] = ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return data;
	}

	@Override
	public long[] readLongs(int index, int size, byte[] source) {
		long[] data = new long[size];
		for(int i = 0; i < size; i++) {
			data[i] = ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return data;
	}

	@Override
	public float[] readFloats(int index, int size, byte[] source) {
		float[] data = new float[size];
		for(int i = 0; i < size; i++) {
			data[i] = Float.intBitsToFloat(((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	@Override
	public double[] readDoubles(int index, int size, byte[] source) {
		double[] data = new double[size];
		for(int i = 0; i < size; i++) {
			data[i] = Double.longBitsToDouble(((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	@Override
	public char[] readChars(int index, int size, byte[] source) {
		char[] data = new char[size];
		for(int i = 0; i < size; i++) {
			data[i] = (char)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return data;
	}

	@Override
	public boolean[] readBooleans(int index, int size, byte[] source) {
		boolean[] data = new boolean[size];
		for(int i = 0; i < size; i++) {
			data[i] = source[index] == 1 ? true : false;
		}
		return data;
	}

	@Override
	public int read(byte[] location, int index, byte[] source) {
		System.arraycopy(source, index, location, 0, location.length);
		return index;
	}

	@Override
	public int read(short[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = (short)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(int[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return index;
	}

	@Override
	public int read(long[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return index;
	}
	
	@Override
	public int read(float[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = Float.intBitsToFloat(((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(double[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = Double.longBitsToDouble(((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(char[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = (char)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(boolean[] location, int index, byte[] source) {
		for(int i = 0; i < location.length; i++) {
			location[i] = source[index] == 1 ? true : false;
		}
		return index;
	}
}
