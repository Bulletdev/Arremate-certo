package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
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

public interface CTColorMapping extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTColorMapping.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolormapping5bc6type");
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STColorSchemeIndex.Enum getBg1();
  
  STColorSchemeIndex xgetBg1();
  
  void setBg1(STColorSchemeIndex.Enum paramEnum);
  
  void xsetBg1(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getTx1();
  
  STColorSchemeIndex xgetTx1();
  
  void setTx1(STColorSchemeIndex.Enum paramEnum);
  
  void xsetTx1(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getBg2();
  
  STColorSchemeIndex xgetBg2();
  
  void setBg2(STColorSchemeIndex.Enum paramEnum);
  
  void xsetBg2(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getTx2();
  
  STColorSchemeIndex xgetTx2();
  
  void setTx2(STColorSchemeIndex.Enum paramEnum);
  
  void xsetTx2(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getAccent1();
  
  STColorSchemeIndex xgetAccent1();
  
  void setAccent1(STColorSchemeIndex.Enum paramEnum);
  
  void xsetAccent1(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getAccent2();
  
  STColorSchemeIndex xgetAccent2();
  
  void setAccent2(STColorSchemeIndex.Enum paramEnum);
  
  void xsetAccent2(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getAccent3();
  
  STColorSchemeIndex xgetAccent3();
  
  void setAccent3(STColorSchemeIndex.Enum paramEnum);
  
  void xsetAccent3(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getAccent4();
  
  STColorSchemeIndex xgetAccent4();
  
  void setAccent4(STColorSchemeIndex.Enum paramEnum);
  
  void xsetAccent4(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getAccent5();
  
  STColorSchemeIndex xgetAccent5();
  
  void setAccent5(STColorSchemeIndex.Enum paramEnum);
  
  void xsetAccent5(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getAccent6();
  
  STColorSchemeIndex xgetAccent6();
  
  void setAccent6(STColorSchemeIndex.Enum paramEnum);
  
  void xsetAccent6(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getHlink();
  
  STColorSchemeIndex xgetHlink();
  
  void setHlink(STColorSchemeIndex.Enum paramEnum);
  
  void xsetHlink(STColorSchemeIndex paramSTColorSchemeIndex);
  
  STColorSchemeIndex.Enum getFolHlink();
  
  STColorSchemeIndex xgetFolHlink();
  
  void setFolHlink(STColorSchemeIndex.Enum paramEnum);
  
  void xsetFolHlink(STColorSchemeIndex paramSTColorSchemeIndex);
  
  public static final class Factory {
    public static CTColorMapping newInstance() {
      return (CTColorMapping)POIXMLTypeLoader.newInstance(CTColorMapping.type, null);
    }
    
    public static CTColorMapping newInstance(XmlOptions param1XmlOptions) {
      return (CTColorMapping)POIXMLTypeLoader.newInstance(CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(String param1String) throws XmlException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1String, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1String, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(File param1File) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1File, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1File, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(URL param1URL) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1URL, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1URL, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1InputStream, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1InputStream, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(Reader param1Reader) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1Reader, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1Reader, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(Node param1Node) throws XmlException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1Node, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1Node, CTColorMapping.type, param1XmlOptions);
    }
    
    public static CTColorMapping parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorMapping.type, null);
    }
    
    public static CTColorMapping parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTColorMapping)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorMapping.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorMapping.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorMapping.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTColorMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */