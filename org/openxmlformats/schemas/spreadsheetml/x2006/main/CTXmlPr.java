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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTXmlPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTXmlPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctxmlpr2c58type");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getMapId();
  
  XmlUnsignedInt xgetMapId();
  
  void setMapId(long paramLong);
  
  void xsetMapId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getXpath();
  
  STXstring xgetXpath();
  
  void setXpath(String paramString);
  
  void xsetXpath(STXstring paramSTXstring);
  
  STXmlDataType.Enum getXmlDataType();
  
  STXmlDataType xgetXmlDataType();
  
  void setXmlDataType(STXmlDataType.Enum paramEnum);
  
  void xsetXmlDataType(STXmlDataType paramSTXmlDataType);
  
  public static final class Factory {
    public static CTXmlPr newInstance() {
      return (CTXmlPr)POIXMLTypeLoader.newInstance(CTXmlPr.type, null);
    }
    
    public static CTXmlPr newInstance(XmlOptions param1XmlOptions) {
      return (CTXmlPr)POIXMLTypeLoader.newInstance(CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(String param1String) throws XmlException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1String, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1String, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(File param1File) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1File, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1File, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(URL param1URL) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1URL, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1URL, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1InputStream, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1InputStream, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1Reader, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1Reader, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(Node param1Node) throws XmlException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1Node, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1Node, CTXmlPr.type, param1XmlOptions);
    }
    
    public static CTXmlPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTXmlPr.type, null);
    }
    
    public static CTXmlPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTXmlPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTXmlPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXmlPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXmlPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTXmlPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */