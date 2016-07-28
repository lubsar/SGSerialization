package svk.sglubos.sgserialization.utils;

import svk.sglubos.sgserialization.Serializable;

public class UtilityReader {
	
	public static byte readByte(int index, byte[] source) {
		return source[index];
	}
	
	public static short readShort(int index, byte[] source) {
		return (short)(((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF));
	}
	
	public static int readInt(int index, byte[] source) {
		return ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF);
	}
	
	public static long readLong(int index, byte[] source) {
		return ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF);
	}
	
	public static float readFloat(int index, byte[] source) {
		return Float.intBitsToFloat(readInt(index, source));
	}
	
	public static double readDouble(int index, byte[] source) {
		return Double.longBitsToDouble(readLong(index, source));
	}

	public static char readChar(int index, byte[] source) {
		return (char)(((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF));
	}

	public static boolean readBoolean(int index, byte[] source) {
		return source[index] == 1 ? true : false;
	}
	
	public static byte[] readBytes(int index, int size, byte[] source) {
		byte[] data = new byte[size];
		System.arraycopy(source, index, data, 0, size);
		return data;
	}

	public static short[] readShorts(int index, int size, byte[] source) {
		short[] data = new short[size];
		for (int i = 0; i < size; i++) {
			data[i] = (short) (((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	public static int[] readInts(int index, int size, byte[] source) {
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return data;
	}

	public static long[] readLongs(int index, int size, byte[] source) {
		long[] data = new long[size];
		for (int i = 0; i < size; i++) {
			data[i] = ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48)
					^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32)
					^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return data;
	}

	public static float[] readFloats(int index, int size, byte[] source) {
		float[] data = new float[size];
		for (int i = 0; i < size; i++) {
			data[i] = Float.intBitsToFloat(((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	public static double[] readDoubles(int index, int size, byte[] source) {
		double[] data = new double[size];
		for (int i = 0; i < size; i++) {
			data[i] = Double.longBitsToDouble(((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48)
					^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32)
					^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	public static char[] readChars(int index, int size, byte[] source) {
		char[] data = new char[size];
		for (int i = 0; i < size; i++) {
			data[i] = (char) (((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	public static boolean[] readBooleans(int index, int size, byte[] source) {
		boolean[] data = new boolean[size];
		for (int i = 0; i < size; i++) {
			data[i] = source[index] == 1 ? true : false;
		}
		return data;
	}

	public static int read(byte[] location, int index, byte[] source) {
		System.arraycopy(source, index, location, 0, location.length);
		return index;
	}

	public int read(short[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = (short) (((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	public static int read(int[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return index;
	}

	public static int read(long[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48)
					^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32)
					^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return index;
	}

	public static int read(float[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = Float.intBitsToFloat(((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	public static int read(double[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = Double.longBitsToDouble(((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48)
					^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32)
					^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16)
					^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	public static int read(char[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = (char) (((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	public static int read(boolean[] location, int index, byte[] source) {
		for (int i = 0; i < location.length; i++) {
			location[i] = source[index] == 1 ? true : false;
		}
		return index;
	}
	
	public <T extends Serializable> T read(T type,int index, byte[] source) {
		return type.deserialize(index, source);
	}
	
	public int read2(Serializable destination, int index, byte[] source) {
		return destination.deserialize2(index, source);
	}
	
	private static final void checkIndex(int index, int size, int destinationCapacity) throws RuntimeException, IndexOutOfBoundsException {
		if(index + size > destinationCapacity){
			throw new RuntimeException("Not enough space in destination array");
		}
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index can not be less than 0");
		}
	}
}
