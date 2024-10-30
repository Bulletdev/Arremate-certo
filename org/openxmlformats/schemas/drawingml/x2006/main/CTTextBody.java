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

public interface CTTextBody extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextBody.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbodya3catype");
  
  CTTextBodyProperties getBodyPr();
  
  void setBodyPr(CTTextBodyProperties paramCTTextBodyProperties);
  
  CTTextBodyProperties addNewBodyPr();
  
  CTTextListStyle getLstStyle();
  
  boolean isSetLstStyle();
  
  void setLstStyle(CTTextListStyle paramCTTextListStyle);
  
  CTTextListStyle addNewLstStyle();
  
  void unsetLstStyle();
  
  List<CTTextParagraph> getPList();
  
  CTTextParagraph[] getPArray();
  
  CTTextParagraph getPArray(int paramInt);
  
  int sizeOfPArray();
  
  void setPArray(CTTextParagraph[] paramArrayOfCTTextParagraph);
  
  void setPArray(int paramInt, CTTextParagraph paramCTTextParagraph);
  
  CTTextParagraph insertNewP(int paramInt);
  
  CTTextParagraph addNewP();
  
  void removeP(int paramInt);
  
  public static final class Factory {
    public static CTTextBody newInstance() {
      return (CTTextBody)POIXMLTypeLoader.newInstance(CTTextBody.type, null);
    }
    
    public static CTTextBody newInstance(XmlOptions param1XmlOptions) {
      return (CTTextBody)POIXMLTypeLoader.newInstance(CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(String param1String) throws XmlException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1String, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1String, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(File param1File) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1File, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1File, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(URL param1URL) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1URL, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1URL, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1InputStream, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1InputStream, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1Reader, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1Reader, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(Node param1Node) throws XmlException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1Node, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1Node, CTTextBody.type, param1XmlOptions);
    }
    
    public static CTTextBody parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBody.type, null);
    }
    
    public static CTTextBody parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextBody)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBody.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBody.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBody.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */