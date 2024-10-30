/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.apache.poi.util.CodePageUtil;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ @Internal
/*     */ class CodePageString
/*     */ {
/*  33 */   private static final POILogger logger = POILogFactory.getLogger(CodePageString.class);
/*     */ 
/*     */   
/*     */   private byte[] _value;
/*     */ 
/*     */   
/*     */   CodePageString(byte[] paramArrayOfbyte, int paramInt) {
/*  40 */     int i = paramInt;
/*     */     
/*  42 */     int j = LittleEndian.getInt(paramArrayOfbyte, i);
/*  43 */     i += 4;
/*     */     
/*  45 */     this._value = LittleEndian.getByteArray(paramArrayOfbyte, i, j);
/*  46 */     if (j != 0 && this._value[j - 1] != 0)
/*     */     {
/*     */ 
/*     */       
/*  50 */       logger.log(5, new Object[] { "CodePageString started at offset #" + i + " is not NULL-terminated" });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CodePageString(String paramString, int paramInt) throws UnsupportedEncodingException {
/*  61 */     setJavaValue(paramString, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   String getJavaValue(int paramInt) throws UnsupportedEncodingException {
/*     */     String str;
/*  67 */     if (paramInt == -1) {
/*  68 */       str = new String(this._value, StringUtil.UTF8);
/*     */     } else {
/*  70 */       str = CodePageUtil.getStringFromCodePage(this._value, paramInt);
/*  71 */     }  int i = str.indexOf(false);
/*  72 */     if (i == -1) {
/*     */       
/*  74 */       logger.log(5, new Object[] { "String terminator (\\0) for CodePageString property value not found.Continue without trimming and hope for the best." });
/*     */ 
/*     */ 
/*     */       
/*  78 */       return str;
/*     */     } 
/*  80 */     if (i != str.length() - 1)
/*     */     {
/*  82 */       logger.log(5, new Object[] { "String terminator (\\0) for CodePageString property value occured before the end of string. Trimming and hope for the best." });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  87 */     return str.substring(0, i);
/*     */   }
/*     */ 
/*     */   
/*     */   int getSize() {
/*  92 */     return 4 + this._value.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setJavaValue(String paramString, int paramInt) throws UnsupportedEncodingException {
/*  98 */     String str = paramString + "\000";
/*  99 */     if (paramInt == -1) {
/* 100 */       this._value = str.getBytes(StringUtil.UTF8);
/*     */     } else {
/* 102 */       this._value = CodePageUtil.getBytesInCodePage(str, paramInt);
/*     */     } 
/*     */   }
/*     */   
/*     */   int write(OutputStream paramOutputStream) throws IOException {
/* 107 */     LittleEndian.putInt(this._value.length, paramOutputStream);
/* 108 */     paramOutputStream.write(this._value);
/* 109 */     return 4 + this._value.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\CodePageString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */