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

public interface CTTabStop extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTabStop.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttabstop5ebbtype");
  
  STTabJc.Enum getVal();
  
  STTabJc xgetVal();
  
  void setVal(STTabJc.Enum paramEnum);
  
  void xsetVal(STTabJc paramSTTabJc);
  
  STTabTlc.Enum getLeader();
  
  STTabTlc xgetLeader();
  
  boolean isSetLeader();
  
  void setLeader(STTabTlc.Enum paramEnum);
  
  void xsetLeader(STTabTlc paramSTTabTlc);
  
  void unsetLeader();
  
  BigInteger getPos();
  
  STSignedTwipsMeasure xgetPos();
  
  void setPos(BigInteger paramBigInteger);
  
  void xsetPos(STSignedTwipsMeasure paramSTSignedTwipsMeasure);
  
  public static final class Factory {
    public static CTTabStop newInstance() {
      return (CTTabStop)POIXMLTypeLoader.newInstance(CTTabStop.type, null);
    }
    
    public static CTTabStop newInstance(XmlOptions param1XmlOptions) {
      return (CTTabStop)POIXMLTypeLoader.newInstance(CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(String param1String) throws XmlException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1String, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1String, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(File param1File) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1File, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1File, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(URL param1URL) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1URL, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1URL, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1InputStream, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1InputStream, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1Reader, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1Reader, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(Node param1Node) throws XmlException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1Node, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1Node, CTTabStop.type, param1XmlOptions);
    }
    
    public static CTTabStop parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1XMLInputStream, CTTabStop.type, null);
    }
    
    public static CTTabStop parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTabStop)POIXMLTypeLoader.parse(param1XMLInputStream, CTTabStop.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTabStop.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTabStop.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTabStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */