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

public interface CTNumLvl extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumLvl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumlvl416ctype");
  
  CTDecimalNumber getStartOverride();
  
  boolean isSetStartOverride();
  
  void setStartOverride(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewStartOverride();
  
  void unsetStartOverride();
  
  CTLvl getLvl();
  
  boolean isSetLvl();
  
  void setLvl(CTLvl paramCTLvl);
  
  CTLvl addNewLvl();
  
  void unsetLvl();
  
  BigInteger getIlvl();
  
  STDecimalNumber xgetIlvl();
  
  void setIlvl(BigInteger paramBigInteger);
  
  void xsetIlvl(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTNumLvl newInstance() {
      return (CTNumLvl)POIXMLTypeLoader.newInstance(CTNumLvl.type, null);
    }
    
    public static CTNumLvl newInstance(XmlOptions param1XmlOptions) {
      return (CTNumLvl)POIXMLTypeLoader.newInstance(CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(String param1String) throws XmlException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1String, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1String, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(File param1File) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1File, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1File, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(URL param1URL) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1URL, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1URL, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1InputStream, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1InputStream, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1Reader, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1Reader, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(Node param1Node) throws XmlException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1Node, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1Node, CTNumLvl.type, param1XmlOptions);
    }
    
    public static CTNumLvl parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumLvl.type, null);
    }
    
    public static CTNumLvl parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumLvl)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumLvl.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumLvl.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumLvl.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTNumLvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */