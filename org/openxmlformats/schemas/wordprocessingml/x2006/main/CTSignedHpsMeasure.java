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

public interface CTSignedHpsMeasure extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSignedHpsMeasure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsignedhpsmeasure3099type");
  
  BigInteger getVal();
  
  STSignedHpsMeasure xgetVal();
  
  void setVal(BigInteger paramBigInteger);
  
  void xsetVal(STSignedHpsMeasure paramSTSignedHpsMeasure);
  
  public static final class Factory {
    public static CTSignedHpsMeasure newInstance() {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.newInstance(CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure newInstance(XmlOptions param1XmlOptions) {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.newInstance(CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(String param1String) throws XmlException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1String, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1String, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(File param1File) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1File, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1File, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(URL param1URL) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1URL, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1URL, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1InputStream, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1Reader, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1Reader, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(Node param1Node) throws XmlException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1Node, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1Node, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static CTSignedHpsMeasure parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, CTSignedHpsMeasure.type, null);
    }
    
    public static CTSignedHpsMeasure parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSignedHpsMeasure)POIXMLTypeLoader.parse(param1XMLInputStream, CTSignedHpsMeasure.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSignedHpsMeasure.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSignedHpsMeasure.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSignedHpsMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */