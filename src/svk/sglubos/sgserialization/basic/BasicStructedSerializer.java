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

import java.nio.charset.Charset;

import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.StructedSerializer;

public class BasicStructedSerializer implements StructedSerializer {
	private static BasicStructedSerializer INSTANCE = null;
	
	protected BasicStructedSerializer() {}
	
	public static BasicStructedSerializer get() {
		if(INSTANCE == null) {
			INSTANCE = new BasicStructedSerializer();
		}
		
		return INSTANCE;
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

	@Override
	public int write(String data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		byte[] dataBytes = data.getBytes();
		assert index + dataBytes.length <= destination.length : "Destionation does not have enough capacity";
		
		System.arraycopy(dataBytes, 0, destination, index, dataBytes.length);
		
		return index + dataBytes.length;
	}
	
	@Override
	public int write(String data, Charset charset, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		byte[] dataBytes = data.getBytes(charset);
		assert index + dataBytes.length <= destination.length : "Destionation does not have enough capacity";
		assert charset != null : "Charset cannot be null";
		assert Charset.isSupported(charset.name()) : "Charset is not supported";
		
		System.arraycopy(dataBytes, 0, destination, index, dataBytes.length);
		
		return index + dataBytes.length;
	}
	
	@Override
	public String readString(int byteLength, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert byteLength >= 0 : "String length cannot be less than 0";
		assert index + byteLength <= source.length : "Source does not contain enough data";
		
		return new String(source, index, byteLength);
	}
	
	@Override
	public String readString(int byteLength, Charset charset, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert byteLength >= 0 : "String length cannot be less than 0";
		assert index + byteLength <= source.length : "Source does not contain enough data";
		assert charset != null : "Charset cannot be null";
		assert Charset.isSupported(charset.name()) : "Charset is not supported";
		
		return new String(source, index, byteLength, charset);
	}
}
