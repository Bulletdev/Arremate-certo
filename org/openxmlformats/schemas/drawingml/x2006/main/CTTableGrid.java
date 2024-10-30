package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTTableGrid extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableGrid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablegrid69a5type");
  
  List<CTTableCol> getGridColList();
  
  CTTableCol[] getGridColArray();
  
  CTTableCol getGridColArray(int paramInt);
  
  int sizeOfGridColArray();
  
  void setGridColArray(CTTableCol[] paramArrayOfCTTableCol);
  
  void setGridColArray(int paramInt, CTTableCol paramCTTableCol);
  
  CTTableCol insertNewGridCol(int paramInt);
  
  CTTableCol addNewGridCol();
  
  void removeGridCol(int paramInt);
  
  public static final class Factory {
    public static CTTableGrid newInstance() {
      return (CTTableGrid)POIXMLTypeLoader.newInstance(CTTableGrid.type, null);
    }
    
    public static CTTableGrid newInstance(XmlOptions param1XmlOptions) {
      return (CTTableGrid)POIXMLTypeLoader.newInstance(CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(String param1String) throws XmlException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1String, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1String, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(File param1File) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1File, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1File, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(URL param1URL) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1URL, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1URL, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1InputStream, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1InputStream, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1Reader, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1Reader, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(Node param1Node) throws XmlException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1Node, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1Node, CTTableGrid.type, param1XmlOptions);
    }
    
    public static CTTableGrid parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableGrid.type, null);
    }
    
    public static CTTableGrid parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableGrid)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableGrid.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableGrid.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableGrid.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */