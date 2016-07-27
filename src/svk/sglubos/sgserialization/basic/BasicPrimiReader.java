package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.PrimiReader;

public class BasicPrimiReader implements PrimiReader {
	@Override
	public byte readByte(int index, byte[] source) {
		return source[index];
	}

	@Override
	public short readShort(int index, byte[] source) {
		return (short)(((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF));
	}

	@Override
	public int readInt(int index, byte[] source) {
		return ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF);
	}

	@Override
	public long readLong(int index, byte[] source) {
		return ((source[index++] & 0xFF) << 56) ^ ((source[index++] & 0xFF) << 48) ^ ((source[index++] & 0xFF) << 40) ^ ((source[index++] & 0xFF) << 32) ^ ((source[index++] & 0xFF) << 24) ^ ((source[index++] & 0xFF) << 16) ^ ((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF);
	}
	
	@Override
	public float readFloat(int index, byte[] source) {
		return Float.intBitsToFloat(readInt(index, source));
	}
	
	@Override
	public double readDouble(int index, byte[] source) {
		return Double.longBitsToDouble(readLong(index, source));
	}

	@Override
	public char readChar(int index, byte[] source) {
		return (char)(((source[index++] & 0xFF) << 8) ^ (source[index] & 0xFF));
	}

	@Override
	public boolean readBoolean(int index, byte[] source) {
		return source[index] == 1 ? true : false;
	}
}
