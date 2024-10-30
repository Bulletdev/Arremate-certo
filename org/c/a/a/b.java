/*     */ package org.c.a.a;
/*     */ 
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */   implements Comparable<b>
/*     */ {
/*     */   private static final String CLASSPATH_PREFIX = "classpath:";
/*     */   public static final String jK = "filesystem:";
/*     */   private final String prefix;
/*     */   private String path;
/*     */   
/*     */   public b(String paramString) {
/*  50 */     String str = paramString.trim();
/*     */     
/*  52 */     if (str.contains(":")) {
/*  53 */       this.prefix = str.substring(0, str.indexOf(":") + 1);
/*  54 */       this.path = str.substring(str.indexOf(":") + 1);
/*     */     } else {
/*  56 */       this.prefix = "classpath:";
/*  57 */       this.path = str;
/*     */     } 
/*     */     
/*  60 */     if (fo()) {
/*  61 */       this.path = this.path.replace(".", "/");
/*  62 */       if (this.path.startsWith("/")) {
/*  63 */         this.path = this.path.substring(1);
/*     */       }
/*  65 */       if (this.path.endsWith("/")) {
/*  66 */         this.path = this.path.substring(0, this.path.length() - 1);
/*     */       }
/*  68 */     } else if (fp()) {
/*  69 */       this.path = (new File(this.path)).getPath();
/*     */     } else {
/*  71 */       throw new a("Unknown prefix for location (should be either filesystem: or classpath:): " + str);
/*     */     } 
/*     */ 
/*     */     
/*  75 */     if (this.path.endsWith(File.separator)) {
/*  76 */       this.path = this.path.substring(0, this.path.length() - 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fo() {
/*  86 */     return "classpath:".equals(this.prefix);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fp() {
/*  95 */     return "filesystem:".equals(this.prefix);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(b paramb) {
/* 106 */     if (fo() && paramb.fo()) {
/* 107 */       return (paramb.er() + "/").startsWith(er() + "/");
/*     */     }
/* 109 */     if (fp() && paramb.fp()) {
/* 110 */       return (paramb.getPath() + File.separator).startsWith(er() + File.separator);
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrefix() {
/* 119 */     return this.prefix;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 126 */     return this.path;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String er() {
/* 133 */     return this.prefix + this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(b paramb) {
/* 138 */     return er().compareTo(paramb.er());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 143 */     if (this == paramObject) return true; 
/* 144 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 146 */     b b1 = (b)paramObject;
/*     */     
/* 148 */     return er().equals(b1.er());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 153 */     return er().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     return er();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */