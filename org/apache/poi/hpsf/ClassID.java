/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public class ClassID
/*     */ {
/*  31 */   public static final ClassID OLE10_PACKAGE = new ClassID("{0003000C-0000-0000-C000-000000000046}");
/*  32 */   public static final ClassID PPT_SHOW = new ClassID("{64818D10-4F9B-11CF-86EA-00AA00B929E8}");
/*  33 */   public static final ClassID XLS_WORKBOOK = new ClassID("{00020841-0000-0000-C000-000000000046}");
/*  34 */   public static final ClassID TXT_ONLY = new ClassID("{5e941d80-bf96-11cd-b579-08002b30bfeb}");
/*  35 */   public static final ClassID EXCEL97 = new ClassID("{00020820-0000-0000-C000-000000000046}");
/*  36 */   public static final ClassID EXCEL95 = new ClassID("{00020810-0000-0000-C000-000000000046}");
/*  37 */   public static final ClassID WORD97 = new ClassID("{00020906-0000-0000-C000-000000000046}");
/*  38 */   public static final ClassID WORD95 = new ClassID("{00020900-0000-0000-C000-000000000046}");
/*  39 */   public static final ClassID POWERPOINT97 = new ClassID("{64818D10-4F9B-11CF-86EA-00AA00B929E8}");
/*  40 */   public static final ClassID POWERPOINT95 = new ClassID("{EA7BAE70-FB3B-11CD-A903-00AA00510EA3}");
/*  41 */   public static final ClassID EQUATION30 = new ClassID("{0002CE02-0000-0000-C000-000000000046}");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] bytes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int LENGTH = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassID(byte[] paramArrayOfbyte, int paramInt) {
/*  61 */     read(paramArrayOfbyte, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassID() {
/*  71 */     this.bytes = new byte[16];
/*  72 */     for (byte b = 0; b < 16; b++) {
/*  73 */       this.bytes[b] = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassID(String paramString) {
/*  84 */     this.bytes = new byte[16];
/*  85 */     String str = paramString.replaceAll("[{}-]", "");
/*  86 */     for (byte b = 0; b < str.length(); b += 2) {
/*  87 */       this.bytes[b / 2] = (byte)Integer.parseInt(str.substring(b, b + 2), 16);
/*     */     }
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
/*     */   public int length() {
/* 102 */     return 16;
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
/*     */   public byte[] getBytes() {
/* 115 */     return this.bytes;
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
/*     */   public void setBytes(byte[] paramArrayOfbyte) {
/* 128 */     for (byte b = 0; b < this.bytes.length; b++) {
/* 129 */       this.bytes[b] = paramArrayOfbyte[b];
/*     */     }
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
/*     */   public byte[] read(byte[] paramArrayOfbyte, int paramInt) {
/* 146 */     this.bytes = new byte[16];
/*     */ 
/*     */     
/* 149 */     this.bytes[0] = paramArrayOfbyte[3 + paramInt];
/* 150 */     this.bytes[1] = paramArrayOfbyte[2 + paramInt];
/* 151 */     this.bytes[2] = paramArrayOfbyte[1 + paramInt];
/* 152 */     this.bytes[3] = paramArrayOfbyte[0 + paramInt];
/*     */ 
/*     */     
/* 155 */     this.bytes[4] = paramArrayOfbyte[5 + paramInt];
/* 156 */     this.bytes[5] = paramArrayOfbyte[4 + paramInt];
/*     */ 
/*     */     
/* 159 */     this.bytes[6] = paramArrayOfbyte[7 + paramInt];
/* 160 */     this.bytes[7] = paramArrayOfbyte[6 + paramInt];
/*     */ 
/*     */     
/* 163 */     for (byte b = 8; b < 16; b++) {
/* 164 */       this.bytes[b] = paramArrayOfbyte[b + paramInt];
/*     */     }
/* 166 */     return this.bytes;
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
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt) throws ArrayStoreException {
/* 186 */     if (paramArrayOfbyte.length < 16) {
/* 187 */       throw new ArrayStoreException("Destination byte[] must have room for at least 16 bytes, but has a length of only " + paramArrayOfbyte.length + ".");
/*     */     }
/*     */ 
/*     */     
/* 191 */     paramArrayOfbyte[0 + paramInt] = this.bytes[3];
/* 192 */     paramArrayOfbyte[1 + paramInt] = this.bytes[2];
/* 193 */     paramArrayOfbyte[2 + paramInt] = this.bytes[1];
/* 194 */     paramArrayOfbyte[3 + paramInt] = this.bytes[0];
/*     */ 
/*     */     
/* 197 */     paramArrayOfbyte[4 + paramInt] = this.bytes[5];
/* 198 */     paramArrayOfbyte[5 + paramInt] = this.bytes[4];
/*     */ 
/*     */     
/* 201 */     paramArrayOfbyte[6 + paramInt] = this.bytes[7];
/* 202 */     paramArrayOfbyte[7 + paramInt] = this.bytes[6];
/*     */ 
/*     */     
/* 205 */     for (byte b = 8; b < 16; b++) {
/* 206 */       paramArrayOfbyte[b + paramInt] = this.bytes[b];
/*     */     }
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
/*     */   public boolean equals(Object paramObject) {
/* 222 */     if (paramObject == null || !(paramObject instanceof ClassID))
/* 223 */       return false; 
/* 224 */     ClassID classID = (ClassID)paramObject;
/* 225 */     if (this.bytes.length != classID.bytes.length)
/* 226 */       return false; 
/* 227 */     for (byte b = 0; b < this.bytes.length; b++) {
/* 228 */       if (this.bytes[b] != classID.bytes[b])
/* 229 */         return false; 
/* 230 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 241 */     return (new String(this.bytes, StringUtil.UTF8)).hashCode();
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
/*     */   public String toString() {
/* 253 */     StringBuffer stringBuffer = new StringBuffer(38);
/* 254 */     stringBuffer.append('{');
/* 255 */     for (byte b = 0; b < 16; b++) {
/*     */       
/* 257 */       stringBuffer.append(HexDump.toHex(this.bytes[b]));
/* 258 */       if (b == 3 || b == 5 || b == 7 || b == 9)
/* 259 */         stringBuffer.append('-'); 
/*     */     } 
/* 261 */     stringBuffer.append('}');
/* 262 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\ClassID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */