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

public interface CTSingleXmlCell extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSingleXmlCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsinglexmlcell7790type");
  
  CTXmlCellPr getXmlCellPr();
  
  void setXmlCellPr(CTXmlCellPr paramCTXmlCellPr);
  
  CTXmlCellPr addNewXmlCellPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  XmlUnsignedInt xgetId();
  
  void setId(long paramLong);
  
  void xsetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getR();
  
  STCellRef xgetR();
  
  void setR(String paramString);
  
  void xsetR(STCellRef paramSTCellRef);
  
  long getConnectionId();
  
  XmlUnsignedInt xgetConnectionId();
  
  void setConnectionId(long paramLong);
  
  void xsetConnectionId(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTSingleXmlCell newInstance() {
      return (CTSingleXmlCell)POIXMLTypeLoader.newInstance(CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell newInstance(XmlOptions param1XmlOptions) {
      return (CTSingleXmlCell)POIXMLTypeLoader.newInstance(CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(String param1String) throws XmlException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1String, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1String, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(File param1File) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1File, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1File, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(URL param1URL) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1URL, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1URL, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1InputStream, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1InputStream, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1Reader, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1Reader, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(Node param1Node) throws XmlException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1Node, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1Node, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static CTSingleXmlCell parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTSingleXmlCell.type, null);
    }
    
    public static CTSingleXmlCell parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSingleXmlCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTSingleXmlCell.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSingleXmlCell.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSingleXmlCell.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSingleXmlCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */