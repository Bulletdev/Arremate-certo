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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTConditionalFormatting extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTConditionalFormatting.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconditionalformatting0deatype");
  
  List<CTCfRule> getCfRuleList();
  
  CTCfRule[] getCfRuleArray();
  
  CTCfRule getCfRuleArray(int paramInt);
  
  int sizeOfCfRuleArray();
  
  void setCfRuleArray(CTCfRule[] paramArrayOfCTCfRule);
  
  void setCfRuleArray(int paramInt, CTCfRule paramCTCfRule);
  
  CTCfRule insertNewCfRule(int paramInt);
  
  CTCfRule addNewCfRule();
  
  void removeCfRule(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getPivot();
  
  XmlBoolean xgetPivot();
  
  boolean isSetPivot();
  
  void setPivot(boolean paramBoolean);
  
  void xsetPivot(XmlBoolean paramXmlBoolean);
  
  void unsetPivot();
  
  List getSqref();
  
  STSqref xgetSqref();
  
  boolean isSetSqref();
  
  void setSqref(List paramList);
  
  void xsetSqref(STSqref paramSTSqref);
  
  void unsetSqref();
  
  public static final class Factory {
    public static CTConditionalFormatting newInstance() {
      return (CTConditionalFormatting)POIXMLTypeLoader.newInstance(CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting newInstance(XmlOptions param1XmlOptions) {
      return (CTConditionalFormatting)POIXMLTypeLoader.newInstance(CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(String param1String) throws XmlException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1String, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1String, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(File param1File) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1File, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1File, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(URL param1URL) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1URL, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1URL, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1InputStream, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1InputStream, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(Reader param1Reader) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1Reader, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1Reader, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1XMLStreamReader, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(Node param1Node) throws XmlException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1Node, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1Node, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static CTConditionalFormatting parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1XMLInputStream, CTConditionalFormatting.type, null);
    }
    
    public static CTConditionalFormatting parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTConditionalFormatting)POIXMLTypeLoader.parse(param1XMLInputStream, CTConditionalFormatting.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConditionalFormatting.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTConditionalFormatting.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */