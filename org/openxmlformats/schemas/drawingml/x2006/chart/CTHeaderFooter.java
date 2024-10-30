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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTHeaderFooter extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHeaderFooter.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctheaderfooter2c34type");
  
  String getOddHeader();
  
  STXstring xgetOddHeader();
  
  boolean isSetOddHeader();
  
  void setOddHeader(String paramString);
  
  void xsetOddHeader(STXstring paramSTXstring);
  
  void unsetOddHeader();
  
  String getOddFooter();
  
  STXstring xgetOddFooter();
  
  boolean isSetOddFooter();
  
  void setOddFooter(String paramString);
  
  void xsetOddFooter(STXstring paramSTXstring);
  
  void unsetOddFooter();
  
  String getEvenHeader();
  
  STXstring xgetEvenHeader();
  
  boolean isSetEvenHeader();
  
  void setEvenHeader(String paramString);
  
  void xsetEvenHeader(STXstring paramSTXstring);
  
  void unsetEvenHeader();
  
  String getEvenFooter();
  
  STXstring xgetEvenFooter();
  
  boolean isSetEvenFooter();
  
  void setEvenFooter(String paramString);
  
  void xsetEvenFooter(STXstring paramSTXstring);
  
  void unsetEvenFooter();
  
  String getFirstHeader();
  
  STXstring xgetFirstHeader();
  
  boolean isSetFirstHeader();
  
  void setFirstHeader(String paramString);
  
  void xsetFirstHeader(STXstring paramSTXstring);
  
  void unsetFirstHeader();
  
  String getFirstFooter();
  
  STXstring xgetFirstFooter();
  
  boolean isSetFirstFooter();
  
  void setFirstFooter(String paramString);
  
  void xsetFirstFooter(STXstring paramSTXstring);
  
  void unsetFirstFooter();
  
  boolean getAlignWithMargins();
  
  XmlBoolean xgetAlignWithMargins();
  
  boolean isSetAlignWithMargins();
  
  void setAlignWithMargins(boolean paramBoolean);
  
  void xsetAlignWithMargins(XmlBoolean paramXmlBoolean);
  
  void unsetAlignWithMargins();
  
  boolean getDifferentOddEven();
  
  XmlBoolean xgetDifferentOddEven();
  
  boolean isSetDifferentOddEven();
  
  void setDifferentOddEven(boolean paramBoolean);
  
  void xsetDifferentOddEven(XmlBoolean paramXmlBoolean);
  
  void unsetDifferentOddEven();
  
  boolean getDifferentFirst();
  
  XmlBoolean xgetDifferentFirst();
  
  boolean isSetDifferentFirst();
  
  void setDifferentFirst(boolean paramBoolean);
  
  void xsetDifferentFirst(XmlBoolean paramXmlBoolean);
  
  void unsetDifferentFirst();
  
  public static final class Factory {
    public static CTHeaderFooter newInstance() {
      return (CTHeaderFooter)POIXMLTypeLoader.newInstance(CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter newInstance(XmlOptions param1XmlOptions) {
      return (CTHeaderFooter)POIXMLTypeLoader.newInstance(CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(String param1String) throws XmlException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1String, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1String, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(File param1File) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1File, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1File, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(URL param1URL) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1URL, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1URL, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1InputStream, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1InputStream, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1Reader, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1Reader, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(Node param1Node) throws XmlException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1Node, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1Node, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static CTHeaderFooter parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1XMLInputStream, CTHeaderFooter.type, null);
    }
    
    public static CTHeaderFooter parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHeaderFooter)POIXMLTypeLoader.parse(param1XMLInputStream, CTHeaderFooter.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHeaderFooter.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHeaderFooter.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTHeaderFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */