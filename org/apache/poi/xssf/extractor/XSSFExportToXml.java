/*     */ package org.apache.poi.xssf.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Vector;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import javax.xml.validation.Schema;
/*     */ import javax.xml.validation.SchemaFactory;
/*     */ import javax.xml.validation.Validator;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.DateUtil;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFMap;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFTable;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
/*     */ import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFExportToXml
/*     */   implements Comparator<String>
/*     */ {
/*  83 */   private static final POILogger LOG = POILogFactory.getLogger(XSSFExportToXml.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private XSSFMap map;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFExportToXml(XSSFMap paramXSSFMap) {
/*  93 */     this.map = paramXSSFMap;
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
/*     */   public void exportToXML(OutputStream paramOutputStream, boolean paramBoolean) throws SAXException, ParserConfigurationException, TransformerException {
/* 107 */     exportToXML(paramOutputStream, "UTF-8", paramBoolean);
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
/*     */   public void exportToXML(OutputStream paramOutputStream, String paramString, boolean paramBoolean) throws SAXException, ParserConfigurationException, TransformerException {
/*     */     Element element;
/* 121 */     List list1 = this.map.getRelatedSingleXMLCell();
/* 122 */     List list2 = this.map.getRelatedTables();
/*     */     
/* 124 */     String str = this.map.getCtMap().getRootElement();
/*     */     
/* 126 */     Document document = DocumentHelper.createDocument();
/*     */ 
/*     */ 
/*     */     
/* 130 */     if (isNamespaceDeclared()) {
/* 131 */       element = document.createElementNS(getNamespace(), str);
/*     */     } else {
/* 133 */       element = document.createElementNS("", str);
/*     */     } 
/* 135 */     document.appendChild(element);
/*     */ 
/*     */     
/* 138 */     Vector<String> vector = new Vector();
/* 139 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 140 */     HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/*     */     
/* 142 */     for (XSSFSingleXmlCell xSSFSingleXmlCell : list1) {
/* 143 */       vector.add(xSSFSingleXmlCell.getXpath());
/* 144 */       hashMap1.put(xSSFSingleXmlCell.getXpath(), xSSFSingleXmlCell);
/*     */     } 
/* 146 */     for (XSSFTable xSSFTable : list2) {
/* 147 */       String str1 = xSSFTable.getCommonXpath();
/* 148 */       vector.add(str1);
/* 149 */       hashMap2.put(str1, xSSFTable);
/*     */     } 
/*     */     
/* 152 */     Collections.sort(vector, this);
/*     */     
/* 154 */     for (String str1 : vector) {
/*     */       
/* 156 */       XSSFSingleXmlCell xSSFSingleXmlCell = (XSSFSingleXmlCell)hashMap1.get(str1);
/* 157 */       XSSFTable xSSFTable = (XSSFTable)hashMap2.get(str1);
/*     */       
/* 159 */       if (!str1.matches(".*\\[.*")) {
/*     */ 
/*     */         
/* 162 */         if (xSSFSingleXmlCell != null) {
/* 163 */           XSSFCell xSSFCell = xSSFSingleXmlCell.getReferencedCell();
/* 164 */           if (xSSFCell != null) {
/* 165 */             Node node = getNodeByXPath(str1, document.getFirstChild(), document, false);
/* 166 */             mapCellOnNode(xSSFCell, node);
/*     */ 
/*     */             
/* 169 */             if ("".equals(node.getTextContent()) && node.getParentNode() != null) {
/* 170 */               node.getParentNode().removeChild(node);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 176 */         if (xSSFTable != null) {
/*     */           
/* 178 */           List<XSSFXmlColumnPr> list = xSSFTable.getXmlColumnPrs();
/*     */           
/* 180 */           XSSFSheet xSSFSheet = xSSFTable.getXSSFSheet();
/*     */           
/* 182 */           int i = xSSFTable.getStartCellReference().getRow();
/*     */           
/* 184 */           i++;
/*     */           
/* 186 */           int j = xSSFTable.getEndCellReference().getRow();
/*     */           
/* 188 */           for (int k = i; k <= j; k++) {
/* 189 */             XSSFRow xSSFRow = xSSFSheet.getRow(k);
/*     */             
/* 191 */             Node node = getNodeByXPath(xSSFTable.getCommonXpath(), document.getFirstChild(), document, true);
/*     */             
/* 193 */             short s = xSSFTable.getStartCellReference().getCol();
/* 194 */             for (short s1 = s; s1 <= xSSFTable.getEndCellReference().getCol(); s1++) {
/* 195 */               XSSFCell xSSFCell = xSSFRow.getCell(s1);
/* 196 */               if (xSSFCell != null) {
/* 197 */                 XSSFXmlColumnPr xSSFXmlColumnPr = list.get(s1 - s);
/* 198 */                 String str2 = xSSFXmlColumnPr.getLocalXPath();
/* 199 */                 Node node1 = getNodeByXPath(str2, node, document, false);
/*     */                 
/* 201 */                 mapCellOnNode(xSSFCell, node1);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     boolean bool = true;
/* 212 */     if (paramBoolean) {
/* 213 */       bool = isValid(document);
/*     */     }
/*     */     
/* 216 */     if (bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 222 */       TransformerFactory transformerFactory = TransformerFactory.newInstance();
/* 223 */       Transformer transformer = transformerFactory.newTransformer();
/* 224 */       transformer.setOutputProperty("omit-xml-declaration", "yes");
/* 225 */       transformer.setOutputProperty("indent", "yes");
/* 226 */       transformer.setOutputProperty("encoding", paramString);
/*     */ 
/*     */ 
/*     */       
/* 230 */       StreamResult streamResult = new StreamResult(paramOutputStream);
/* 231 */       DOMSource dOMSource = new DOMSource(document);
/* 232 */       transformer.transform(dOMSource, streamResult);
/*     */     } 
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
/*     */   private boolean isValid(Document paramDocument) throws SAXException {
/*     */     try {
/* 246 */       String str = "http://www.w3.org/2001/XMLSchema";
/* 247 */       SchemaFactory schemaFactory = SchemaFactory.newInstance(str);
/*     */       
/* 249 */       DOMSource dOMSource = new DOMSource(this.map.getSchema());
/* 250 */       Schema schema = schemaFactory.newSchema(dOMSource);
/* 251 */       Validator validator = schema.newValidator();
/* 252 */       validator.validate(new DOMSource(paramDocument));
/*     */ 
/*     */       
/* 255 */       return true;
/* 256 */     } catch (IOException iOException) {
/* 257 */       LOG.log(7, new Object[] { "document is not valid", iOException });
/*     */ 
/*     */       
/* 260 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void mapCellOnNode(XSSFCell paramXSSFCell, Node paramNode) {
/* 266 */     String str = "";
/* 267 */     switch (paramXSSFCell.getCellTypeEnum()) {
/*     */       case STRING:
/* 269 */         str = paramXSSFCell.getStringCellValue(); break;
/* 270 */       case BOOLEAN: str = str + paramXSSFCell.getBooleanCellValue(); break;
/* 271 */       case ERROR: str = paramXSSFCell.getErrorCellString(); break;
/*     */       case FORMULA:
/* 273 */         if (paramXSSFCell.getCachedFormulaResultTypeEnum() == CellType.STRING) {
/* 274 */           str = paramXSSFCell.getStringCellValue(); break;
/*     */         } 
/* 276 */         if (DateUtil.isCellDateFormatted((Cell)paramXSSFCell)) {
/* 277 */           str = getFormattedDate(paramXSSFCell); break;
/*     */         } 
/* 279 */         str = str + paramXSSFCell.getNumericCellValue();
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case NUMERIC:
/* 285 */         if (DateUtil.isCellDateFormatted((Cell)paramXSSFCell)) {
/* 286 */           str = getFormattedDate(paramXSSFCell); break;
/*     */         } 
/* 288 */         str = str + paramXSSFCell.getRawValue();
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     if (paramNode instanceof Element) {
/* 296 */       Element element = (Element)paramNode;
/* 297 */       element.setTextContent(str);
/*     */     } else {
/* 299 */       paramNode.setNodeValue(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String removeNamespace(String paramString) {
/* 304 */     return paramString.matches(".*:.*") ? paramString.split(":")[1] : paramString;
/*     */   }
/*     */   
/*     */   private String getFormattedDate(XSSFCell paramXSSFCell) {
/* 308 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
/* 309 */     simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
/* 310 */     return simpleDateFormat.format(paramXSSFCell.getDateCellValue());
/*     */   }
/*     */   
/*     */   private Node getNodeByXPath(String paramString, Node paramNode, Document paramDocument, boolean paramBoolean) {
/* 314 */     String[] arrayOfString = paramString.split("/");
/*     */ 
/*     */     
/* 317 */     Node node = paramNode;
/*     */     
/* 319 */     for (byte b = 2; b < arrayOfString.length; b++) {
/*     */       
/* 321 */       String str = removeNamespace(arrayOfString[b]);
/*     */ 
/*     */       
/* 324 */       if (!str.startsWith("@")) {
/*     */         
/* 326 */         NodeList nodeList = node.getChildNodes();
/*     */         
/* 328 */         Node node1 = null;
/* 329 */         if (!paramBoolean || b != arrayOfString.length - 1)
/*     */         {
/* 331 */           node1 = selectNode(str, nodeList);
/*     */         }
/* 333 */         if (node1 == null) {
/* 334 */           node1 = createElement(paramDocument, node, str);
/*     */         }
/* 336 */         node = node1;
/*     */       } else {
/* 338 */         node = createAttribute(paramDocument, node, str);
/*     */       } 
/*     */     } 
/* 341 */     return node;
/*     */   }
/*     */   
/*     */   private Node createAttribute(Document paramDocument, Node paramNode, String paramString) {
/* 345 */     String str = paramString.substring(1);
/* 346 */     NamedNodeMap namedNodeMap = paramNode.getAttributes();
/* 347 */     Node node = namedNodeMap.getNamedItem(str);
/* 348 */     if (node == null) {
/* 349 */       node = paramDocument.createAttributeNS("", str);
/* 350 */       namedNodeMap.setNamedItem(node);
/*     */     } 
/* 352 */     return node;
/*     */   }
/*     */   
/*     */   private Node createElement(Document paramDocument, Node paramNode, String paramString) {
/*     */     Element element;
/* 357 */     if (isNamespaceDeclared()) {
/* 358 */       element = paramDocument.createElementNS(getNamespace(), paramString);
/*     */     } else {
/* 360 */       element = paramDocument.createElementNS("", paramString);
/*     */     } 
/* 362 */     paramNode.appendChild(element);
/* 363 */     return element;
/*     */   }
/*     */   
/*     */   private Node selectNode(String paramString, NodeList paramNodeList) {
/* 367 */     Node node = null;
/* 368 */     for (byte b = 0; b < paramNodeList.getLength(); b++) {
/* 369 */       Node node1 = paramNodeList.item(b);
/* 370 */       if (node1.getNodeName().equals(paramString)) {
/* 371 */         node = node1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 375 */     return node;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNamespaceDeclared() {
/* 380 */     String str = getNamespace();
/* 381 */     return (str != null && !str.equals(""));
/*     */   }
/*     */   
/*     */   private String getNamespace() {
/* 385 */     return this.map.getCTSchema().getNamespace();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compare(String paramString1, String paramString2) {
/* 395 */     Node node1 = this.map.getSchema();
/*     */     
/* 397 */     String[] arrayOfString1 = paramString1.split("/");
/* 398 */     String[] arrayOfString2 = paramString2.split("/");
/*     */     
/* 400 */     int i = (arrayOfString1.length < arrayOfString2.length) ? arrayOfString1.length : arrayOfString2.length;
/*     */     
/* 402 */     Node node2 = node1;
/*     */     
/* 404 */     for (byte b = 1; b < i; b++) {
/*     */       
/* 406 */       String str1 = arrayOfString1[b];
/* 407 */       String str2 = arrayOfString2[b];
/*     */       
/* 409 */       if (str1.equals(str2)) {
/* 410 */         node2 = getComplexTypeForElement(str1, node1, node2);
/*     */       } else {
/* 412 */         int j = indexOfElementInComplexType(str1, node2);
/* 413 */         int k = indexOfElementInComplexType(str2, node2);
/* 414 */         if (j != -1 && k != -1) {
/* 415 */           if (j < k)
/* 416 */             return -1; 
/* 417 */           if (j > k) {
/* 418 */             return 1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 426 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private int indexOfElementInComplexType(String paramString, Node paramNode) {
/* 431 */     NodeList nodeList = paramNode.getChildNodes();
/* 432 */     byte b = -1;
/*     */     
/* 434 */     for (byte b1 = 0; b1 < nodeList.getLength(); b1++) {
/* 435 */       Node node = nodeList.item(b1);
/* 436 */       if (node instanceof Element && 
/* 437 */         node.getLocalName().equals("element")) {
/* 438 */         Node node1 = getNameOrRefElement(node);
/* 439 */         if (node1.getNodeValue().equals(removeNamespace(paramString))) {
/* 440 */           b = b1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 447 */     return b;
/*     */   }
/*     */   
/*     */   private Node getNameOrRefElement(Node paramNode) {
/* 451 */     Node node = paramNode.getAttributes().getNamedItem("name");
/* 452 */     if (node != null) {
/* 453 */       return node;
/*     */     }
/*     */     
/* 456 */     return paramNode.getAttributes().getNamedItem("ref");
/*     */   }
/*     */   
/*     */   private Node getComplexTypeForElement(String paramString, Node paramNode1, Node paramNode2) {
/* 460 */     String str1 = removeNamespace(paramString);
/*     */     
/* 462 */     String str2 = getComplexTypeNameFromChildren(paramNode2, str1);
/*     */ 
/*     */     
/* 465 */     Node node = null;
/* 466 */     if (!"".equals(str2)) {
/* 467 */       node = getComplexTypeNodeFromSchemaChildren(paramNode1, null, str2);
/*     */     }
/*     */     
/* 470 */     return node;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getComplexTypeNameFromChildren(Node paramNode, String paramString) {
/* 475 */     NodeList nodeList = paramNode.getChildNodes();
/* 476 */     String str = "";
/*     */     
/* 478 */     for (byte b = 0; b < nodeList.getLength(); b++) {
/* 479 */       Node node = nodeList.item(b);
/* 480 */       if (node instanceof Element && 
/* 481 */         node.getLocalName().equals("element")) {
/* 482 */         Node node1 = getNameOrRefElement(node);
/* 483 */         if (node1.getNodeValue().equals(paramString)) {
/* 484 */           Node node2 = node.getAttributes().getNamedItem("type");
/* 485 */           if (node2 != null) {
/* 486 */             str = node2.getNodeValue();
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 493 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private Node getComplexTypeNodeFromSchemaChildren(Node paramNode1, Node paramNode2, String paramString) {
/* 498 */     NodeList nodeList = paramNode1.getChildNodes();
/* 499 */     for (byte b = 0; b < nodeList.getLength(); b++) {
/* 500 */       Node node = nodeList.item(b);
/* 501 */       if (node instanceof Element && 
/* 502 */         node.getLocalName().equals("complexType")) {
/* 503 */         Node node1 = getNameOrRefElement(node);
/* 504 */         if (node1.getNodeValue().equals(paramString)) {
/*     */           
/* 506 */           NodeList nodeList1 = node.getChildNodes();
/* 507 */           for (byte b1 = 0; b1 < nodeList1.getLength(); b1++) {
/* 508 */             Node node2 = nodeList1.item(b1);
/*     */             
/* 510 */             if (node2 instanceof Element && (
/* 511 */               node2.getLocalName().equals("sequence") || node2.getLocalName().equals("all"))) {
/* 512 */               paramNode2 = node2;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 517 */           if (paramNode2 != null) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 525 */     return paramNode2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\extractor\XSSFExportToXml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */