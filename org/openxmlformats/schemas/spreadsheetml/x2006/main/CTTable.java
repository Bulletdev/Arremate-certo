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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTable extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTable.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttable736dtype");
  
  CTAutoFilter getAutoFilter();
  
  boolean isSetAutoFilter();
  
  void setAutoFilter(CTAutoFilter paramCTAutoFilter);
  
  CTAutoFilter addNewAutoFilter();
  
  void unsetAutoFilter();
  
  CTSortState getSortState();
  
  boolean isSetSortState();
  
  void setSortState(CTSortState paramCTSortState);
  
  CTSortState addNewSortState();
  
  void unsetSortState();
  
  CTTableColumns getTableColumns();
  
  void setTableColumns(CTTableColumns paramCTTableColumns);
  
  CTTableColumns addNewTableColumns();
  
  CTTableStyleInfo getTableStyleInfo();
  
  boolean isSetTableStyleInfo();
  
  void setTableStyleInfo(CTTableStyleInfo paramCTTableStyleInfo);
  
  CTTableStyleInfo addNewTableStyleInfo();
  
  void unsetTableStyleInfo();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  XmlUnsignedInt xgetId();
  
  void setId(long paramLong);
  
  void xsetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getName();
  
  STXstring xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  void unsetName();
  
  String getDisplayName();
  
  STXstring xgetDisplayName();
  
  void setDisplayName(String paramString);
  
  void xsetDisplayName(STXstring paramSTXstring);
  
  String getComment();
  
  STXstring xgetComment();
  
  boolean isSetComment();
  
  void setComment(String paramString);
  
  void xsetComment(STXstring paramSTXstring);
  
  void unsetComment();
  
  String getRef();
  
  STRef xgetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  STTableType$Enum getTableType();
  
  STTableType xgetTableType();
  
  boolean isSetTableType();
  
  void setTableType(STTableType$Enum paramSTTableType$Enum);
  
  void xsetTableType(STTableType paramSTTableType);
  
  void unsetTableType();
  
  long getHeaderRowCount();
  
  XmlUnsignedInt xgetHeaderRowCount();
  
  boolean isSetHeaderRowCount();
  
  void setHeaderRowCount(long paramLong);
  
  void xsetHeaderRowCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetHeaderRowCount();
  
  boolean getInsertRow();
  
  XmlBoolean xgetInsertRow();
  
  boolean isSetInsertRow();
  
  void setInsertRow(boolean paramBoolean);
  
  void xsetInsertRow(XmlBoolean paramXmlBoolean);
  
  void unsetInsertRow();
  
  boolean getInsertRowShift();
  
  XmlBoolean xgetInsertRowShift();
  
  boolean isSetInsertRowShift();
  
  void setInsertRowShift(boolean paramBoolean);
  
  void xsetInsertRowShift(XmlBoolean paramXmlBoolean);
  
  void unsetInsertRowShift();
  
  long getTotalsRowCount();
  
  XmlUnsignedInt xgetTotalsRowCount();
  
  boolean isSetTotalsRowCount();
  
  void setTotalsRowCount(long paramLong);
  
  void xsetTotalsRowCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetTotalsRowCount();
  
  boolean getTotalsRowShown();
  
  XmlBoolean xgetTotalsRowShown();
  
  boolean isSetTotalsRowShown();
  
  void setTotalsRowShown(boolean paramBoolean);
  
  void xsetTotalsRowShown(XmlBoolean paramXmlBoolean);
  
  void unsetTotalsRowShown();
  
  boolean getPublished();
  
  XmlBoolean xgetPublished();
  
  boolean isSetPublished();
  
  void setPublished(boolean paramBoolean);
  
  void xsetPublished(XmlBoolean paramXmlBoolean);
  
  void unsetPublished();
  
  long getHeaderRowDxfId();
  
  STDxfId xgetHeaderRowDxfId();
  
  boolean isSetHeaderRowDxfId();
  
  void setHeaderRowDxfId(long paramLong);
  
  void xsetHeaderRowDxfId(STDxfId paramSTDxfId);
  
  void unsetHeaderRowDxfId();
  
  long getDataDxfId();
  
  STDxfId xgetDataDxfId();
  
  boolean isSetDataDxfId();
  
  void setDataDxfId(long paramLong);
  
  void xsetDataDxfId(STDxfId paramSTDxfId);
  
  void unsetDataDxfId();
  
  long getTotalsRowDxfId();
  
  STDxfId xgetTotalsRowDxfId();
  
  boolean isSetTotalsRowDxfId();
  
  void setTotalsRowDxfId(long paramLong);
  
  void xsetTotalsRowDxfId(STDxfId paramSTDxfId);
  
  void unsetTotalsRowDxfId();
  
  long getHeaderRowBorderDxfId();
  
  STDxfId xgetHeaderRowBorderDxfId();
  
  boolean isSetHeaderRowBorderDxfId();
  
  void setHeaderRowBorderDxfId(long paramLong);
  
  void xsetHeaderRowBorderDxfId(STDxfId paramSTDxfId);
  
  void unsetHeaderRowBorderDxfId();
  
  long getTableBorderDxfId();
  
  STDxfId xgetTableBorderDxfId();
  
  boolean isSetTableBorderDxfId();
  
  void setTableBorderDxfId(long paramLong);
  
  void xsetTableBorderDxfId(STDxfId paramSTDxfId);
  
  void unsetTableBorderDxfId();
  
  long getTotalsRowBorderDxfId();
  
  STDxfId xgetTotalsRowBorderDxfId();
  
  boolean isSetTotalsRowBorderDxfId();
  
  void setTotalsRowBorderDxfId(long paramLong);
  
  void xsetTotalsRowBorderDxfId(STDxfId paramSTDxfId);
  
  void unsetTotalsRowBorderDxfId();
  
  String getHeaderRowCellStyle();
  
  STXstring xgetHeaderRowCellStyle();
  
  boolean isSetHeaderRowCellStyle();
  
  void setHeaderRowCellStyle(String paramString);
  
  void xsetHeaderRowCellStyle(STXstring paramSTXstring);
  
  void unsetHeaderRowCellStyle();
  
  String getDataCellStyle();
  
  STXstring xgetDataCellStyle();
  
  boolean isSetDataCellStyle();
  
  void setDataCellStyle(String paramString);
  
  void xsetDataCellStyle(STXstring paramSTXstring);
  
  void unsetDataCellStyle();
  
  String getTotalsRowCellStyle();
  
  STXstring xgetTotalsRowCellStyle();
  
  boolean isSetTotalsRowCellStyle();
  
  void setTotalsRowCellStyle(String paramString);
  
  void xsetTotalsRowCellStyle(STXstring paramSTXstring);
  
  void unsetTotalsRowCellStyle();
  
  long getConnectionId();
  
  XmlUnsignedInt xgetConnectionId();
  
  boolean isSetConnectionId();
  
  void setConnectionId(long paramLong);
  
  void xsetConnectionId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetConnectionId();
  
  public static final class Factory {
    public static CTTable newInstance() {
      return (CTTable)POIXMLTypeLoader.newInstance(CTTable.type, null);
    }
    
    public static CTTable newInstance(XmlOptions param1XmlOptions) {
      return (CTTable)POIXMLTypeLoader.newInstance(CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(String param1String) throws XmlException {
      return (CTTable)POIXMLTypeLoader.parse(param1String, CTTable.type, null);
    }
    
    public static CTTable parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTable)POIXMLTypeLoader.parse(param1String, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(File param1File) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1File, CTTable.type, null);
    }
    
    public static CTTable parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1File, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(URL param1URL) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1URL, CTTable.type, null);
    }
    
    public static CTTable parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1URL, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1InputStream, CTTable.type, null);
    }
    
    public static CTTable parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1InputStream, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1Reader, CTTable.type, null);
    }
    
    public static CTTable parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTable)POIXMLTypeLoader.parse(param1Reader, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTable)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTable.type, null);
    }
    
    public static CTTable parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTable)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(Node param1Node) throws XmlException {
      return (CTTable)POIXMLTypeLoader.parse(param1Node, CTTable.type, null);
    }
    
    public static CTTable parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTable)POIXMLTypeLoader.parse(param1Node, CTTable.type, param1XmlOptions);
    }
    
    public static CTTable parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTable)POIXMLTypeLoader.parse(param1XMLInputStream, CTTable.type, null);
    }
    
    public static CTTable parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTable)POIXMLTypeLoader.parse(param1XMLInputStream, CTTable.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTable.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTable.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */