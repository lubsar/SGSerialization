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

import svk.sglubos.sgserialization.PrimiArrWriter;

public class BasicPrimiArrWriter implements PrimiArrWriter {
	private static BasicPrimiArrWriter instance = null; 
	
	private BasicPrimiArrWriter() {}
	
	public static BasicPrimiArrWriter get() {
		if(instance == null) {
			instance = new BasicPrimiArrWriter();
		}
		
		return instance;
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
}
