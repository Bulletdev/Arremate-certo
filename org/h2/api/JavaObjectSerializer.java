package org.h2.api;

public interface JavaObjectSerializer {
  byte[] serialize(Object paramObject) throws Exception;
  
  Object deserialize(byte[] paramArrayOfbyte) throws Exception;
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\JavaObjectSerializer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */