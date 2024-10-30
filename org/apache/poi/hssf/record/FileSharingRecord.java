/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class FileSharingRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 91;
/*     */   private short field_1_readonly;
/*     */   private short field_2_password;
/*     */   private byte field_3_username_unicode_options;
/*     */   private String field_3_username_value;
/*     */   
/*     */   public FileSharingRecord() {}
/*     */   
/*     */   public FileSharingRecord(RecordInputStream paramRecordInputStream) {
/*  40 */     this.field_1_readonly = paramRecordInputStream.readShort();
/*  41 */     this.field_2_password = paramRecordInputStream.readShort();
/*     */     
/*  43 */     short s = paramRecordInputStream.readShort();
/*     */     
/*  45 */     if (s > 0) {
/*     */       
/*  47 */       this.field_3_username_unicode_options = paramRecordInputStream.readByte();
/*  48 */       this.field_3_username_value = paramRecordInputStream.readCompressedUnicode(s);
/*     */     } else {
/*  50 */       this.field_3_username_value = "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(short paramShort) {
/*  60 */     this.field_1_readonly = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getReadOnly() {
/*  69 */     return this.field_1_readonly;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(short paramShort) {
/*  76 */     this.field_2_password = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPassword() {
/*  83 */     return this.field_2_password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsername() {
/*  91 */     return this.field_3_username_value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsername(String paramString) {
/*  98 */     this.field_3_username_value = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 105 */     stringBuffer.append("[FILESHARING]\n");
/* 106 */     stringBuffer.append("    .readonly       = ").append((getReadOnly() == 1) ? "true" : "false").append("\n");
/*     */     
/* 108 */     stringBuffer.append("    .password       = ").append(Integer.toHexString(getPassword())).append("\n");
/*     */     
/* 110 */     stringBuffer.append("    .username       = ").append(getUsername()).append("\n");
/*     */     
/* 112 */     stringBuffer.append("[/FILESHARING]\n");
/* 113 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 118 */     paramLittleEndianOutput.writeShort(getReadOnly());
/* 119 */     paramLittleEndianOutput.writeShort(getPassword());
/* 120 */     paramLittleEndianOutput.writeShort(this.field_3_username_value.length());
/* 121 */     if (this.field_3_username_value.length() > 0) {
/* 122 */       paramLittleEndianOutput.writeByte(this.field_3_username_unicode_options);
/* 123 */       StringUtil.putCompressedUnicode(getUsername(), paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 128 */     int i = this.field_3_username_value.length();
/* 129 */     if (i < 1) {
/* 130 */       return 6;
/*     */     }
/* 132 */     return 7 + i;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 136 */     return 91;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSharingRecord clone() {
/* 141 */     FileSharingRecord fileSharingRecord = new FileSharingRecord();
/* 142 */     fileSharingRecord.setReadOnly(this.field_1_readonly);
/* 143 */     fileSharingRecord.setPassword(this.field_2_password);
/* 144 */     fileSharingRecord.setUsername(this.field_3_username_value);
/* 145 */     return fileSharingRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FileSharingRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */