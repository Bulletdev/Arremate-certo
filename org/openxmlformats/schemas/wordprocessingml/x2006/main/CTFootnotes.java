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

public interface CTFootnotes extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFootnotes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfootnotes691ftype");
  
  List<CTFtnEdn> getFootnoteList();
  
  CTFtnEdn[] getFootnoteArray();
  
  CTFtnEdn getFootnoteArray(int paramInt);
  
  int sizeOfFootnoteArray();
  
  void setFootnoteArray(CTFtnEdn[] paramArrayOfCTFtnEdn);
  
  void setFootnoteArray(int paramInt, CTFtnEdn paramCTFtnEdn);
  
  CTFtnEdn insertNewFootnote(int paramInt);
  
  CTFtnEdn addNewFootnote();
  
  void removeFootnote(int paramInt);
  
  public static final class Factory {
    public static CTFootnotes newInstance() {
      return (CTFootnotes)POIXMLTypeLoader.newInstance(CTFootnotes.type, null);
    }
    
    public static CTFootnotes newInstance(XmlOptions param1XmlOptions) {
      return (CTFootnotes)POIXMLTypeLoader.newInstance(CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(String param1String) throws XmlException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1String, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1String, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(File param1File) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1File, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1File, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(URL param1URL) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1URL, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1URL, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1InputStream, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1InputStream, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1Reader, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1Reader, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(Node param1Node) throws XmlException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1Node, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1Node, CTFootnotes.type, param1XmlOptions);
    }
    
    public static CTFootnotes parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1XMLInputStream, CTFootnotes.type, null);
    }
    
    public static CTFootnotes parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFootnotes)POIXMLTypeLoader.parse(param1XMLInputStream, CTFootnotes.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFootnotes.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFootnotes.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTFootnotes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */