package svk.sglubos.sgserialization.buffer;

import svk.sglubos.sgserialization.Writable;
import svk.sglubos.sgserialization.Readable;

public abstract class Buffer implements Readable, Writable{
	protected byte[] data;
	protected int pointer;
	
	public Buffer(int capacity) {
		data = new byte[capacity];
	}
	
	public int getPointer() {
		return pointer;
	}
	
	public void setPointer(int pointer) {
		this.pointer = pointer;
	}
	
	public byte[] getData() {
		return data;
	}
}
