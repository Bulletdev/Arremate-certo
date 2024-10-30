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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSheetProtection extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetprotection22f7type");
  
  byte[] getPassword();
  
  STUnsignedShortHex xgetPassword();
  
  boolean isSetPassword();
  
  void setPassword(byte[] paramArrayOfbyte);
  
  void xsetPassword(STUnsignedShortHex paramSTUnsignedShortHex);
  
  void unsetPassword();
  
  boolean getSheet();
  
  XmlBoolean xgetSheet();
  
  boolean isSetSheet();
  
  void setSheet(boolean paramBoolean);
  
  void xsetSheet(XmlBoolean paramXmlBoolean);
  
  void unsetSheet();
  
  boolean getObjects();
  
  XmlBoolean xgetObjects();
  
  boolean isSetObjects();
  
  void setObjects(boolean paramBoolean);
  
  void xsetObjects(XmlBoolean paramXmlBoolean);
  
  void unsetObjects();
  
  boolean getScenarios();
  
  XmlBoolean xgetScenarios();
  
  boolean isSetScenarios();
  
  void setScenarios(boolean paramBoolean);
  
  void xsetScenarios(XmlBoolean paramXmlBoolean);
  
  void unsetScenarios();
  
  boolean getFormatCells();
  
  XmlBoolean xgetFormatCells();
  
  boolean isSetFormatCells();
  
  void setFormatCells(boolean paramBoolean);
  
  void xsetFormatCells(XmlBoolean paramXmlBoolean);
  
  void unsetFormatCells();
  
  boolean getFormatColumns();
  
  XmlBoolean xgetFormatColumns();
  
  boolean isSetFormatColumns();
  
  void setFormatColumns(boolean paramBoolean);
  
  void xsetFormatColumns(XmlBoolean paramXmlBoolean);
  
  void unsetFormatColumns();
  
  boolean getFormatRows();
  
  XmlBoolean xgetFormatRows();
  
  boolean isSetFormatRows();
  
  void setFormatRows(boolean paramBoolean);
  
  void xsetFormatRows(XmlBoolean paramXmlBoolean);
  
  void unsetFormatRows();
  
  boolean getInsertColumns();
  
  XmlBoolean xgetInsertColumns();
  
  boolean isSetInsertColumns();
  
  void setInsertColumns(boolean paramBoolean);
  
  void xsetInsertColumns(XmlBoolean paramXmlBoolean);
  
  void unsetInsertColumns();
  
  boolean getInsertRows();
  
  XmlBoolean xgetInsertRows();
  
  boolean isSetInsertRows();
  
  void setInsertRows(boolean paramBoolean);
  
  void xsetInsertRows(XmlBoolean paramXmlBoolean);
  
  void unsetInsertRows();
  
  boolean getInsertHyperlinks();
  
  XmlBoolean xgetInsertHyperlinks();
  
  boolean isSetInsertHyperlinks();
  
  void setInsertHyperlinks(boolean paramBoolean);
  
  void xsetInsertHyperlinks(XmlBoolean paramXmlBoolean);
  
  void unsetInsertHyperlinks();
  
  boolean getDeleteColumns();
  
  XmlBoolean xgetDeleteColumns();
  
  boolean isSetDeleteColumns();
  
  void setDeleteColumns(boolean paramBoolean);
  
  void xsetDeleteColumns(XmlBoolean paramXmlBoolean);
  
  void unsetDeleteColumns();
  
  boolean getDeleteRows();
  
  XmlBoolean xgetDeleteRows();
  
  boolean isSetDeleteRows();
  
  void setDeleteRows(boolean paramBoolean);
  
  void xsetDeleteRows(XmlBoolean paramXmlBoolean);
  
  void unsetDeleteRows();
  
  boolean getSelectLockedCells();
  
  XmlBoolean xgetSelectLockedCells();
  
  boolean isSetSelectLockedCells();
  
  void setSelectLockedCells(boolean paramBoolean);
  
  void xsetSelectLockedCells(XmlBoolean paramXmlBoolean);
  
  void unsetSelectLockedCells();
  
  boolean getSort();
  
  XmlBoolean xgetSort();
  
  boolean isSetSort();
  
  void setSort(boolean paramBoolean);
  
  void xsetSort(XmlBoolean paramXmlBoolean);
  
  void unsetSort();
  
  boolean getAutoFilter();
  
  XmlBoolean xgetAutoFilter();
  
  boolean isSetAutoFilter();
  
  void setAutoFilter(boolean paramBoolean);
  
  void xsetAutoFilter(XmlBoolean paramXmlBoolean);
  
  void unsetAutoFilter();
  
  boolean getPivotTables();
  
  XmlBoolean xgetPivotTables();
  
  boolean isSetPivotTables();
  
  void setPivotTables(boolean paramBoolean);
  
  void xsetPivotTables(XmlBoolean paramXmlBoolean);
  
  void unsetPivotTables();
  
  boolean getSelectUnlockedCells();
  
  XmlBoolean xgetSelectUnlockedCells();
  
  boolean isSetSelectUnlockedCells();
  
  void setSelectUnlockedCells(boolean paramBoolean);
  
  void xsetSelectUnlockedCells(XmlBoolean paramXmlBoolean);
  
  void unsetSelectUnlockedCells();
  
  public static final class Factory {
    public static CTSheetProtection newInstance() {
      return (CTSheetProtection)POIXMLTypeLoader.newInstance(CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetProtection)POIXMLTypeLoader.newInstance(CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(String param1String) throws XmlException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1String, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1String, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(File param1File) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1File, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1File, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1URL, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1URL, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1InputStream, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1InputStream, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1Reader, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1Reader, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(Node param1Node) throws XmlException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1Node, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1Node, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static CTSheetProtection parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetProtection.type, null);
    }
    
    public static CTSheetProtection parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetProtection)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetProtection.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetProtection.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetProtection.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */