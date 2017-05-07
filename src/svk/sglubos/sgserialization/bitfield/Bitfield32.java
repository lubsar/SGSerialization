package svk.sglubos.sgserialization.bitfield;

import svk.sglubos.sgserialization.utils.UtilitySerializer;

public class Bitfield32 extends Bitfield {
	public int data;
	
	public Bitfield32() {}
	
	public Bitfield32(int data) {
		this.data = data;
	}
	
	@Override
	public int serialize(int index, byte[] location) {
		return UtilitySerializer.write(data, index, location);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bitfield32 deserialize(int index, byte[] source) {
		return new Bitfield32(UtilitySerializer.readInt(index, source));
	}

	@Override
	public int deserialize2(int index, byte[] source) {
		this.data = UtilitySerializer.readInt(index, source);
		return index + 4;
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public byte getBit(byte bit) {
		assert (bit >= 0) && (bit < 32): "Bit must be between 0 and 31"; 
		return (byte) ((data >> bit) & 0x00000001); 
	}

	@Override
	public void setBit(byte bit) {
		assert (bit >= 0) && (bit < 32): "Bit must be between 0 and 31";
		data |= (1 << bit);
	}

	@Override
	public void clearBit(byte bit) {
		assert (bit >= 0) && (bit < 32): "Bit must be between 0 and 31";
		data = (data & ~(1 << bit));
	}

	@Override
	public void toggleBit(byte bit) {
		assert (bit >= 0) && (bit < 32): "Bit must be between 0 and 31";
		data ^= 1 << bit;
	}
}
