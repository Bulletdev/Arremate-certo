/*     */ package com.google.a.l;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.L;
/*     */ import com.google.a.b.y;
/*     */ import com.google.b.a.j;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @j
/*     */ @a
/*     */ @b
/*     */ public final class a
/*     */   implements Serializable
/*     */ {
/*     */   private static final int gc = -1;
/*     */   private final String host;
/*     */   private final int port;
/*     */   private final boolean bf;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   private a(String paramString, int paramInt, boolean paramBoolean) {
/*  79 */     this.host = paramString;
/*  80 */     this.port = paramInt;
/*  81 */     this.bf = paramBoolean;
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
/*     */   public String getHost() {
/*  94 */     return this.host;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dg() {
/*  99 */     return (this.port >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 110 */     D.ab(dg());
/* 111 */     return this.port;
/*     */   }
/*     */ 
/*     */   
/*     */   public int Q(int paramInt) {
/* 116 */     return dg() ? this.port : paramInt;
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
/*     */   public static a a(String paramString, int paramInt) {
/* 132 */     D.a(r(paramInt), "Port out of range: %s", paramInt);
/* 133 */     a a1 = b(paramString);
/* 134 */     D.a(!a1.dg(), "Host has a port: %s", paramString);
/* 135 */     return new a(a1.host, paramInt, a1.bf);
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
/*     */   public static a a(String paramString) {
/* 150 */     a a1 = b(paramString);
/* 151 */     D.a(!a1.dg(), "Host has a port: %s", paramString);
/* 152 */     return a1;
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
/*     */   public static a b(String paramString) {
/*     */     String str1;
/* 166 */     D.checkNotNull(paramString);
/*     */     
/* 168 */     String str2 = null;
/* 169 */     boolean bool = false;
/*     */     
/* 171 */     if (paramString.startsWith("[")) {
/* 172 */       String[] arrayOfString = a(paramString);
/* 173 */       str1 = arrayOfString[0];
/* 174 */       str2 = arrayOfString[1];
/*     */     } else {
/* 176 */       int j = paramString.indexOf(':');
/* 177 */       if (j >= 0 && paramString.indexOf(':', j + 1) == -1) {
/*     */         
/* 179 */         str1 = paramString.substring(0, j);
/* 180 */         str2 = paramString.substring(j + 1);
/*     */       } else {
/*     */         
/* 183 */         str1 = paramString;
/* 184 */         bool = (j >= 0) ? true : false;
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     int i = -1;
/* 189 */     if (!L.isNullOrEmpty(str2)) {
/*     */ 
/*     */       
/* 192 */       D.a(!str2.startsWith("+"), "Unparseable port number: %s", paramString);
/*     */       try {
/* 194 */         i = Integer.parseInt(str2);
/* 195 */       } catch (NumberFormatException numberFormatException) {
/* 196 */         String.valueOf(paramString); throw new IllegalArgumentException((String.valueOf(paramString).length() != 0) ? "Unparseable port number: ".concat(String.valueOf(paramString)) : new String("Unparseable port number: "));
/*     */       } 
/* 198 */       D.a(r(i), "Port number out of range: %s", paramString);
/*     */     } 
/*     */     
/* 201 */     return new a(str1, i, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] a(String paramString) {
/* 212 */     int i = 0;
/* 213 */     int j = 0;
/* 214 */     D.a(
/* 215 */         (paramString.charAt(0) == '['), "Bracketed host-port string must start with a bracket: %s", paramString);
/*     */ 
/*     */     
/* 218 */     i = paramString.indexOf(':');
/* 219 */     j = paramString.lastIndexOf(']');
/* 220 */     D.a((i > -1 && j > i), "Invalid bracketed host/port: %s", paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     String str = paramString.substring(1, j);
/* 226 */     if (j + 1 == paramString.length()) {
/* 227 */       return new String[] { str, "" };
/*     */     }
/* 229 */     D.a(
/* 230 */         (paramString.charAt(j + 1) == ':'), "Only a colon may follow a close bracket: %s", paramString);
/*     */ 
/*     */     
/* 233 */     for (int k = j + 2; k < paramString.length(); k++) {
/* 234 */       D.a(
/* 235 */           Character.isDigit(paramString.charAt(k)), "Port must be numeric: %s", paramString);
/*     */     }
/*     */ 
/*     */     
/* 239 */     return new String[] { str, paramString.substring(j + 2) };
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
/*     */   public a a(int paramInt) {
/* 253 */     D.checkArgument(r(paramInt));
/* 254 */     if (dg()) {
/* 255 */       return this;
/*     */     }
/* 257 */     return new a(this.host, paramInt, this.bf);
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
/*     */   public a a() {
/* 275 */     D.a(!this.bf, "Possible bracketless IPv6 literal: %s", this.host);
/* 276 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 281 */     if (this == paramObject) {
/* 282 */       return true;
/*     */     }
/* 284 */     if (paramObject instanceof a) {
/* 285 */       a a1 = (a)paramObject;
/* 286 */       return (y.equal(this.host, a1.host) && this.port == a1.port);
/*     */     } 
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 293 */     return y.a(new Object[] { this.host, Integer.valueOf(this.port) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 300 */     StringBuilder stringBuilder = new StringBuilder(this.host.length() + 8);
/* 301 */     if (this.host.indexOf(':') >= 0) {
/* 302 */       stringBuilder.append('[').append(this.host).append(']');
/*     */     } else {
/* 304 */       stringBuilder.append(this.host);
/*     */     } 
/* 306 */     if (dg()) {
/* 307 */       stringBuilder.append(':').append(this.port);
/*     */     }
/* 309 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean r(int paramInt) {
/* 314 */     return (paramInt >= 0 && paramInt <= 65535);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */