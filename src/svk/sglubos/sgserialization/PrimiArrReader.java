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

public interface PrimiArrReader {
	public byte[] readBytes(int size, int index, byte[] source);
	public short[] readShorts(int size, int index, byte[] source);
	public int[] readInts(int size, int index, byte[] source);
	public long[] readLongs(int size, int index, byte[] source);
	public float[] readFloats(int size, int index, byte[] source);
	public double[] readDoubles(int size, int index, byte[] source);
	public char[] readChars(int size, int index, byte[] source);
	public boolean[] readBooleans(int size, int index, byte[] source);
	
	public int read(byte[] location, int index, byte[] source);
	public int read(short[] location, int index, byte[] source);
	public int read(int[] location, int index, byte[] source);
	public int read(long[] location, int index, byte[] source);
	public int read(float[] location, int index, byte[] source);
	public int read(double[] location, int index, byte[] source);
	public int read(char[] location, int index, byte[] source);
	public int read(boolean[] location, int index, byte[] source);
}
