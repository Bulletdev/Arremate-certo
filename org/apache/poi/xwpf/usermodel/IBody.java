package org.apache.poi.xwpf.usermodel;

import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

public interface IBody {
  POIXMLDocumentPart getPart();
  
  BodyType getPartType();
  
  List<IBodyElement> getBodyElements();
  
  List<XWPFParagraph> getParagraphs();
  
  List<XWPFTable> getTables();
  
  XWPFParagraph getParagraph(CTP paramCTP);
  
  XWPFTable getTable(CTTbl paramCTTbl);
  
  XWPFParagraph getParagraphArray(int paramInt);
  
  XWPFTable getTableArray(int paramInt);
  
  XWPFParagraph insertNewParagraph(XmlCursor paramXmlCursor);
  
  XWPFTable insertNewTbl(XmlCursor paramXmlCursor);
  
  void insertTable(int paramInt, XWPFTable paramXWPFTable);
  
  XWPFTableCell getTableCell(CTTc paramCTTc);
  
  XWPFDocument getXWPFDocument();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\IBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */