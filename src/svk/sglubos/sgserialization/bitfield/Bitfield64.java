package svk.sglubos.sgserialization.bitfield;

import svk.sglubos.sgserialization.utils.UtilitySerializer;

public class Bitfield64 extends Bitfield {
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
