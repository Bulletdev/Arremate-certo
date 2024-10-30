package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTblGridBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblGridBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblgridbasea11dtype");
  
  List<CTTblGridCol> getGridColList();
  
  CTTblGridCol[] getGridColArray();
  
  CTTblGridCol getGridColArray(int paramInt);
  
  int sizeOfGridColArray();
  
  void setGridColArray(CTTblGridCol[] paramArrayOfCTTblGridCol);
  
  void setGridColArray(int paramInt, CTTblGridCol paramCTTblGridCol);
  
  CTTblGridCol insertNewGridCol(int paramInt);
  
  CTTblGridCol addNewGridCol();
  
  void removeGridCol(int paramInt);
  
  public static final class Factory {
    public static CTTblGridBase newInstance() {
      return (CTTblGridBase)POIXMLTypeLoader.newInstance(CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase newInstance(XmlOptions param1XmlOptions) {
      return (CTTblGridBase)POIXMLTypeLoader.newInstance(CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(String param1String) throws XmlException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1String, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1String, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(File param1File) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1File, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1File, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(URL param1URL) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1URL, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1URL, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1InputStream, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1InputStream, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1Reader, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1Reader, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(Node param1Node) throws XmlException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1Node, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1Node, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static CTTblGridBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblGridBase.type, null);
    }
    
    public static CTTblGridBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblGridBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblGridBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblGridBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblGridBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblGridBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */