/*     */ package org.apache.poi.xssf.eventusermodel;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
/*     */ import org.apache.poi.ss.usermodel.BuiltinFormats;
/*     */ import org.apache.poi.ss.usermodel.DataFormatter;
/*     */ import org.apache.poi.ss.util.CellAddress;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.model.CommentsTable;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFComment;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRichTextString;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.helpers.DefaultHandler;
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
/*     */ public class XSSFSheetXMLHandler
/*     */   extends DefaultHandler
/*     */ {
/*     */   private StylesTable stylesTable;
/*     */   private CommentsTable commentsTable;
/*     */   private ReadOnlySharedStringsTable sharedStringsTable;
/*     */   private final SheetContentsHandler output;
/*     */   private boolean vIsOpen;
/*     */   private boolean fIsOpen;
/*     */   private boolean isIsOpen;
/*     */   private boolean hfIsOpen;
/*  45 */   private static final POILogger logger = POILogFactory.getLogger(XSSFSheetXMLHandler.class); private xssfDataType nextDataType; private short formatIndex;
/*     */   private String formatString;
/*     */   private final DataFormatter formatter;
/*     */   private int rowNum;
/*     */   private int nextRowNum;
/*     */   private String cellRef;
/*     */   private boolean formulasNotResults;
/*     */   
/*  53 */   enum xssfDataType { BOOLEAN,
/*  54 */     ERROR,
/*  55 */     FORMULA,
/*  56 */     INLINE_STRING,
/*  57 */     SST_STRING,
/*  58 */     NUMBER; }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   private StringBuffer value = new StringBuffer();
/* 106 */   private StringBuffer formula = new StringBuffer();
/* 107 */   private StringBuffer headerFooter = new StringBuffer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Queue<CellAddress> commentCellRefs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFSheetXMLHandler(StylesTable paramStylesTable, CommentsTable paramCommentsTable, ReadOnlySharedStringsTable paramReadOnlySharedStringsTable, SheetContentsHandler paramSheetContentsHandler, DataFormatter paramDataFormatter, boolean paramBoolean) {
/* 124 */     this.stylesTable = paramStylesTable;
/* 125 */     this.commentsTable = paramCommentsTable;
/* 126 */     this.sharedStringsTable = paramReadOnlySharedStringsTable;
/* 127 */     this.output = paramSheetContentsHandler;
/* 128 */     this.formulasNotResults = paramBoolean;
/* 129 */     this.nextDataType = xssfDataType.NUMBER;
/* 130 */     this.formatter = paramDataFormatter;
/* 131 */     init();
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
/*     */   
/*     */   public XSSFSheetXMLHandler(StylesTable paramStylesTable, ReadOnlySharedStringsTable paramReadOnlySharedStringsTable, SheetContentsHandler paramSheetContentsHandler, DataFormatter paramDataFormatter, boolean paramBoolean) {
/* 146 */     this(paramStylesTable, null, paramReadOnlySharedStringsTable, paramSheetContentsHandler, paramDataFormatter, paramBoolean);
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
/*     */   public XSSFSheetXMLHandler(StylesTable paramStylesTable, ReadOnlySharedStringsTable paramReadOnlySharedStringsTable, SheetContentsHandler paramSheetContentsHandler, boolean paramBoolean) {
/* 160 */     this(paramStylesTable, paramReadOnlySharedStringsTable, paramSheetContentsHandler, new DataFormatter(), paramBoolean);
/*     */   }
/*     */   
/*     */   private void init() {
/* 164 */     if (this.commentsTable != null) {
/* 165 */       this.commentCellRefs = new LinkedList<CellAddress>();
/* 166 */       for (CTComment cTComment : this.commentsTable.getCTComments().getCommentList().getCommentArray()) {
/* 167 */         this.commentCellRefs.add(new CellAddress(cTComment.getRef()));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isTextTag(String paramString) {
/* 173 */     if ("v".equals(paramString))
/*     */     {
/* 175 */       return true;
/*     */     }
/* 177 */     if ("inlineStr".equals(paramString))
/*     */     {
/* 179 */       return true;
/*     */     }
/* 181 */     if ("t".equals(paramString) && this.isIsOpen)
/*     */     {
/* 183 */       return true;
/*     */     }
/*     */     
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) throws SAXException {
/* 194 */     if (paramString1 != null && !paramString1.equals("http://schemas.openxmlformats.org/spreadsheetml/2006/main")) {
/*     */       return;
/*     */     }
/*     */     
/* 198 */     if (isTextTag(paramString2)) {
/* 199 */       this.vIsOpen = true;
/*     */       
/* 201 */       this.value.setLength(0);
/* 202 */     } else if ("is".equals(paramString2)) {
/*     */       
/* 204 */       this.isIsOpen = true;
/* 205 */     } else if ("f".equals(paramString2)) {
/*     */       
/* 207 */       this.formula.setLength(0);
/*     */ 
/*     */       
/* 210 */       if (this.nextDataType == xssfDataType.NUMBER) {
/* 211 */         this.nextDataType = xssfDataType.FORMULA;
/*     */       }
/*     */ 
/*     */       
/* 215 */       String str = paramAttributes.getValue("t");
/* 216 */       if (str != null && str.equals("shared"))
/*     */       {
/* 218 */         String str1 = paramAttributes.getValue("ref");
/* 219 */         String str2 = paramAttributes.getValue("si");
/*     */         
/* 221 */         if (str1 != null) {
/*     */ 
/*     */           
/* 224 */           this.fIsOpen = true;
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 229 */         else if (this.formulasNotResults) {
/* 230 */           logger.log(5, new Object[] { "shared formulas not yet supported!" });
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else
/*     */       {
/* 237 */         this.fIsOpen = true;
/*     */       }
/*     */     
/* 240 */     } else if ("oddHeader".equals(paramString2) || "evenHeader".equals(paramString2) || "firstHeader".equals(paramString2) || "firstFooter".equals(paramString2) || "oddFooter".equals(paramString2) || "evenFooter".equals(paramString2)) {
/*     */ 
/*     */       
/* 243 */       this.hfIsOpen = true;
/*     */       
/* 245 */       this.headerFooter.setLength(0);
/*     */     }
/* 247 */     else if ("row".equals(paramString2)) {
/* 248 */       String str = paramAttributes.getValue("r");
/* 249 */       if (str != null) {
/* 250 */         this.rowNum = Integer.parseInt(str) - 1;
/*     */       } else {
/* 252 */         this.rowNum = this.nextRowNum;
/*     */       } 
/* 254 */       this.output.startRow(this.rowNum);
/*     */     
/*     */     }
/* 257 */     else if ("c".equals(paramString2)) {
/*     */       
/* 259 */       this.nextDataType = xssfDataType.NUMBER;
/* 260 */       this.formatIndex = -1;
/* 261 */       this.formatString = null;
/* 262 */       this.cellRef = paramAttributes.getValue("r");
/* 263 */       String str1 = paramAttributes.getValue("t");
/* 264 */       String str2 = paramAttributes.getValue("s");
/* 265 */       if ("b".equals(str1)) {
/* 266 */         this.nextDataType = xssfDataType.BOOLEAN;
/* 267 */       } else if ("e".equals(str1)) {
/* 268 */         this.nextDataType = xssfDataType.ERROR;
/* 269 */       } else if ("inlineStr".equals(str1)) {
/* 270 */         this.nextDataType = xssfDataType.INLINE_STRING;
/* 271 */       } else if ("s".equals(str1)) {
/* 272 */         this.nextDataType = xssfDataType.SST_STRING;
/* 273 */       } else if ("str".equals(str1)) {
/* 274 */         this.nextDataType = xssfDataType.FORMULA;
/*     */       } else {
/*     */         
/* 277 */         XSSFCellStyle xSSFCellStyle = null;
/* 278 */         if (this.stylesTable != null) {
/* 279 */           if (str2 != null) {
/* 280 */             int i = Integer.parseInt(str2);
/* 281 */             xSSFCellStyle = this.stylesTable.getStyleAt(i);
/* 282 */           } else if (this.stylesTable.getNumCellStyles() > 0) {
/* 283 */             xSSFCellStyle = this.stylesTable.getStyleAt(0);
/*     */           } 
/*     */         }
/* 286 */         if (xSSFCellStyle != null) {
/* 287 */           this.formatIndex = xSSFCellStyle.getDataFormat();
/* 288 */           this.formatString = xSSFCellStyle.getDataFormatString();
/* 289 */           if (this.formatString == null) {
/* 290 */             this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void endElement(String paramString1, String paramString2, String paramString3) throws SAXException {
/* 300 */     if (paramString1 != null && !paramString1.equals("http://schemas.openxmlformats.org/spreadsheetml/2006/main")) {
/*     */       return;
/*     */     }
/*     */     
/* 304 */     String str = null;
/*     */ 
/*     */     
/* 307 */     if (isTextTag(paramString2)) {
/* 308 */       char c; String str1; XSSFRichTextString xSSFRichTextString; String str2, str3; this.vIsOpen = false;
/*     */ 
/*     */       
/* 311 */       switch (this.nextDataType) {
/*     */         case BOOLEAN:
/* 313 */           c = this.value.charAt(0);
/* 314 */           str = (c == '0') ? "FALSE" : "TRUE";
/*     */           break;
/*     */         
/*     */         case ERROR:
/* 318 */           str = "ERROR:" + this.value.toString();
/*     */           break;
/*     */         
/*     */         case FORMULA:
/* 322 */           if (this.formulasNotResults) {
/* 323 */             str = this.formula.toString(); break;
/*     */           } 
/* 325 */           str1 = this.value.toString();
/*     */           
/* 327 */           if (this.formatString != null) {
/*     */             
/*     */             try {
/* 330 */               double d = Double.parseDouble(str1);
/* 331 */               str = this.formatter.formatRawCellContents(d, this.formatIndex, this.formatString);
/* 332 */             } catch (NumberFormatException numberFormatException) {
/*     */               
/* 334 */               str = str1;
/*     */             } 
/*     */             break;
/*     */           } 
/* 338 */           str = str1;
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case INLINE_STRING:
/* 345 */           xSSFRichTextString = new XSSFRichTextString(this.value.toString());
/* 346 */           str = xSSFRichTextString.toString();
/*     */           break;
/*     */         
/*     */         case SST_STRING:
/* 350 */           str2 = this.value.toString();
/*     */           try {
/* 352 */             int i = Integer.parseInt(str2);
/* 353 */             XSSFRichTextString xSSFRichTextString1 = new XSSFRichTextString(this.sharedStringsTable.getEntryAt(i));
/* 354 */             str = xSSFRichTextString1.toString();
/*     */           }
/* 356 */           catch (NumberFormatException numberFormatException) {
/* 357 */             logger.log(7, new Object[] { "Failed to parse SST index '" + str2, numberFormatException });
/*     */           } 
/*     */           break;
/*     */         
/*     */         case NUMBER:
/* 362 */           str3 = this.value.toString();
/* 363 */           if (this.formatString != null && str3.length() > 0) {
/* 364 */             str = this.formatter.formatRawCellContents(Double.parseDouble(str3), this.formatIndex, this.formatString); break;
/*     */           } 
/* 366 */           str = str3;
/*     */           break;
/*     */         
/*     */         default:
/* 370 */           str = "(TODO: Unexpected type: " + this.nextDataType + ")";
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 375 */       checkForEmptyCellComments(EmptyCellCommentsCheckType.CELL);
/* 376 */       XSSFComment xSSFComment = (this.commentsTable != null) ? this.commentsTable.findCellComment(new CellAddress(this.cellRef)) : null;
/*     */ 
/*     */       
/* 379 */       this.output.cell(this.cellRef, str, xSSFComment);
/* 380 */     } else if ("f".equals(paramString2)) {
/* 381 */       this.fIsOpen = false;
/* 382 */     } else if ("is".equals(paramString2)) {
/* 383 */       this.isIsOpen = false;
/* 384 */     } else if ("row".equals(paramString2)) {
/*     */       
/* 386 */       checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_ROW);
/*     */ 
/*     */       
/* 389 */       this.output.endRow(this.rowNum);
/*     */ 
/*     */       
/* 392 */       this.nextRowNum = this.rowNum + 1;
/* 393 */     } else if ("sheetData".equals(paramString2)) {
/*     */       
/* 395 */       checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_SHEET_DATA);
/*     */     }
/* 397 */     else if ("oddHeader".equals(paramString2) || "evenHeader".equals(paramString2) || "firstHeader".equals(paramString2)) {
/*     */       
/* 399 */       this.hfIsOpen = false;
/* 400 */       this.output.headerFooter(this.headerFooter.toString(), true, paramString2);
/*     */     }
/* 402 */     else if ("oddFooter".equals(paramString2) || "evenFooter".equals(paramString2) || "firstFooter".equals(paramString2)) {
/*     */       
/* 404 */       this.hfIsOpen = false;
/* 405 */       this.output.headerFooter(this.headerFooter.toString(), false, paramString2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void characters(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws SAXException {
/* 416 */     if (this.vIsOpen) {
/* 417 */       this.value.append(paramArrayOfchar, paramInt1, paramInt2);
/*     */     }
/* 419 */     if (this.fIsOpen) {
/* 420 */       this.formula.append(paramArrayOfchar, paramInt1, paramInt2);
/*     */     }
/* 422 */     if (this.hfIsOpen) {
/* 423 */       this.headerFooter.append(paramArrayOfchar, paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkForEmptyCellComments(EmptyCellCommentsCheckType paramEmptyCellCommentsCheckType) {
/* 431 */     if (this.commentCellRefs != null && !this.commentCellRefs.isEmpty()) {
/*     */       Object object;
/*     */       
/* 434 */       if (paramEmptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_SHEET_DATA) {
/* 435 */         while (!this.commentCellRefs.isEmpty()) {
/* 436 */           outputEmptyCellComment(this.commentCellRefs.remove());
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 442 */       if (this.cellRef == null) {
/* 443 */         if (paramEmptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_ROW) {
/* 444 */           while (!this.commentCellRefs.isEmpty()) {
/* 445 */             if (((CellAddress)this.commentCellRefs.peek()).getRow() == this.rowNum) {
/* 446 */               outputEmptyCellComment(this.commentCellRefs.remove());
/*     */               continue;
/*     */             } 
/*     */             return;
/*     */           } 
/*     */           return;
/*     */         } 
/* 453 */         throw new IllegalStateException("Cell ref should be null only if there are only empty cells in the row; rowNum: " + this.rowNum);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       do {
/* 459 */         CellAddress cellAddress1 = new CellAddress(this.cellRef);
/* 460 */         CellAddress cellAddress2 = this.commentCellRefs.peek();
/* 461 */         if (paramEmptyCellCommentsCheckType == EmptyCellCommentsCheckType.CELL && cellAddress1.equals(cellAddress2)) {
/*     */           
/* 463 */           this.commentCellRefs.remove();
/*     */           
/*     */           return;
/*     */         } 
/* 467 */         int i = cellAddress2.compareTo(cellAddress1);
/* 468 */         if (i > 0 && paramEmptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_ROW && cellAddress2.getRow() <= this.rowNum) {
/* 469 */           object = this.commentCellRefs.remove();
/* 470 */           outputEmptyCellComment((CellAddress)object);
/* 471 */         } else if (i < 0 && paramEmptyCellCommentsCheckType == EmptyCellCommentsCheckType.CELL && cellAddress2.getRow() <= this.rowNum) {
/* 472 */           object = this.commentCellRefs.remove();
/* 473 */           outputEmptyCellComment((CellAddress)object);
/*     */         } else {
/* 475 */           object = null;
/*     */         }
/*     */       
/* 478 */       } while (object != null && !this.commentCellRefs.isEmpty());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void outputEmptyCellComment(CellAddress paramCellAddress) {
/* 487 */     XSSFComment xSSFComment = this.commentsTable.findCellComment(paramCellAddress);
/* 488 */     this.output.cell(paramCellAddress.formatAsString(), null, xSSFComment);
/*     */   }
/*     */   
/*     */   private enum EmptyCellCommentsCheckType {
/* 492 */     CELL,
/* 493 */     END_OF_ROW,
/* 494 */     END_OF_SHEET_DATA;
/*     */   }
/*     */   
/*     */   public static interface SheetContentsHandler {
/*     */     void startRow(int param1Int);
/*     */     
/*     */     void endRow(int param1Int);
/*     */     
/*     */     void cell(String param1String1, String param1String2, XSSFComment param1XSSFComment);
/*     */     
/*     */     void headerFooter(String param1String1, boolean param1Boolean, String param1String2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\eventusermodel\XSSFSheetXMLHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */