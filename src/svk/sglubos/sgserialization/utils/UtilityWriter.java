package svk.sglubos.sgserialization.utils;

public class UtilityWriter {
	public static int write(byte data, int index, byte[] destination) {
		checkIndex(index, 1, destination.length);
		
		destination[index++] = data;
		return index;
	}
	
	public static int write(short data, int index, byte[] destination) {
		checkIndex(index, 2, destination.length);
		
		destination[index++] = (byte)((data >> 8) & 0xFF);
		destination[index++] = (byte)(data & 0x00FF);
		return index;
	}
	
	public static int write(int data, int index, byte[] destination) {
		checkIndex(index, 4, destination.length);
		
		destination[index++] = (byte)((data >> 24) & 0xFF);
		destination[index++] = (byte)((data >> 16) & 0x00FF);
		destination[index++] = (byte)((data >> 8) & 0x0000FF);
		destination[index++] = (byte)(data & 0x000000FF);
		return index;
	}
	
	public static int write(long data, int index, byte[] destination) {
		checkIndex(index, 8, destination.length);
		
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
	
	public static int write(float data, int index, byte[] destination) {
		checkIndex(index, 4, destination.length);
		
		int bits = Float.floatToRawIntBits(data);
		
		destination[index++] = (byte)((bits >> 24) & 0xFF);
		destination[index++] = (byte)((bits >> 16) & 0x00FF);
		destination[index++] = (byte)((bits >> 8) & 0x0000FF);
		destination[index++] = (byte)(bits & 0x000000FF);
		return index;
	}
	
	public static int write(double data, int index, byte[] destination) {
		checkIndex(index, 8, destination.length);
		
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
	
	public static int write(char data, int index, byte[] destination) {
		checkIndex(index, 2, destination.length);
		
		destination[index++] = (byte)((data >> 8) & 0xFF);
		destination[index++] = (byte)(data & 0x00FF);
		return index;
	}
	
	public static int write(boolean data, int index, byte[] destination) {
		checkIndex(index, 1, destination.length);
		
		destination[index++] = (byte) (data ? 1 : 0);
		return index;
	}
	
	public static int write(byte[] data, int index, byte[] destination) {
		checkIndex(index, data.length, destination.length);
		
		System.arraycopy(data, 0, destination, index, data.length);
		
		return index + data.length;
	}
	
	public static int write(short[] data, int index, byte[] destination) {
		checkIndex(index, data.length * 2, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 8) & 0xFF);
			destination[index++] = (byte)(data[i] & 0x00FF);
		}
		
		return index;
	}

	public static int write(int[] data, int index, byte[] destination) {
		checkIndex(index, data.length * 4, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 24) & 0xFF);
			destination[index++] = (byte)((data[i] >> 16) & 0x00FF);
			destination[index++] = (byte)((data[i] >> 8) & 0x0000FF);
			destination[index++] = (byte)(data[i] & 0x000000FF);
		}
		
		return index;
	}

	public static int write(long[] data, int index, byte[] destination) {
		checkIndex(index, data.length * 8, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 56) & 0xFF);
			destination[index++] = (byte)((data[i] >> 48) & 0x00FF);
			destination[index++] = (byte)((data[i] >> 40) & 0x0000FF);
			destination[index++] = (byte)((data[i] >> 32) & 0x000000FF);
			destination[index++] = (byte)((data[i] >> 24) & 0x00000000FF);
			destination[index++] = (byte)((data[i] >> 16) & 0x0000000000FF);
			destination[index++] = (byte)((data[i] >> 8) & 0x000000000000FF);
			destination[index++] = (byte)(data[i] & 0x00000000000000FF);
		}
		
		return index;
	}
	
	public static int write(float[] data, int index, byte[] destination) {
		checkIndex(index, data.length * 4, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			int bits = Float.floatToRawIntBits(data[i]);
			destination[index++] = (byte)((bits >> 24) & 0xFF);
			destination[index++] = (byte)((bits >> 16) & 0x00FF);
			destination[index++] = (byte)((bits >> 8) & 0x0000FF);
			destination[index++] = (byte)(bits & 0x000000FF);
		}
		
		return index;
	}
	
	public static int write(double[] data, int index, byte[] destination) {
		checkIndex(index, data.length * 8, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			long bits = Double.doubleToRawLongBits(data[i]);
			destination[index++] = (byte)((bits >> 56) & 0xFF);
			destination[index++] = (byte)((bits >> 48) & 0x00FF);
			destination[index++] = (byte)((bits >> 40) & 0x0000FF);
			destination[index++] = (byte)((bits >> 32) & 0x000000FF);
			destination[index++] = (byte)((bits >> 24) & 0x00000000FF);
			destination[index++] = (byte)((bits >> 16) & 0x0000000000FF);
			destination[index++] = (byte)((bits >> 8) & 0x000000000000FF);
			destination[index++] = (byte)(bits & 0x00000000000000FF);
		}
		
		return index;
	}
	
	public static int write(char[] data, int index, byte[] destination) {
		checkIndex(index, data.length * 2, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte)((data[i] >> 8) & 0xFF);
			destination[index++] = (byte)(data[i] & 0x00FF);
		}
		
		return index;
	}

	public static int write(boolean[] data, int index, byte[] destination) {
		checkIndex(index, data.length, destination.length);
		
		for(int i = 0; i < data.length; i++) {
			destination[index++] = (byte) (data[i] ? 1 : 0);
		}
		
		return index;
	}
	
	private static final void checkIndex(int index, int size, int destinationCapacity) throws RuntimeException, IndexOutOfBoundsException {
		if(index + size > destinationCapacity){
			throw new RuntimeException("Not enough space in destination array");
		}
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index can not be less than 0");
		}
	}
}
