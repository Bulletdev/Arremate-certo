/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public final class WriteAccessRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 92;
/*     */   private static final byte PAD_CHAR = 32;
/*     */   private static final int DATA_SIZE = 112;
/*     */   private String field_1_username;
/*  41 */   private static final byte[] PADDING = new byte[112];
/*     */   static {
/*  43 */     Arrays.fill(PADDING, (byte)32);
/*     */   }
/*     */   
/*     */   public WriteAccessRecord() {
/*  47 */     setUsername("");
/*     */   }
/*     */   public WriteAccessRecord(RecordInputStream paramRecordInputStream) {
/*     */     String str;
/*  51 */     if (paramRecordInputStream.remaining() > 112) {
/*  52 */       throw new RecordFormatException("Expected data size (112) but got (" + paramRecordInputStream.remaining() + ")");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     int i = paramRecordInputStream.readUShort();
/*  59 */     int j = paramRecordInputStream.readUByte();
/*  60 */     if (i > 112 || (j & 0xFE) != 0) {
/*     */ 
/*     */ 
/*     */       
/*  64 */       byte[] arrayOfByte = new byte[3 + paramRecordInputStream.remaining()];
/*  65 */       LittleEndian.putUShort(arrayOfByte, 0, i);
/*  66 */       LittleEndian.putByte(arrayOfByte, 2, j);
/*  67 */       paramRecordInputStream.readFully(arrayOfByte, 3, arrayOfByte.length - 3);
/*  68 */       String str1 = new String(arrayOfByte, StringUtil.UTF8);
/*  69 */       setUsername(str1.trim());
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  74 */     if ((j & 0x1) == 0) {
/*  75 */       str = StringUtil.readCompressedUnicode(paramRecordInputStream, i);
/*     */     } else {
/*  77 */       str = StringUtil.readUnicodeLE(paramRecordInputStream, i);
/*     */     } 
/*  79 */     this.field_1_username = str.trim();
/*     */ 
/*     */     
/*  82 */     int k = paramRecordInputStream.remaining();
/*  83 */     while (k > 0) {
/*     */       
/*  85 */       paramRecordInputStream.readUByte();
/*  86 */       k--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsername(String paramString) {
/*  97 */     boolean bool = StringUtil.hasMultibyte(paramString);
/*  98 */     int i = 3 + paramString.length() * (bool ? 2 : 1);
/*  99 */     int j = 112 - i;
/* 100 */     if (j < 0) {
/* 101 */       throw new IllegalArgumentException("Name is too long: " + paramString);
/*     */     }
/*     */     
/* 104 */     this.field_1_username = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsername() {
/* 115 */     return this.field_1_username;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 121 */     stringBuffer.append("[WRITEACCESS]\n");
/* 122 */     stringBuffer.append("    .name = ").append(this.field_1_username).append("\n");
/* 123 */     stringBuffer.append("[/WRITEACCESS]\n");
/* 124 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 128 */     String str = getUsername();
/* 129 */     boolean bool = StringUtil.hasMultibyte(str);
/*     */     
/* 131 */     paramLittleEndianOutput.writeShort(str.length());
/* 132 */     paramLittleEndianOutput.writeByte(bool ? 1 : 0);
/* 133 */     if (bool) {
/* 134 */       StringUtil.putUnicodeLE(str, paramLittleEndianOutput);
/*     */     } else {
/* 136 */       StringUtil.putCompressedUnicode(str, paramLittleEndianOutput);
/*     */     } 
/* 138 */     int i = 3 + str.length() * (bool ? 2 : 1);
/* 139 */     int j = 112 - i;
/* 140 */     paramLittleEndianOutput.write(PADDING, 0, j);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 144 */     return 112;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 148 */     return 92;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\WriteAccessRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */