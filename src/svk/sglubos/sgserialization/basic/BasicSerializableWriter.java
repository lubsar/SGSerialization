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

import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableWriter;

public class BasicSerializableWriter implements SerializableWriter {
	private static BasicSerializableWriter instance = null; 
	
	private BasicSerializableWriter() {}
	
	public static BasicSerializableWriter get() {
		if(instance == null) {
			instance = new BasicSerializableWriter();
		}
		
		return instance;
	}
	
	@Override
	public int write(Serializable data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.getSize() <= destination.length : "Destionation does not have enough capacity";
		
		return data.serialize(index, destination);
	}

	@Override
	public int write(Serializable[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data[0].getSize() * data.length <= destination.length : "Destionation does not have enough capacity";
		
		for(Serializable s : data) {
			s.serialize(index, destination);
			index += s.getSize();
		}
		
		return index;
	}
}
