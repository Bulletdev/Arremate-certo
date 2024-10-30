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

public interface CTAbstractNum extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAbstractNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctabstractnum588etype");
  
  CTLongHexNumber getNsid();
  
  boolean isSetNsid();
  
  void setNsid(CTLongHexNumber paramCTLongHexNumber);
  
  CTLongHexNumber addNewNsid();
  
  void unsetNsid();
  
  CTMultiLevelType getMultiLevelType();
  
  boolean isSetMultiLevelType();
  
  void setMultiLevelType(CTMultiLevelType paramCTMultiLevelType);
  
  CTMultiLevelType addNewMultiLevelType();
  
  void unsetMultiLevelType();
  
  CTLongHexNumber getTmpl();
  
  boolean isSetTmpl();
  
  void setTmpl(CTLongHexNumber paramCTLongHexNumber);
  
  CTLongHexNumber addNewTmpl();
  
  void unsetTmpl();
  
  CTString getName();
  
  boolean isSetName();
  
  void setName(CTString paramCTString);
  
  CTString addNewName();
  
  void unsetName();
  
  CTString getStyleLink();
  
  boolean isSetStyleLink();
  
  void setStyleLink(CTString paramCTString);
  
  CTString addNewStyleLink();
  
  void unsetStyleLink();
  
  CTString getNumStyleLink();
  
  boolean isSetNumStyleLink();
  
  void setNumStyleLink(CTString paramCTString);
  
  CTString addNewNumStyleLink();
  
  void unsetNumStyleLink();
  
  List<CTLvl> getLvlList();
  
  CTLvl[] getLvlArray();
  
  CTLvl getLvlArray(int paramInt);
  
  int sizeOfLvlArray();
  
  void setLvlArray(CTLvl[] paramArrayOfCTLvl);
  
  void setLvlArray(int paramInt, CTLvl paramCTLvl);
  
  CTLvl insertNewLvl(int paramInt);
  
  CTLvl addNewLvl();
  
  void removeLvl(int paramInt);
  
  BigInteger getAbstractNumId();
  
  STDecimalNumber xgetAbstractNumId();
  
  void setAbstractNumId(BigInteger paramBigInteger);
  
  void xsetAbstractNumId(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTAbstractNum newInstance() {
      return (CTAbstractNum)POIXMLTypeLoader.newInstance(CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum newInstance(XmlOptions param1XmlOptions) {
      return (CTAbstractNum)POIXMLTypeLoader.newInstance(CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(String param1String) throws XmlException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1String, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1String, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(File param1File) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1File, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1File, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(URL param1URL) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1URL, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1URL, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1InputStream, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1InputStream, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1Reader, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1Reader, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(Node param1Node) throws XmlException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1Node, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1Node, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static CTAbstractNum parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1XMLInputStream, CTAbstractNum.type, null);
    }
    
    public static CTAbstractNum parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAbstractNum)POIXMLTypeLoader.parse(param1XMLInputStream, CTAbstractNum.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAbstractNum.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAbstractNum.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTAbstractNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */