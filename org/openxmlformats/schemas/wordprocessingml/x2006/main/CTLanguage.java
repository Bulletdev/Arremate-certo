package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTLanguage extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLanguage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlanguage7b90type");
  
  Object getVal();
  
  STLang xgetVal();
  
  boolean isSetVal();
  
  void setVal(Object paramObject);
  
  void xsetVal(STLang paramSTLang);
  
  void unsetVal();
  
  Object getEastAsia();
  
  STLang xgetEastAsia();
  
  boolean isSetEastAsia();
  
  void setEastAsia(Object paramObject);
  
  void xsetEastAsia(STLang paramSTLang);
  
  void unsetEastAsia();
  
  Object getBidi();
  
  STLang xgetBidi();
  
  boolean isSetBidi();
  
  void setBidi(Object paramObject);
  
  void xsetBidi(STLang paramSTLang);
  
  void unsetBidi();
  
  public static final class Factory {
    public static CTLanguage newInstance() {
      return (CTLanguage)POIXMLTypeLoader.newInstance(CTLanguage.type, null);
    }
    
    public static CTLanguage newInstance(XmlOptions param1XmlOptions) {
      return (CTLanguage)POIXMLTypeLoader.newInstance(CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(String param1String) throws XmlException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1String, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1String, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(File param1File) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1File, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1File, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(URL param1URL) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1URL, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1URL, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1InputStream, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1InputStream, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1Reader, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1Reader, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(Node param1Node) throws XmlException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1Node, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1Node, CTLanguage.type, param1XmlOptions);
    }
    
    public static CTLanguage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1XMLInputStream, CTLanguage.type, null);
    }
    
    public static CTLanguage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLanguage)POIXMLTypeLoader.parse(param1XMLInputStream, CTLanguage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLanguage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLanguage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTLanguage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */