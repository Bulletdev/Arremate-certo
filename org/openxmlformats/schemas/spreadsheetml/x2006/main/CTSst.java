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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSst extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSst.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsst44f3type");
  
  List<CTRst> getSiList();
  
  CTRst[] getSiArray();
  
  CTRst getSiArray(int paramInt);
  
  int sizeOfSiArray();
  
  void setSiArray(CTRst[] paramArrayOfCTRst);
  
  void setSiArray(int paramInt, CTRst paramCTRst);
  
  CTRst insertNewSi(int paramInt);
  
  CTRst addNewSi();
  
  void removeSi(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  long getUniqueCount();
  
  XmlUnsignedInt xgetUniqueCount();
  
  boolean isSetUniqueCount();
  
  void setUniqueCount(long paramLong);
  
  void xsetUniqueCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetUniqueCount();
  
  public static final class Factory {
    public static CTSst newInstance() {
      return (CTSst)POIXMLTypeLoader.newInstance(CTSst.type, null);
    }
    
    public static CTSst newInstance(XmlOptions param1XmlOptions) {
      return (CTSst)POIXMLTypeLoader.newInstance(CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(String param1String) throws XmlException {
      return (CTSst)POIXMLTypeLoader.parse(param1String, CTSst.type, null);
    }
    
    public static CTSst parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSst)POIXMLTypeLoader.parse(param1String, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(File param1File) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1File, CTSst.type, null);
    }
    
    public static CTSst parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1File, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(URL param1URL) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1URL, CTSst.type, null);
    }
    
    public static CTSst parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1URL, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1InputStream, CTSst.type, null);
    }
    
    public static CTSst parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1InputStream, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1Reader, CTSst.type, null);
    }
    
    public static CTSst parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSst)POIXMLTypeLoader.parse(param1Reader, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSst)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSst.type, null);
    }
    
    public static CTSst parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSst)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(Node param1Node) throws XmlException {
      return (CTSst)POIXMLTypeLoader.parse(param1Node, CTSst.type, null);
    }
    
    public static CTSst parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSst)POIXMLTypeLoader.parse(param1Node, CTSst.type, param1XmlOptions);
    }
    
    public static CTSst parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSst)POIXMLTypeLoader.parse(param1XMLInputStream, CTSst.type, null);
    }
    
    public static CTSst parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSst)POIXMLTypeLoader.parse(param1XMLInputStream, CTSst.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSst.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSst.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */