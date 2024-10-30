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

public interface CTTextParagraph extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextParagraph.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextparagraphcaf2type");
  
  CTTextParagraphProperties getPPr();
  
  boolean isSetPPr();
  
  void setPPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewPPr();
  
  void unsetPPr();
  
  List<CTRegularTextRun> getRList();
  
  CTRegularTextRun[] getRArray();
  
  CTRegularTextRun getRArray(int paramInt);
  
  int sizeOfRArray();
  
  void setRArray(CTRegularTextRun[] paramArrayOfCTRegularTextRun);
  
  void setRArray(int paramInt, CTRegularTextRun paramCTRegularTextRun);
  
  CTRegularTextRun insertNewR(int paramInt);
  
  CTRegularTextRun addNewR();
  
  void removeR(int paramInt);
  
  List<CTTextLineBreak> getBrList();
  
  CTTextLineBreak[] getBrArray();
  
  CTTextLineBreak getBrArray(int paramInt);
  
  int sizeOfBrArray();
  
  void setBrArray(CTTextLineBreak[] paramArrayOfCTTextLineBreak);
  
  void setBrArray(int paramInt, CTTextLineBreak paramCTTextLineBreak);
  
  CTTextLineBreak insertNewBr(int paramInt);
  
  CTTextLineBreak addNewBr();
  
  void removeBr(int paramInt);
  
  List<CTTextField> getFldList();
  
  CTTextField[] getFldArray();
  
  CTTextField getFldArray(int paramInt);
  
  int sizeOfFldArray();
  
  void setFldArray(CTTextField[] paramArrayOfCTTextField);
  
  void setFldArray(int paramInt, CTTextField paramCTTextField);
  
  CTTextField insertNewFld(int paramInt);
  
  CTTextField addNewFld();
  
  void removeFld(int paramInt);
  
  CTTextCharacterProperties getEndParaRPr();
  
  boolean isSetEndParaRPr();
  
  void setEndParaRPr(CTTextCharacterProperties paramCTTextCharacterProperties);
  
  CTTextCharacterProperties addNewEndParaRPr();
  
  void unsetEndParaRPr();
  
  public static final class Factory {
    public static CTTextParagraph newInstance() {
      return (CTTextParagraph)POIXMLTypeLoader.newInstance(CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph newInstance(XmlOptions param1XmlOptions) {
      return (CTTextParagraph)POIXMLTypeLoader.newInstance(CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(String param1String) throws XmlException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1String, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1String, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(File param1File) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1File, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1File, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(URL param1URL) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1URL, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1URL, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1InputStream, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1InputStream, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1Reader, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1Reader, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(Node param1Node) throws XmlException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1Node, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1Node, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static CTTextParagraph parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextParagraph.type, null);
    }
    
    public static CTTextParagraph parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextParagraph)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextParagraph.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextParagraph.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextParagraph.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */