/*     */ package org.e;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ public class t
/*     */ {
/*  38 */   public static final t a = new t();
/*     */ 
/*     */   
/*  41 */   public static final t b = (new t())
/*  42 */     .a(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String lS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean de;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, v<?>> av;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t() {
/*  74 */     this.dd = false;
/*  75 */     this.lS = "content";
/*  76 */     this.de = false;
/*  77 */     this.av = Collections.emptyMap();
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
/*     */   @Deprecated
/*     */   public t(boolean paramBoolean) {
/*  90 */     this(paramBoolean, "content", false);
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
/*     */   @Deprecated
/*     */   public t(String paramString) {
/* 105 */     this(false, paramString, false);
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
/*     */   @Deprecated
/*     */   public t(boolean paramBoolean, String paramString) {
/* 120 */     this.dd = paramBoolean;
/* 121 */     this.lS = paramString;
/* 122 */     this.de = false;
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
/*     */   @Deprecated
/*     */   public t(boolean paramBoolean1, String paramString, boolean paramBoolean2) {
/* 139 */     this.dd = paramBoolean1;
/* 140 */     this.lS = paramString;
/* 141 */     this.de = paramBoolean2;
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
/*     */   private t(boolean paramBoolean1, String paramString, boolean paramBoolean2, Map<String, v<?>> paramMap) {
/* 157 */     this.dd = paramBoolean1;
/* 158 */     this.lS = paramString;
/* 159 */     this.de = paramBoolean2;
/* 160 */     this.av = Collections.unmodifiableMap(paramMap);
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
/*     */   protected t a() {
/* 173 */     return new t(this.dd, this.lS, this.de, this.av);
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
/*     */   public boolean gf() {
/* 188 */     return this.dd;
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
/*     */   public t a(boolean paramBoolean) {
/* 201 */     t t1 = a();
/* 202 */     t1.dd = paramBoolean;
/* 203 */     return t1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eR() {
/* 214 */     return this.lS;
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
/*     */   public t a(String paramString) {
/* 228 */     t t1 = a();
/* 229 */     t1.lS = paramString;
/* 230 */     return t1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gg() {
/* 241 */     return this.de;
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
/*     */   public t b(boolean paramBoolean) {
/* 255 */     t t1 = a();
/* 256 */     t1.de = paramBoolean;
/* 257 */     return t1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, v<?>> T() {
/* 268 */     return this.av;
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
/*     */   public t a(Map<String, v<?>> paramMap) {
/* 281 */     t t1 = a();
/* 282 */     HashMap<String, v<?>> hashMap = new HashMap<String, v<?>>(paramMap);
/* 283 */     t1.av = Collections.unmodifiableMap(hashMap);
/* 284 */     return t1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */