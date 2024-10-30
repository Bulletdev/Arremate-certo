package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCfvo extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCfvo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcfvo7ca5type");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STCfvoType.Enum getType();
  
  STCfvoType xgetType();
  
  void setType(STCfvoType.Enum paramEnum);
  
  void xsetType(STCfvoType paramSTCfvoType);
  
  String getVal();
  
  STXstring xgetVal();
  
  boolean isSetVal();
  
  void setVal(String paramString);
  
  void xsetVal(STXstring paramSTXstring);
  
  void unsetVal();
  
  boolean getGte();
  
  XmlBoolean xgetGte();
  
  boolean isSetGte();
  
  void setGte(boolean paramBoolean);
  
  void xsetGte(XmlBoolean paramXmlBoolean);
  
  void unsetGte();
  
  public static final class Factory {
    public static CTCfvo newInstance() {
      return (CTCfvo)POIXMLTypeLoader.newInstance(CTCfvo.type, null);
    }
    
    public static CTCfvo newInstance(XmlOptions param1XmlOptions) {
      return (CTCfvo)POIXMLTypeLoader.newInstance(CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(String param1String) throws XmlException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1String, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1String, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(File param1File) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1File, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1File, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(URL param1URL) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1URL, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1URL, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1InputStream, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1InputStream, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1Reader, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1Reader, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(Node param1Node) throws XmlException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1Node, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1Node, CTCfvo.type, param1XmlOptions);
    }
    
    public static CTCfvo parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1XMLInputStream, CTCfvo.type, null);
    }
    
    public static CTCfvo parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCfvo)POIXMLTypeLoader.parse(param1XMLInputStream, CTCfvo.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCfvo.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCfvo.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCfvo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */