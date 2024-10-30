package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTPageSetup extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPageSetup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagesetupdb38type");
  
  long getPaperSize();
  
  XmlUnsignedInt xgetPaperSize();
  
  boolean isSetPaperSize();
  
  void setPaperSize(long paramLong);
  
  void xsetPaperSize(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetPaperSize();
  
  long getFirstPageNumber();
  
  XmlUnsignedInt xgetFirstPageNumber();
  
  boolean isSetFirstPageNumber();
  
  void setFirstPageNumber(long paramLong);
  
  void xsetFirstPageNumber(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetFirstPageNumber();
  
  STPageSetupOrientation$Enum getOrientation();
  
  STPageSetupOrientation xgetOrientation();
  
  boolean isSetOrientation();
  
  void setOrientation(STPageSetupOrientation$Enum paramSTPageSetupOrientation$Enum);
  
  void xsetOrientation(STPageSetupOrientation paramSTPageSetupOrientation);
  
  void unsetOrientation();
  
  boolean getBlackAndWhite();
  
  XmlBoolean xgetBlackAndWhite();
  
  boolean isSetBlackAndWhite();
  
  void setBlackAndWhite(boolean paramBoolean);
  
  void xsetBlackAndWhite(XmlBoolean paramXmlBoolean);
  
  void unsetBlackAndWhite();
  
  boolean getDraft();
  
  XmlBoolean xgetDraft();
  
  boolean isSetDraft();
  
  void setDraft(boolean paramBoolean);
  
  void xsetDraft(XmlBoolean paramXmlBoolean);
  
  void unsetDraft();
  
  boolean getUseFirstPageNumber();
  
  XmlBoolean xgetUseFirstPageNumber();
  
  boolean isSetUseFirstPageNumber();
  
  void setUseFirstPageNumber(boolean paramBoolean);
  
  void xsetUseFirstPageNumber(XmlBoolean paramXmlBoolean);
  
  void unsetUseFirstPageNumber();
  
  int getHorizontalDpi();
  
  XmlInt xgetHorizontalDpi();
  
  boolean isSetHorizontalDpi();
  
  void setHorizontalDpi(int paramInt);
  
  void xsetHorizontalDpi(XmlInt paramXmlInt);
  
  void unsetHorizontalDpi();
  
  int getVerticalDpi();
  
  XmlInt xgetVerticalDpi();
  
  boolean isSetVerticalDpi();
  
  void setVerticalDpi(int paramInt);
  
  void xsetVerticalDpi(XmlInt paramXmlInt);
  
  void unsetVerticalDpi();
  
  long getCopies();
  
  XmlUnsignedInt xgetCopies();
  
  boolean isSetCopies();
  
  void setCopies(long paramLong);
  
  void xsetCopies(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCopies();
  
  public static final class Factory {
    public static CTPageSetup newInstance() {
      return (CTPageSetup)POIXMLTypeLoader.newInstance(CTPageSetup.type, null);
    }
    
    public static CTPageSetup newInstance(XmlOptions param1XmlOptions) {
      return (CTPageSetup)POIXMLTypeLoader.newInstance(CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(String param1String) throws XmlException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1String, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1String, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(File param1File) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1File, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1File, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(URL param1URL) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1URL, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1URL, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1InputStream, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1InputStream, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1Reader, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1Reader, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(Node param1Node) throws XmlException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1Node, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1Node, CTPageSetup.type, param1XmlOptions);
    }
    
    public static CTPageSetup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageSetup.type, null);
    }
    
    public static CTPageSetup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPageSetup)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageSetup.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageSetup.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageSetup.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTPageSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */