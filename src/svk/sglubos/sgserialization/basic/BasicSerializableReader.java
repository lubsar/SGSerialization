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
import svk.sglubos.sgserialization.SerializableReader;

public class BasicSerializableReader implements SerializableReader {
	private static BasicSerializableReader instance = null; 
	
	private BasicSerializableReader() {}
	
	public static BasicSerializableReader get() {
		if(instance == null) {
			instance = new BasicSerializableReader();
		}
		
		return instance;
	}
	
	@Override
	public <T extends Serializable> T readSerializable(T type, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + type.getSize() <= source.length : "Source does not contain enough data";
		
		return type.deserialize(index, source);
	}
	
	@Override
	public int readSerializable2(Serializable destination, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + destination.getSize() <= source.length : "Source does not contain enough data";
		
		return destination.deserialize2(index, source);
	}

	@Override
	public <T extends Serializable> T[] readSerializables(T[] type, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + type[0].getSize() * type.length <= source.length : "Source does not contain enough data";
		
		for(T t : type) {
			t.deserialize(index, source);
			index += t.getSize();
		}
		
		return type;
	}

	@Override
	public int readSerializables2(Serializable[] destination, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + destination[0].getSize() * destination.length <= source.length : "Source does not contain enough data";
		
		for(Serializable s : destination) {
			s.deserialize(index, source);
			index += s.getSize();
		}
		
		return index;
	}
}
