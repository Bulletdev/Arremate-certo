/*     */ package org.apache.poi.xssf.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.a;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.xpath.XPath;
/*     */ import javax.xml.xpath.XPathConstants;
/*     */ import javax.xml.xpath.XPathExpressionException;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import org.apache.poi.ss.usermodel.DateUtil;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFMap;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFTable;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFImportFromXML
/*     */ {
/*     */   private final XSSFMap _map;
/*  74 */   private static POILogger logger = POILogFactory.getLogger(XSSFImportFromXML.class);
/*     */   
/*     */   public XSSFImportFromXML(XSSFMap paramXSSFMap) {
/*  77 */     this._map = paramXSSFMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importFromXML(String paramString) throws SAXException, XPathExpressionException, IOException {
/*  91 */     DocumentBuilder documentBuilder = DocumentHelper.newDocumentBuilder();
/*     */     
/*  93 */     Document document = documentBuilder.parse(new InputSource(new StringReader(paramString.trim())));
/*     */     
/*  95 */     List list1 = this._map.getRelatedSingleXMLCell();
/*     */     
/*  97 */     List list2 = this._map.getRelatedTables();
/*     */     
/*  99 */     XPathFactory xPathFactory = XPathFactory.newInstance();
/* 100 */     XPath xPath = xPathFactory.newXPath();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     xPath.setNamespaceContext(new DefaultNamespaceContext(document));
/*     */     
/* 107 */     for (XSSFSingleXmlCell xSSFSingleXmlCell : list1) {
/*     */       
/* 109 */       STXmlDataType.Enum enum_ = xSSFSingleXmlCell.getXmlDataType();
/* 110 */       String str = xSSFSingleXmlCell.getXpath();
/* 111 */       Node node = (Node)xPath.evaluate(str, document, (b)XPathConstants.NODE);
/*     */       
/* 113 */       if (node != null) {
/* 114 */         String str1 = node.getTextContent();
/* 115 */         logger.log(1, new Object[] { "Extracting with xpath " + str + " : value is '" + str1 + "'" });
/* 116 */         XSSFCell xSSFCell = xSSFSingleXmlCell.getReferencedCell();
/* 117 */         logger.log(1, new Object[] { "Setting '" + str1 + "' to cell " + xSSFCell.getColumnIndex() + "-" + xSSFCell.getRowIndex() + " in sheet " + xSSFCell.getSheet().getSheetName() });
/*     */         
/* 119 */         setCellValue(str1, xSSFCell, enum_);
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     for (XSSFTable xSSFTable : list2) {
/*     */       
/* 125 */       String str = xSSFTable.getCommonXpath();
/* 126 */       NodeList nodeList = (NodeList)xPath.evaluate(str, document, (b)XPathConstants.NODESET);
/* 127 */       int i = xSSFTable.getStartCellReference().getRow() + 1;
/* 128 */       int j = xSSFTable.getStartCellReference().getCol() - 1;
/*     */       
/* 130 */       for (byte b = 0; b < nodeList.getLength(); b++) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 135 */         for (XSSFXmlColumnPr xSSFXmlColumnPr : xSSFTable.getXmlColumnPrs()) {
/*     */           
/* 137 */           int k = (int)xSSFXmlColumnPr.getId();
/* 138 */           int m = i + b;
/* 139 */           int n = j + k;
/* 140 */           String str1 = xSSFXmlColumnPr.getLocalXPath();
/* 141 */           str1 = str1.substring(str1.substring(1).indexOf('/') + 1);
/*     */ 
/*     */ 
/*     */           
/* 145 */           String str2 = str + "[" + (b + 1) + "]" + str1;
/*     */ 
/*     */           
/* 148 */           String str3 = (String)xPath.evaluate(str2, nodeList.item(b), (b)XPathConstants.STRING);
/* 149 */           logger.log(1, new Object[] { "Extracting with xpath " + str2 + " : value is '" + str3 + "'" });
/* 150 */           XSSFRow xSSFRow = xSSFTable.getXSSFSheet().getRow(m);
/* 151 */           if (xSSFRow == null) {
/* 152 */             xSSFRow = xSSFTable.getXSSFSheet().createRow(m);
/*     */           }
/*     */           
/* 155 */           XSSFCell xSSFCell = xSSFRow.getCell(n);
/* 156 */           if (xSSFCell == null) {
/* 157 */             xSSFCell = xSSFRow.createCell(n);
/*     */           }
/* 159 */           logger.log(1, new Object[] { "Setting '" + str3 + "' to cell " + xSSFCell.getColumnIndex() + "-" + xSSFCell.getRowIndex() + " in sheet " + xSSFTable.getXSSFSheet().getSheetName() });
/*     */           
/* 161 */           setCellValue(str3, xSSFCell, xSSFXmlColumnPr.getXmlDataType());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private enum DataType {
/* 168 */     BOOLEAN((String)new STXmlDataType.Enum[] { STXmlDataType.BOOLEAN }),
/* 169 */     DOUBLE((String)new STXmlDataType.Enum[] { STXmlDataType.DOUBLE }),
/* 170 */     INTEGER((String)new STXmlDataType.Enum[] { STXmlDataType.INT, STXmlDataType.UNSIGNED_INT, STXmlDataType.INTEGER }),
/* 171 */     STRING((String)new STXmlDataType.Enum[] { STXmlDataType.STRING }),
/* 172 */     DATE((String)new STXmlDataType.Enum[] { STXmlDataType.DATE });
/*     */     
/*     */     private Set<STXmlDataType.Enum> xmlDataTypes;
/*     */     
/*     */     DataType(STXmlDataType.Enum... param1VarArgs) {
/* 177 */       this.xmlDataTypes = new HashSet<STXmlDataType.Enum>(Arrays.asList(param1VarArgs));
/*     */     }
/*     */     
/*     */     public static DataType getDataType(STXmlDataType.Enum param1Enum) {
/* 181 */       for (DataType dataType : values()) {
/* 182 */         if (dataType.xmlDataTypes.contains(param1Enum)) {
/* 183 */           return dataType;
/*     */         }
/*     */       } 
/* 186 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   private void setCellValue(String paramString, XSSFCell paramXSSFCell, STXmlDataType.Enum paramEnum) {
/* 191 */     DataType dataType = DataType.getDataType(paramEnum);
/*     */     try {
/* 193 */       if (paramString.isEmpty() || dataType == null) {
/* 194 */         paramXSSFCell.setCellValue((String)null);
/*     */       } else {
/* 196 */         SimpleDateFormat simpleDateFormat; Date date; switch (dataType) {
/*     */           case BOOLEAN:
/* 198 */             paramXSSFCell.setCellValue(Boolean.parseBoolean(paramString));
/*     */             return;
/*     */           case DOUBLE:
/* 201 */             paramXSSFCell.setCellValue(Double.parseDouble(paramString));
/*     */             return;
/*     */           case INTEGER:
/* 204 */             paramXSSFCell.setCellValue(Integer.parseInt(paramString));
/*     */             return;
/*     */           case DATE:
/* 207 */             simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", LocaleUtil.getUserLocale());
/* 208 */             date = simpleDateFormat.parse(paramString);
/* 209 */             paramXSSFCell.setCellValue(date);
/* 210 */             if (!DateUtil.isValidExcelDate(paramXSSFCell.getNumericCellValue())) {
/* 211 */               paramXSSFCell.setCellValue(paramString);
/*     */             }
/*     */             return;
/*     */         } 
/*     */         
/* 216 */         paramXSSFCell.setCellValue(paramString.trim());
/*     */       }
/*     */     
/*     */     }
/* 220 */     catch (IllegalArgumentException illegalArgumentException) {
/* 221 */       throw new IllegalArgumentException(String.format(LocaleUtil.getUserLocale(), "Unable to format value '%s' as %s for cell %s", new Object[] { paramString, dataType, (new CellReference(paramXSSFCell)).formatAsString() }));
/*     */     }
/* 223 */     catch (ParseException parseException) {
/* 224 */       throw new IllegalArgumentException(String.format(LocaleUtil.getUserLocale(), "Unable to format value '%s' as %s for cell %s", new Object[] { paramString, dataType, (new CellReference(paramXSSFCell)).formatAsString() }));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class DefaultNamespaceContext
/*     */     implements a
/*     */   {
/*     */     private final Element _docElem;
/*     */ 
/*     */     
/*     */     public DefaultNamespaceContext(Document param1Document) {
/* 237 */       this._docElem = param1Document.getDocumentElement();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getNamespaceURI(String param1String) {
/* 242 */       return getNamespaceForPrefix(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String getNamespaceForPrefix(String param1String) {
/* 254 */       if (param1String.equals("xml")) {
/* 255 */         return "http://www.w3.org/XML/1998/namespace";
/*     */       }
/*     */       
/* 258 */       Element element = this._docElem;
/*     */       
/* 260 */       while (element != null) {
/*     */         
/* 262 */         short s = element.getNodeType();
/* 263 */         if (s == 1) {
/* 264 */           if (element.getNodeName().startsWith(param1String + ":")) {
/* 265 */             return element.getNamespaceURI();
/*     */           }
/* 267 */           NamedNodeMap namedNodeMap = element.getAttributes();
/*     */           
/* 269 */           for (byte b = 0; b < namedNodeMap.getLength(); b++) {
/* 270 */             Node node1 = namedNodeMap.item(b);
/* 271 */             String str = node1.getNodeName();
/* 272 */             boolean bool = str.startsWith("xmlns:");
/*     */             
/* 274 */             if (bool || str.equals("xmlns")) {
/* 275 */               int i = str.indexOf(':');
/* 276 */               String str1 = bool ? str.substring(i + 1) : "";
/*     */               
/* 278 */               if (str1.equals(param1String))
/* 279 */                 return node1.getNodeValue(); 
/*     */             } 
/*     */           } 
/*     */         } else {
/* 283 */           if (s == 5) {
/*     */             continue;
/*     */           }
/*     */           break;
/*     */         } 
/* 288 */         Node node = element.getParentNode();
/*     */       } 
/*     */       
/* 291 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<?> getPrefixes(String param1String) {
/* 297 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPrefix(String param1String) {
/* 303 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\extractor\XSSFImportFromXML.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */