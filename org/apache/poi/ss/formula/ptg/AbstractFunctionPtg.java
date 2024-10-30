/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.ss.formula.function.FunctionMetadata;
/*     */ import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
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
/*     */ public abstract class AbstractFunctionPtg
/*     */   extends OperationPtg
/*     */ {
/*     */   public static final String FUNCTION_NAME_IF = "IF";
/*     */   private static final short FUNCTION_INDEX_EXTERNAL = 255;
/*     */   private final byte returnClass;
/*     */   private final byte[] paramClass;
/*     */   private final byte _numberOfArgs;
/*     */   private final short _functionIndex;
/*     */   
/*     */   protected AbstractFunctionPtg(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, int paramInt3) {
/*  48 */     this._numberOfArgs = (byte)paramInt3;
/*  49 */     this._functionIndex = (short)paramInt1;
/*  50 */     this.returnClass = (byte)paramInt2;
/*  51 */     this.paramClass = paramArrayOfbyte;
/*     */   }
/*     */   public final boolean isBaseToken() {
/*  54 */     return false;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*  58 */     StringBuilder stringBuilder = new StringBuilder(64);
/*  59 */     stringBuilder.append(getClass().getName()).append(" [");
/*  60 */     stringBuilder.append(lookupName(this._functionIndex));
/*  61 */     stringBuilder.append(" nArgs=").append(this._numberOfArgs);
/*  62 */     stringBuilder.append("]");
/*  63 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public final short getFunctionIndex() {
/*  67 */     return this._functionIndex;
/*     */   }
/*     */   public final int getNumberOfOperands() {
/*  70 */     return this._numberOfArgs;
/*     */   }
/*     */   
/*     */   public final String getName() {
/*  74 */     return lookupName(this._functionIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isExternalFunction() {
/*  81 */     return (this._functionIndex == 255);
/*     */   }
/*     */   
/*     */   public final String toFormulaString() {
/*  85 */     return getName();
/*     */   }
/*     */   
/*     */   public String toFormulaString(String[] paramArrayOfString) {
/*  89 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  91 */     if (isExternalFunction()) {
/*  92 */       stringBuilder.append(paramArrayOfString[0]);
/*  93 */       appendArgs(stringBuilder, 1, paramArrayOfString);
/*     */     } else {
/*  95 */       stringBuilder.append(getName());
/*  96 */       appendArgs(stringBuilder, 0, paramArrayOfString);
/*     */     } 
/*  98 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static void appendArgs(StringBuilder paramStringBuilder, int paramInt, String[] paramArrayOfString) {
/* 102 */     paramStringBuilder.append('(');
/* 103 */     for (int i = paramInt; i < paramArrayOfString.length; i++) {
/* 104 */       if (i > paramInt) {
/* 105 */         paramStringBuilder.append(',');
/*     */       }
/* 107 */       paramStringBuilder.append(paramArrayOfString[i]);
/*     */     } 
/* 109 */     paramStringBuilder.append(")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getSize();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isBuiltInFunctionName(String paramString) {
/* 123 */     short s = FunctionMetadataRegistry.lookupIndexByName(paramString.toUpperCase(Locale.ROOT));
/* 124 */     return (s >= 0);
/*     */   }
/*     */   
/*     */   protected final String lookupName(short paramShort) {
/* 128 */     if (paramShort == 255) {
/* 129 */       return "#external#";
/*     */     }
/* 131 */     FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByIndex(paramShort);
/* 132 */     if (functionMetadata == null) {
/* 133 */       throw new RuntimeException("bad function index (" + paramShort + ")");
/*     */     }
/* 135 */     return functionMetadata.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static short lookupIndex(String paramString) {
/* 145 */     short s = FunctionMetadataRegistry.lookupIndexByName(paramString.toUpperCase(Locale.ROOT));
/* 146 */     if (s < 0) {
/* 147 */       return 255;
/*     */     }
/* 149 */     return s;
/*     */   }
/*     */   
/*     */   public byte getDefaultOperandClass() {
/* 153 */     return this.returnClass;
/*     */   }
/*     */   
/*     */   public final byte getParameterClass(int paramInt) {
/* 157 */     if (paramInt >= this.paramClass.length)
/*     */     {
/*     */ 
/*     */       
/* 161 */       return this.paramClass[this.paramClass.length - 1];
/*     */     }
/* 163 */     return this.paramClass[paramInt];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AbstractFunctionPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */