package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.PrimiWriter;

public class BasicPrimiWriter implements PrimiWriter {
	@Override
	public int write(byte data, int index, byte[] destination) {
		if(index + 1 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		destination[index++] = data;
		return index;
	}

	@Override
	public int write(short data, int index, byte[] destination) {
		if(index + 2 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		destination[index++] = (byte)((data >> 8) & 0xFF);
		destination[index++] = (byte)(data & 0x00FF);
		return index;
	}

	@Override
	public int write(int data, int index, byte[] destination) {
		if(index + 4 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		destination[index++] = (byte)((data >> 24) & 0xFF);
		destination[index++] = (byte)((data >> 16) & 0x00FF);
		destination[index++] = (byte)((data >> 8) & 0x0000FF);
		destination[index++] = (byte)(data & 0x000000FF);
		return index;
	}

	@Override
	public int write(long data, int index, byte[] destination) {
		if(index + 8 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		destination[index++] = (byte)((data >> 56) & 0xFF);
		destination[index++] = (byte)((data >> 48) & 0x00FF);
		destination[index++] = (byte)((data >> 40) & 0x0000FF);
		destination[index++] = (byte)((data >> 32) & 0x000000FF);
		destination[index++] = (byte)((data >> 24) & 0x00000000FF);
		destination[index++] = (byte)((data >> 16) & 0x0000000000FF);
		destination[index++] = (byte)((data >> 8) & 0x000000000000FF);
		destination[index++] = (byte)(data & 0x00000000000000FF);
		return index;
	}
	
	@Override
	public int write(float data, int index, byte[] destination) {
		if(index + 4 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		int bits = Float.floatToRawIntBits(data);
		
		destination[index++] = (byte)((bits >> 24) & 0xFF);
		destination[index++] = (byte)((bits >> 16) & 0x00FF);
		destination[index++] = (byte)((bits >> 8) & 0x0000FF);
		destination[index++] = (byte)(bits & 0x000000FF);
		return index;
	}
	
	@Override
	public int write(double data, int index, byte[] destination) {
		if(index + 8 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		long bits = Double.doubleToRawLongBits(data);
		
		destination[index++] = (byte)((bits >> 56) & 0xFF);
		destination[index++] = (byte)((bits >> 48) & 0x00FF);
		destination[index++] = (byte)((bits >> 40) & 0x0000FF);
		destination[index++] = (byte)((bits >> 32) & 0x000000FF);
		destination[index++] = (byte)((bits >> 24) & 0x00000000FF);
		destination[index++] = (byte)((bits >> 16) & 0x0000000000FF);
		destination[index++] = (byte)((bits >> 8) & 0x000000000000FF);
		destination[index++] = (byte)(bits & 0x00000000000000FF);
		return index;
	}

	@Override
	public int write(char data, int index, byte[] destination) {
		if(index + 2 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		destination[index++] = (byte)((data >> 8) & 0xFF);
		destination[index++] = (byte)(data & 0x00FF);
		return index;
	}

	@Override
	public int write(boolean data, int index, byte[] destination) {
		if(index + 1 > destination.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		destination[index++] = (byte) (data ? 1 : 0);
		return index;
	}
}
