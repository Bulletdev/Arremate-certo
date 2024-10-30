package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCellAlignment extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCellAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellalignmentb580type");
  
  STHorizontalAlignment.Enum getHorizontal();
  
  STHorizontalAlignment xgetHorizontal();
  
  boolean isSetHorizontal();
  
  void setHorizontal(STHorizontalAlignment.Enum paramEnum);
  
  void xsetHorizontal(STHorizontalAlignment paramSTHorizontalAlignment);
  
  void unsetHorizontal();
  
  STVerticalAlignment.Enum getVertical();
  
  STVerticalAlignment xgetVertical();
  
  boolean isSetVertical();
  
  void setVertical(STVerticalAlignment.Enum paramEnum);
  
  void xsetVertical(STVerticalAlignment paramSTVerticalAlignment);
  
  void unsetVertical();
  
  long getTextRotation();
  
  XmlUnsignedInt xgetTextRotation();
  
  boolean isSetTextRotation();
  
  void setTextRotation(long paramLong);
  
  void xsetTextRotation(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetTextRotation();
  
  boolean getWrapText();
  
  XmlBoolean xgetWrapText();
  
  boolean isSetWrapText();
  
  void setWrapText(boolean paramBoolean);
  
  void xsetWrapText(XmlBoolean paramXmlBoolean);
  
  void unsetWrapText();
  
  long getIndent();
  
  XmlUnsignedInt xgetIndent();
  
  boolean isSetIndent();
  
  void setIndent(long paramLong);
  
  void xsetIndent(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIndent();
  
  int getRelativeIndent();
  
  XmlInt xgetRelativeIndent();
  
  boolean isSetRelativeIndent();
  
  void setRelativeIndent(int paramInt);
  
  void xsetRelativeIndent(XmlInt paramXmlInt);
  
  void unsetRelativeIndent();
  
  boolean getJustifyLastLine();
  
  XmlBoolean xgetJustifyLastLine();
  
  boolean isSetJustifyLastLine();
  
  void setJustifyLastLine(boolean paramBoolean);
  
  void xsetJustifyLastLine(XmlBoolean paramXmlBoolean);
  
  void unsetJustifyLastLine();
  
  boolean getShrinkToFit();
  
  XmlBoolean xgetShrinkToFit();
  
  boolean isSetShrinkToFit();
  
  void setShrinkToFit(boolean paramBoolean);
  
  void xsetShrinkToFit(XmlBoolean paramXmlBoolean);
  
  void unsetShrinkToFit();
  
  long getReadingOrder();
  
  XmlUnsignedInt xgetReadingOrder();
  
  boolean isSetReadingOrder();
  
  void setReadingOrder(long paramLong);
  
  void xsetReadingOrder(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetReadingOrder();
  
  public static final class Factory {
    public static CTCellAlignment newInstance() {
      return (CTCellAlignment)POIXMLTypeLoader.newInstance(CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment newInstance(XmlOptions param1XmlOptions) {
      return (CTCellAlignment)POIXMLTypeLoader.newInstance(CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(String param1String) throws XmlException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1String, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1String, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(File param1File) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1File, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1File, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(URL param1URL) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1URL, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1URL, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1InputStream, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1InputStream, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1Reader, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1Reader, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(Node param1Node) throws XmlException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1Node, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1Node, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static CTCellAlignment parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellAlignment.type, null);
    }
    
    public static CTCellAlignment parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCellAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellAlignment.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellAlignment.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellAlignment.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCellAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */