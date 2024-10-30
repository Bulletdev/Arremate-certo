/*     */ package org.apache.poi.xssf.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.apache.poi.POIXMLProperties;
/*     */ import org.apache.poi.POIXMLTextExtractor;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.ss.extractor.ExcelExtractor;
/*     */ import org.apache.poi.ss.usermodel.DataFormatter;
/*     */ import org.apache.poi.util.SAXHelper;
/*     */ import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
/*     */ import org.apache.poi.xssf.eventusermodel.XSSFReader;
/*     */ import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
/*     */ import org.apache.poi.xssf.model.CommentsTable;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.usermodel.XSSFComment;
/*     */ import org.apache.poi.xssf.usermodel.XSSFShape;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.xml.sax.ContentHandler;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.XMLReader;
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
/*     */ public class XSSFEventBasedExcelExtractor
/*     */   extends POIXMLTextExtractor
/*     */   implements ExcelExtractor
/*     */ {
/*     */   private OPCPackage container;
/*     */   private POIXMLProperties properties;
/*     */   private Locale locale;
/*     */   private boolean includeTextBoxes = true;
/*     */   private boolean includeSheetNames = true;
/*     */   private boolean includeCellComments = false;
/*     */   private boolean includeHeadersFooters = true;
/*     */   private boolean formulasNotResults = false;
/*     */   
/*     */   public XSSFEventBasedExcelExtractor(String paramString) throws XmlException, OpenXML4JException, IOException {
/*  69 */     this(OPCPackage.open(paramString));
/*     */   }
/*     */   public XSSFEventBasedExcelExtractor(OPCPackage paramOPCPackage) throws XmlException, OpenXML4JException, IOException {
/*  72 */     super(null);
/*  73 */     this.container = paramOPCPackage;
/*     */     
/*  75 */     this.properties = new POIXMLProperties(paramOPCPackage);
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  79 */     if (paramArrayOfString.length < 1) {
/*  80 */       System.err.println("Use:");
/*  81 */       System.err.println("  XSSFEventBasedExcelExtractor <filename.xlsx>");
/*  82 */       System.exit(1);
/*     */     } 
/*  84 */     XSSFEventBasedExcelExtractor xSSFEventBasedExcelExtractor = new XSSFEventBasedExcelExtractor(paramArrayOfString[0]);
/*     */     
/*  86 */     System.out.println(xSSFEventBasedExcelExtractor.getText());
/*  87 */     xSSFEventBasedExcelExtractor.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeSheetNames(boolean paramBoolean) {
/*  94 */     this.includeSheetNames = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormulasNotResults(boolean paramBoolean) {
/* 101 */     this.formulasNotResults = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeHeadersFooters(boolean paramBoolean) {
/* 107 */     this.includeHeadersFooters = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeTextBoxes(boolean paramBoolean) {
/* 113 */     this.includeTextBoxes = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeCellComments(boolean paramBoolean) {
/* 120 */     this.includeCellComments = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setLocale(Locale paramLocale) {
/* 124 */     this.locale = paramLocale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPCPackage getPackage() {
/* 132 */     return this.container;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties.CoreProperties getCoreProperties() {
/* 140 */     return this.properties.getCoreProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties.ExtendedProperties getExtendedProperties() {
/* 147 */     return this.properties.getExtendedProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties.CustomProperties getCustomProperties() {
/* 154 */     return this.properties.getCustomProperties();
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
/*     */   public void processSheet(XSSFSheetXMLHandler.SheetContentsHandler paramSheetContentsHandler, StylesTable paramStylesTable, CommentsTable paramCommentsTable, ReadOnlySharedStringsTable paramReadOnlySharedStringsTable, InputStream paramInputStream) throws IOException, SAXException {
/*     */     DataFormatter dataFormatter;
/* 169 */     if (this.locale == null) {
/* 170 */       dataFormatter = new DataFormatter();
/*     */     } else {
/* 172 */       dataFormatter = new DataFormatter(this.locale);
/*     */     } 
/*     */     
/* 175 */     InputSource inputSource = new InputSource(paramInputStream);
/*     */     try {
/* 177 */       XMLReader xMLReader = SAXHelper.newXMLReader();
/* 178 */       XSSFSheetXMLHandler xSSFSheetXMLHandler = new XSSFSheetXMLHandler(paramStylesTable, paramCommentsTable, paramReadOnlySharedStringsTable, paramSheetContentsHandler, dataFormatter, this.formulasNotResults);
/*     */       
/* 180 */       xMLReader.setContentHandler((ContentHandler)xSSFSheetXMLHandler);
/* 181 */       xMLReader.parse(inputSource);
/* 182 */     } catch (ParserConfigurationException parserConfigurationException) {
/* 183 */       throw new RuntimeException("SAX parser appears to be broken - " + parserConfigurationException.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/*     */     try {
/* 192 */       ReadOnlySharedStringsTable readOnlySharedStringsTable = new ReadOnlySharedStringsTable(this.container);
/* 193 */       XSSFReader xSSFReader = new XSSFReader(this.container);
/* 194 */       StylesTable stylesTable = xSSFReader.getStylesTable();
/* 195 */       XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator)xSSFReader.getSheetsData();
/*     */       
/* 197 */       StringBuffer stringBuffer = new StringBuffer();
/* 198 */       SheetTextExtractor sheetTextExtractor = new SheetTextExtractor();
/*     */       
/* 200 */       while (sheetIterator.hasNext()) {
/* 201 */         InputStream inputStream = sheetIterator.next();
/* 202 */         if (this.includeSheetNames) {
/* 203 */           stringBuffer.append(sheetIterator.getSheetName());
/* 204 */           stringBuffer.append('\n');
/*     */         } 
/* 206 */         CommentsTable commentsTable = this.includeCellComments ? sheetIterator.getSheetComments() : null;
/* 207 */         processSheet(sheetTextExtractor, stylesTable, commentsTable, readOnlySharedStringsTable, inputStream);
/* 208 */         if (this.includeHeadersFooters) {
/* 209 */           sheetTextExtractor.appendHeaderText(stringBuffer);
/*     */         }
/* 211 */         sheetTextExtractor.appendCellText(stringBuffer);
/* 212 */         if (this.includeTextBoxes) {
/* 213 */           processShapes(sheetIterator.getShapes(), stringBuffer);
/*     */         }
/* 215 */         if (this.includeHeadersFooters) {
/* 216 */           sheetTextExtractor.appendFooterText(stringBuffer);
/*     */         }
/* 218 */         sheetTextExtractor.reset();
/* 219 */         inputStream.close();
/*     */       } 
/*     */       
/* 222 */       return stringBuffer.toString();
/* 223 */     } catch (IOException iOException) {
/* 224 */       System.err.println(iOException);
/* 225 */       return null;
/* 226 */     } catch (SAXException sAXException) {
/* 227 */       System.err.println(sAXException);
/* 228 */       return null;
/* 229 */     } catch (OpenXML4JException openXML4JException) {
/* 230 */       System.err.println(openXML4JException);
/* 231 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void processShapes(List<XSSFShape> paramList, StringBuffer paramStringBuffer) {
/* 236 */     if (paramList == null) {
/*     */       return;
/*     */     }
/* 239 */     for (XSSFShape xSSFShape : paramList) {
/* 240 */       if (xSSFShape instanceof XSSFSimpleShape) {
/* 241 */         String str = ((XSSFSimpleShape)xSSFShape).getText();
/* 242 */         if (str != null && str.length() > 0) {
/* 243 */           paramStringBuffer.append(str).append('\n');
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 250 */     if (this.container != null) {
/* 251 */       this.container.close();
/* 252 */       this.container = null;
/*     */     } 
/* 254 */     super.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class SheetTextExtractor
/*     */     implements XSSFSheetXMLHandler.SheetContentsHandler
/*     */   {
/* 263 */     private final StringBuffer output = new StringBuffer();
/*     */     private boolean firstCellOfRow = true;
/* 265 */     private final Map<String, String> headerFooterMap = XSSFEventBasedExcelExtractor.this.includeHeadersFooters ? new HashMap<String, String>() : null;
/*     */ 
/*     */ 
/*     */     
/*     */     public void startRow(int param1Int) {
/* 270 */       this.firstCellOfRow = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void endRow(int param1Int) {
/* 275 */       this.output.append('\n');
/*     */     }
/*     */ 
/*     */     
/*     */     public void cell(String param1String1, String param1String2, XSSFComment param1XSSFComment) {
/* 280 */       if (this.firstCellOfRow) {
/* 281 */         this.firstCellOfRow = false;
/*     */       } else {
/* 283 */         this.output.append('\t');
/*     */       } 
/* 285 */       if (param1String2 != null) {
/* 286 */         XSSFEventBasedExcelExtractor.this.checkMaxTextSize(this.output, param1String2);
/* 287 */         this.output.append(param1String2);
/*     */       } 
/* 289 */       if (XSSFEventBasedExcelExtractor.this.includeCellComments && param1XSSFComment != null) {
/* 290 */         String str = param1XSSFComment.getString().getString().replace('\n', ' ');
/* 291 */         this.output.append((param1String2 != null) ? " Comment by " : "Comment by ");
/* 292 */         XSSFEventBasedExcelExtractor.this.checkMaxTextSize(this.output, str);
/* 293 */         if (str.startsWith(param1XSSFComment.getAuthor() + ": ")) {
/* 294 */           this.output.append(str);
/*     */         } else {
/* 296 */           this.output.append(param1XSSFComment.getAuthor()).append(": ").append(str);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void headerFooter(String param1String1, boolean param1Boolean, String param1String2) {
/* 303 */       if (this.headerFooterMap != null) {
/* 304 */         this.headerFooterMap.put(param1String2, param1String1);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void appendHeaderFooterText(StringBuffer param1StringBuffer, String param1String) {
/* 312 */       String str = this.headerFooterMap.get(param1String);
/* 313 */       if (str != null && str.length() > 0) {
/*     */ 
/*     */ 
/*     */         
/* 317 */         str = handleHeaderFooterDelimiter(str, "&L");
/* 318 */         str = handleHeaderFooterDelimiter(str, "&C");
/* 319 */         str = handleHeaderFooterDelimiter(str, "&R");
/* 320 */         param1StringBuffer.append(str).append('\n');
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String handleHeaderFooterDelimiter(String param1String1, String param1String2) {
/* 328 */       int i = param1String1.indexOf(param1String2);
/* 329 */       if (i == 0) {
/* 330 */         param1String1 = param1String1.substring(2);
/* 331 */       } else if (i > 0) {
/* 332 */         param1String1 = param1String1.substring(0, i) + "\t" + param1String1.substring(i + 2);
/*     */       } 
/* 334 */       return param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void appendHeaderText(StringBuffer param1StringBuffer) {
/* 345 */       appendHeaderFooterText(param1StringBuffer, "firstHeader");
/* 346 */       appendHeaderFooterText(param1StringBuffer, "oddHeader");
/* 347 */       appendHeaderFooterText(param1StringBuffer, "evenHeader");
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
/*     */     private void appendFooterText(StringBuffer param1StringBuffer) {
/* 359 */       appendHeaderFooterText(param1StringBuffer, "firstFooter");
/* 360 */       appendHeaderFooterText(param1StringBuffer, "oddFooter");
/* 361 */       appendHeaderFooterText(param1StringBuffer, "evenFooter");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void appendCellText(StringBuffer param1StringBuffer) {
/* 368 */       XSSFEventBasedExcelExtractor.this.checkMaxTextSize(param1StringBuffer, this.output.toString());
/* 369 */       param1StringBuffer.append(this.output);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void reset() {
/* 376 */       this.output.setLength(0);
/* 377 */       this.firstCellOfRow = true;
/* 378 */       if (this.headerFooterMap != null)
/* 379 */         this.headerFooterMap.clear(); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\extractor\XSSFEventBasedExcelExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */