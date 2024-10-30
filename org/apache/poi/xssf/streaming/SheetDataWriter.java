/*     */ package org.apache.poi.xssf.streaming;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.FormulaError;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.TempFile;
/*     */ import org.apache.poi.xssf.model.SharedStringsTable;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRichTextString;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;
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
/*     */ public class SheetDataWriter
/*     */ {
/*  51 */   private static final POILogger logger = POILogFactory.getLogger(SheetDataWriter.class);
/*     */   
/*     */   private final File _fd;
/*     */   private final Writer _out;
/*     */   private int _rownum;
/*     */   private int _numberOfFlushedRows;
/*     */   private int _lowestIndexOfFlushedRows;
/*     */   private int _numberOfCellsOfLastFlushedRow;
/*  59 */   private int _numberLastFlushedRow = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private SharedStringsTable _sharedStringSource;
/*     */ 
/*     */ 
/*     */   
/*     */   public SheetDataWriter() throws IOException {
/*  68 */     this._fd = createTempFile();
/*  69 */     this._out = createWriter(this._fd);
/*     */   }
/*     */   
/*     */   public SheetDataWriter(SharedStringsTable paramSharedStringsTable) throws IOException {
/*  73 */     this();
/*  74 */     this._sharedStringSource = paramSharedStringsTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File createTempFile() throws IOException {
/*  85 */     return TempFile.createTempFile("poi-sxssf-sheet", ".xml");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Writer createWriter(File paramFile) throws IOException {
/*  94 */     return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), "UTF-8"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 102 */     this._out.flush();
/* 103 */     this._out.close();
/*     */   }
/*     */   
/*     */   File getTempFile() {
/* 107 */     return this._fd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getWorksheetXMLInputStream() throws IOException {
/* 114 */     File file = getTempFile();
/* 115 */     return new FileInputStream(file);
/*     */   }
/*     */   
/*     */   public int getNumberOfFlushedRows() {
/* 119 */     return this._numberOfFlushedRows;
/*     */   }
/*     */   
/*     */   public int getNumberOfCellsOfLastFlushedRow() {
/* 123 */     return this._numberOfCellsOfLastFlushedRow;
/*     */   }
/*     */   
/*     */   public int getLowestIndexOfFlushedRows() {
/* 127 */     return this._lowestIndexOfFlushedRows;
/*     */   }
/*     */   
/*     */   public int getLastFlushedRow() {
/* 131 */     return this._numberLastFlushedRow;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 136 */     if (!this._fd.delete()) {
/* 137 */       logger.log(7, new Object[] { "Can't delete temporary encryption file: " + this._fd });
/*     */     }
/*     */     
/* 140 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeRow(int paramInt, SXSSFRow paramSXSSFRow) throws IOException {
/* 150 */     if (this._numberOfFlushedRows == 0)
/* 151 */       this._lowestIndexOfFlushedRows = paramInt; 
/* 152 */     this._numberLastFlushedRow = Math.max(paramInt, this._numberLastFlushedRow);
/* 153 */     this._numberOfCellsOfLastFlushedRow = paramSXSSFRow.getLastCellNum();
/* 154 */     this._numberOfFlushedRows++;
/* 155 */     beginRow(paramInt, paramSXSSFRow);
/* 156 */     Iterator<Cell> iterator = paramSXSSFRow.allCellsIterator();
/* 157 */     byte b = 0;
/* 158 */     while (iterator.hasNext()) {
/* 159 */       writeCell(b++, iterator.next());
/*     */     }
/* 161 */     endRow();
/*     */   }
/*     */   
/*     */   void beginRow(int paramInt, SXSSFRow paramSXSSFRow) throws IOException {
/* 165 */     this._out.write("<row r=\"" + (paramInt + 1) + "\"");
/* 166 */     if (paramSXSSFRow.hasCustomHeight())
/* 167 */       this._out.write(" customHeight=\"true\"  ht=\"" + paramSXSSFRow.getHeightInPoints() + "\""); 
/* 168 */     if (paramSXSSFRow.getZeroHeight())
/* 169 */       this._out.write(" hidden=\"true\""); 
/* 170 */     if (paramSXSSFRow.isFormatted()) {
/* 171 */       this._out.write(" s=\"" + paramSXSSFRow.getRowStyleIndex() + "\"");
/* 172 */       this._out.write(" customFormat=\"1\"");
/*     */     } 
/* 174 */     if (paramSXSSFRow.getOutlineLevel() != 0) {
/* 175 */       this._out.write(" outlineLevel=\"" + paramSXSSFRow.getOutlineLevel() + "\"");
/*     */     }
/* 177 */     if (paramSXSSFRow.getHidden() != null) {
/* 178 */       this._out.write(" hidden=\"" + (paramSXSSFRow.getHidden().booleanValue() ? "1" : "0") + "\"");
/*     */     }
/* 180 */     if (paramSXSSFRow.getCollapsed() != null) {
/* 181 */       this._out.write(" collapsed=\"" + (paramSXSSFRow.getCollapsed().booleanValue() ? "1" : "0") + "\"");
/*     */     }
/*     */     
/* 184 */     this._out.write(">\n");
/* 185 */     this._rownum = paramInt;
/*     */   }
/*     */   
/*     */   void endRow() throws IOException {
/* 189 */     this._out.write("</row>\n");
/*     */   } public void writeCell(int paramInt, Cell paramCell) throws IOException {
/*     */     double d;
/*     */     FormulaError formulaError;
/* 193 */     if (paramCell == null) {
/*     */       return;
/*     */     }
/* 196 */     String str = (new CellReference(this._rownum, paramInt)).formatAsString();
/* 197 */     this._out.write("<c r=\"" + str + "\"");
/* 198 */     CellStyle cellStyle = paramCell.getCellStyle();
/* 199 */     if (cellStyle.getIndex() != 0)
/*     */     {
/*     */ 
/*     */       
/* 203 */       this._out.write(" s=\"" + (cellStyle.getIndex() & 0xFFFF) + "\"");
/*     */     }
/* 205 */     CellType cellType = paramCell.getCellTypeEnum();
/* 206 */     switch (cellType) {
/*     */       case BLANK:
/* 208 */         this._out.write(">");
/*     */         break;
/*     */       
/*     */       case FORMULA:
/* 212 */         this._out.write(">");
/* 213 */         this._out.write("<f>");
/* 214 */         outputQuotedString(paramCell.getCellFormula());
/* 215 */         this._out.write("</f>");
/* 216 */         switch (paramCell.getCachedFormulaResultTypeEnum()) {
/*     */           case NUMERIC:
/* 218 */             d = paramCell.getNumericCellValue();
/* 219 */             if (!Double.isNaN(d)) {
/* 220 */               this._out.write("<v>" + d + "</v>");
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/*     */         break;
/*     */       
/*     */       case STRING:
/* 229 */         if (this._sharedStringSource != null) {
/* 230 */           XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(paramCell.getStringCellValue());
/* 231 */           int i = this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst());
/*     */           
/* 233 */           this._out.write(" t=\"" + STCellType.S.toString() + "\">");
/* 234 */           this._out.write("<v>");
/* 235 */           this._out.write(String.valueOf(i));
/* 236 */           this._out.write("</v>"); break;
/*     */         } 
/* 238 */         this._out.write(" t=\"inlineStr\">");
/* 239 */         this._out.write("<is><t");
/* 240 */         if (hasLeadingTrailingSpaces(paramCell.getStringCellValue())) {
/* 241 */           this._out.write(" xml:space=\"preserve\"");
/*     */         }
/* 243 */         this._out.write(">");
/* 244 */         outputQuotedString(paramCell.getStringCellValue());
/* 245 */         this._out.write("</t></is>");
/*     */         break;
/*     */ 
/*     */       
/*     */       case NUMERIC:
/* 250 */         this._out.write(" t=\"n\">");
/* 251 */         this._out.write("<v>" + paramCell.getNumericCellValue() + "</v>");
/*     */         break;
/*     */       
/*     */       case BOOLEAN:
/* 255 */         this._out.write(" t=\"b\">");
/* 256 */         this._out.write("<v>" + (paramCell.getBooleanCellValue() ? "1" : "0") + "</v>");
/*     */         break;
/*     */       
/*     */       case ERROR:
/* 260 */         formulaError = FormulaError.forInt(paramCell.getErrorCellValue());
/*     */         
/* 262 */         this._out.write(" t=\"e\">");
/* 263 */         this._out.write("<v>" + formulaError.getString() + "</v>");
/*     */         break;
/*     */       
/*     */       default:
/* 267 */         throw new IllegalStateException("Invalid cell type: " + cellType);
/*     */     } 
/*     */     
/* 270 */     this._out.write("</c>");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasLeadingTrailingSpaces(String paramString) {
/* 279 */     if (paramString != null && paramString.length() > 0) {
/* 280 */       char c1 = paramString.charAt(0);
/* 281 */       char c2 = paramString.charAt(paramString.length() - 1);
/* 282 */       return (Character.isWhitespace(c1) || Character.isWhitespace(c2));
/*     */     } 
/* 284 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void outputQuotedString(String paramString) throws IOException {
/* 289 */     if (paramString == null || paramString.length() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 293 */     char[] arrayOfChar = paramString.toCharArray();
/* 294 */     int i = 0;
/* 295 */     int j = paramString.length();
/* 296 */     for (byte b = 0; b < j; b++) {
/* 297 */       char c = arrayOfChar[b];
/* 298 */       switch (c) {
/*     */         case '<':
/* 300 */           if (b > i) {
/* 301 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 303 */           i = b + 1;
/* 304 */           this._out.write("&lt;");
/*     */           break;
/*     */         case '>':
/* 307 */           if (b > i) {
/* 308 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 310 */           i = b + 1;
/* 311 */           this._out.write("&gt;");
/*     */           break;
/*     */         case '&':
/* 314 */           if (b > i) {
/* 315 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 317 */           i = b + 1;
/* 318 */           this._out.write("&amp;");
/*     */           break;
/*     */         case '"':
/* 321 */           if (b > i) {
/* 322 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 324 */           i = b + 1;
/* 325 */           this._out.write("&quot;");
/*     */           break;
/*     */         
/*     */         case '\n':
/*     */         case '\r':
/* 330 */           if (b > i) {
/* 331 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 333 */           this._out.write("&#xa;");
/* 334 */           i = b + 1;
/*     */           break;
/*     */         case '\t':
/* 337 */           if (b > i) {
/* 338 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 340 */           this._out.write("&#x9;");
/* 341 */           i = b + 1;
/*     */           break;
/*     */         case ' ':
/* 344 */           if (b > i) {
/* 345 */             this._out.write(arrayOfChar, i, b - i);
/*     */           }
/* 347 */           this._out.write("&#xa0;");
/* 348 */           i = b + 1;
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/* 353 */           if (c < ' ' || Character.isLowSurrogate(c) || Character.isHighSurrogate(c) || ('￾' <= c && c <= Character.MAX_VALUE)) {
/*     */             
/* 355 */             if (b > i) {
/* 356 */               this._out.write(arrayOfChar, i, b - i);
/*     */             }
/* 358 */             this._out.write(63);
/* 359 */             i = b + 1; break;
/*     */           } 
/* 361 */           if (c > '') {
/* 362 */             if (b > i) {
/* 363 */               this._out.write(arrayOfChar, i, b - i);
/*     */             }
/* 365 */             i = b + 1;
/*     */ 
/*     */             
/* 368 */             this._out.write("&#");
/* 369 */             this._out.write(String.valueOf(c));
/* 370 */             this._out.write(";");
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } 
/* 375 */     if (i < j) {
/* 376 */       this._out.write(arrayOfChar, i, j - i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean dispose() throws IOException {
/*     */     boolean bool;
/*     */     try {
/* 387 */       this._out.close();
/*     */     } finally {
/* 389 */       bool = this._fd.delete();
/*     */     } 
/* 391 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SheetDataWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */