package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTTextListStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextListStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextliststyleab77type");
  
  CTTextParagraphProperties getDefPPr();
  
  boolean isSetDefPPr();
  
  void setDefPPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewDefPPr();
  
  void unsetDefPPr();
  
  CTTextParagraphProperties getLvl1PPr();
  
  boolean isSetLvl1PPr();
  
  void setLvl1PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl1PPr();
  
  void unsetLvl1PPr();
  
  CTTextParagraphProperties getLvl2PPr();
  
  boolean isSetLvl2PPr();
  
  void setLvl2PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl2PPr();
  
  void unsetLvl2PPr();
  
  CTTextParagraphProperties getLvl3PPr();
  
  boolean isSetLvl3PPr();
  
  void setLvl3PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl3PPr();
  
  void unsetLvl3PPr();
  
  CTTextParagraphProperties getLvl4PPr();
  
  boolean isSetLvl4PPr();
  
  void setLvl4PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl4PPr();
  
  void unsetLvl4PPr();
  
  CTTextParagraphProperties getLvl5PPr();
  
  boolean isSetLvl5PPr();
  
  void setLvl5PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl5PPr();
  
  void unsetLvl5PPr();
  
  CTTextParagraphProperties getLvl6PPr();
  
  boolean isSetLvl6PPr();
  
  void setLvl6PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl6PPr();
  
  void unsetLvl6PPr();
  
  CTTextParagraphProperties getLvl7PPr();
  
  boolean isSetLvl7PPr();
  
  void setLvl7PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl7PPr();
  
  void unsetLvl7PPr();
  
  CTTextParagraphProperties getLvl8PPr();
  
  boolean isSetLvl8PPr();
  
  void setLvl8PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl8PPr();
  
  void unsetLvl8PPr();
  
  CTTextParagraphProperties getLvl9PPr();
  
  boolean isSetLvl9PPr();
  
  void setLvl9PPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewLvl9PPr();
  
  void unsetLvl9PPr();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTTextListStyle newInstance() {
      return (CTTextListStyle)POIXMLTypeLoader.newInstance(CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTTextListStyle)POIXMLTypeLoader.newInstance(CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(String param1String) throws XmlException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1String, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1String, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(File param1File) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1File, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1File, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1URL, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1URL, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1InputStream, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1InputStream, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1Reader, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1Reader, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(Node param1Node) throws XmlException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1Node, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1Node, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static CTTextListStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextListStyle.type, null);
    }
    
    public static CTTextListStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextListStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextListStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextListStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextListStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextListStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */