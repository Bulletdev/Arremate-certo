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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCols extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCols.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcols627ctype");
  
  List<CTCol> getColList();
  
  CTCol[] getColArray();
  
  CTCol getColArray(int paramInt);
  
  int sizeOfColArray();
  
  void setColArray(CTCol[] paramArrayOfCTCol);
  
  void setColArray(int paramInt, CTCol paramCTCol);
  
  CTCol insertNewCol(int paramInt);
  
  CTCol addNewCol();
  
  void removeCol(int paramInt);
  
  public static final class Factory {
    public static CTCols newInstance() {
      return (CTCols)POIXMLTypeLoader.newInstance(CTCols.type, null);
    }
    
    public static CTCols newInstance(XmlOptions param1XmlOptions) {
      return (CTCols)POIXMLTypeLoader.newInstance(CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(String param1String) throws XmlException {
      return (CTCols)POIXMLTypeLoader.parse(param1String, CTCols.type, null);
    }
    
    public static CTCols parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCols)POIXMLTypeLoader.parse(param1String, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(File param1File) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1File, CTCols.type, null);
    }
    
    public static CTCols parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1File, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(URL param1URL) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1URL, CTCols.type, null);
    }
    
    public static CTCols parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1URL, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1InputStream, CTCols.type, null);
    }
    
    public static CTCols parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1InputStream, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1Reader, CTCols.type, null);
    }
    
    public static CTCols parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCols)POIXMLTypeLoader.parse(param1Reader, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCols)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCols.type, null);
    }
    
    public static CTCols parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCols)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(Node param1Node) throws XmlException {
      return (CTCols)POIXMLTypeLoader.parse(param1Node, CTCols.type, null);
    }
    
    public static CTCols parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCols)POIXMLTypeLoader.parse(param1Node, CTCols.type, param1XmlOptions);
    }
    
    public static CTCols parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCols)POIXMLTypeLoader.parse(param1XMLInputStream, CTCols.type, null);
    }
    
    public static CTCols parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCols)POIXMLTypeLoader.parse(param1XMLInputStream, CTCols.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCols.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCols.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */