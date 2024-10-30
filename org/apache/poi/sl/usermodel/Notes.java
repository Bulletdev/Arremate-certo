package org.apache.poi.sl.usermodel;

import java.util.List;

public interface Notes<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Sheet<S, P> {
  List<? extends List<P>> getTextParagraphs();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Notes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */