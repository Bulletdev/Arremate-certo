/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class y
/*     */   extends U
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final N a;
/*     */   private final Map<String, List<String>> an;
/*     */   private final byte[] g;
/*     */   
/*     */   y(T paramT, String paramString, N paramN, Map<String, List<String>> paramMap) {
/*  43 */     this(paramT, paramString, paramN, paramMap, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   y(T paramT, String paramString, N paramN, Map<String, List<String>> paramMap, byte[] paramArrayOfbyte) {
/*  51 */     super(paramT, paramString);
/*     */     
/*  53 */     this.a = paramN;
/*  54 */     this.an = paramMap;
/*  55 */     this.g = paramArrayOfbyte;
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
/*     */   public N a() {
/*  68 */     return this.a;
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
/*     */   public Map<String, List<String>> O() {
/*  83 */     return this.an;
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
/*     */   
/*     */   public byte[] m() {
/* 104 */     return this.g;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\y.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */