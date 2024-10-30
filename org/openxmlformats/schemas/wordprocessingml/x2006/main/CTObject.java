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

public interface CTObject extends CTPictureBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTObject.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctobject47c9type");
  
  CTControl getControl();
  
  boolean isSetControl();
  
  void setControl(CTControl paramCTControl);
  
  CTControl addNewControl();
  
  void unsetControl();
  
  BigInteger getDxaOrig();
  
  STTwipsMeasure xgetDxaOrig();
  
  boolean isSetDxaOrig();
  
  void setDxaOrig(BigInteger paramBigInteger);
  
  void xsetDxaOrig(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetDxaOrig();
  
  BigInteger getDyaOrig();
  
  STTwipsMeasure xgetDyaOrig();
  
  boolean isSetDyaOrig();
  
  void setDyaOrig(BigInteger paramBigInteger);
  
  void xsetDyaOrig(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetDyaOrig();
  
  public static final class Factory {
    public static CTObject newInstance() {
      return (CTObject)POIXMLTypeLoader.newInstance(CTObject.type, null);
    }
    
    public static CTObject newInstance(XmlOptions param1XmlOptions) {
      return (CTObject)POIXMLTypeLoader.newInstance(CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(String param1String) throws XmlException {
      return (CTObject)POIXMLTypeLoader.parse(param1String, CTObject.type, null);
    }
    
    public static CTObject parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTObject)POIXMLTypeLoader.parse(param1String, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(File param1File) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1File, CTObject.type, null);
    }
    
    public static CTObject parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1File, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(URL param1URL) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1URL, CTObject.type, null);
    }
    
    public static CTObject parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1URL, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1InputStream, CTObject.type, null);
    }
    
    public static CTObject parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1InputStream, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(Reader param1Reader) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1Reader, CTObject.type, null);
    }
    
    public static CTObject parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTObject)POIXMLTypeLoader.parse(param1Reader, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTObject)POIXMLTypeLoader.parse(param1XMLStreamReader, CTObject.type, null);
    }
    
    public static CTObject parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTObject)POIXMLTypeLoader.parse(param1XMLStreamReader, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(Node param1Node) throws XmlException {
      return (CTObject)POIXMLTypeLoader.parse(param1Node, CTObject.type, null);
    }
    
    public static CTObject parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTObject)POIXMLTypeLoader.parse(param1Node, CTObject.type, param1XmlOptions);
    }
    
    public static CTObject parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTObject)POIXMLTypeLoader.parse(param1XMLInputStream, CTObject.type, null);
    }
    
    public static CTObject parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTObject)POIXMLTypeLoader.parse(param1XMLInputStream, CTObject.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTObject.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTObject.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */