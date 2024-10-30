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

public interface CTFontCollection extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFontCollection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfontcollectiondd68type");
  
  CTTextFont getLatin();
  
  void setLatin(CTTextFont paramCTTextFont);
  
  CTTextFont addNewLatin();
  
  CTTextFont getEa();
  
  void setEa(CTTextFont paramCTTextFont);
  
  CTTextFont addNewEa();
  
  CTTextFont getCs();
  
  void setCs(CTTextFont paramCTTextFont);
  
  CTTextFont addNewCs();
  
  List<CTSupplementalFont> getFontList();
  
  CTSupplementalFont[] getFontArray();
  
  CTSupplementalFont getFontArray(int paramInt);
  
  int sizeOfFontArray();
  
  void setFontArray(CTSupplementalFont[] paramArrayOfCTSupplementalFont);
  
  void setFontArray(int paramInt, CTSupplementalFont paramCTSupplementalFont);
  
  CTSupplementalFont insertNewFont(int paramInt);
  
  CTSupplementalFont addNewFont();
  
  void removeFont(int paramInt);
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTFontCollection newInstance() {
      return (CTFontCollection)POIXMLTypeLoader.newInstance(CTFontCollection.type, null);
    }
    
    public static CTFontCollection newInstance(XmlOptions param1XmlOptions) {
      return (CTFontCollection)POIXMLTypeLoader.newInstance(CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(String param1String) throws XmlException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1String, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1String, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(File param1File) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1File, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1File, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(URL param1URL) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1URL, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1URL, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1InputStream, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1InputStream, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1Reader, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1Reader, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(Node param1Node) throws XmlException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1Node, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1Node, CTFontCollection.type, param1XmlOptions);
    }
    
    public static CTFontCollection parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontCollection.type, null);
    }
    
    public static CTFontCollection parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFontCollection)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontCollection.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontCollection.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontCollection.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTFontCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */