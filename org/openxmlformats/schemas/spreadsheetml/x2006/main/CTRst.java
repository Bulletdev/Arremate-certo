package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTRst extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRst.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrsta472type");
  
  String getT();
  
  STXstring xgetT();
  
  boolean isSetT();
  
  void setT(String paramString);
  
  void xsetT(STXstring paramSTXstring);
  
  void unsetT();
  
  List<CTRElt> getRList();
  
  CTRElt[] getRArray();
  
  CTRElt getRArray(int paramInt);
  
  int sizeOfRArray();
  
  void setRArray(CTRElt[] paramArrayOfCTRElt);
  
  void setRArray(int paramInt, CTRElt paramCTRElt);
  
  CTRElt insertNewR(int paramInt);
  
  CTRElt addNewR();
  
  void removeR(int paramInt);
  
  List<CTPhoneticRun> getRPhList();
  
  CTPhoneticRun[] getRPhArray();
  
  CTPhoneticRun getRPhArray(int paramInt);
  
  int sizeOfRPhArray();
  
  void setRPhArray(CTPhoneticRun[] paramArrayOfCTPhoneticRun);
  
  void setRPhArray(int paramInt, CTPhoneticRun paramCTPhoneticRun);
  
  CTPhoneticRun insertNewRPh(int paramInt);
  
  CTPhoneticRun addNewRPh();
  
  void removeRPh(int paramInt);
  
  CTPhoneticPr getPhoneticPr();
  
  boolean isSetPhoneticPr();
  
  void setPhoneticPr(CTPhoneticPr paramCTPhoneticPr);
  
  CTPhoneticPr addNewPhoneticPr();
  
  void unsetPhoneticPr();
  
  public static final class Factory {
    public static CTRst newInstance() {
      return (CTRst)POIXMLTypeLoader.newInstance(CTRst.type, null);
    }
    
    public static CTRst newInstance(XmlOptions param1XmlOptions) {
      return (CTRst)POIXMLTypeLoader.newInstance(CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(String param1String) throws XmlException {
      return (CTRst)POIXMLTypeLoader.parse(param1String, CTRst.type, null);
    }
    
    public static CTRst parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRst)POIXMLTypeLoader.parse(param1String, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(File param1File) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1File, CTRst.type, null);
    }
    
    public static CTRst parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1File, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(URL param1URL) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1URL, CTRst.type, null);
    }
    
    public static CTRst parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1URL, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1InputStream, CTRst.type, null);
    }
    
    public static CTRst parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1InputStream, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1Reader, CTRst.type, null);
    }
    
    public static CTRst parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRst)POIXMLTypeLoader.parse(param1Reader, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRst)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRst.type, null);
    }
    
    public static CTRst parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRst)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(Node param1Node) throws XmlException {
      return (CTRst)POIXMLTypeLoader.parse(param1Node, CTRst.type, null);
    }
    
    public static CTRst parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRst)POIXMLTypeLoader.parse(param1Node, CTRst.type, param1XmlOptions);
    }
    
    public static CTRst parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRst)POIXMLTypeLoader.parse(param1XMLInputStream, CTRst.type, null);
    }
    
    public static CTRst parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRst)POIXMLTypeLoader.parse(param1XMLInputStream, CTRst.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRst.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRst.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTRst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */