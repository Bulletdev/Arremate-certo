/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Vector;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.FormatRecord;
/*     */ import org.apache.poi.ss.usermodel.BuiltinFormats;
/*     */ import org.apache.poi.ss.usermodel.DataFormat;
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
/*     */ public final class HSSFDataFormat
/*     */   implements DataFormat
/*     */ {
/*  44 */   private static final String[] _builtinFormats = BuiltinFormats.getAll();
/*     */   
/*  46 */   private final Vector<String> _formats = new Vector<String>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final InternalWorkbook _workbook;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _movedBuiltins = false;
/*     */ 
/*     */ 
/*     */   
/*     */   HSSFDataFormat(InternalWorkbook paramInternalWorkbook) {
/*  59 */     this._workbook = paramInternalWorkbook;
/*     */     
/*  61 */     Iterator<FormatRecord> iterator = paramInternalWorkbook.getFormats().iterator();
/*  62 */     while (iterator.hasNext()) {
/*  63 */       FormatRecord formatRecord = iterator.next();
/*  64 */       ensureFormatsSize(formatRecord.getIndexCode());
/*  65 */       this._formats.set(formatRecord.getIndexCode(), formatRecord.getFormatString());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List<String> getBuiltinFormats() {
/*  70 */     return Arrays.asList(_builtinFormats);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short getBuiltinFormat(String paramString) {
/*  80 */     return (short)BuiltinFormats.getBuiltinFormat(paramString);
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
/*     */   public short getFormat(String paramString) {
/*     */     String str;
/*  93 */     if (paramString.toUpperCase(Locale.ROOT).equals("TEXT")) {
/*  94 */       str = "@";
/*     */     } else {
/*  96 */       str = paramString;
/*     */     } 
/*     */ 
/*     */     
/* 100 */     if (!this._movedBuiltins) {
/* 101 */       for (byte b = 0; b < _builtinFormats.length; b++) {
/* 102 */         ensureFormatsSize(b);
/* 103 */         if (this._formats.get(b) == null) {
/* 104 */           this._formats.set(b, _builtinFormats[b]);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 109 */       this._movedBuiltins = true;
/*     */     } 
/*     */     
/*     */     short s;
/* 113 */     for (s = 0; s < this._formats.size(); s++) {
/* 114 */       if (str.equals(this._formats.get(s))) {
/* 115 */         return (short)s;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 120 */     s = this._workbook.getFormat(str, true);
/* 121 */     ensureFormatsSize(s);
/* 122 */     this._formats.set(s, str);
/* 123 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormat(short paramShort) {
/* 132 */     if (this._movedBuiltins) {
/* 133 */       return this._formats.get(paramShort);
/*     */     }
/*     */     
/* 136 */     if (paramShort == -1)
/*     */     {
/*     */       
/* 139 */       return null;
/*     */     }
/*     */     
/* 142 */     String str = (this._formats.size() > paramShort) ? this._formats.get(paramShort) : null;
/* 143 */     if (_builtinFormats.length > paramShort && _builtinFormats[paramShort] != null) {
/*     */       
/* 145 */       if (str != null)
/*     */       {
/* 147 */         return str;
/*     */       }
/*     */       
/* 150 */       return _builtinFormats[paramShort];
/*     */     } 
/*     */     
/* 153 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBuiltinFormat(short paramShort) {
/* 162 */     return BuiltinFormats.getBuiltinFormat(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getNumberOfBuiltinBuiltinFormats() {
/* 170 */     return _builtinFormats.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ensureFormatsSize(int paramInt) {
/* 178 */     if (this._formats.size() <= paramInt)
/* 179 */       this._formats.setSize(paramInt + 1); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFDataFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */