/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
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
/*     */ @b
/*     */ public enum d
/*     */ {
/*  33 */   a(e.a('-'), "-")
/*     */   {
/*     */     String ai(String param1String) {
/*  36 */       return c.ag(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     String b(d param1d, String param1String) {
/*  41 */       if (param1d == b) {
/*  42 */         return param1String.replace('-', '_');
/*     */       }
/*  44 */       if (param1d == e) {
/*  45 */         return c.ah(param1String.replace('-', '_'));
/*     */       }
/*  47 */       return super.b(param1d, param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  52 */   b(e.a('_'), "_")
/*     */   {
/*     */     String ai(String param1String) {
/*  55 */       return c.ag(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     String b(d param1d, String param1String) {
/*  60 */       if (param1d == a) {
/*  61 */         return param1String.replace('_', '-');
/*     */       }
/*  63 */       if (param1d == e) {
/*  64 */         return c.ah(param1String);
/*     */       }
/*  66 */       return super.b(param1d, param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  71 */   c(e.a('A', 'Z'), "")
/*     */   {
/*     */     String ai(String param1String) {
/*  74 */       return al(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     String aj(String param1String) {
/*  79 */       return c.ag(param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  84 */   d(e.a('A', 'Z'), "")
/*     */   {
/*     */     String ai(String param1String) {
/*  87 */       return al(param1String);
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  92 */   e(e.a('_'), "_")
/*     */   {
/*     */     String ai(String param1String) {
/*  95 */       return c.ah(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     String b(d param1d, String param1String) {
/* 100 */       if (param1d == a) {
/* 101 */         return c.ag(param1String.replace('_', '-'));
/*     */       }
/* 103 */       if (param1d == b) {
/* 104 */         return c.ag(param1String);
/*     */       }
/* 106 */       return super.b(param1d, param1String);
/*     */     }
/*     */   };
/*     */   
/*     */   private final e a;
/*     */   private final String gr;
/*     */   
/*     */   d(e parame, String paramString1) {
/* 114 */     this.a = (d[])parame;
/* 115 */     this.gr = paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(d paramd, String paramString) {
/* 124 */     D.checkNotNull(paramd);
/* 125 */     D.checkNotNull(paramString);
/* 126 */     return (paramd == this) ? paramString : b(paramd, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   String b(d paramd, String paramString) {
/* 132 */     StringBuilder stringBuilder = null;
/* 133 */     int i = 0;
/* 134 */     int j = -1;
/* 135 */     while ((j = this.a.a(paramString, ++j)) != -1) {
/* 136 */       if (!i) {
/*     */         
/* 138 */         stringBuilder = new StringBuilder(paramString.length() + 4 * paramd.gr.length());
/* 139 */         stringBuilder.append(paramd.aj(paramString.substring(i, j)));
/*     */       } else {
/* 141 */         stringBuilder.append(paramd.ai(paramString.substring(i, j)));
/*     */       } 
/* 143 */       stringBuilder.append(paramd.gr);
/* 144 */       i = j + this.gr.length();
/*     */     } 
/* 146 */     return (i == 0) ? 
/* 147 */       paramd.aj(paramString) : 
/* 148 */       stringBuilder.append(paramd.ai(paramString.substring(i))).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i<String, String> a(d paramd) {
/* 157 */     return new a(this, paramd);
/*     */   }
/*     */   
/*     */   private static final class a
/*     */     extends i<String, String> implements Serializable {
/*     */     private final d f;
/*     */     private final d g;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(d param1d1, d param1d2) {
/* 167 */       this.f = D.<d>checkNotNull(param1d1);
/* 168 */       this.g = D.<d>checkNotNull(param1d2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String am(String param1String) {
/* 173 */       return this.f.a(this.g, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String an(String param1String) {
/* 178 */       return this.g.a(this.f, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 183 */       if (param1Object instanceof a) {
/* 184 */         a a1 = (a)param1Object;
/* 185 */         return (this.f.equals(a1.f) && this.g.equals(a1.g));
/*     */       } 
/* 187 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 192 */       return this.f.hashCode() ^ this.g.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 197 */       String str1 = String.valueOf(this.f), str2 = String.valueOf(this.g); return (new StringBuilder(14 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".converterTo(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String aj(String paramString) {
/* 206 */     return ai(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String ak(String paramString) {
/* 212 */     char c = c.b(paramString.charAt(0)); String str = c.ag(paramString.substring(1)); return paramString.isEmpty() ? paramString : (new StringBuilder(1 + String.valueOf(str).length())).append(c).append(str).toString();
/*     */   }
/*     */   
/*     */   abstract String ai(String paramString);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */