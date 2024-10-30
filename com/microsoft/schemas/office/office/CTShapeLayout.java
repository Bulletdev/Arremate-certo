package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
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

public interface CTShapeLayout extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShapeLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapelayoutbda4type");
  
  CTIdMap getIdmap();
  
  boolean isSetIdmap();
  
  void setIdmap(CTIdMap paramCTIdMap);
  
  CTIdMap addNewIdmap();
  
  void unsetIdmap();
  
  CTRegroupTable getRegrouptable();
  
  boolean isSetRegrouptable();
  
  void setRegrouptable(CTRegroupTable paramCTRegroupTable);
  
  CTRegroupTable addNewRegrouptable();
  
  void unsetRegrouptable();
  
  CTRules getRules();
  
  boolean isSetRules();
  
  void setRules(CTRules paramCTRules);
  
  CTRules addNewRules();
  
  void unsetRules();
  
  STExt.Enum getExt();
  
  STExt xgetExt();
  
  boolean isSetExt();
  
  void setExt(STExt.Enum paramEnum);
  
  void xsetExt(STExt paramSTExt);
  
  void unsetExt();
  
  public static final class Factory {
    public static CTShapeLayout newInstance() {
      return (CTShapeLayout)POIXMLTypeLoader.newInstance(CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout newInstance(XmlOptions param1XmlOptions) {
      return (CTShapeLayout)POIXMLTypeLoader.newInstance(CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(String param1String) throws XmlException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1String, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1String, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(File param1File) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1File, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1File, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(URL param1URL) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1URL, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1URL, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1InputStream, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1InputStream, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1Reader, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1Reader, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(Node param1Node) throws XmlException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1Node, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1Node, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static CTShapeLayout parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeLayout.type, null);
    }
    
    public static CTShapeLayout parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShapeLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeLayout.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeLayout.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeLayout.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\CTShapeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */