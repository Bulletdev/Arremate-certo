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

public interface CTHyperlink extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHyperlink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthyperlink0c85type");
  
  String getRef();
  
  STRef xgetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  String getId();
  
  STRelationshipId xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  void unsetId();
  
  String getLocation();
  
  STXstring xgetLocation();
  
  boolean isSetLocation();
  
  void setLocation(String paramString);
  
  void xsetLocation(STXstring paramSTXstring);
  
  void unsetLocation();
  
  String getTooltip();
  
  STXstring xgetTooltip();
  
  boolean isSetTooltip();
  
  void setTooltip(String paramString);
  
  void xsetTooltip(STXstring paramSTXstring);
  
  void unsetTooltip();
  
  String getDisplay();
  
  STXstring xgetDisplay();
  
  boolean isSetDisplay();
  
  void setDisplay(String paramString);
  
  void xsetDisplay(STXstring paramSTXstring);
  
  void unsetDisplay();
  
  public static final class Factory {
    public static CTHyperlink newInstance() {
      return (CTHyperlink)POIXMLTypeLoader.newInstance(CTHyperlink.type, null);
    }
    
    public static CTHyperlink newInstance(XmlOptions param1XmlOptions) {
      return (CTHyperlink)POIXMLTypeLoader.newInstance(CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(String param1String) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1String, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1String, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(File param1File) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1File, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1File, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(URL param1URL) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1URL, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1URL, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1InputStream, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1InputStream, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Reader, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Reader, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(Node param1Node) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Node, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1Node, CTHyperlink.type, param1XmlOptions);
    }
    
    public static CTHyperlink parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLInputStream, CTHyperlink.type, null);
    }
    
    public static CTHyperlink parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHyperlink)POIXMLTypeLoader.parse(param1XMLInputStream, CTHyperlink.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHyperlink.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHyperlink.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */