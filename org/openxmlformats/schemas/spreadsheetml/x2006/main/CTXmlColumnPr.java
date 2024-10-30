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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTXmlColumnPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTXmlColumnPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctxmlcolumnprc14etype");
  
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
  
  boolean getDenormalized();
  
  XmlBoolean xgetDenormalized();
  
  boolean isSetDenormalized();
  
  void setDenormalized(boolean paramBoolean);
  
  void xsetDenormalized(XmlBoolean paramXmlBoolean);
  
  void unsetDenormalized();
  
  STXmlDataType.Enum getXmlDataType();
  
  STXmlDataType xgetXmlDataType();
  
  void setXmlDataType(STXmlDataType.Enum paramEnum);
  
  void xsetXmlDataType(STXmlDataType paramSTXmlDataType);
  
  public static final class Factory {
    public static CTXmlColumnPr newInstance() {
      return (CTXmlColumnPr)POIXMLTypeLoader.newInstance(CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr newInstance(XmlOptions param1XmlOptions) {
      return (CTXmlColumnPr)POIXMLTypeLoader.newInstance(CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(String param1String) throws XmlException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1String, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1String, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(File param1File) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1File, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1File, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(URL param1URL) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1URL, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1URL, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1InputStream, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1InputStream, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1Reader, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1Reader, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(Node param1Node) throws XmlException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1Node, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1Node, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static CTXmlColumnPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTXmlColumnPr.type, null);
    }
    
    public static CTXmlColumnPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTXmlColumnPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTXmlColumnPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXmlColumnPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXmlColumnPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTXmlColumnPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */