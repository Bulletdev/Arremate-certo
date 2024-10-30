package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBookmarkRange extends CTMarkupRange {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBookmarkRange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbookmarkranged88btype");
  
  BigInteger getColFirst();
  
  STDecimalNumber xgetColFirst();
  
  boolean isSetColFirst();
  
  void setColFirst(BigInteger paramBigInteger);
  
  void xsetColFirst(STDecimalNumber paramSTDecimalNumber);
  
  void unsetColFirst();
  
  BigInteger getColLast();
  
  STDecimalNumber xgetColLast();
  
  boolean isSetColLast();
  
  void setColLast(BigInteger paramBigInteger);
  
  void xsetColLast(STDecimalNumber paramSTDecimalNumber);
  
  void unsetColLast();
  
  public static final class Factory {
    public static CTBookmarkRange newInstance() {
      return (CTBookmarkRange)POIXMLTypeLoader.newInstance(CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange newInstance(XmlOptions param1XmlOptions) {
      return (CTBookmarkRange)POIXMLTypeLoader.newInstance(CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(String param1String) throws XmlException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1String, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1String, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(File param1File) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1File, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1File, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(URL param1URL) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1URL, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1URL, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1InputStream, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1InputStream, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1Reader, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1Reader, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(Node param1Node) throws XmlException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1Node, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1Node, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static CTBookmarkRange parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookmarkRange.type, null);
    }
    
    public static CTBookmarkRange parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBookmarkRange)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookmarkRange.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookmarkRange.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookmarkRange.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTBookmarkRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */