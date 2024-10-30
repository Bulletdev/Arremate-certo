package org.openxmlformats.schemas.presentationml.x2006.main;

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

public interface NotesDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(NotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("notes4a02doctype");
  
  CTNotesSlide getNotes();
  
  void setNotes(CTNotesSlide paramCTNotesSlide);
  
  CTNotesSlide addNewNotes();
  
  public static final class Factory {
    public static NotesDocument newInstance() {
      return (NotesDocument)POIXMLTypeLoader.newInstance(NotesDocument.type, null);
    }
    
    public static NotesDocument newInstance(XmlOptions param1XmlOptions) {
      return (NotesDocument)POIXMLTypeLoader.newInstance(NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(String param1String) throws XmlException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1String, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1String, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(File param1File) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1File, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1File, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(URL param1URL) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1URL, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1URL, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1InputStream, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1InputStream, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1Reader, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1Reader, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(Node param1Node) throws XmlException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1Node, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1Node, NotesDocument.type, param1XmlOptions);
    }
    
    public static NotesDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, NotesDocument.type, null);
    }
    
    public static NotesDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (NotesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, NotesDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, NotesDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, NotesDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\NotesDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */