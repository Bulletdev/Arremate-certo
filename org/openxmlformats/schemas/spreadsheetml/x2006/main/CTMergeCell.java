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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTMergeCell extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMergeCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmergecelle8d9type");
  
  String getRef();
  
  STRef xgetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  public static final class Factory {
    public static CTMergeCell newInstance() {
      return (CTMergeCell)POIXMLTypeLoader.newInstance(CTMergeCell.type, null);
    }
    
    public static CTMergeCell newInstance(XmlOptions param1XmlOptions) {
      return (CTMergeCell)POIXMLTypeLoader.newInstance(CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(String param1String) throws XmlException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1String, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1String, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(File param1File) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1File, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1File, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(URL param1URL) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1URL, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1URL, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1InputStream, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1InputStream, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1Reader, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1Reader, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(Node param1Node) throws XmlException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1Node, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1Node, CTMergeCell.type, param1XmlOptions);
    }
    
    public static CTMergeCell parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTMergeCell.type, null);
    }
    
    public static CTMergeCell parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMergeCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTMergeCell.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMergeCell.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMergeCell.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTMergeCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */