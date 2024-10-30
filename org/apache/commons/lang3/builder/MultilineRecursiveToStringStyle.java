/*     */ package org.apache.commons.lang3.builder;
/*     */ 
/*     */ import org.apache.commons.lang3.ClassUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultilineRecursiveToStringStyle
/*     */   extends RecursiveToStringStyle
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final int INDENT = 2;
/*  76 */   private int spaces = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultilineRecursiveToStringStyle() {
/*  83 */     resetIndent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetIndent() {
/*  91 */     setArrayStart("{" + System.lineSeparator() + spacer(this.spaces));
/*  92 */     setArraySeparator("," + System.lineSeparator() + spacer(this.spaces));
/*  93 */     setArrayEnd(System.lineSeparator() + spacer(this.spaces - 2) + "}");
/*     */     
/*  95 */     setContentStart("[" + System.lineSeparator() + spacer(this.spaces));
/*  96 */     setFieldSeparator("," + System.lineSeparator() + spacer(this.spaces));
/*  97 */     setContentEnd(System.lineSeparator() + spacer(this.spaces - 2) + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StringBuilder spacer(int paramInt) {
/* 107 */     StringBuilder stringBuilder = new StringBuilder();
/* 108 */     for (byte b = 0; b < paramInt; b++) {
/* 109 */       stringBuilder.append(" ");
/*     */     }
/* 111 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/* 116 */     if (!ClassUtils.isPrimitiveWrapper(paramObject.getClass()) && !String.class.equals(paramObject.getClass()) && 
/* 117 */       accept(paramObject.getClass())) {
/* 118 */       this.spaces += 2;
/* 119 */       resetIndent();
/* 120 */       paramStringBuffer.append(ReflectionToStringBuilder.toString(paramObject, this));
/* 121 */       this.spaces -= 2;
/* 122 */       resetIndent();
/*     */     } else {
/* 124 */       super.appendDetail(paramStringBuffer, paramString, paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject) {
/* 130 */     this.spaces += 2;
/* 131 */     resetIndent();
/* 132 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfObject);
/* 133 */     this.spaces -= 2;
/* 134 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reflectionAppendArrayDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/* 139 */     this.spaces += 2;
/* 140 */     resetIndent();
/* 141 */     super.reflectionAppendArrayDetail(paramStringBuffer, paramString, paramObject);
/* 142 */     this.spaces -= 2;
/* 143 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong) {
/* 148 */     this.spaces += 2;
/* 149 */     resetIndent();
/* 150 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOflong);
/* 151 */     this.spaces -= 2;
/* 152 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint) {
/* 157 */     this.spaces += 2;
/* 158 */     resetIndent();
/* 159 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfint);
/* 160 */     this.spaces -= 2;
/* 161 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort) {
/* 166 */     this.spaces += 2;
/* 167 */     resetIndent();
/* 168 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfshort);
/* 169 */     this.spaces -= 2;
/* 170 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte) {
/* 175 */     this.spaces += 2;
/* 176 */     resetIndent();
/* 177 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfbyte);
/* 178 */     this.spaces -= 2;
/* 179 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar) {
/* 184 */     this.spaces += 2;
/* 185 */     resetIndent();
/* 186 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfchar);
/* 187 */     this.spaces -= 2;
/* 188 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble) {
/* 193 */     this.spaces += 2;
/* 194 */     resetIndent();
/* 195 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfdouble);
/* 196 */     this.spaces -= 2;
/* 197 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat) {
/* 202 */     this.spaces += 2;
/* 203 */     resetIndent();
/* 204 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOffloat);
/* 205 */     this.spaces -= 2;
/* 206 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean) {
/* 211 */     this.spaces += 2;
/* 212 */     resetIndent();
/* 213 */     super.appendDetail(paramStringBuffer, paramString, paramArrayOfboolean);
/* 214 */     this.spaces -= 2;
/* 215 */     resetIndent();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\MultilineRecursiveToStringStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */