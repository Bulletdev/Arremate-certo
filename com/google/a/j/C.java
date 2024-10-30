package com.google.a.j;

import com.google.a.a.c;
import com.google.b.a.a;
import java.io.DataInput;

@c
public interface c extends DataInput {
  void readFully(byte[] paramArrayOfbyte);
  
  void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  int skipBytes(int paramInt);
  
  @a
  boolean readBoolean();
  
  @a
  byte readByte();
  
  @a
  int readUnsignedByte();
  
  @a
  short readShort();
  
  @a
  int readUnsignedShort();
  
  @a
  char readChar();
  
  @a
  int readInt();
  
  @a
  long readLong();
  
  @a
  float readFloat();
  
  @a
  double readDouble();
  
  @a
  String readLine();
  
  @a
  String readUTF();
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */