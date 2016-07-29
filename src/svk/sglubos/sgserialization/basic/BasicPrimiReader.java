package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.PrimiReader;

public class BasicPrimiReader implements PrimiReader {
	@Override
	public byte readByte(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 1 <= source.length : "Source does not contain enough data";
		
		return source[index];
	}

	@Override
	public short readShort(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 2 <= source.length : "Source does not contain enough data";
		
		return (short)(((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF));
	}

	@Override
	public int readInt(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 4 <= source.length : "Source does not contain enough data";
		
		return ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF);
	}

	@Override
	public long readLong(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 8 <= source.length : "Source does not contain enough data";
		
		return ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF);
	}
	
	@Override
	public float readFloat(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 4 <= source.length : "Source does not contain enough data";
		
		return Float.intBitsToFloat(readInt(index, source));
	}
	
	@Override
	public double readDouble(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 8 <= source.length : "Source does not contain enough data";
		
		return Double.longBitsToDouble(readLong(index, source));
	}

	@Override
	public char readChar(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 2 <= source.length : "Source does not contain enough data";
		
		return (char)(((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF));
	}

	@Override
	public boolean readBoolean(int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 1 <= source.length : "Source does not contain enough data";
		
		return source[index] == 1 ? true : false;
	}
}
