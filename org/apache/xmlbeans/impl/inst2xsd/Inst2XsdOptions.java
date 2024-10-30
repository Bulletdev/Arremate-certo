/*     */ package org.apache.xmlbeans.impl.inst2xsd;
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
/*     */ public class Inst2XsdOptions
/*     */ {
/*     */   public static final int DESIGN_RUSSIAN_DOLL = 1;
/*     */   public static final int DESIGN_SALAMI_SLICE = 2;
/*     */   public static final int DESIGN_VENETIAN_BLIND = 3;
/*  39 */   private int _design = 3;
/*     */   
/*     */   public static final int SIMPLE_CONTENT_TYPES_SMART = 1;
/*     */   
/*     */   public static final int SIMPLE_CONTENT_TYPES_STRING = 2;
/*     */   
/*  45 */   private int _simpleContentTypes = 1;
/*     */   
/*     */   public static final int ENUMERATION_NEVER = 1;
/*     */   
/*     */   public static final int ENUMERATION_NOT_MORE_THAN_DEFAULT = 10;
/*     */   
/*  51 */   private int _enumerations = 10;
/*     */ 
/*     */   
/*     */   private boolean _verbose = false;
/*     */ 
/*     */   
/*     */   public int getDesign() {
/*  58 */     return this._design;
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
/*     */   public void setDesign(int paramInt) {
/*  73 */     if (paramInt != 1 && paramInt != 2 && paramInt != 3)
/*  74 */       throw new IllegalArgumentException("Unknown value for design type."); 
/*  75 */     this._design = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUseEnumerations() {
/*  80 */     return (this._enumerations > 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getUseEnumerations() {
/*  85 */     return this._enumerations;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUseEnumerations(int paramInt) {
/*  90 */     if (paramInt < 1)
/*  91 */       throw new IllegalArgumentException("UseEnumerations must be set to a value bigger than 1"); 
/*  92 */     this._enumerations = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSimpleContentTypes() {
/*  97 */     return this._simpleContentTypes;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSimpleContentTypes(int paramInt) {
/* 102 */     if (paramInt != 1 && paramInt != 2)
/* 103 */       throw new IllegalArgumentException("Unknown value for simpleContentTypes."); 
/* 104 */     this._simpleContentTypes = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVerbose() {
/* 109 */     return this._verbose;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVerbose(boolean paramBoolean) {
/* 114 */     this._verbose = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xsd\Inst2XsdOptions.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */