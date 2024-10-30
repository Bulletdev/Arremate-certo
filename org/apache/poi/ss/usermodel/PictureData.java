package org.apache.poi.ss.usermodel;

public interface PictureData {
  byte[] getData();
  
  String suggestFileExtension();
  
  String getMimeType();
  
  int getPictureType();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PictureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */