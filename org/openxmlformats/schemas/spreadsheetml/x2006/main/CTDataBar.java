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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDataBar extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDataBar.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatabar4128type");
  
  List<CTCfvo> getCfvoList();
  
  CTCfvo[] getCfvoArray();
  
  CTCfvo getCfvoArray(int paramInt);
  
  int sizeOfCfvoArray();
  
  void setCfvoArray(CTCfvo[] paramArrayOfCTCfvo);
  
  void setCfvoArray(int paramInt, CTCfvo paramCTCfvo);
  
  CTCfvo insertNewCfvo(int paramInt);
  
  CTCfvo addNewCfvo();
  
  void removeCfvo(int paramInt);
  
  CTColor getColor();
  
  void setColor(CTColor paramCTColor);
  
  CTColor addNewColor();
  
  long getMinLength();
  
  XmlUnsignedInt xgetMinLength();
  
  boolean isSetMinLength();
  
  void setMinLength(long paramLong);
  
  void xsetMinLength(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMinLength();
  
  long getMaxLength();
  
  XmlUnsignedInt xgetMaxLength();
  
  boolean isSetMaxLength();
  
  void setMaxLength(long paramLong);
  
  void xsetMaxLength(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMaxLength();
  
  boolean getShowValue();
  
  XmlBoolean xgetShowValue();
  
  boolean isSetShowValue();
  
  void setShowValue(boolean paramBoolean);
  
  void xsetShowValue(XmlBoolean paramXmlBoolean);
  
  void unsetShowValue();
  
  public static final class Factory {
    public static CTDataBar newInstance() {
      return (CTDataBar)POIXMLTypeLoader.newInstance(CTDataBar.type, null);
    }
    
    public static CTDataBar newInstance(XmlOptions param1XmlOptions) {
      return (CTDataBar)POIXMLTypeLoader.newInstance(CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(String param1String) throws XmlException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1String, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1String, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(File param1File) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1File, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1File, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(URL param1URL) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1URL, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1URL, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1InputStream, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1InputStream, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1Reader, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1Reader, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(Node param1Node) throws XmlException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1Node, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1Node, CTDataBar.type, param1XmlOptions);
    }
    
    public static CTDataBar parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataBar.type, null);
    }
    
    public static CTDataBar parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDataBar)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataBar.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataBar.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataBar.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDataBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */