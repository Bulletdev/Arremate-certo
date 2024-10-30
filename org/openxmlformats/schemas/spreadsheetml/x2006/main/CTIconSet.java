package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTIconSet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTIconSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cticonset2648type");
  
  List<CTCfvo> getCfvoList();
  
  CTCfvo[] getCfvoArray();
  
  CTCfvo getCfvoArray(int paramInt);
  
  int sizeOfCfvoArray();
  
  void setCfvoArray(CTCfvo[] paramArrayOfCTCfvo);
  
  void setCfvoArray(int paramInt, CTCfvo paramCTCfvo);
  
  CTCfvo insertNewCfvo(int paramInt);
  
  CTCfvo addNewCfvo();
  
  void removeCfvo(int paramInt);
  
  STIconSetType.Enum getIconSet();
  
  STIconSetType xgetIconSet();
  
  boolean isSetIconSet();
  
  void setIconSet(STIconSetType.Enum paramEnum);
  
  void xsetIconSet(STIconSetType paramSTIconSetType);
  
  void unsetIconSet();
  
  boolean getShowValue();
  
  XmlBoolean xgetShowValue();
  
  boolean isSetShowValue();
  
  void setShowValue(boolean paramBoolean);
  
  void xsetShowValue(XmlBoolean paramXmlBoolean);
  
  void unsetShowValue();
  
  boolean getPercent();
  
  XmlBoolean xgetPercent();
  
  boolean isSetPercent();
  
  void setPercent(boolean paramBoolean);
  
  void xsetPercent(XmlBoolean paramXmlBoolean);
  
  void unsetPercent();
  
  boolean getReverse();
  
  XmlBoolean xgetReverse();
  
  boolean isSetReverse();
  
  void setReverse(boolean paramBoolean);
  
  void xsetReverse(XmlBoolean paramXmlBoolean);
  
  void unsetReverse();
  
  public static final class Factory {
    public static CTIconSet newInstance() {
      return (CTIconSet)POIXMLTypeLoader.newInstance(CTIconSet.type, null);
    }
    
    public static CTIconSet newInstance(XmlOptions param1XmlOptions) {
      return (CTIconSet)POIXMLTypeLoader.newInstance(CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(String param1String) throws XmlException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1String, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1String, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(File param1File) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1File, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1File, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(URL param1URL) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1URL, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1URL, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1InputStream, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1InputStream, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1Reader, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1Reader, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(Node param1Node) throws XmlException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1Node, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1Node, CTIconSet.type, param1XmlOptions);
    }
    
    public static CTIconSet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1XMLInputStream, CTIconSet.type, null);
    }
    
    public static CTIconSet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTIconSet)POIXMLTypeLoader.parse(param1XMLInputStream, CTIconSet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIconSet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIconSet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTIconSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */