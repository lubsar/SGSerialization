package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.PrimiArrReader;

public class BasicPrimiArrReader implements PrimiArrReader {

	@Override
	public byte[] readBytes(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size <= source.length : "Source does not contain enough data";
		
		byte[] data = new byte[size];
		System.arraycopy(source, index, data, 0, size);
		return data;
	}

	@Override
	public short[] readShorts(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 2 <= source.length : "Source does not contain enough data";
		
		short[] data = new short[size];
		for(int i = 0; i < size; i++) {
			data[i] = (short)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return data;
	}

	@Override
	public int[] readInts(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 4 <= source.length : "Source does not contain enough data";
		
		int[] data = new int[size];
		for(int i = 0; i < size; i++) {
			data[i] = ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return data;
	}

	@Override
	public long[] readLongs(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 8 <= source.length : "Source does not contain enough data";
		
		long[] data = new long[size];
		for(int i = 0; i < size; i++) {
			data[i] = ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return data;
	}

	@Override
	public float[] readFloats(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 4 <= source.length : "Source does not contain enough data";
		
		float[] data = new float[size];
		for(int i = 0; i < size; i++) {
			data[i] = Float.intBitsToFloat(((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	@Override
	public double[] readDoubles(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 8 <= source.length : "Source does not contain enough data";
		
		double[] data = new double[size];
		for(int i = 0; i < size; i++) {
			data[i] = Double.longBitsToDouble(((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return data;
	}

	@Override
	public char[] readChars(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 2 <= source.length : "Source does not contain enough data";
		
		char[] data = new char[size];
		for(int i = 0; i < size; i++) {
			data[i] = (char)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return data;
	}

	@Override
	public boolean[] readBooleans(int size, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + size * 1 <= source.length : "Source does not contain enough data";
		
		boolean[] data = new boolean[size];
		for(int i = 0; i < size; i++) {
			data[i] = source[index] == 1 ? true : false;
		}
		return data;
	}

	@Override
	public int read(byte[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length : "Source does not contain enough data";
		
		System.arraycopy(source, index, location, 0, location.length);
		return index;
	}

	@Override
	public int read(short[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length * 2 : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = (short)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(int[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length * 4 : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return index;
	}

	@Override
	public int read(long[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length * 8 : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF);
		}
		return index;
	}
	
	@Override
	public int read(float[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length * 4 : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = Float.intBitsToFloat(((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(double[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length * 8 : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = Double.longBitsToDouble(((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index++] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(char[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length * 2 : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = (char)(((source[index++] & 0xFF) << 8) ^ (source[index++ ] & 0xFF));
		}
		return index;
	}

	@Override
	public int read(boolean[] location, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + location.length <= source.length : "Source does not contain enough data";
		
		for(int i = 0; i < location.length; i++) {
			location[i] = source[index] == 1 ? true : false;
		}
		return index;
	}
}
