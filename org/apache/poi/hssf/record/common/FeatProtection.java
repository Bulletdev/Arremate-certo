/*     */ package org.apache.poi.hssf.record.common;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FeatProtection
/*     */   implements SharedFeature
/*     */ {
/*  37 */   public static long NO_SELF_RELATIVE_SECURITY_FEATURE = 0L;
/*  38 */   public static long HAS_SELF_RELATIVE_SECURITY_FEATURE = 1L;
/*     */ 
/*     */   
/*     */   private int fSD;
/*     */ 
/*     */   
/*     */   private int passwordVerifier;
/*     */ 
/*     */   
/*     */   private String title;
/*     */ 
/*     */   
/*     */   private byte[] securityDescriptor;
/*     */ 
/*     */   
/*     */   public FeatProtection() {
/*  54 */     this.securityDescriptor = new byte[0];
/*     */   }
/*     */   
/*     */   public FeatProtection(RecordInputStream paramRecordInputStream) {
/*  58 */     this.fSD = paramRecordInputStream.readInt();
/*  59 */     this.passwordVerifier = paramRecordInputStream.readInt();
/*     */     
/*  61 */     this.title = StringUtil.readUnicodeString((LittleEndianInput)paramRecordInputStream);
/*     */     
/*  63 */     this.securityDescriptor = paramRecordInputStream.readRemainder();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  67 */     StringBuffer stringBuffer = new StringBuffer();
/*  68 */     stringBuffer.append(" [FEATURE PROTECTION]\n");
/*  69 */     stringBuffer.append("   Self Relative = " + this.fSD);
/*  70 */     stringBuffer.append("   Password Verifier = " + this.passwordVerifier);
/*  71 */     stringBuffer.append("   Title = " + this.title);
/*  72 */     stringBuffer.append("   Security Descriptor Size = " + this.securityDescriptor.length);
/*  73 */     stringBuffer.append(" [/FEATURE PROTECTION]\n");
/*  74 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  78 */     paramLittleEndianOutput.writeInt(this.fSD);
/*  79 */     paramLittleEndianOutput.writeInt(this.passwordVerifier);
/*  80 */     StringUtil.writeUnicodeString(paramLittleEndianOutput, this.title);
/*  81 */     paramLittleEndianOutput.write(this.securityDescriptor);
/*     */   }
/*     */   
/*     */   public int getDataSize() {
/*  85 */     return 8 + StringUtil.getEncodedSize(this.title) + this.securityDescriptor.length;
/*     */   }
/*     */   
/*     */   public int getPasswordVerifier() {
/*  89 */     return this.passwordVerifier;
/*     */   }
/*     */   public void setPasswordVerifier(int paramInt) {
/*  92 */     this.passwordVerifier = paramInt;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  96 */     return this.title;
/*     */   }
/*     */   public void setTitle(String paramString) {
/*  99 */     this.title = paramString;
/*     */   }
/*     */   
/*     */   public int getFSD() {
/* 103 */     return this.fSD;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\FeatProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */