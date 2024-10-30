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

public interface CTTableStyleInfo extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableStyleInfo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestyleinfo499atype");
  
  String getName();
  
  STXstring xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  void unsetName();
  
  boolean getShowFirstColumn();
  
  XmlBoolean xgetShowFirstColumn();
  
  boolean isSetShowFirstColumn();
  
  void setShowFirstColumn(boolean paramBoolean);
  
  void xsetShowFirstColumn(XmlBoolean paramXmlBoolean);
  
  void unsetShowFirstColumn();
  
  boolean getShowLastColumn();
  
  XmlBoolean xgetShowLastColumn();
  
  boolean isSetShowLastColumn();
  
  void setShowLastColumn(boolean paramBoolean);
  
  void xsetShowLastColumn(XmlBoolean paramXmlBoolean);
  
  void unsetShowLastColumn();
  
  boolean getShowRowStripes();
  
  XmlBoolean xgetShowRowStripes();
  
  boolean isSetShowRowStripes();
  
  void setShowRowStripes(boolean paramBoolean);
  
  void xsetShowRowStripes(XmlBoolean paramXmlBoolean);
  
  void unsetShowRowStripes();
  
  boolean getShowColumnStripes();
  
  XmlBoolean xgetShowColumnStripes();
  
  boolean isSetShowColumnStripes();
  
  void setShowColumnStripes(boolean paramBoolean);
  
  void xsetShowColumnStripes(XmlBoolean paramXmlBoolean);
  
  void unsetShowColumnStripes();
  
  public static final class Factory {
    public static CTTableStyleInfo newInstance() {
      return (CTTableStyleInfo)POIXMLTypeLoader.newInstance(CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo newInstance(XmlOptions param1XmlOptions) {
      return (CTTableStyleInfo)POIXMLTypeLoader.newInstance(CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(String param1String) throws XmlException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1String, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1String, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(File param1File) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1File, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1File, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(URL param1URL) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1URL, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1URL, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1Reader, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1Reader, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(Node param1Node) throws XmlException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1Node, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1Node, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static CTTableStyleInfo parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleInfo.type, null);
    }
    
    public static CTTableStyleInfo parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableStyleInfo)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleInfo.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleInfo.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleInfo.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTTableStyleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */