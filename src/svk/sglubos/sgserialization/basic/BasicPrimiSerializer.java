/* The MIT License (MIT)
 *
 * Copyright (c) 2016 Ľubomír Hlavko
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.PrimiSerializer;

public class BasicPrimiSerializer implements PrimiSerializer {
	private static BasicPrimiSerializer INSTANCE = null;
	
	private BasicPrimiSerializer() {}
	
	public static BasicPrimiSerializer get() {
		if(INSTANCE == null) {
			INSTANCE = new BasicPrimiSerializer();
		}
		
		return INSTANCE;
	}
	
	@Override
	public int write(byte data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 1 <= destination.length : "Destination does not have enough capacity";
		
		destination[index++] = data;
		return index;
	}

	@Override
	public int write(short data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 2 <= destination.length : "Destination does not have enough capacity";
		
		destination[index++] = (byte)((data >> 8) & 0xFF);
		destination[index++] = (byte)(data & 0x00FF);
		return index;
	}

	@Override
	public int write(int data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 4 <= destination.length : "Destination does not have enough capacity";
		
		destination[index++] = (byte)((data >> 24) & 0xFF);
		destination[index++] = (byte)((data >> 16) & 0x00FF);
		destination[index++] = (byte)((data >> 8) & 0x0000FF);
		destination[index++] = (byte)(data & 0x000000FF);
		return index;
	}

	@Override
	public int write(long data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 8 <= destination.length : "Destination does not have enough capacity";
		
		destination[index++] = (byte)((data >> 56) & 0xFF);
		destination[index++] = (byte)((data >> 48) & 0x00FF);
		destination[index++] = (byte)((data >> 40) & 0x0000FF);
		destination[index++] = (byte)((data >> 32) & 0x000000FF);
		destination[index++] = (byte)((data >> 24) & 0x00000000FF);
		destination[index++] = (byte)((data >> 16) & 0x0000000000FF);
		destination[index++] = (byte)((data >> 8) & 0x000000000000FF);
		destination[index++] = (byte)(data & 0x00000000000000FF);
		return index;
	}
	
	@Override
	public int write(float data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 4 <= destination.length : "Destination does not have enough capacity";
		
		int bits = Float.floatToRawIntBits(data);
		
		destination[index++] = (byte)((bits >> 24) & 0xFF);
		destination[index++] = (byte)((bits >> 16) & 0x00FF);
		destination[index++] = (byte)((bits >> 8) & 0x0000FF);
		destination[index++] = (byte)(bits & 0x000000FF);
		return index;
	}
	
	@Override
	public int write(double data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 8 <= destination.length : "Destination does not have enough capacity";
		
		long bits = Double.doubleToRawLongBits(data);
		
		destination[index++] = (byte)((bits >> 56) & 0xFF);
		destination[index++] = (byte)((bits >> 48) & 0x00FF);
		destination[index++] = (byte)((bits >> 40) & 0x0000FF);
		destination[index++] = (byte)((bits >> 32) & 0x000000FF);
		destination[index++] = (byte)((bits >> 24) & 0x00000000FF);
		destination[index++] = (byte)((bits >> 16) & 0x0000000000FF);
		destination[index++] = (byte)((bits >> 8) & 0x000000000000FF);
		destination[index++] = (byte)(bits & 0x00000000000000FF);
		return index;
	}

	@Override
	public int write(char data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 2 <= destination.length : "Destination does not have enough capacity";
		
		destination[index++] = (byte)((data >> 8) & 0xFF);
		destination[index++] = (byte)(data & 0x00FF);
		return index;
	}

	@Override
	public int write(boolean data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + 1 <= destination.length : "Destination does not have enough capacity";
		
		destination[index++] = (byte) (data ? 1 : 0);
		return index;
	}
	
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
	@Override
	public int write(byte[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length <= destination.length : "Destination does not have enough capacity";
		
		System.arraycopy(data, 0, destination, index, data.length);
		
		return index + data.length;
	}

	@Override
	public int write(short[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 2 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 8) & 0xFF);
			destination[index++] = (byte)(data[i] & 0x00FF);
		}
		
		return index;
	}

	@Override
	public int write(int[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 4 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 24) & 0xFF);
			destination[index++] = (byte)((data[i] >> 16) & 0x00FF);
			destination[index++] = (byte)((data[i] >> 8) & 0x0000FF);
			destination[index++] = (byte)(data[i] & 0x000000FF);
		}
		
		return index;
	}

	@Override
	public int write(long[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 8 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 56) & 0xFF);
			destination[index++] = (byte)((data[i] >> 48) & 0x00FF);
			destination[index++] = (byte)((data[i] >> 40) & 0x0000FF);
			destination[index++] = (byte)((data[i] >> 32) & 0x000000FF);
			destination[index++] = (byte)((data[i] >> 24) & 0x00000000FF);
			destination[index++] = (byte)((data[i] >> 16) & 0x0000000000FF);
			destination[index++] = (byte)((data[i] >> 8) & 0x000000000000FF);
			destination[index++] = (byte)(data[i] & 0x00000000000000FF);
		}
		
		return index;
	}
	
	@Override
	public int write(float[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 4 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			int bits = Float.floatToRawIntBits(data[i]);
			destination[index++] = (byte)((bits >> 24) & 0xFF);
			destination[index++] = (byte)((bits >> 16) & 0x00FF);
			destination[index++] = (byte)((bits >> 8) & 0x0000FF);
			destination[index++] = (byte)(bits & 0x000000FF);
		}
		
		return index;
	}
	
	@Override
	public int write(double[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 8 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			long bits = Double.doubleToRawLongBits(data[i]);
			destination[index++] = (byte)((bits >> 56) & 0xFF);
			destination[index++] = (byte)((bits >> 48) & 0x00FF);
			destination[index++] = (byte)((bits >> 40) & 0x0000FF);
			destination[index++] = (byte)((bits >> 32) & 0x000000FF);
			destination[index++] = (byte)((bits >> 24) & 0x00000000FF);
			destination[index++] = (byte)((bits >> 16) & 0x0000000000FF);
			destination[index++] = (byte)((bits >> 8) & 0x000000000000FF);
			destination[index++] = (byte)(bits & 0x00000000000000FF);
		}
		
		return index;
	}

	@Override
	public int write(char[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 2 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 8) & 0xFF);
			destination[index++] = (byte)(data[i] & 0x00FF);
		}
		
		return index;
	}

	@Override
	public int write(boolean[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.length * 1 <= destination.length : "Destination does not have enough capacity";
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte) (data[i] ? 1 : 0);
		}
		
		return index;
	}
	
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
