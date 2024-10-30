/*     */ package org.apache.poi.xssf.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.POIXMLDocument;
/*     */ import org.apache.poi.POIXMLTextExtractor;
/*     */ import org.apache.poi.hssf.extractor.ExcelExtractor;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.ss.extractor.ExcelExtractor;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Comment;
/*     */ import org.apache.poi.ss.usermodel.DataFormatter;
/*     */ import org.apache.poi.ss.usermodel.HeaderFooter;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFDrawing;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRelation;
/*     */ import org.apache.poi.xssf.usermodel.XSSFShape;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.apache.xmlbeans.XmlException;
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
/*     */ public class XSSFExcelExtractor
/*     */   extends POIXMLTextExtractor
/*     */   implements ExcelExtractor
/*     */ {
/*  49 */   public static final XSSFRelation[] SUPPORTED_TYPES = new XSSFRelation[] { XSSFRelation.WORKBOOK, XSSFRelation.MACRO_TEMPLATE_WORKBOOK, XSSFRelation.MACRO_ADDIN_WORKBOOK, XSSFRelation.TEMPLATE_WORKBOOK, XSSFRelation.MACROS_WORKBOOK };
/*     */   
/*     */   private Locale locale;
/*     */   
/*     */   private XSSFWorkbook workbook;
/*     */   
/*     */   private boolean includeSheetNames = true;
/*     */   
/*     */   private boolean formulasNotResults = false;
/*     */   
/*     */   private boolean includeCellComments = false;
/*     */   private boolean includeHeadersFooters = true;
/*     */   private boolean includeTextBoxes = true;
/*     */   
/*     */   public XSSFExcelExtractor(OPCPackage paramOPCPackage) throws XmlException, OpenXML4JException, IOException {
/*  64 */     this(new XSSFWorkbook(paramOPCPackage));
/*     */   }
/*     */   public XSSFExcelExtractor(XSSFWorkbook paramXSSFWorkbook) {
/*  67 */     super((POIXMLDocument)paramXSSFWorkbook);
/*  68 */     this.workbook = paramXSSFWorkbook;
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  72 */     if (paramArrayOfString.length < 1) {
/*  73 */       System.err.println("Use:");
/*  74 */       System.err.println("  XSSFExcelExtractor <filename.xlsx>");
/*  75 */       System.exit(1);
/*     */     } 
/*  77 */     OPCPackage oPCPackage = OPCPackage.create(paramArrayOfString[0]);
/*  78 */     XSSFExcelExtractor xSSFExcelExtractor = new XSSFExcelExtractor(oPCPackage);
/*     */     try {
/*  80 */       System.out.println(xSSFExcelExtractor.getText());
/*     */     } finally {
/*  82 */       xSSFExcelExtractor.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeSheetNames(boolean paramBoolean) {
/*  90 */     this.includeSheetNames = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormulasNotResults(boolean paramBoolean) {
/*  97 */     this.formulasNotResults = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeCellComments(boolean paramBoolean) {
/* 103 */     this.includeCellComments = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeHeadersFooters(boolean paramBoolean) {
/* 109 */     this.includeHeadersFooters = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeTextBoxes(boolean paramBoolean) {
/* 116 */     this.includeTextBoxes = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocale(Locale paramLocale) {
/* 123 */     this.locale = paramLocale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/*     */     DataFormatter dataFormatter;
/* 132 */     if (this.locale == null) {
/* 133 */       dataFormatter = new DataFormatter();
/*     */     } else {
/* 135 */       dataFormatter = new DataFormatter(this.locale);
/*     */     } 
/*     */     
/* 138 */     StringBuffer stringBuffer = new StringBuffer();
/* 139 */     for (Sheet sheet : this.workbook) {
/* 140 */       XSSFSheet xSSFSheet = (XSSFSheet)sheet;
/* 141 */       if (this.includeSheetNames) {
/* 142 */         stringBuffer.append(xSSFSheet.getSheetName()).append("\n");
/*     */       }
/*     */ 
/*     */       
/* 146 */       if (this.includeHeadersFooters) {
/* 147 */         stringBuffer.append(extractHeaderFooter((HeaderFooter)xSSFSheet.getFirstHeader()));
/*     */ 
/*     */         
/* 150 */         stringBuffer.append(extractHeaderFooter((HeaderFooter)xSSFSheet.getOddHeader()));
/*     */ 
/*     */         
/* 153 */         stringBuffer.append(extractHeaderFooter((HeaderFooter)xSSFSheet.getEvenHeader()));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       for (Row row1 : xSSFSheet) {
/* 160 */         Row row2 = row1;
/* 161 */         for (Iterator<Cell> iterator = row2.cellIterator(); iterator.hasNext(); ) {
/* 162 */           Cell cell = iterator.next();
/*     */ 
/*     */           
/* 165 */           if (cell.getCellTypeEnum() == CellType.FORMULA) {
/* 166 */             if (this.formulasNotResults) {
/* 167 */               String str = cell.getCellFormula();
/* 168 */               checkMaxTextSize(stringBuffer, str);
/* 169 */               stringBuffer.append(str);
/*     */             }
/* 171 */             else if (cell.getCachedFormulaResultTypeEnum() == CellType.STRING) {
/* 172 */               handleStringCell(stringBuffer, cell);
/*     */             } else {
/* 174 */               handleNonStringCell(stringBuffer, cell, dataFormatter);
/*     */             }
/*     */           
/* 177 */           } else if (cell.getCellTypeEnum() == CellType.STRING) {
/* 178 */             handleStringCell(stringBuffer, cell);
/*     */           } else {
/* 180 */             handleNonStringCell(stringBuffer, cell, dataFormatter);
/*     */           } 
/*     */ 
/*     */           
/* 184 */           Comment comment = cell.getCellComment();
/* 185 */           if (this.includeCellComments && comment != null) {
/*     */ 
/*     */             
/* 188 */             String str = comment.getString().getString().replace('\n', ' ');
/* 189 */             checkMaxTextSize(stringBuffer, str);
/* 190 */             stringBuffer.append(" Comment by ").append(comment.getAuthor()).append(": ").append(str);
/*     */           } 
/*     */           
/* 193 */           if (iterator.hasNext()) {
/* 194 */             stringBuffer.append("\t");
/*     */           }
/*     */         } 
/* 197 */         stringBuffer.append("\n");
/*     */       } 
/*     */ 
/*     */       
/* 201 */       if (this.includeTextBoxes) {
/* 202 */         XSSFDrawing xSSFDrawing = xSSFSheet.getDrawingPatriarch();
/* 203 */         if (xSSFDrawing != null) {
/* 204 */           for (XSSFShape xSSFShape : xSSFDrawing.getShapes()) {
/* 205 */             if (xSSFShape instanceof XSSFSimpleShape) {
/* 206 */               String str = ((XSSFSimpleShape)xSSFShape).getText();
/* 207 */               if (str.length() > 0) {
/* 208 */                 stringBuffer.append(str);
/* 209 */                 stringBuffer.append('\n');
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 216 */       if (this.includeHeadersFooters) {
/* 217 */         stringBuffer.append(extractHeaderFooter((HeaderFooter)xSSFSheet.getFirstFooter()));
/*     */ 
/*     */         
/* 220 */         stringBuffer.append(extractHeaderFooter((HeaderFooter)xSSFSheet.getOddFooter()));
/*     */ 
/*     */         
/* 223 */         stringBuffer.append(extractHeaderFooter((HeaderFooter)xSSFSheet.getEvenFooter()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 229 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private void handleStringCell(StringBuffer paramStringBuffer, Cell paramCell) {
/* 233 */     String str = paramCell.getRichStringCellValue().getString();
/* 234 */     checkMaxTextSize(paramStringBuffer, str);
/* 235 */     paramStringBuffer.append(str);
/*     */   }
/*     */   
/*     */   private void handleNonStringCell(StringBuffer paramStringBuffer, Cell paramCell, DataFormatter paramDataFormatter) {
/* 239 */     CellType cellType = paramCell.getCellTypeEnum();
/* 240 */     if (cellType == CellType.FORMULA) {
/* 241 */       cellType = paramCell.getCachedFormulaResultTypeEnum();
/*     */     }
/*     */     
/* 244 */     if (cellType == CellType.NUMERIC) {
/* 245 */       CellStyle cellStyle = paramCell.getCellStyle();
/*     */       
/* 247 */       if (cellStyle != null && cellStyle.getDataFormatString() != null) {
/* 248 */         String str1 = paramDataFormatter.formatRawCellContents(paramCell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString());
/*     */         
/* 250 */         checkMaxTextSize(paramStringBuffer, str1);
/* 251 */         paramStringBuffer.append(str1);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     String str = ((XSSFCell)paramCell).getRawValue();
/* 258 */     checkMaxTextSize(paramStringBuffer, str);
/* 259 */     paramStringBuffer.append(str);
/*     */   }
/*     */   
/*     */   private String extractHeaderFooter(HeaderFooter paramHeaderFooter) {
/* 263 */     return ExcelExtractor._extractHeaderFooter(paramHeaderFooter);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\extractor\XSSFExcelExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */