package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTNum extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnume94ctype");
  
  CTDecimalNumber getAbstractNumId();
  
  void setAbstractNumId(CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber addNewAbstractNumId();
  
  List<CTNumLvl> getLvlOverrideList();
  
  CTNumLvl[] getLvlOverrideArray();
  
  CTNumLvl getLvlOverrideArray(int paramInt);
  
  int sizeOfLvlOverrideArray();
  
  void setLvlOverrideArray(CTNumLvl[] paramArrayOfCTNumLvl);
  
  void setLvlOverrideArray(int paramInt, CTNumLvl paramCTNumLvl);
  
  CTNumLvl insertNewLvlOverride(int paramInt);
  
  CTNumLvl addNewLvlOverride();
  
  void removeLvlOverride(int paramInt);
  
  BigInteger getNumId();
  
  STDecimalNumber xgetNumId();
  
  void setNumId(BigInteger paramBigInteger);
  
  void xsetNumId(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTNum newInstance() {
      return (CTNum)POIXMLTypeLoader.newInstance(CTNum.type, null);
    }
    
    public static CTNum newInstance(XmlOptions param1XmlOptions) {
      return (CTNum)POIXMLTypeLoader.newInstance(CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(String param1String) throws XmlException {
      return (CTNum)POIXMLTypeLoader.parse(param1String, CTNum.type, null);
    }
    
    public static CTNum parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNum)POIXMLTypeLoader.parse(param1String, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(File param1File) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1File, CTNum.type, null);
    }
    
    public static CTNum parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1File, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(URL param1URL) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1URL, CTNum.type, null);
    }
    
    public static CTNum parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1URL, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1InputStream, CTNum.type, null);
    }
    
    public static CTNum parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1InputStream, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1Reader, CTNum.type, null);
    }
    
    public static CTNum parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNum)POIXMLTypeLoader.parse(param1Reader, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNum)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNum.type, null);
    }
    
    public static CTNum parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNum)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(Node param1Node) throws XmlException {
      return (CTNum)POIXMLTypeLoader.parse(param1Node, CTNum.type, null);
    }
    
    public static CTNum parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNum)POIXMLTypeLoader.parse(param1Node, CTNum.type, param1XmlOptions);
    }
    
    public static CTNum parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNum)POIXMLTypeLoader.parse(param1XMLInputStream, CTNum.type, null);
    }
    
    public static CTNum parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNum)POIXMLTypeLoader.parse(param1XMLInputStream, CTNum.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNum.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNum.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */