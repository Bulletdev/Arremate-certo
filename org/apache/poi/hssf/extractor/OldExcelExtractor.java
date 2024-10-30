/*     */ package org.apache.poi.hssf.extractor;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.hssf.OldExcelFormatException;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.BOFRecord;
/*     */ import org.apache.poi.hssf.record.CodepageRecord;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.NumberRecord;
/*     */ import org.apache.poi.hssf.record.OldFormulaRecord;
/*     */ import org.apache.poi.hssf.record.OldLabelRecord;
/*     */ import org.apache.poi.hssf.record.OldSheetRecord;
/*     */ import org.apache.poi.hssf.record.OldStringRecord;
/*     */ import org.apache.poi.hssf.record.RKRecord;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentNode;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.NotOLE2FileException;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.util.IOUtils;
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
/*     */ public class OldExcelExtractor
/*     */   implements Closeable
/*     */ {
/*     */   private RecordInputStream ris;
/*     */   private Closeable toClose;
/*     */   private int biffVersion;
/*     */   private int fileType;
/*     */   
/*     */   public OldExcelExtractor(InputStream paramInputStream) throws IOException {
/*  69 */     open(paramInputStream);
/*     */   }
/*     */   
/*     */   public OldExcelExtractor(File paramFile) throws IOException {
/*  73 */     NPOIFSFileSystem nPOIFSFileSystem = null;
/*     */     try {
/*  75 */       nPOIFSFileSystem = new NPOIFSFileSystem(paramFile);
/*  76 */       open(nPOIFSFileSystem);
/*  77 */       this.toClose = (Closeable)nPOIFSFileSystem;
/*     */       return;
/*  79 */     } catch (OldExcelFormatException oldExcelFormatException) {
/*     */       
/*  81 */       if (nPOIFSFileSystem != null) {
/*  82 */         nPOIFSFileSystem.close();
/*     */       }
/*  84 */     } catch (NotOLE2FileException notOLE2FileException) {
/*     */       
/*  86 */       if (nPOIFSFileSystem != null) {
/*  87 */         nPOIFSFileSystem.close();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  92 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/*  94 */       open(fileInputStream);
/*  95 */     } catch (IOException iOException) {
/*     */ 
/*     */       
/*  98 */       fileInputStream.close();
/*  99 */       throw iOException;
/* 100 */     } catch (RuntimeException runtimeException) {
/*     */ 
/*     */       
/* 103 */       fileInputStream.close();
/* 104 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */   
/*     */   public OldExcelExtractor(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/* 109 */     open(paramNPOIFSFileSystem);
/*     */   }
/*     */   
/*     */   public OldExcelExtractor(DirectoryNode paramDirectoryNode) throws IOException {
/* 113 */     open(paramDirectoryNode);
/*     */   }
/*     */   
/*     */   private void open(InputStream paramInputStream) throws IOException {
/* 117 */     BufferedInputStream bufferedInputStream = (paramInputStream instanceof BufferedInputStream) ? (BufferedInputStream)paramInputStream : new BufferedInputStream(paramInputStream, 8);
/*     */ 
/*     */ 
/*     */     
/* 121 */     if (NPOIFSFileSystem.hasPOIFSHeader(bufferedInputStream)) {
/* 122 */       NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(bufferedInputStream);
/*     */       try {
/* 124 */         open(nPOIFSFileSystem);
/*     */       } finally {
/* 126 */         nPOIFSFileSystem.close();
/*     */       } 
/*     */     } else {
/* 129 */       this.ris = new RecordInputStream(bufferedInputStream);
/* 130 */       this.toClose = bufferedInputStream;
/* 131 */       prepare();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void open(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/* 136 */     open(paramNPOIFSFileSystem.getRoot());
/*     */   }
/*     */   
/*     */   private void open(DirectoryNode paramDirectoryNode) throws IOException {
/*     */     DocumentNode documentNode;
/*     */     try {
/* 142 */       documentNode = (DocumentNode)paramDirectoryNode.getEntry("Book");
/* 143 */     } catch (FileNotFoundException fileNotFoundException) {
/*     */       
/* 145 */       documentNode = (DocumentNode)paramDirectoryNode.getEntry(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES[0]);
/*     */     } 
/*     */     
/* 148 */     if (documentNode == null) {
/* 149 */       throw new IOException("No Excel 5/95 Book stream found");
/*     */     }
/*     */     
/* 152 */     this.ris = new RecordInputStream((InputStream)paramDirectoryNode.createDocumentInputStream((Entry)documentNode));
/* 153 */     prepare();
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/* 157 */     if (paramArrayOfString.length < 1) {
/* 158 */       System.err.println("Use:");
/* 159 */       System.err.println("   OldExcelExtractor <filename>");
/* 160 */       System.exit(1);
/*     */     } 
/* 162 */     OldExcelExtractor oldExcelExtractor = new OldExcelExtractor(new File(paramArrayOfString[0]));
/* 163 */     System.out.println(oldExcelExtractor.getText());
/* 164 */     oldExcelExtractor.close();
/*     */   }
/*     */   
/*     */   private void prepare() {
/* 168 */     if (!this.ris.hasNextRecord())
/* 169 */       throw new IllegalArgumentException("File contains no records!"); 
/* 170 */     this.ris.nextRecord();
/*     */ 
/*     */     
/* 173 */     short s = this.ris.getSid();
/* 174 */     switch (s) {
/*     */       case 9:
/* 176 */         this.biffVersion = 2;
/*     */         break;
/*     */       case 521:
/* 179 */         this.biffVersion = 3;
/*     */         break;
/*     */       case 1033:
/* 182 */         this.biffVersion = 4;
/*     */         break;
/*     */       case 2057:
/* 185 */         this.biffVersion = 5;
/*     */         break;
/*     */       default:
/* 188 */         throw new IllegalArgumentException("File does not begin with a BOF, found sid of " + s);
/*     */     } 
/*     */ 
/*     */     
/* 192 */     BOFRecord bOFRecord = new BOFRecord(this.ris);
/* 193 */     this.fileType = bOFRecord.getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBiffVersion() {
/* 202 */     return this.biffVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFileType() {
/* 213 */     return this.fileType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 223 */     StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */     
/* 226 */     CodepageRecord codepageRecord = null;
/*     */ 
/*     */ 
/*     */     
/* 230 */     while (this.ris.hasNextRecord()) {
/* 231 */       OldSheetRecord oldSheetRecord; OldLabelRecord oldLabelRecord; OldStringRecord oldStringRecord; NumberRecord numberRecord; OldFormulaRecord oldFormulaRecord; RKRecord rKRecord; int i = this.ris.getNextSid();
/* 232 */       this.ris.nextRecord();
/*     */       
/* 234 */       switch (i) {
/*     */         
/*     */         case 133:
/* 237 */           oldSheetRecord = new OldSheetRecord(this.ris);
/* 238 */           oldSheetRecord.setCodePage(codepageRecord);
/* 239 */           stringBuffer.append("Sheet: ");
/* 240 */           stringBuffer.append(oldSheetRecord.getSheetname());
/* 241 */           stringBuffer.append('\n');
/*     */           continue;
/*     */         
/*     */         case 4:
/*     */         case 516:
/* 246 */           oldLabelRecord = new OldLabelRecord(this.ris);
/* 247 */           oldLabelRecord.setCodePage(codepageRecord);
/* 248 */           stringBuffer.append(oldLabelRecord.getValue());
/* 249 */           stringBuffer.append('\n');
/*     */           continue;
/*     */         case 7:
/*     */         case 519:
/* 253 */           oldStringRecord = new OldStringRecord(this.ris);
/* 254 */           oldStringRecord.setCodePage(codepageRecord);
/* 255 */           stringBuffer.append(oldStringRecord.getString());
/* 256 */           stringBuffer.append('\n');
/*     */           continue;
/*     */         
/*     */         case 515:
/* 260 */           numberRecord = new NumberRecord(this.ris);
/* 261 */           handleNumericCell(stringBuffer, numberRecord.getValue());
/*     */           continue;
/*     */         
/*     */         case 6:
/*     */         case 518:
/*     */         case 1030:
/* 267 */           if (this.biffVersion == 5) {
/* 268 */             FormulaRecord formulaRecord = new FormulaRecord(this.ris);
/* 269 */             if (formulaRecord.getCachedResultType() == CellType.NUMERIC.getCode())
/* 270 */               handleNumericCell(stringBuffer, formulaRecord.getValue()); 
/*     */             continue;
/*     */           } 
/* 273 */           oldFormulaRecord = new OldFormulaRecord(this.ris);
/* 274 */           if (oldFormulaRecord.getCachedResultType() == CellType.NUMERIC.getCode()) {
/* 275 */             handleNumericCell(stringBuffer, oldFormulaRecord.getValue());
/*     */           }
/*     */           continue;
/*     */         
/*     */         case 638:
/* 280 */           rKRecord = new RKRecord(this.ris);
/* 281 */           handleNumericCell(stringBuffer, rKRecord.getRKNumber());
/*     */           continue;
/*     */         
/*     */         case 66:
/* 285 */           codepageRecord = new CodepageRecord(this.ris);
/*     */           continue;
/*     */       } 
/*     */       
/* 289 */       this.ris.readFully(new byte[this.ris.remaining()]);
/*     */     } 
/*     */ 
/*     */     
/* 293 */     close();
/* 294 */     this.ris = null;
/*     */     
/* 296 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 302 */     if (this.toClose != null) {
/* 303 */       IOUtils.closeQuietly(this.toClose);
/* 304 */       this.toClose = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void handleNumericCell(StringBuffer paramStringBuffer, double paramDouble) {
/* 310 */     paramStringBuffer.append(paramDouble);
/* 311 */     paramStringBuffer.append('\n');
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\extractor\OldExcelExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */