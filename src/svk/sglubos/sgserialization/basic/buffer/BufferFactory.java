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


package svk.sglubos.sgserialization.basic.buffer;

import svk.sglubos.sgserialization.PrimiSerializer;
import svk.sglubos.sgserialization.StructedSerializer;
import svk.sglubos.sgserialization.basic.BasicPrimiSerializer;
import svk.sglubos.sgserialization.basic.BasicStructedSerializer;
import svk.sglubos.sgserialization.buffer.DynamicBuffer;
import svk.sglubos.sgserialization.buffer.StaticBuffer;

public class BufferFactory {
	private static final PrimiSerializer defaultPrimiSerializer = BasicPrimiSerializer.get();
	private static final StructedSerializer defaultStructedSerializer = BasicStructedSerializer.get();

	public static StaticBuffer createStaticBuffer(int capacity) {
		return new StaticBuffer(capacity, defaultPrimiSerializer, defaultStructedSerializer);
	}

	public static StaticBuffer createStaticBuffer(int capacity, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		return new StaticBuffer(capacity, primiSerializer, structedSerializer);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, int expansion) {
		return new DynamicBuffer(capacity, expansion, defaultPrimiSerializer, defaultStructedSerializer);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, int expansion, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		return new DynamicBuffer(capacity, expansion, primiSerializer, structedSerializer);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, float expansionRate) {
		return new DynamicBuffer(capacity, expansionRate, defaultPrimiSerializer, defaultStructedSerializer);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, float expansionRate, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		return new DynamicBuffer(capacity, expansionRate, primiSerializer, structedSerializer);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity) {
		return new DynamicBuffer(capacity, defaultPrimiSerializer, defaultStructedSerializer);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity,  PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		return new DynamicBuffer(capacity, primiSerializer, structedSerializer);
	}
}
