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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTExternalBook extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTExternalBook.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalbookc89dtype");
  
  CTExternalSheetNames getSheetNames();
  
  boolean isSetSheetNames();
  
  void setSheetNames(CTExternalSheetNames paramCTExternalSheetNames);
  
  CTExternalSheetNames addNewSheetNames();
  
  void unsetSheetNames();
  
  CTExternalDefinedNames getDefinedNames();
  
  boolean isSetDefinedNames();
  
  void setDefinedNames(CTExternalDefinedNames paramCTExternalDefinedNames);
  
  CTExternalDefinedNames addNewDefinedNames();
  
  void unsetDefinedNames();
  
  CTExternalSheetDataSet getSheetDataSet();
  
  boolean isSetSheetDataSet();
  
  void setSheetDataSet(CTExternalSheetDataSet paramCTExternalSheetDataSet);
  
  CTExternalSheetDataSet addNewSheetDataSet();
  
  void unsetSheetDataSet();
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTExternalBook newInstance() {
      return (CTExternalBook)POIXMLTypeLoader.newInstance(CTExternalBook.type, null);
    }
    
    public static CTExternalBook newInstance(XmlOptions param1XmlOptions) {
      return (CTExternalBook)POIXMLTypeLoader.newInstance(CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(String param1String) throws XmlException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1String, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1String, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(File param1File) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1File, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1File, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(URL param1URL) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1URL, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1URL, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1InputStream, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1InputStream, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(Reader param1Reader) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1Reader, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1Reader, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(Node param1Node) throws XmlException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1Node, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1Node, CTExternalBook.type, param1XmlOptions);
    }
    
    public static CTExternalBook parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalBook.type, null);
    }
    
    public static CTExternalBook parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTExternalBook)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalBook.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalBook.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalBook.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTExternalBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */