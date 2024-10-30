/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class q
/*     */ {
/*     */   private static final String jh = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
/*     */   private final Q b;
/*     */   
/*     */   public q(Q paramQ) {
/*  41 */     this.b = paramQ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, List<String>> a(Y paramY, String paramString) throws U {
/*  48 */     N n = a(paramY);
/*     */ 
/*     */     
/*  51 */     Map<String, List<String>> map = a(paramY);
/*     */ 
/*     */     
/*  54 */     a(n, map, paramY);
/*     */ 
/*     */     
/*  57 */     a(n, map);
/*     */ 
/*     */     
/*  60 */     b(n, map);
/*     */ 
/*     */     
/*  63 */     a(n, map, paramString);
/*     */ 
/*     */     
/*  66 */     c(n, map);
/*     */ 
/*     */     
/*  69 */     d(n, map);
/*     */ 
/*     */     
/*  72 */     return map;
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
/*     */   private N a(Y paramY) throws U {
/*     */     String str;
/*     */     try {
/*  86 */       str = paramY.readLine();
/*     */     }
/*  88 */     catch (IOException iOException) {
/*     */ 
/*     */       
/*  91 */       throw new U(T.e, "Failed to read an opening handshake response from the server: " + iOException
/*     */           
/*  93 */           .getMessage(), iOException);
/*     */     } 
/*     */     
/*  96 */     if (str == null || str.length() == 0)
/*     */     {
/*     */       
/*  99 */       throw new U(T.f, "The status line of the opening handshake response is empty.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 107 */       return new N(str);
/*     */     }
/* 109 */     catch (Exception exception) {
/*     */ 
/*     */       
/* 112 */       throw new U(T.g, "The status line of the opening handshake response is badly formatted. The status line is: " + str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, List<String>> a(Y paramY) throws U {
/* 122 */     TreeMap<String, Object> treeMap = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
/*     */ 
/*     */     
/* 125 */     StringBuilder stringBuilder = null;
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       String str;
/*     */       
/*     */       try {
/* 132 */         str = paramY.readLine();
/*     */       }
/* 134 */       catch (IOException iOException) {
/*     */ 
/*     */         
/* 137 */         throw new U(T.i, "An error occurred while HTTP header section was being read: " + iOException
/*     */             
/* 139 */             .getMessage(), iOException);
/*     */       } 
/*     */ 
/*     */       
/* 143 */       if (str == null || str.length() == 0) {
/*     */         
/* 145 */         if (stringBuilder != null)
/*     */         {
/* 147 */           a((Map)treeMap, stringBuilder.toString());
/*     */         }
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */ 
/*     */       
/* 155 */       char c = str.charAt(0);
/*     */ 
/*     */       
/* 158 */       if (c == ' ' || c == '\t') {
/*     */         
/* 160 */         if (stringBuilder == null) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 167 */         str = str.replaceAll("^[ \t]+", " ");
/*     */ 
/*     */         
/* 170 */         stringBuilder.append(str);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 175 */       if (stringBuilder != null)
/*     */       {
/* 177 */         a((Map)treeMap, stringBuilder.toString());
/*     */       }
/*     */       
/* 180 */       stringBuilder = new StringBuilder(str);
/*     */     } 
/*     */     
/* 183 */     return (Map)treeMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Map<String, List<String>> paramMap, String paramString) {
/* 190 */     String[] arrayOfString = paramString.split(":", 2);
/*     */     
/* 192 */     if (arrayOfString.length < 2) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     String str1 = arrayOfString[0].trim();
/*     */ 
/*     */     
/* 202 */     String str2 = arrayOfString[1].trim();
/*     */     
/* 204 */     List<String> list = paramMap.get(str1);
/*     */     
/* 206 */     if (list == null) {
/*     */       
/* 208 */       list = new ArrayList();
/* 209 */       paramMap.put(str1, list);
/*     */     } 
/*     */     
/* 212 */     list.add(str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(N paramN, Map<String, List<String>> paramMap, Y paramY) throws U {
/* 222 */     if (paramN.getStatusCode() == 101) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     byte[] arrayOfByte = a(paramMap, paramY);
/*     */ 
/*     */     
/* 232 */     throw new y(T.h, "The status code of the opening handshake response is not '101 Switching Protocols'. The status line is: " + paramN, paramN, paramMap, arrayOfByte);
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
/*     */   private byte[] a(Map<String, List<String>> paramMap, Y paramY) {
/* 245 */     int i = a(paramMap);
/*     */     
/* 247 */     if (i <= 0)
/*     */     {
/*     */       
/* 250 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 256 */       byte[] arrayOfByte = new byte[i];
/*     */ 
/*     */       
/* 259 */       paramY.readBytes(arrayOfByte, i);
/*     */ 
/*     */       
/* 262 */       return arrayOfByte;
/*     */     }
/* 264 */     catch (Throwable throwable) {
/*     */ 
/*     */       
/* 267 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(Map<String, List<String>> paramMap) {
/*     */     try {
/* 279 */       return Integer.parseInt(((List<String>)paramMap.get("Content-Length")).get(0));
/*     */     }
/* 281 */     catch (Exception exception) {
/*     */       
/* 283 */       return -1;
/*     */     } 
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
/*     */   private void a(N paramN, Map<String, List<String>> paramMap) throws U {
/* 303 */     List list = paramMap.get("Upgrade");
/*     */     
/* 305 */     if (list == null || list.size() == 0)
/*     */     {
/*     */       
/* 308 */       throw new y(T.j, "The opening handshake response does not contain 'Upgrade' header.", paramN, paramMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     for (String str : list) {
/*     */ 
/*     */       
/* 317 */       String[] arrayOfString = str.split("\\s*,\\s*");
/*     */       
/* 319 */       for (String str1 : arrayOfString) {
/*     */         
/* 321 */         if ("websocket".equalsIgnoreCase(str1)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 330 */     throw new y(T.k, "'websocket' was not found in 'Upgrade' header.", paramN, paramMap);
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
/*     */   private void b(N paramN, Map<String, List<String>> paramMap) throws U {
/* 352 */     List list = paramMap.get("Connection");
/*     */     
/* 354 */     if (list == null || list.size() == 0)
/*     */     {
/*     */       
/* 357 */       throw new y(T.l, "The opening handshake response does not contain 'Connection' header.", paramN, paramMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     for (String str : list) {
/*     */ 
/*     */       
/* 366 */       String[] arrayOfString = str.split("\\s*,\\s*");
/*     */       
/* 368 */       for (String str1 : arrayOfString) {
/*     */         
/* 370 */         if ("Upgrade".equalsIgnoreCase(str1)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 379 */     throw new y(T.m, "'Upgrade' was not found in 'Connection' header.", paramN, paramMap);
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
/*     */ 
/*     */   
/*     */   private void a(N paramN, Map<String, List<String>> paramMap, String paramString) throws U {
/*     */     String str3;
/* 404 */     List<String> list = paramMap.get("Sec-WebSocket-Accept");
/*     */     
/* 406 */     if (list == null)
/*     */     {
/*     */       
/* 409 */       throw new y(T.n, "The opening handshake response does not contain 'Sec-WebSocket-Accept' header.", paramN, paramMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 416 */     String str1 = list.get(0);
/*     */ 
/*     */     
/* 419 */     String str2 = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 427 */       MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
/*     */ 
/*     */       
/* 430 */       byte[] arrayOfByte = messageDigest.digest(v.e(str2));
/*     */ 
/*     */       
/* 433 */       str3 = b.encode(arrayOfByte);
/*     */     }
/* 435 */     catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 441 */     if (!str3.equals(str1))
/*     */     {
/*     */       
/* 444 */       throw new y(T.o, "The value of 'Sec-WebSocket-Accept' header is different from the expected one.", paramN, paramMap);
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(N paramN, Map<String, List<String>> paramMap) throws U {
/* 471 */     List list = paramMap.get("Sec-WebSocket-Extensions");
/*     */     
/* 473 */     if (list == null || list.size() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 479 */     ArrayList<V> arrayList = new ArrayList();
/*     */     
/* 481 */     for (String str : list) {
/*     */ 
/*     */       
/* 484 */       String[] arrayOfString = str.split("\\s*,\\s*");
/*     */       
/* 486 */       for (String str1 : arrayOfString) {
/*     */ 
/*     */         
/* 489 */         V v = V.a(str1);
/*     */         
/* 491 */         if (v == null)
/*     */         {
/*     */           
/* 494 */           throw new y(T.p, "The value in 'Sec-WebSocket-Extensions' failed to be parsed: " + str1, paramN, paramMap);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 501 */         String str2 = v.getName();
/*     */ 
/*     */         
/* 504 */         if (!this.b.a().A(str2))
/*     */         {
/*     */           
/* 507 */           throw new y(T.q, "The extension contained in the Sec-WebSocket-Extensions header is not supported: " + str2, paramN, paramMap);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 514 */         v.validate();
/*     */ 
/*     */         
/* 517 */         arrayList.add(v);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 522 */     a(paramN, paramMap, arrayList);
/*     */ 
/*     */     
/* 525 */     this.b.q(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(N paramN, Map<String, List<String>> paramMap, List<V> paramList) throws U {
/* 535 */     V v = null;
/*     */     
/* 537 */     for (V v1 : paramList) {
/*     */ 
/*     */       
/* 540 */       if (!(v1 instanceof A)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 546 */       if (v == null) {
/*     */ 
/*     */         
/* 549 */         v = v1;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 554 */       String str = String.format("'%s' extension and '%s' extension conflict with each other.", new Object[] { v
/*     */             
/* 556 */             .getName(), v1.getName() });
/*     */ 
/*     */       
/* 559 */       throw new y(T.r, str, paramN, paramMap);
/*     */     } 
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
/*     */   private void d(N paramN, Map<String, List<String>> paramMap) throws U {
/* 582 */     List<String> list = paramMap.get("Sec-WebSocket-Protocol");
/*     */     
/* 584 */     if (list == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 591 */     String str = list.get(0);
/*     */     
/* 593 */     if (str == null || str.length() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 601 */     if (!this.b.a().z(str))
/*     */     {
/*     */       
/* 604 */       throw new y(T.s, "The protocol contained in the Sec-WebSocket-Protocol header is not supported: " + str, paramN, paramMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 611 */     this.b.bc(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\q.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */