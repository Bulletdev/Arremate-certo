/*     */ package org.apache.poi.hssf.extractor;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.POIDocument;
/*     */ import org.apache.poi.POIOLE2TextExtractor;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*     */ import org.apache.poi.hssf.usermodel.HSSFComment;
/*     */ import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRichTextString;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.ss.extractor.ExcelExtractor;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.HeaderFooter;
/*     */ import org.apache.poi.ss.usermodel.Row;
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
/*     */ public class ExcelExtractor
/*     */   extends POIOLE2TextExtractor
/*     */   implements ExcelExtractor
/*     */ {
/*     */   private final HSSFWorkbook _wb;
/*     */   private final HSSFDataFormatter _formatter;
/*     */   private boolean _includeSheetNames = true;
/*     */   private boolean _shouldEvaluateFormulas = true;
/*     */   private boolean _includeCellComments = false;
/*     */   private boolean _includeBlankCells = false;
/*     */   private boolean _includeHeadersFooters = true;
/*     */   
/*     */   public ExcelExtractor(HSSFWorkbook paramHSSFWorkbook) {
/*  66 */     super((POIDocument)paramHSSFWorkbook);
/*  67 */     this._wb = paramHSSFWorkbook;
/*  68 */     this._formatter = new HSSFDataFormatter();
/*     */   }
/*     */   public ExcelExtractor(POIFSFileSystem paramPOIFSFileSystem) throws IOException {
/*  71 */     this(paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */   public ExcelExtractor(DirectoryNode paramDirectoryNode) throws IOException {
/*  74 */     this(new HSSFWorkbook(paramDirectoryNode, true));
/*     */   }
/*     */   
/*     */   private static final class CommandParseException extends Exception {
/*     */     public CommandParseException(String param1String) {
/*  79 */       super(param1String);
/*     */     } }
/*     */   
/*     */   private static final class CommandArgs { private final boolean _requestHelp;
/*     */     private final File _inputFile;
/*     */     private final boolean _showSheetNames;
/*     */     private final boolean _evaluateFormulas;
/*     */     private final boolean _showCellComments;
/*     */     private final boolean _showBlankCells;
/*     */     private final boolean _headersFooters;
/*     */     
/*     */     public CommandArgs(String[] param1ArrayOfString) throws ExcelExtractor.CommandParseException {
/*  91 */       int i = param1ArrayOfString.length;
/*  92 */       File file = null;
/*  93 */       boolean bool = false;
/*  94 */       boolean bool1 = true;
/*  95 */       boolean bool2 = true;
/*  96 */       boolean bool3 = false;
/*  97 */       boolean bool4 = false;
/*  98 */       boolean bool5 = true;
/*  99 */       for (byte b = 0; b < i; b++) {
/* 100 */         String str = param1ArrayOfString[b];
/* 101 */         if ("-help".equalsIgnoreCase(str)) {
/* 102 */           bool = true;
/*     */           break;
/*     */         } 
/* 105 */         if ("-i".equals(str)) {
/*     */           
/* 107 */           if (++b >= i) {
/* 108 */             throw new ExcelExtractor.CommandParseException("Expected filename after '-i'");
/*     */           }
/* 110 */           str = param1ArrayOfString[b];
/* 111 */           if (file != null) {
/* 112 */             throw new ExcelExtractor.CommandParseException("Only one input file can be supplied");
/*     */           }
/* 114 */           file = new File(str);
/* 115 */           if (!file.exists()) {
/* 116 */             throw new ExcelExtractor.CommandParseException("Specified input file '" + str + "' does not exist");
/*     */           }
/* 118 */           if (file.isDirectory()) {
/* 119 */             throw new ExcelExtractor.CommandParseException("Specified input file '" + str + "' is a directory");
/*     */           
/*     */           }
/*     */         }
/* 123 */         else if ("--show-sheet-names".equals(str)) {
/* 124 */           bool1 = parseBoolArg(param1ArrayOfString, ++b);
/*     */         
/*     */         }
/* 127 */         else if ("--evaluate-formulas".equals(str)) {
/* 128 */           bool2 = parseBoolArg(param1ArrayOfString, ++b);
/*     */         
/*     */         }
/* 131 */         else if ("--show-comments".equals(str)) {
/* 132 */           bool3 = parseBoolArg(param1ArrayOfString, ++b);
/*     */         
/*     */         }
/* 135 */         else if ("--show-blanks".equals(str)) {
/* 136 */           bool4 = parseBoolArg(param1ArrayOfString, ++b);
/*     */         
/*     */         }
/* 139 */         else if ("--headers-footers".equals(str)) {
/* 140 */           bool5 = parseBoolArg(param1ArrayOfString, ++b);
/*     */         } else {
/*     */           
/* 143 */           throw new ExcelExtractor.CommandParseException("Invalid argument '" + str + "'");
/*     */         } 
/* 145 */       }  this._requestHelp = bool;
/* 146 */       this._inputFile = file;
/* 147 */       this._showSheetNames = bool1;
/* 148 */       this._evaluateFormulas = bool2;
/* 149 */       this._showCellComments = bool3;
/* 150 */       this._showBlankCells = bool4;
/* 151 */       this._headersFooters = bool5;
/*     */     }
/*     */     private static boolean parseBoolArg(String[] param1ArrayOfString, int param1Int) throws ExcelExtractor.CommandParseException {
/* 154 */       if (param1Int >= param1ArrayOfString.length) {
/* 155 */         throw new ExcelExtractor.CommandParseException("Expected value after '" + param1ArrayOfString[param1Int - 1] + "'");
/*     */       }
/* 157 */       String str = param1ArrayOfString[param1Int].toUpperCase(Locale.ROOT);
/* 158 */       if ("Y".equals(str) || "YES".equals(str) || "ON".equals(str) || "TRUE".equals(str)) {
/* 159 */         return true;
/*     */       }
/* 161 */       if ("N".equals(str) || "NO".equals(str) || "OFF".equals(str) || "FALSE".equals(str)) {
/* 162 */         return false;
/*     */       }
/* 164 */       throw new ExcelExtractor.CommandParseException("Invalid value '" + param1ArrayOfString[param1Int] + "' for '" + param1ArrayOfString[param1Int - 1] + "'. Expected 'Y' or 'N'");
/*     */     }
/*     */     public boolean isRequestHelp() {
/* 167 */       return this._requestHelp;
/*     */     }
/*     */     public File getInputFile() {
/* 170 */       return this._inputFile;
/*     */     }
/*     */     public boolean shouldShowSheetNames() {
/* 173 */       return this._showSheetNames;
/*     */     }
/*     */     public boolean shouldEvaluateFormulas() {
/* 176 */       return this._evaluateFormulas;
/*     */     }
/*     */     public boolean shouldShowCellComments() {
/* 179 */       return this._showCellComments;
/*     */     }
/*     */     public boolean shouldShowBlankCells() {
/* 182 */       return this._showBlankCells;
/*     */     }
/*     */     public boolean shouldIncludeHeadersFooters() {
/* 185 */       return this._headersFooters;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static void printUsageMessage(PrintStream paramPrintStream) {
/* 190 */     paramPrintStream.println("Use:");
/* 191 */     paramPrintStream.println("    " + ExcelExtractor.class.getName() + " [<flag> <value> [<flag> <value> [...]]] [-i <filename.xls>]");
/* 192 */     paramPrintStream.println("       -i <filename.xls> specifies input file (default is to use stdin)");
/* 193 */     paramPrintStream.println("       Flags can be set on or off by using the values 'Y' or 'N'.");
/* 194 */     paramPrintStream.println("       Following are available flags and their default values:");
/* 195 */     paramPrintStream.println("       --show-sheet-names  Y");
/* 196 */     paramPrintStream.println("       --evaluate-formulas Y");
/* 197 */     paramPrintStream.println("       --show-comments     N");
/* 198 */     paramPrintStream.println("       --show-blanks       Y");
/* 199 */     paramPrintStream.println("       --headers-footers   Y");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*     */     CommandArgs commandArgs;
/*     */     InputStream inputStream;
/*     */     try {
/* 213 */       commandArgs = new CommandArgs(paramArrayOfString);
/* 214 */     } catch (CommandParseException commandParseException) {
/* 215 */       System.err.println(commandParseException.getMessage());
/* 216 */       printUsageMessage(System.err);
/* 217 */       System.exit(1);
/*     */       
/*     */       return;
/*     */     } 
/* 221 */     if (commandArgs.isRequestHelp()) {
/* 222 */       printUsageMessage(System.out);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 227 */     if (commandArgs.getInputFile() == null) {
/* 228 */       inputStream = System.in;
/*     */     } else {
/* 230 */       inputStream = new FileInputStream(commandArgs.getInputFile());
/*     */     } 
/* 232 */     HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(inputStream);
/* 233 */     inputStream.close();
/*     */     
/* 235 */     ExcelExtractor excelExtractor = new ExcelExtractor(hSSFWorkbook);
/* 236 */     excelExtractor.setIncludeSheetNames(commandArgs.shouldShowSheetNames());
/* 237 */     excelExtractor.setFormulasNotResults(!commandArgs.shouldEvaluateFormulas());
/* 238 */     excelExtractor.setIncludeCellComments(commandArgs.shouldShowCellComments());
/* 239 */     excelExtractor.setIncludeBlankCells(commandArgs.shouldShowBlankCells());
/* 240 */     excelExtractor.setIncludeHeadersFooters(commandArgs.shouldIncludeHeadersFooters());
/* 241 */     System.out.println(excelExtractor.getText());
/* 242 */     excelExtractor.close();
/* 243 */     hSSFWorkbook.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIncludeSheetNames(boolean paramBoolean) {
/* 248 */     this._includeSheetNames = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFormulasNotResults(boolean paramBoolean) {
/* 253 */     this._shouldEvaluateFormulas = !paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIncludeCellComments(boolean paramBoolean) {
/* 258 */     this._includeCellComments = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeBlankCells(boolean paramBoolean) {
/* 269 */     this._includeBlankCells = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIncludeHeadersFooters(boolean paramBoolean) {
/* 274 */     this._includeHeadersFooters = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText() {
/* 279 */     StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */ 
/*     */     
/* 283 */     this._wb.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
/*     */ 
/*     */     
/* 286 */     for (byte b = 0; b < this._wb.getNumberOfSheets(); b++) {
/* 287 */       HSSFSheet hSSFSheet = this._wb.getSheetAt(b);
/* 288 */       if (hSSFSheet != null) {
/*     */         
/* 290 */         if (this._includeSheetNames) {
/* 291 */           String str = this._wb.getSheetName(b);
/* 292 */           if (str != null) {
/* 293 */             stringBuffer.append(str);
/* 294 */             stringBuffer.append("\n");
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 299 */         if (this._includeHeadersFooters) {
/* 300 */           stringBuffer.append(_extractHeaderFooter((HeaderFooter)hSSFSheet.getHeader()));
/*     */         }
/*     */         
/* 303 */         int i = hSSFSheet.getFirstRowNum();
/* 304 */         int j = hSSFSheet.getLastRowNum();
/* 305 */         for (int k = i; k <= j; k++) {
/* 306 */           HSSFRow hSSFRow = hSSFSheet.getRow(k);
/* 307 */           if (hSSFRow != null) {
/*     */ 
/*     */             
/* 310 */             short s1 = hSSFRow.getFirstCellNum();
/* 311 */             short s2 = hSSFRow.getLastCellNum();
/* 312 */             if (this._includeBlankCells) {
/* 313 */               s1 = 0;
/*     */             }
/*     */             
/* 316 */             for (short s = s1; s < s2; s++) {
/* 317 */               HSSFCell hSSFCell = hSSFRow.getCell(s);
/* 318 */               boolean bool = true;
/*     */               
/* 320 */               if (hSSFCell == null) {
/*     */                 
/* 322 */                 bool = this._includeBlankCells;
/*     */               } else {
/* 324 */                 HSSFRichTextString hSSFRichTextString; HSSFCellStyle hSSFCellStyle; double d; short s3; String str; switch (hSSFCell.getCellTypeEnum()) {
/*     */                   case STRING:
/* 326 */                     stringBuffer.append(hSSFCell.getRichStringCellValue().getString());
/*     */                     break;
/*     */                   case NUMERIC:
/* 329 */                     stringBuffer.append(this._formatter.formatCellValue((Cell)hSSFCell));
/*     */                     break;
/*     */                   case BOOLEAN:
/* 332 */                     stringBuffer.append(hSSFCell.getBooleanCellValue());
/*     */                     break;
/*     */                   case ERROR:
/* 335 */                     stringBuffer.append(ErrorEval.getText(hSSFCell.getErrorCellValue()));
/*     */                     break;
/*     */                   case FORMULA:
/* 338 */                     if (!this._shouldEvaluateFormulas) {
/* 339 */                       stringBuffer.append(hSSFCell.getCellFormula()); break;
/*     */                     } 
/* 341 */                     switch (hSSFCell.getCachedFormulaResultTypeEnum()) {
/*     */                       case STRING:
/* 343 */                         hSSFRichTextString = hSSFCell.getRichStringCellValue();
/* 344 */                         if (hSSFRichTextString != null && hSSFRichTextString.length() > 0) {
/* 345 */                           stringBuffer.append(hSSFRichTextString.toString());
/*     */                         }
/*     */                         break;
/*     */                       case NUMERIC:
/* 349 */                         hSSFCellStyle = hSSFCell.getCellStyle();
/* 350 */                         d = hSSFCell.getNumericCellValue();
/* 351 */                         s3 = hSSFCellStyle.getDataFormat();
/* 352 */                         str = hSSFCellStyle.getDataFormatString();
/* 353 */                         stringBuffer.append(this._formatter.formatRawCellContents(d, s3, str));
/*     */                         break;
/*     */                       case BOOLEAN:
/* 356 */                         stringBuffer.append(hSSFCell.getBooleanCellValue());
/*     */                         break;
/*     */                       case ERROR:
/* 359 */                         stringBuffer.append(ErrorEval.getText(hSSFCell.getErrorCellValue()));
/*     */                         break;
/*     */                     } 
/* 362 */                     throw new IllegalStateException("Unexpected cell cached formula result type: " + hSSFCell.getCachedFormulaResultTypeEnum());
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   default:
/* 368 */                     throw new RuntimeException("Unexpected cell type (" + hSSFCell.getCellTypeEnum() + ")");
/*     */                 } 
/*     */ 
/*     */                 
/* 372 */                 HSSFComment hSSFComment = hSSFCell.getCellComment();
/* 373 */                 if (this._includeCellComments && hSSFComment != null) {
/*     */ 
/*     */                   
/* 376 */                   String str1 = hSSFComment.getString().getString().replace('\n', ' ');
/* 377 */                   stringBuffer.append(" Comment by " + hSSFComment.getAuthor() + ": " + str1);
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 382 */               if (bool && s < s2 - 1) {
/* 383 */                 stringBuffer.append("\t");
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 388 */             stringBuffer.append("\n");
/*     */           } 
/*     */         } 
/*     */         
/* 392 */         if (this._includeHeadersFooters) {
/* 393 */           stringBuffer.append(_extractHeaderFooter((HeaderFooter)hSSFSheet.getFooter()));
/*     */         }
/*     */       } 
/*     */     } 
/* 397 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public static String _extractHeaderFooter(HeaderFooter paramHeaderFooter) {
/* 401 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 403 */     if (paramHeaderFooter.getLeft() != null) {
/* 404 */       stringBuffer.append(paramHeaderFooter.getLeft());
/*     */     }
/* 406 */     if (paramHeaderFooter.getCenter() != null) {
/* 407 */       if (stringBuffer.length() > 0)
/* 408 */         stringBuffer.append("\t"); 
/* 409 */       stringBuffer.append(paramHeaderFooter.getCenter());
/*     */     } 
/* 411 */     if (paramHeaderFooter.getRight() != null) {
/* 412 */       if (stringBuffer.length() > 0)
/* 413 */         stringBuffer.append("\t"); 
/* 414 */       stringBuffer.append(paramHeaderFooter.getRight());
/*     */     } 
/* 416 */     if (stringBuffer.length() > 0) {
/* 417 */       stringBuffer.append("\n");
/*     */     }
/* 419 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\extractor\ExcelExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */