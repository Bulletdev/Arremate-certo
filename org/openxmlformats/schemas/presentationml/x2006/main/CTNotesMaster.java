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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.w3c.dom.Node;

public interface CTNotesMaster extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNotesMaster.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnotesmaster69ectype");
  
  CTCommonSlideData getCSld();
  
  void setCSld(CTCommonSlideData paramCTCommonSlideData);
  
  CTCommonSlideData addNewCSld();
  
  CTColorMapping getClrMap();
  
  void setClrMap(CTColorMapping paramCTColorMapping);
  
  CTColorMapping addNewClrMap();
  
  CTHeaderFooter getHf();
  
  boolean isSetHf();
  
  void setHf(CTHeaderFooter paramCTHeaderFooter);
  
  CTHeaderFooter addNewHf();
  
  void unsetHf();
  
  CTTextListStyle getNotesStyle();
  
  boolean isSetNotesStyle();
  
  void setNotesStyle(CTTextListStyle paramCTTextListStyle);
  
  CTTextListStyle addNewNotesStyle();
  
  void unsetNotesStyle();
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTNotesMaster newInstance() {
      return (CTNotesMaster)POIXMLTypeLoader.newInstance(CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster newInstance(XmlOptions param1XmlOptions) {
      return (CTNotesMaster)POIXMLTypeLoader.newInstance(CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(String param1String) throws XmlException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1String, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1String, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(File param1File) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1File, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1File, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(URL param1URL) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1URL, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1URL, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1InputStream, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1InputStream, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1Reader, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1Reader, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(Node param1Node) throws XmlException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1Node, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1Node, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static CTNotesMaster parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesMaster.type, null);
    }
    
    public static CTNotesMaster parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNotesMaster)POIXMLTypeLoader.parse(param1XMLInputStream, CTNotesMaster.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesMaster.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNotesMaster.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTNotesMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */