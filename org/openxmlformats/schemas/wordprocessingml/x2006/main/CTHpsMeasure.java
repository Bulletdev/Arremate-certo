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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTHpsMeasure extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthpsmeasure3795type");
  
  BigInteger getVal();
  
  STHpsMeasure xgetVal();
  
  void setVal(BigInteger paramBigInteger);
  
  void xsetVal(STHpsMeasure paramSTHpsMeasure);
  
  public static final class Factory {
    public static CTHpsMeasure newInstance() {
      return (CTHpsMeasure)POIXMLTypeLoader.newInstance(CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure newInstance(XmlOptions param1XmlOptions) {
      return (CTHpsMeasure)POIXMLTypeLoader.newInstance(CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(String param1String) throws XmlException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1String, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1String, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(File param1File) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1File, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1File, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(URL param1URL) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1URL, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1URL, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1Reader, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1Reader, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(Node param1Node) throws XmlException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1Node, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1Node, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTHpsMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, CTHpsMeasure.type, null);
    }
    
    public static CTHpsMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, CTHpsMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHpsMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHpsMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTHpsMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */