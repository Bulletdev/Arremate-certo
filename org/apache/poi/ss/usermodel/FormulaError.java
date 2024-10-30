/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ public enum FormulaError
/*     */ {
/*  31 */   _NO_ERROR(-1, "(no error)"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   NULL(0, "#NULL!"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   DIV0(7, "#DIV/0!"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   VALUE(15, "#VALUE!"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   REF(23, "#REF!"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   NAME(29, "#NAME?"),
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
/*  90 */   NUM(36, "#NUM!"),
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
/* 102 */   NA(42, "#N/A"),
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
/* 113 */   CIRCULAR_REF(-60, "~CIRCULAR~REF~"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   FUNCTION_NOT_IMPLEMENTED(-30, "~FUNCTION~NOT~IMPLEMENTED~");
/*     */   
/*     */   private final byte type;
/*     */   private final int longType;
/*     */   private final String repr;
/*     */   
/*     */   FormulaError(int paramInt1, String paramString1) {
/* 125 */     this.type = (byte)paramInt1;
/* 126 */     this.longType = paramInt1;
/* 127 */     this.repr = paramString1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Map<String, FormulaError> smap;
/*     */   
/*     */   public byte getCode() {
/* 134 */     return this.type;
/*     */   }
/*     */   private static final Map<Byte, FormulaError> bmap;
/*     */   private static final Map<Integer, FormulaError> imap;
/*     */   
/*     */   public int getLongCode() {
/* 140 */     return this.longType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 147 */     return this.repr;
/*     */   }
/*     */   static {
/* 150 */     smap = new HashMap<String, FormulaError>();
/* 151 */     bmap = new HashMap<Byte, FormulaError>();
/* 152 */     imap = new HashMap<Integer, FormulaError>();
/*     */     
/* 154 */     for (FormulaError formulaError : values()) {
/* 155 */       bmap.put(Byte.valueOf(formulaError.getCode()), formulaError);
/* 156 */       imap.put(Integer.valueOf(formulaError.getLongCode()), formulaError);
/* 157 */       smap.put(formulaError.getString(), formulaError);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final boolean isValidCode(int paramInt) {
/* 162 */     for (FormulaError formulaError : values()) {
/* 163 */       if (formulaError.getCode() == paramInt) return true; 
/* 164 */       if (formulaError.getLongCode() == paramInt) return true; 
/*     */     } 
/* 166 */     return false;
/*     */   }
/*     */   
/*     */   public static FormulaError forInt(byte paramByte) throws IllegalArgumentException {
/* 170 */     FormulaError formulaError = bmap.get(Byte.valueOf(paramByte));
/* 171 */     if (formulaError == null) throw new IllegalArgumentException("Unknown error type: " + paramByte); 
/* 172 */     return formulaError;
/*     */   }
/*     */   public static FormulaError forInt(int paramInt) throws IllegalArgumentException {
/* 175 */     FormulaError formulaError = imap.get(Integer.valueOf(paramInt));
/* 176 */     if (formulaError == null) formulaError = bmap.get(Byte.valueOf((byte)paramInt)); 
/* 177 */     if (formulaError == null) throw new IllegalArgumentException("Unknown error type: " + paramInt); 
/* 178 */     return formulaError;
/*     */   }
/*     */   
/*     */   public static FormulaError forString(String paramString) throws IllegalArgumentException {
/* 182 */     FormulaError formulaError = smap.get(paramString);
/* 183 */     if (formulaError == null) throw new IllegalArgumentException("Unknown error code: " + paramString); 
/* 184 */     return formulaError;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FormulaError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */