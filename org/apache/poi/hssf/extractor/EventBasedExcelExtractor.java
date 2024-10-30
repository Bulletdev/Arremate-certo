/*     */ package org.apache.poi.hssf.extractor;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIDocument;
/*     */ import org.apache.poi.POIOLE2TextExtractor;
/*     */ import org.apache.poi.hpsf.DocumentSummaryInformation;
/*     */ import org.apache.poi.hpsf.SummaryInformation;
/*     */ import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
/*     */ import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
/*     */ import org.apache.poi.hssf.eventusermodel.HSSFListener;
/*     */ import org.apache.poi.hssf.eventusermodel.HSSFRequest;
/*     */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*     */ import org.apache.poi.hssf.record.BOFRecord;
/*     */ import org.apache.poi.hssf.record.BoundSheetRecord;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.LabelRecord;
/*     */ import org.apache.poi.hssf.record.LabelSSTRecord;
/*     */ import org.apache.poi.hssf.record.NoteRecord;
/*     */ import org.apache.poi.hssf.record.NumberRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.SSTRecord;
/*     */ import org.apache.poi.hssf.record.StringRecord;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.ss.extractor.ExcelExtractor;
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
/*     */ public class EventBasedExcelExtractor
/*     */   extends POIOLE2TextExtractor
/*     */   implements ExcelExtractor
/*     */ {
/*     */   private DirectoryNode _dir;
/*     */   boolean _includeSheetNames = true;
/*     */   boolean _formulasNotResults = false;
/*     */   
/*     */   public EventBasedExcelExtractor(DirectoryNode paramDirectoryNode) {
/*  70 */     super((POIDocument)null);
/*  71 */     this._dir = paramDirectoryNode;
/*     */   }
/*     */   
/*     */   public EventBasedExcelExtractor(POIFSFileSystem paramPOIFSFileSystem) {
/*  75 */     this(paramPOIFSFileSystem.getRoot());
/*  76 */     setFilesystem((Closeable)paramPOIFSFileSystem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentSummaryInformation getDocSummaryInformation() {
/*  84 */     throw new IllegalStateException("Metadata extraction not supported in streaming mode, please use ExcelExtractor");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SummaryInformation getSummaryInformation() {
/*  91 */     throw new IllegalStateException("Metadata extraction not supported in streaming mode, please use ExcelExtractor");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeCellComments(boolean paramBoolean) {
/* 100 */     throw new IllegalStateException("Comment extraction not supported in streaming mode, please use ExcelExtractor");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeHeadersFooters(boolean paramBoolean) {
/* 108 */     throw new IllegalStateException("Header/Footer extraction not supported in streaming mode, please use ExcelExtractor");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeSheetNames(boolean paramBoolean) {
/* 116 */     this._includeSheetNames = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormulasNotResults(boolean paramBoolean) {
/* 123 */     this._formulasNotResults = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 131 */     String str = null;
/*     */     try {
/* 133 */       TextListener textListener = triggerExtraction();
/*     */       
/* 135 */       str = textListener._text.toString();
/* 136 */       if (!str.endsWith("\n")) {
/* 137 */         str = str + "\n";
/*     */       }
/* 139 */     } catch (IOException iOException) {
/* 140 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */     
/* 143 */     return str;
/*     */   }
/*     */   
/*     */   private TextListener triggerExtraction() throws IOException {
/* 147 */     TextListener textListener = new TextListener();
/* 148 */     FormatTrackingHSSFListener formatTrackingHSSFListener = new FormatTrackingHSSFListener(textListener);
/* 149 */     textListener._ft = formatTrackingHSSFListener;
/*     */ 
/*     */     
/* 152 */     HSSFEventFactory hSSFEventFactory = new HSSFEventFactory();
/* 153 */     HSSFRequest hSSFRequest = new HSSFRequest();
/* 154 */     hSSFRequest.addListenerForAllRecords((HSSFListener)formatTrackingHSSFListener);
/*     */     
/* 156 */     hSSFEventFactory.processWorkbookEvents(hSSFRequest, this._dir);
/*     */     
/* 158 */     return textListener;
/*     */   }
/*     */   
/*     */   private class TextListener
/*     */     implements HSSFListener {
/*     */     FormatTrackingHSSFListener _ft;
/*     */     private SSTRecord sstRecord;
/*     */     private final List<String> sheetNames;
/* 166 */     final StringBuffer _text = new StringBuffer();
/* 167 */     private int sheetNum = -1;
/*     */     
/*     */     private int rowNum;
/*     */     private boolean outputNextStringValue = false;
/* 171 */     private int nextRow = -1;
/*     */     
/*     */     public TextListener() {
/* 174 */       this.sheetNames = new ArrayList<String>(); } public void processRecord(Record param1Record) { BoundSheetRecord boundSheetRecord; BOFRecord bOFRecord; FormulaRecord formulaRecord; LabelRecord labelRecord; LabelSSTRecord labelSSTRecord;
/*     */       NoteRecord noteRecord;
/*     */       NumberRecord numberRecord;
/* 177 */       String str = null;
/* 178 */       int i = -1;
/*     */       
/* 180 */       switch (param1Record.getSid()) {
/*     */         case 133:
/* 182 */           boundSheetRecord = (BoundSheetRecord)param1Record;
/* 183 */           this.sheetNames.add(boundSheetRecord.getSheetname());
/*     */           break;
/*     */         case 2057:
/* 186 */           bOFRecord = (BOFRecord)param1Record;
/* 187 */           if (bOFRecord.getType() == 16) {
/* 188 */             this.sheetNum++;
/* 189 */             this.rowNum = -1;
/*     */             
/* 191 */             if (EventBasedExcelExtractor.this._includeSheetNames) {
/* 192 */               if (this._text.length() > 0) this._text.append("\n"); 
/* 193 */               this._text.append(this.sheetNames.get(this.sheetNum));
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 252:
/* 198 */           this.sstRecord = (SSTRecord)param1Record;
/*     */           break;
/*     */         
/*     */         case 6:
/* 202 */           formulaRecord = (FormulaRecord)param1Record;
/* 203 */           i = formulaRecord.getRow();
/*     */           
/* 205 */           if (EventBasedExcelExtractor.this._formulasNotResults) {
/* 206 */             str = HSSFFormulaParser.toFormulaString((HSSFWorkbook)null, formulaRecord.getParsedExpression()); break;
/*     */           } 
/* 208 */           if (formulaRecord.hasCachedResultString()) {
/*     */ 
/*     */             
/* 211 */             this.outputNextStringValue = true;
/* 212 */             this.nextRow = formulaRecord.getRow(); break;
/*     */           } 
/* 214 */           str = this._ft.formatNumberDateCell((CellValueRecordInterface)formulaRecord);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 519:
/* 219 */           if (this.outputNextStringValue) {
/*     */             
/* 221 */             StringRecord stringRecord = (StringRecord)param1Record;
/* 222 */             str = stringRecord.getString();
/* 223 */             i = this.nextRow;
/* 224 */             this.outputNextStringValue = false;
/*     */           } 
/*     */           break;
/*     */         case 516:
/* 228 */           labelRecord = (LabelRecord)param1Record;
/* 229 */           i = labelRecord.getRow();
/* 230 */           str = labelRecord.getValue();
/*     */           break;
/*     */         case 253:
/* 233 */           labelSSTRecord = (LabelSSTRecord)param1Record;
/* 234 */           i = labelSSTRecord.getRow();
/* 235 */           if (this.sstRecord == null) {
/* 236 */             throw new IllegalStateException("No SST record found");
/*     */           }
/* 238 */           str = this.sstRecord.getString(labelSSTRecord.getSSTIndex()).toString();
/*     */           break;
/*     */         case 28:
/* 241 */           noteRecord = (NoteRecord)param1Record;
/* 242 */           i = noteRecord.getRow();
/*     */           break;
/*     */         
/*     */         case 515:
/* 246 */           numberRecord = (NumberRecord)param1Record;
/* 247 */           i = numberRecord.getRow();
/* 248 */           str = this._ft.formatNumberDateCell((CellValueRecordInterface)numberRecord);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 254 */       if (str != null) {
/* 255 */         if (i != this.rowNum) {
/* 256 */           this.rowNum = i;
/* 257 */           if (this._text.length() > 0)
/* 258 */             this._text.append("\n"); 
/*     */         } else {
/* 260 */           this._text.append("\t");
/*     */         } 
/* 262 */         this._text.append(str);
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\extractor\EventBasedExcelExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */