/* The MIT License (MIT)
 *
 * Copyright (c) 2017 Ľubomír Hlavko
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

package svk.sglubos.sgserialization.bitfield;

import svk.sglubos.sgserialization.utils.UtilitySerializer;

public class Bitfield64 implements Bitfield {
	public long data;
	
	public Bitfield64() {}
	
	public Bitfield64(long data) {
		this.data = data;
	}
	
	@Override
	public int serialize(int index, byte[] location) {
		return UtilitySerializer.write(data, index, location);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bitfield64 deserialize(int index, byte[] source) {
		return new Bitfield64(UtilitySerializer.readLong(index, source));
	}

	@Override
	public int deserialize2(int index, byte[] source) {
		this.data = UtilitySerializer.readLong(index, source);
		return index + 8;
	}

	@Override
	public int getSize() {
		return 8;
	}

	@Override
	public byte getBit(byte bit) {
		assert (bit >= 0) && (bit < 64): "Bit must be between 0 and 63"; 
		return (byte) ((data >> bit) & 0x0000000000000001L); 
	}

	@Override
	public void setBit(byte bit) {
		assert (bit >= 0) && (bit < 64): "Bit must be between 0 and 63";
		data |= (1L << bit);
	}

	@Override
	public void clearBit(byte bit) {
		assert (bit >= 0) && (bit < 64): "Bit must be between 0 and 63";
		data = (data & ~(1L << bit));
	}

	@Override
	public void toggleBit(byte bit) {
		assert (bit >= 0) && (bit < 64): "Bit must be between 0 and 63";
		data ^= 1L << bit;
	}
}
