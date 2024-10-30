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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTRow extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrowdd39type");
  
  List<CTCell> getCList();
  
  CTCell[] getCArray();
  
  CTCell getCArray(int paramInt);
  
  int sizeOfCArray();
  
  void setCArray(CTCell[] paramArrayOfCTCell);
  
  void setCArray(int paramInt, CTCell paramCTCell);
  
  CTCell insertNewC(int paramInt);
  
  CTCell addNewC();
  
  void removeC(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getR();
  
  XmlUnsignedInt xgetR();
  
  boolean isSetR();
  
  void setR(long paramLong);
  
  void xsetR(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetR();
  
  List getSpans();
  
  STCellSpans xgetSpans();
  
  boolean isSetSpans();
  
  void setSpans(List paramList);
  
  void xsetSpans(STCellSpans paramSTCellSpans);
  
  void unsetSpans();
  
  long getS();
  
  XmlUnsignedInt xgetS();
  
  boolean isSetS();
  
  void setS(long paramLong);
  
  void xsetS(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetS();
  
  boolean getCustomFormat();
  
  XmlBoolean xgetCustomFormat();
  
  boolean isSetCustomFormat();
  
  void setCustomFormat(boolean paramBoolean);
  
  void xsetCustomFormat(XmlBoolean paramXmlBoolean);
  
  void unsetCustomFormat();
  
  double getHt();
  
  XmlDouble xgetHt();
  
  boolean isSetHt();
  
  void setHt(double paramDouble);
  
  void xsetHt(XmlDouble paramXmlDouble);
  
  void unsetHt();
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  boolean getCustomHeight();
  
  XmlBoolean xgetCustomHeight();
  
  boolean isSetCustomHeight();
  
  void setCustomHeight(boolean paramBoolean);
  
  void xsetCustomHeight(XmlBoolean paramXmlBoolean);
  
  void unsetCustomHeight();
  
  short getOutlineLevel();
  
  XmlUnsignedByte xgetOutlineLevel();
  
  boolean isSetOutlineLevel();
  
  void setOutlineLevel(short paramShort);
  
  void xsetOutlineLevel(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetOutlineLevel();
  
  boolean getCollapsed();
  
  XmlBoolean xgetCollapsed();
  
  boolean isSetCollapsed();
  
  void setCollapsed(boolean paramBoolean);
  
  void xsetCollapsed(XmlBoolean paramXmlBoolean);
  
  void unsetCollapsed();
  
  boolean getThickTop();
  
  XmlBoolean xgetThickTop();
  
  boolean isSetThickTop();
  
  void setThickTop(boolean paramBoolean);
  
  void xsetThickTop(XmlBoolean paramXmlBoolean);
  
  void unsetThickTop();
  
  boolean getThickBot();
  
  XmlBoolean xgetThickBot();
  
  boolean isSetThickBot();
  
  void setThickBot(boolean paramBoolean);
  
  void xsetThickBot(XmlBoolean paramXmlBoolean);
  
  void unsetThickBot();
  
  boolean getPh();
  
  XmlBoolean xgetPh();
  
  boolean isSetPh();
  
  void setPh(boolean paramBoolean);
  
  void xsetPh(XmlBoolean paramXmlBoolean);
  
  void unsetPh();
  
  public static final class Factory {
    public static CTRow newInstance() {
      return (CTRow)POIXMLTypeLoader.newInstance(CTRow.type, null);
    }
    
    public static CTRow newInstance(XmlOptions param1XmlOptions) {
      return (CTRow)POIXMLTypeLoader.newInstance(CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(String param1String) throws XmlException {
      return (CTRow)POIXMLTypeLoader.parse(param1String, CTRow.type, null);
    }
    
    public static CTRow parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRow)POIXMLTypeLoader.parse(param1String, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(File param1File) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1File, CTRow.type, null);
    }
    
    public static CTRow parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1File, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(URL param1URL) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1URL, CTRow.type, null);
    }
    
    public static CTRow parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1URL, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1InputStream, CTRow.type, null);
    }
    
    public static CTRow parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1InputStream, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1Reader, CTRow.type, null);
    }
    
    public static CTRow parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRow)POIXMLTypeLoader.parse(param1Reader, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRow)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRow.type, null);
    }
    
    public static CTRow parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRow)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(Node param1Node) throws XmlException {
      return (CTRow)POIXMLTypeLoader.parse(param1Node, CTRow.type, null);
    }
    
    public static CTRow parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRow)POIXMLTypeLoader.parse(param1Node, CTRow.type, param1XmlOptions);
    }
    
    public static CTRow parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRow)POIXMLTypeLoader.parse(param1XMLInputStream, CTRow.type, null);
    }
    
    public static CTRow parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRow)POIXMLTypeLoader.parse(param1XMLInputStream, CTRow.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRow.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRow.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */