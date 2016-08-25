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

package svk.sglubos.sgserialization;

import java.nio.charset.Charset;

public interface Readable {
	public byte readByte(int index);
	public short readShort(int index);
	public int readInt(int index);
	public long readLong(int index);
	public float readFloat(int index);
	public double readDouble(int index);
	public char readChar(int index);
	public boolean readBoolean(int index);
	
	public byte[] readBytes(int size, int index);
	public short[] readShorts(int size, int index);
	public int[] readInts(int size, int index);
	public long[] readLongs(int size, int index);
	public float[] readFloats(int size, int index);
	public double[] readDoubles(int size, int index);
	public char[] readChars(int size, int index);
	public boolean[] readBooleans(int size, int index);
	public int read(byte[] location, int index);
	public int read(short[] location, int index);
	public int read(int[] location, int index);
	public int read(long[] location, int index);
	public int read(float[] location, int index);
	public int read(double[] location, int index);
	public int read(char[] location, int index);
	public int read(boolean[] location, int index);
	
	public <T extends Serializable> T readSerializable(T type, int index);
	public int readSerializable2(Serializable destination, int index);
	public <T extends Serializable> T[] readSerializables(T[] type,int index);
	public int readSerializables2(Serializable[] destination, int index);
	
	public String readString(int byteLength, int index);
	public String readString(int byteLength, Charset charset, int index);
}
