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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTableCell extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecell3ac1type");
  
  CTTextBody getTxBody();
  
  boolean isSetTxBody();
  
  void setTxBody(CTTextBody paramCTTextBody);
  
  CTTextBody addNewTxBody();
  
  void unsetTxBody();
  
  CTTableCellProperties getTcPr();
  
  boolean isSetTcPr();
  
  void setTcPr(CTTableCellProperties paramCTTableCellProperties);
  
  CTTableCellProperties addNewTcPr();
  
  void unsetTcPr();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  int getRowSpan();
  
  XmlInt xgetRowSpan();
  
  boolean isSetRowSpan();
  
  void setRowSpan(int paramInt);
  
  void xsetRowSpan(XmlInt paramXmlInt);
  
  void unsetRowSpan();
  
  int getGridSpan();
  
  XmlInt xgetGridSpan();
  
  boolean isSetGridSpan();
  
  void setGridSpan(int paramInt);
  
  void xsetGridSpan(XmlInt paramXmlInt);
  
  void unsetGridSpan();
  
  boolean getHMerge();
  
  XmlBoolean xgetHMerge();
  
  boolean isSetHMerge();
  
  void setHMerge(boolean paramBoolean);
  
  void xsetHMerge(XmlBoolean paramXmlBoolean);
  
  void unsetHMerge();
  
  boolean getVMerge();
  
  XmlBoolean xgetVMerge();
  
  boolean isSetVMerge();
  
  void setVMerge(boolean paramBoolean);
  
  void xsetVMerge(XmlBoolean paramXmlBoolean);
  
  void unsetVMerge();
  
  public static final class Factory {
    public static CTTableCell newInstance() {
      return (CTTableCell)POIXMLTypeLoader.newInstance(CTTableCell.type, null);
    }
    
    public static CTTableCell newInstance(XmlOptions param1XmlOptions) {
      return (CTTableCell)POIXMLTypeLoader.newInstance(CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(String param1String) throws XmlException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1String, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1String, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(File param1File) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1File, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1File, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(URL param1URL) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1URL, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1URL, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1InputStream, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1InputStream, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1Reader, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1Reader, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(Node param1Node) throws XmlException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1Node, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1Node, CTTableCell.type, param1XmlOptions);
    }
    
    public static CTTableCell parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableCell.type, null);
    }
    
    public static CTTableCell parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableCell.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableCell.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableCell.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */