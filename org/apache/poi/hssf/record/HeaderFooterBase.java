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
/*     */ public abstract class HeaderFooterBase
/*     */   extends StandardRecord
/*     */ {
/*     */   private boolean field_2_hasMultibyte;
/*     */   private String field_3_text;
/*     */   
/*     */   protected HeaderFooterBase(String paramString) {
/*  33 */     setText(paramString);
/*     */   }
/*     */   
/*     */   protected HeaderFooterBase(RecordInputStream paramRecordInputStream) {
/*  37 */     if (paramRecordInputStream.remaining() > 0) {
/*  38 */       short s = paramRecordInputStream.readShort();
/*  39 */       this.field_2_hasMultibyte = (paramRecordInputStream.readByte() != 0);
/*     */       
/*  41 */       if (this.field_2_hasMultibyte) {
/*  42 */         this.field_3_text = paramRecordInputStream.readUnicodeLEString(s);
/*     */       } else {
/*  44 */         this.field_3_text = paramRecordInputStream.readCompressedUnicode(s);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  49 */       this.field_3_text = "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setText(String paramString) {
/*  59 */     if (paramString == null) {
/*  60 */       throw new IllegalArgumentException("text must not be null");
/*     */     }
/*  62 */     this.field_2_hasMultibyte = StringUtil.hasMultibyte(paramString);
/*  63 */     this.field_3_text = paramString;
/*     */ 
/*     */     
/*  66 */     if (getDataSize() > 8224) {
/*  67 */       throw new IllegalArgumentException("Header/Footer string too long (limit is 8224 bytes)");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getTextLength() {
/*  78 */     return this.field_3_text.length();
/*     */   }
/*     */   
/*     */   public final String getText() {
/*  82 */     return this.field_3_text;
/*     */   }
/*     */   
/*     */   public final void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  86 */     if (getTextLength() > 0) {
/*  87 */       paramLittleEndianOutput.writeShort(getTextLength());
/*  88 */       paramLittleEndianOutput.writeByte(this.field_2_hasMultibyte ? 1 : 0);
/*  89 */       if (this.field_2_hasMultibyte) {
/*  90 */         StringUtil.putUnicodeLE(this.field_3_text, paramLittleEndianOutput);
/*     */       } else {
/*  92 */         StringUtil.putCompressedUnicode(this.field_3_text, paramLittleEndianOutput);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final int getDataSize() {
/*  98 */     if (getTextLength() < 1) {
/*  99 */       return 0;
/*     */     }
/* 101 */     return 3 + getTextLength() * (this.field_2_hasMultibyte ? 2 : 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HeaderFooterBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */