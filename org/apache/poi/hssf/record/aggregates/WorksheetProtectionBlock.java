/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.ObjectProtectRecord;
/*     */ import org.apache.poi.hssf.record.PasswordRecord;
/*     */ import org.apache.poi.hssf.record.ProtectRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFormatException;
/*     */ import org.apache.poi.hssf.record.ScenarioProtectRecord;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
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
/*     */ public final class WorksheetProtectionBlock
/*     */   extends RecordAggregate
/*     */ {
/*     */   private ProtectRecord _protectRecord;
/*     */   private ObjectProtectRecord _objectProtectRecord;
/*     */   private ScenarioProtectRecord _scenarioProtectRecord;
/*     */   private PasswordRecord _passwordRecord;
/*     */   
/*     */   public static boolean isComponentRecord(int paramInt) {
/*  58 */     switch (paramInt) {
/*     */       case 18:
/*     */       case 19:
/*     */       case 99:
/*     */       case 221:
/*  63 */         return true;
/*     */     } 
/*  65 */     return false;
/*     */   }
/*     */   
/*     */   private boolean readARecord(RecordStream paramRecordStream) {
/*  69 */     switch (paramRecordStream.peekNextSid()) {
/*     */       case 18:
/*  71 */         checkNotPresent((Record)this._protectRecord);
/*  72 */         this._protectRecord = (ProtectRecord)paramRecordStream.getNext();
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
/*  90 */         return true;case 99: checkNotPresent((Record)this._objectProtectRecord); this._objectProtectRecord = (ObjectProtectRecord)paramRecordStream.getNext(); return true;case 221: checkNotPresent((Record)this._scenarioProtectRecord); this._scenarioProtectRecord = (ScenarioProtectRecord)paramRecordStream.getNext(); return true;case 19: checkNotPresent((Record)this._passwordRecord); this._passwordRecord = (PasswordRecord)paramRecordStream.getNext(); return true;
/*     */     } 
/*     */     return false;
/*     */   } private void checkNotPresent(Record paramRecord) {
/*  94 */     if (paramRecord != null) {
/*  95 */       throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(paramRecord.getSid()) + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 103 */     visitIfPresent((Record)this._protectRecord, paramRecordVisitor);
/* 104 */     visitIfPresent((Record)this._objectProtectRecord, paramRecordVisitor);
/* 105 */     visitIfPresent((Record)this._scenarioProtectRecord, paramRecordVisitor);
/* 106 */     visitIfPresent((Record)this._passwordRecord, paramRecordVisitor);
/*     */   }
/*     */   
/*     */   private static void visitIfPresent(Record paramRecord, RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 110 */     if (paramRecord != null) {
/* 111 */       paramRecordVisitor.visitRecord(paramRecord);
/*     */     }
/*     */   }
/*     */   
/*     */   public PasswordRecord getPasswordRecord() {
/* 116 */     return this._passwordRecord;
/*     */   }
/*     */   
/*     */   public ScenarioProtectRecord getHCenter() {
/* 120 */     return this._scenarioProtectRecord;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRecords(RecordStream paramRecordStream) {
/*     */     do {
/*     */     
/* 141 */     } while (readARecord(paramRecordStream));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ProtectRecord getProtect() {
/* 152 */     if (this._protectRecord == null) {
/* 153 */       this._protectRecord = new ProtectRecord(false);
/*     */     }
/* 155 */     return this._protectRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PasswordRecord getPassword() {
/* 163 */     if (this._passwordRecord == null) {
/* 164 */       this._passwordRecord = createPassword();
/*     */     }
/* 166 */     return this._passwordRecord;
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
/*     */   public void protectSheet(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 179 */     if (paramString == null) {
/* 180 */       this._passwordRecord = null;
/* 181 */       this._protectRecord = null;
/* 182 */       this._objectProtectRecord = null;
/* 183 */       this._scenarioProtectRecord = null;
/*     */       
/*     */       return;
/*     */     } 
/* 187 */     ProtectRecord protectRecord = getProtect();
/* 188 */     PasswordRecord passwordRecord = getPassword();
/* 189 */     protectRecord.setProtect(true);
/* 190 */     passwordRecord.setPassword((short)CryptoFunctions.createXorVerifier1(paramString));
/* 191 */     if (this._objectProtectRecord == null && paramBoolean1) {
/* 192 */       ObjectProtectRecord objectProtectRecord = createObjectProtect();
/* 193 */       objectProtectRecord.setProtect(true);
/* 194 */       this._objectProtectRecord = objectProtectRecord;
/*     */     } 
/* 196 */     if (this._scenarioProtectRecord == null && paramBoolean2) {
/* 197 */       ScenarioProtectRecord scenarioProtectRecord = createScenarioProtect();
/* 198 */       scenarioProtectRecord.setProtect(true);
/* 199 */       this._scenarioProtectRecord = scenarioProtectRecord;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSheetProtected() {
/* 204 */     return (this._protectRecord != null && this._protectRecord.getProtect());
/*     */   }
/*     */   
/*     */   public boolean isObjectProtected() {
/* 208 */     return (this._objectProtectRecord != null && this._objectProtectRecord.getProtect());
/*     */   }
/*     */   
/*     */   public boolean isScenarioProtected() {
/* 212 */     return (this._scenarioProtectRecord != null && this._scenarioProtectRecord.getProtect());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ObjectProtectRecord createObjectProtect() {
/* 219 */     ObjectProtectRecord objectProtectRecord = new ObjectProtectRecord();
/* 220 */     objectProtectRecord.setProtect(false);
/* 221 */     return objectProtectRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ScenarioProtectRecord createScenarioProtect() {
/* 228 */     ScenarioProtectRecord scenarioProtectRecord = new ScenarioProtectRecord();
/* 229 */     scenarioProtectRecord.setProtect(false);
/* 230 */     return scenarioProtectRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PasswordRecord createPassword() {
/* 237 */     return new PasswordRecord(0);
/*     */   }
/*     */   
/*     */   public int getPasswordHash() {
/* 241 */     if (this._passwordRecord == null) {
/* 242 */       return 0;
/*     */     }
/* 244 */     return this._passwordRecord.getPassword();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\WorksheetProtectionBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */