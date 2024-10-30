/*     */ package javax.xml.namespace;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   implements Serializable
/*     */ {
/*     */   private String namespaceURI;
/*     */   private String jA;
/*     */   private String prefix;
/*     */   
/*     */   public b(String paramString) {
/*  55 */     this("", paramString);
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
/*     */   public b(String paramString1, String paramString2) {
/*  70 */     this(paramString1, paramString2, "");
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
/*     */   public b(String paramString1, String paramString2, String paramString3) {
/*  84 */     if (paramString2 == null) {
/*  85 */       throw new IllegalArgumentException("Local part not allowed to be null");
/*     */     }
/*     */     
/*  88 */     if (paramString1 == null) {
/*  89 */       paramString1 = "";
/*     */     }
/*     */     
/*  92 */     if (paramString3 == null) {
/*  93 */       paramString3 = "";
/*     */     }
/*     */     
/*  96 */     this.namespaceURI = paramString1;
/*  97 */     this.jA = paramString2;
/*  98 */     this.prefix = paramString3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNamespaceURI() {
/* 109 */     return this.namespaceURI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dT() {
/* 116 */     return this.jA;
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
/*     */   public String getPrefix() {
/* 129 */     return this.prefix;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 137 */     if (this.namespaceURI.equals("")) {
/* 138 */       return this.jA;
/*     */     }
/*     */     
/* 141 */     return "{" + this.namespaceURI + "}" + this.jA;
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
/*     */   public static b a(String paramString) {
/* 162 */     if (paramString == null || paramString.equals("")) {
/* 163 */       throw new IllegalArgumentException("invalid QName literal");
/*     */     }
/*     */     
/* 166 */     if (paramString.charAt(0) == '{') {
/*     */       
/* 168 */       int i = paramString.indexOf('}');
/* 169 */       if (i == -1) {
/* 170 */         throw new IllegalArgumentException("invalid QName literal");
/*     */       }
/* 172 */       if (i == paramString.length() - 1) {
/* 173 */         throw new IllegalArgumentException("invalid QName literal");
/*     */       }
/* 175 */       return new b(paramString.substring(1, i), paramString.substring(i + 1));
/*     */     } 
/*     */     
/* 178 */     return new b(paramString);
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
/*     */   public final int hashCode() {
/* 190 */     return this.namespaceURI.hashCode() ^ this.jA.hashCode();
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
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 212 */     if (paramObject == null) {
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     if (!(paramObject instanceof b)) {
/* 217 */       return false;
/*     */     }
/*     */     
/* 220 */     b b1 = (b)paramObject;
/*     */     
/* 222 */     return (this.jA.equals(b1.jA) && this.namespaceURI.equals(b1.namespaceURI));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\namespace\b.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */