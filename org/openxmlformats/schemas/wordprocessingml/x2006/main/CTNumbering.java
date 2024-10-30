package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTNumbering extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumbering.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumberingfdf9type");
  
  List<CTNumPicBullet> getNumPicBulletList();
  
  CTNumPicBullet[] getNumPicBulletArray();
  
  CTNumPicBullet getNumPicBulletArray(int paramInt);
  
  int sizeOfNumPicBulletArray();
  
  void setNumPicBulletArray(CTNumPicBullet[] paramArrayOfCTNumPicBullet);
  
  void setNumPicBulletArray(int paramInt, CTNumPicBullet paramCTNumPicBullet);
  
  CTNumPicBullet insertNewNumPicBullet(int paramInt);
  
  CTNumPicBullet addNewNumPicBullet();
  
  void removeNumPicBullet(int paramInt);
  
  List<CTAbstractNum> getAbstractNumList();
  
  CTAbstractNum[] getAbstractNumArray();
  
  CTAbstractNum getAbstractNumArray(int paramInt);
  
  int sizeOfAbstractNumArray();
  
  void setAbstractNumArray(CTAbstractNum[] paramArrayOfCTAbstractNum);
  
  void setAbstractNumArray(int paramInt, CTAbstractNum paramCTAbstractNum);
  
  CTAbstractNum insertNewAbstractNum(int paramInt);
  
  CTAbstractNum addNewAbstractNum();
  
  void removeAbstractNum(int paramInt);
  
  List<CTNum> getNumList();
  
  CTNum[] getNumArray();
  
  CTNum getNumArray(int paramInt);
  
  int sizeOfNumArray();
  
  void setNumArray(CTNum[] paramArrayOfCTNum);
  
  void setNumArray(int paramInt, CTNum paramCTNum);
  
  CTNum insertNewNum(int paramInt);
  
  CTNum addNewNum();
  
  void removeNum(int paramInt);
  
  CTDecimalNumber getNumIdMacAtCleanup();
  
  boolean isSetNumIdMacAtCleanup();
  
  void setNumIdMacAtCleanup(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewNumIdMacAtCleanup();
  
  void unsetNumIdMacAtCleanup();
  
  public static final class Factory {
    public static CTNumbering newInstance() {
      return (CTNumbering)POIXMLTypeLoader.newInstance(CTNumbering.type, null);
    }
    
    public static CTNumbering newInstance(XmlOptions param1XmlOptions) {
      return (CTNumbering)POIXMLTypeLoader.newInstance(CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(String param1String) throws XmlException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1String, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1String, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(File param1File) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1File, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1File, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(URL param1URL) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1URL, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1URL, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1InputStream, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1InputStream, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1Reader, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1Reader, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(Node param1Node) throws XmlException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1Node, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1Node, CTNumbering.type, param1XmlOptions);
    }
    
    public static CTNumbering parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumbering.type, null);
    }
    
    public static CTNumbering parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumbering)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumbering.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumbering.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumbering.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTNumbering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */