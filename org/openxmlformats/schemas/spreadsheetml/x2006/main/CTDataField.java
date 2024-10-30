package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDataField extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDataField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatafield6f0ftype");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  STXstring xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  void unsetName();
  
  long getFld();
  
  XmlUnsignedInt xgetFld();
  
  void setFld(long paramLong);
  
  void xsetFld(XmlUnsignedInt paramXmlUnsignedInt);
  
  STDataConsolidateFunction.Enum getSubtotal();
  
  STDataConsolidateFunction xgetSubtotal();
  
  boolean isSetSubtotal();
  
  void setSubtotal(STDataConsolidateFunction.Enum paramEnum);
  
  void xsetSubtotal(STDataConsolidateFunction paramSTDataConsolidateFunction);
  
  void unsetSubtotal();
  
  STShowDataAs$Enum getShowDataAs();
  
  STShowDataAs xgetShowDataAs();
  
  boolean isSetShowDataAs();
  
  void setShowDataAs(STShowDataAs$Enum paramSTShowDataAs$Enum);
  
  void xsetShowDataAs(STShowDataAs paramSTShowDataAs);
  
  void unsetShowDataAs();
  
  int getBaseField();
  
  XmlInt xgetBaseField();
  
  boolean isSetBaseField();
  
  void setBaseField(int paramInt);
  
  void xsetBaseField(XmlInt paramXmlInt);
  
  void unsetBaseField();
  
  long getBaseItem();
  
  XmlUnsignedInt xgetBaseItem();
  
  boolean isSetBaseItem();
  
  void setBaseItem(long paramLong);
  
  void xsetBaseItem(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetBaseItem();
  
  long getNumFmtId();
  
  STNumFmtId xgetNumFmtId();
  
  boolean isSetNumFmtId();
  
  void setNumFmtId(long paramLong);
  
  void xsetNumFmtId(STNumFmtId paramSTNumFmtId);
  
  void unsetNumFmtId();
  
  public static final class Factory {
    public static CTDataField newInstance() {
      return (CTDataField)POIXMLTypeLoader.newInstance(CTDataField.type, null);
    }
    
    public static CTDataField newInstance(XmlOptions param1XmlOptions) {
      return (CTDataField)POIXMLTypeLoader.newInstance(CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(String param1String) throws XmlException {
      return (CTDataField)POIXMLTypeLoader.parse(param1String, CTDataField.type, null);
    }
    
    public static CTDataField parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataField)POIXMLTypeLoader.parse(param1String, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(File param1File) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1File, CTDataField.type, null);
    }
    
    public static CTDataField parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1File, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(URL param1URL) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1URL, CTDataField.type, null);
    }
    
    public static CTDataField parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1URL, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1InputStream, CTDataField.type, null);
    }
    
    public static CTDataField parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1InputStream, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1Reader, CTDataField.type, null);
    }
    
    public static CTDataField parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataField)POIXMLTypeLoader.parse(param1Reader, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDataField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataField.type, null);
    }
    
    public static CTDataField parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(Node param1Node) throws XmlException {
      return (CTDataField)POIXMLTypeLoader.parse(param1Node, CTDataField.type, null);
    }
    
    public static CTDataField parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataField)POIXMLTypeLoader.parse(param1Node, CTDataField.type, param1XmlOptions);
    }
    
    public static CTDataField parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDataField)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataField.type, null);
    }
    
    public static CTDataField parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDataField)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataField.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataField.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataField.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDataField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */