package org.apache.poi.sl.usermodel;

import java.awt.Dimension;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface SlideShow<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Closeable {
  Slide<S, P> createSlide() throws IOException;
  
  List<? extends Slide<S, P>> getSlides();
  
  MasterSheet<S, P> createMasterSheet() throws IOException;
  
  List<? extends MasterSheet<S, P>> getSlideMasters();
  
  Resources getResources();
  
  Dimension getPageSize();
  
  void setPageSize(Dimension paramDimension);
  
  List<? extends PictureData> getPictureData();
  
  PictureData addPicture(byte[] paramArrayOfbyte, PictureData.PictureType paramPictureType) throws IOException;
  
  PictureData addPicture(InputStream paramInputStream, PictureData.PictureType paramPictureType) throws IOException;
  
  PictureData addPicture(File paramFile, PictureData.PictureType paramPictureType) throws IOException;
  
  PictureData findPictureData(byte[] paramArrayOfbyte);
  
  void write(OutputStream paramOutputStream) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\SlideShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */