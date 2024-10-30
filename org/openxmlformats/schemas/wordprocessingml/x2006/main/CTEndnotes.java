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

public interface CTEndnotes extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEndnotes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctendnotescee2type");
  
  List<CTFtnEdn> getEndnoteList();
  
  CTFtnEdn[] getEndnoteArray();
  
  CTFtnEdn getEndnoteArray(int paramInt);
  
  int sizeOfEndnoteArray();
  
  void setEndnoteArray(CTFtnEdn[] paramArrayOfCTFtnEdn);
  
  void setEndnoteArray(int paramInt, CTFtnEdn paramCTFtnEdn);
  
  CTFtnEdn insertNewEndnote(int paramInt);
  
  CTFtnEdn addNewEndnote();
  
  void removeEndnote(int paramInt);
  
  public static final class Factory {
    public static CTEndnotes newInstance() {
      return (CTEndnotes)POIXMLTypeLoader.newInstance(CTEndnotes.type, null);
    }
    
    public static CTEndnotes newInstance(XmlOptions param1XmlOptions) {
      return (CTEndnotes)POIXMLTypeLoader.newInstance(CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(String param1String) throws XmlException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1String, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1String, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(File param1File) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1File, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1File, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(URL param1URL) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1URL, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1URL, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1InputStream, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1InputStream, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1Reader, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1Reader, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(Node param1Node) throws XmlException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1Node, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1Node, CTEndnotes.type, param1XmlOptions);
    }
    
    public static CTEndnotes parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1XMLInputStream, CTEndnotes.type, null);
    }
    
    public static CTEndnotes parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEndnotes)POIXMLTypeLoader.parse(param1XMLInputStream, CTEndnotes.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEndnotes.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEndnotes.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTEndnotes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */