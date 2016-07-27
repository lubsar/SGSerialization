package svk.sglubos.sgserialization.utils;

public class UtilityWriter {
	public static int write(byte data, int index, byte[] location) {
		if(index + 1 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		location[index++] = data;
		return index;
	}
	
	public static int write(short data, int index, byte[] location) {
		if(index + 2 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		location[index++] = (byte)((data >> 8) & 0xFF);
		location[index++] = (byte)(data & 0x00FF);
		return index;
	}
	
	public static int write(int data, int index, byte[] location) {
		if(index + 4 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		location[index++] = (byte)((data >> 24) & 0xFF);
		location[index++] = (byte)((data >> 16) & 0x00FF);
		location[index++] = (byte)((data >> 8) & 0x0000FF);
		location[index++] = (byte)(data & 0x000000FF);
		return index;
	}
	
	public static int write(long data, int index, byte[] location) {
		if(index + 8 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		location[index++] = (byte)((data >> 56) & 0xFF);
		location[index++] = (byte)((data >> 48) & 0x00FF);
		location[index++] = (byte)((data >> 40) & 0x0000FF);
		location[index++] = (byte)((data >> 32) & 0x000000FF);
		location[index++] = (byte)((data >> 24) & 0x00000000FF);
		location[index++] = (byte)((data >> 16) & 0x0000000000FF);
		location[index++] = (byte)((data >> 8) & 0x000000000000FF);
		location[index++] = (byte)(data & 0x00000000000000FF);
		return index;
	}
	
	public static int write(float data, int index, byte[] location) {
		if(index + 4 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		int bits = Float.floatToRawIntBits(data);
		
		location[index++] = (byte)((bits >> 24) & 0xFF);
		location[index++] = (byte)((bits >> 16) & 0x00FF);
		location[index++] = (byte)((bits >> 8) & 0x0000FF);
		location[index++] = (byte)(bits & 0x000000FF);
		return index;
	}
	
	public static int write(double data, int index, byte[] location) {
		if(index + 8 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		long bits = Double.doubleToRawLongBits(data);
		
		location[index++] = (byte)((bits >> 56) & 0xFF);
		location[index++] = (byte)((bits >> 48) & 0x00FF);
		location[index++] = (byte)((bits >> 40) & 0x0000FF);
		location[index++] = (byte)((bits >> 32) & 0x000000FF);
		location[index++] = (byte)((bits >> 24) & 0x00000000FF);
		location[index++] = (byte)((bits >> 16) & 0x0000000000FF);
		location[index++] = (byte)((bits >> 8) & 0x000000000000FF);
		location[index++] = (byte)(bits & 0x00000000000000FF);
		return index;
	}
	
	public static int write(char data, int index, byte[] location) {
		if(index + 2 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		location[index++] = (byte)((data >> 8) & 0xFF);
		location[index++] = (byte)(data & 0x00FF);
		return index;
	}
	
	public static int write(boolean data, int index, byte[] location) {
		if(index + 1 > location.length || index < 0){
			throw new RuntimeException("wrong index");
		}
		
		location[index++] = (byte) (data ? 1 : 0);
		return index;
	}
	
	public static int write(byte[] data, int index, byte[] location) {
		System.arraycopy(data, 0, location, index, data.length);
		
		return index + data.length;
	}
	
	public static int write(short[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			location[index++] = (byte)((data[i] >> 8) & 0xFF);
			location[index++] = (byte)(data[i] & 0x00FF);
		}
		
		return index;
	}

	public static int write(int[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			location[index++] = (byte)((data[i] >> 24) & 0xFF);
			location[index++] = (byte)((data[i] >> 16) & 0x00FF);
			location[index++] = (byte)((data[i] >> 8) & 0x0000FF);
			location[index++] = (byte)(data[i] & 0x000000FF);
		}
		
		return index;
	}

	public static int write(long[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			location[index++] = (byte)((data[i] >> 56) & 0xFF);
			location[index++] = (byte)((data[i] >> 48) & 0x00FF);
			location[index++] = (byte)((data[i] >> 40) & 0x0000FF);
			location[index++] = (byte)((data[i] >> 32) & 0x000000FF);
			location[index++] = (byte)((data[i] >> 24) & 0x00000000FF);
			location[index++] = (byte)((data[i] >> 16) & 0x0000000000FF);
			location[index++] = (byte)((data[i] >> 8) & 0x000000000000FF);
			location[index++] = (byte)(data[i] & 0x00000000000000FF);
		}
		
		return index;
	}
	
	public static int write(float[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			int bits = Float.floatToRawIntBits(data[i]);
			location[index++] = (byte)((bits >> 24) & 0xFF);
			location[index++] = (byte)((bits >> 16) & 0x00FF);
			location[index++] = (byte)((bits >> 8) & 0x0000FF);
			location[index++] = (byte)(bits & 0x000000FF);
		}
		
		return index;
	}
	
	public static int write(double[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			long bits = Double.doubleToRawLongBits(data[i]);
			location[index++] = (byte)((bits >> 56) & 0xFF);
			location[index++] = (byte)((bits >> 48) & 0x00FF);
			location[index++] = (byte)((bits >> 40) & 0x0000FF);
			location[index++] = (byte)((bits >> 32) & 0x000000FF);
			location[index++] = (byte)((bits >> 24) & 0x00000000FF);
			location[index++] = (byte)((bits >> 16) & 0x0000000000FF);
			location[index++] = (byte)((bits >> 8) & 0x000000000000FF);
			location[index++] = (byte)(bits & 0x00000000000000FF);
		}
		
		return index;
	}
	
	public static int write(char[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			location[index++] = (byte)((data[i] >> 8) & 0xFF);
			location[index++] = (byte)(data[i] & 0x00FF);
		}
		
		return index;
	}

	public static int write(boolean[] data, int index, byte[] location) {
		for(int i = 0; i < data.length; i++) {
			location[index++] = (byte) (data[i] ? 1 : 0);
		}
		
		return index;
	}
}
