/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class p
/*     */ {
/*  28 */   private static final String[] c = new String[] { "Connection", "Upgrade" };
/*  29 */   private static final String[] d = new String[] { "Upgrade", "websocket" };
/*  30 */   private static final String[] e = new String[] { "Sec-WebSocket-Version", "13" };
/*     */   
/*     */   private static final String jd = "\r\n";
/*     */   
/*     */   private boolean bC;
/*     */   
/*     */   private String je;
/*     */   
/*     */   private final String ja;
/*     */   private final String jf;
/*     */   private final URI a;
/*     */   private String jg;
/*     */   private Set<String> G;
/*     */   private List<V> V;
/*     */   private List<String[]> W;
/*     */   
/*     */   public p(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
/*  47 */     this.bC = paramBoolean;
/*  48 */     this.je = paramString1;
/*  49 */     this.ja = paramString2;
/*  50 */     this.jf = paramString3;
/*     */ 
/*     */ 
/*     */     
/*  54 */     this.a = URI.create(String.format("%s://%s%s", new Object[] { paramBoolean ? "wss" : "ws", paramString2, paramString3 }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p(p paramp) {
/*  61 */     this.bC = paramp.bC;
/*  62 */     this.je = paramp.je;
/*  63 */     this.ja = paramp.ja;
/*  64 */     this.jf = paramp.jf;
/*  65 */     this.a = paramp.a;
/*  66 */     this.jg = paramp.jg;
/*  67 */     this.G = f(paramp.G);
/*  68 */     this.V = j(paramp.V);
/*  69 */     this.W = k(paramp.W);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aT(String paramString) {
/*  75 */     if (!y(paramString))
/*     */     {
/*  77 */       throw new IllegalArgumentException("'protocol' must be a non-empty string with characters in the range U+0021 to U+007E not including separator characters.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  82 */     synchronized (this) {
/*     */       
/*  84 */       if (this.G == null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*  89 */         this.G = new LinkedHashSet<String>();
/*     */       }
/*     */       
/*  92 */       this.G.add(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aU(String paramString) {
/*  99 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 104 */     synchronized (this) {
/*     */       
/* 106 */       if (this.G == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 111 */       this.G.remove(paramString);
/*     */       
/* 113 */       if (this.G.size() == 0)
/*     */       {
/* 115 */         this.G = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gu() {
/* 123 */     synchronized (this) {
/*     */       
/* 125 */       this.G = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean y(String paramString) {
/* 132 */     if (paramString == null || paramString.length() == 0)
/*     */     {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     int i = paramString.length();
/*     */     
/* 139 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 141 */       char c = paramString.charAt(b);
/*     */       
/* 143 */       if (c < '!' || '~' < c || P.isSeparator(c))
/*     */       {
/* 145 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean z(String paramString) {
/* 155 */     synchronized (this) {
/*     */       
/* 157 */       if (this.G == null)
/*     */       {
/* 159 */         return false;
/*     */       }
/*     */       
/* 162 */       return this.G.contains(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(V paramV) {
/* 169 */     if (paramV == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 174 */     synchronized (this) {
/*     */       
/* 176 */       if (this.V == null)
/*     */       {
/* 178 */         this.V = new ArrayList<V>();
/*     */       }
/*     */       
/* 181 */       this.V.add(paramV);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aV(String paramString) {
/* 188 */     a(V.a(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(V paramV) {
/* 194 */     if (paramV == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 199 */     synchronized (this) {
/*     */       
/* 201 */       if (this.V == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 206 */       this.V.remove(paramV);
/*     */       
/* 208 */       if (this.V.size() == 0)
/*     */       {
/* 210 */         this.V = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aW(String paramString) {
/* 218 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 223 */     synchronized (this) {
/*     */       
/* 225 */       if (this.V == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 230 */       ArrayList<V> arrayList = new ArrayList();
/*     */       
/* 232 */       for (V v : this.V) {
/*     */         
/* 234 */         if (v.getName().equals(paramString))
/*     */         {
/* 236 */           arrayList.add(v);
/*     */         }
/*     */       } 
/*     */       
/* 240 */       for (V v : arrayList)
/*     */       {
/* 242 */         this.V.remove(v);
/*     */       }
/*     */       
/* 245 */       if (this.V.size() == 0)
/*     */       {
/* 247 */         this.V = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gv() {
/* 255 */     synchronized (this) {
/*     */       
/* 257 */       this.V = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(V paramV) {
/* 264 */     if (paramV == null)
/*     */     {
/* 266 */       return false;
/*     */     }
/*     */     
/* 269 */     synchronized (this) {
/*     */       
/* 271 */       if (this.V == null)
/*     */       {
/* 273 */         return false;
/*     */       }
/*     */       
/* 276 */       return this.V.contains(paramV);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean A(String paramString) {
/* 283 */     if (paramString == null)
/*     */     {
/* 285 */       return false;
/*     */     }
/*     */     
/* 288 */     synchronized (this) {
/*     */       
/* 290 */       if (this.V == null)
/*     */       {
/* 292 */         return false;
/*     */       }
/*     */       
/* 295 */       for (V v : this.V) {
/*     */         
/* 297 */         if (v.getName().equals(paramString))
/*     */         {
/* 299 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 303 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addHeader(String paramString1, String paramString2) {
/* 310 */     if (paramString1 == null || paramString1.length() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 315 */     if (paramString2 == null)
/*     */     {
/* 317 */       paramString2 = "";
/*     */     }
/*     */     
/* 320 */     synchronized (this) {
/*     */       
/* 322 */       if (this.W == null)
/*     */       {
/* 324 */         this.W = (List)new ArrayList<String>();
/*     */       }
/*     */       
/* 327 */       this.W.add(new String[] { paramString1, paramString2 });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHeaders(String paramString) {
/* 334 */     if (paramString == null || paramString.length() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 339 */     synchronized (this) {
/*     */       
/* 341 */       if (this.W == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 346 */       ArrayList<String[]> arrayList = new ArrayList();
/*     */       
/* 348 */       for (String[] arrayOfString : this.W) {
/*     */         
/* 350 */         if (arrayOfString[0].equals(paramString))
/*     */         {
/* 352 */           arrayList.add(arrayOfString);
/*     */         }
/*     */       } 
/*     */       
/* 356 */       for (String[] arrayOfString : arrayList)
/*     */       {
/* 358 */         this.W.remove(arrayOfString);
/*     */       }
/*     */       
/* 361 */       if (this.W.size() == 0)
/*     */       {
/* 363 */         this.W = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gw() {
/* 371 */     synchronized (this) {
/*     */       
/* 373 */       this.W = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aX(String paramString) {
/* 380 */     synchronized (this) {
/*     */       
/* 382 */       this.je = paramString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void h(String paramString1, String paramString2) {
/* 389 */     if (paramString1 == null)
/*     */     {
/* 391 */       paramString1 = "";
/*     */     }
/*     */     
/* 394 */     if (paramString2 == null)
/*     */     {
/* 396 */       paramString2 = "";
/*     */     }
/*     */     
/* 399 */     String str = String.format("%s:%s", new Object[] { paramString1, paramString2 });
/*     */     
/* 401 */     aX(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gx() {
/* 407 */     synchronized (this) {
/*     */       
/* 409 */       this.je = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getURI() {
/* 416 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/* 422 */     this.jg = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String dI() {
/* 428 */     return String.format("GET %s HTTP/1.1", new Object[] { this.jf });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String[]> aa() {
/* 434 */     ArrayList<String[]> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 437 */     arrayList.add(new String[] { "Host", this.ja });
/*     */ 
/*     */     
/* 440 */     arrayList.add(c);
/*     */ 
/*     */     
/* 443 */     arrayList.add(d);
/*     */ 
/*     */     
/* 446 */     arrayList.add(e);
/*     */ 
/*     */     
/* 449 */     arrayList.add(new String[] { "Sec-WebSocket-Key", this.jg });
/*     */ 
/*     */     
/* 452 */     if (this.G != null && this.G.size() != 0)
/*     */     {
/* 454 */       arrayList.add(new String[] { "Sec-WebSocket-Protocol", v.join(this.G, ", ") });
/*     */     }
/*     */ 
/*     */     
/* 458 */     if (this.V != null && this.V.size() != 0)
/*     */     {
/* 460 */       arrayList.add(new String[] { "Sec-WebSocket-Extensions", v.join(this.V, ", ") });
/*     */     }
/*     */ 
/*     */     
/* 464 */     if (this.je != null && this.je.length() != 0)
/*     */     {
/* 466 */       arrayList.add(new String[] { "Authorization", "Basic " + b.encode(this.je) });
/*     */     }
/*     */ 
/*     */     
/* 470 */     if (this.W != null && this.W.size() != 0)
/*     */     {
/* 472 */       arrayList.addAll(this.W);
/*     */     }
/*     */     
/* 475 */     return (List<String[]>)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(String paramString, List<String[]> paramList) {
/* 481 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */     
/* 484 */     stringBuilder.append(paramString).append("\r\n");
/*     */ 
/*     */     
/* 487 */     for (String[] arrayOfString : paramList)
/*     */     {
/*     */       
/* 490 */       stringBuilder.append(arrayOfString[0]).append(": ").append(arrayOfString[1]).append("\r\n");
/*     */     }
/*     */ 
/*     */     
/* 494 */     stringBuilder.append("\r\n");
/*     */     
/* 496 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set<String> f(Set<String> paramSet) {
/* 502 */     if (paramSet == null)
/*     */     {
/* 504 */       return null;
/*     */     }
/*     */     
/* 507 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet(paramSet.size());
/*     */     
/* 509 */     linkedHashSet.addAll(paramSet);
/*     */     
/* 511 */     return linkedHashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<V> j(List<V> paramList) {
/* 517 */     if (paramList == null)
/*     */     {
/* 519 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 523 */     ArrayList<V> arrayList = new ArrayList(paramList.size());
/*     */     
/* 525 */     for (V v : paramList)
/*     */     {
/* 527 */       arrayList.add(new V(v));
/*     */     }
/*     */     
/* 530 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<String[]> k(List<String[]> paramList) {
/* 536 */     if (paramList == null)
/*     */     {
/* 538 */       return null;
/*     */     }
/*     */     
/* 541 */     ArrayList<String[]> arrayList = new ArrayList(paramList.size());
/*     */     
/* 543 */     for (String[] arrayOfString : paramList)
/*     */     {
/* 545 */       arrayList.add(a(arrayOfString));
/*     */     }
/*     */     
/* 548 */     return (List<String[]>)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] a(String[] paramArrayOfString) {
/* 554 */     String[] arrayOfString = new String[2];
/*     */     
/* 556 */     arrayOfString[0] = paramArrayOfString[0];
/* 557 */     arrayOfString[1] = paramArrayOfString[1];
/*     */     
/* 559 */     return arrayOfString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\p.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */