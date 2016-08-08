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

import svk.sglubos.sgserialization.PrimiReader;

public class BasicPrimiReader implements PrimiReader {
	private static BasicPrimiReader instance = null; 
	
	private BasicPrimiReader() {}
	
	public static BasicPrimiReader get() {
		if(instance == null) {
			instance = new BasicPrimiReader();
		}
		
		return instance;
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
}
