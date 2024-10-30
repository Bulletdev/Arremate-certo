package org.apache.poi.sl.usermodel;

import org.apache.poi.common.usermodel.Hyperlink;

public interface Hyperlink<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Hyperlink {
  void linkToEmail(String paramString);
  
  void linkToUrl(String paramString);
  
  void linkToSlide(Slide<S, P> paramSlide);
  
  void linkToNextSlide();
  
  void linkToPreviousSlide();
  
  void linkToFirstSlide();
  
  void linkToLastSlide();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Hyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */