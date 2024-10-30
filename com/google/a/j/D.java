package com.google.a.j;

import com.google.a.a.c;
import java.io.DataOutput;

@c
public interface d extends DataOutput {
  void write(int paramInt);
  
  void write(byte[] paramArrayOfbyte);
  
  void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  void writeBoolean(boolean paramBoolean);
  
  void writeByte(int paramInt);
  
  void writeShort(int paramInt);
  
  void writeChar(int paramInt);
  
  void writeInt(int paramInt);
  
  void writeLong(long paramLong);
  
  void writeFloat(float paramFloat);
  
  void writeDouble(double paramDouble);
  
  void writeChars(String paramString);
  
  void writeUTF(String paramString);
  
  @Deprecated
  void writeBytes(String paramString);
  
  byte[] toByteArray();
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */