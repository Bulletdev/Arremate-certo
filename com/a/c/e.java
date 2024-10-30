/*     */ package com.a.c;
/*     */ 
/*     */ import com.a.e.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */ {
/*     */   public static c a(String paramString) {
/* 100 */     if (paramString == null) {
/* 101 */       throw new d("Expression string cannot be null.", -1);
/*     */     }
/* 103 */     return a(paramString, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static c a(String paramString, int paramInt) {
/* 109 */     if (paramString.trim().length() == 0) {
/* 110 */       return null;
/*     */     }
/* 112 */     c c1 = new c();
/* 113 */     c c2 = new c();
/*     */     
/* 115 */     boolean bool1 = true;
/* 116 */     boolean bool2 = false;
/* 117 */     boolean bool3 = false;
/*     */     
/* 119 */     for (int i = 0; i < paramString.length(); i++) {
/* 120 */       char c = paramString.charAt(i);
/*     */       
/* 122 */       if (c != ' ' && c != '\t' && c != '\n')
/*     */       {
/*     */         
/* 125 */         if (bool1) {
/* 126 */           if (c == '(') {
/* 127 */             if (bool3) {
/* 128 */               throw new d("Open bracket found after negate.", i);
/*     */             }
/* 130 */             c2.push("(");
/*     */           }
/* 132 */           else if (!bool2 && (c == '+' || c == '-')) {
/* 133 */             bool2 = true;
/* 134 */             if (c == '-') bool3 = true;
/*     */           
/* 136 */           } else if ((c >= '0' && c <= '9') || c == '.') {
/*     */             
/* 138 */             int j = i + 1;
/* 139 */             while (j < paramString.length()) {
/* 140 */               c = paramString.charAt(j);
/* 141 */               if ((c >= '0' && c <= '9') || c == '.') { j++;
/*     */                 continue; }
/*     */               
/* 144 */               if (c == 'e' || c == 'E') {
/* 145 */                 j++;
/*     */                 
/* 147 */                 if (j < paramString.length()) {
/* 148 */                   c = paramString.charAt(j);
/*     */                   
/* 150 */                   if (c != '+' && c != '-' && (c < '0' || c > '9')) {
/* 151 */                     throw new d("Expected digit, plus sign or minus sign but found: " + String.valueOf(c), j + paramInt);
/*     */                   }
/* 153 */                   j++;
/*     */                 } 
/*     */                 
/* 156 */                 while (j < paramString.length()) {
/* 157 */                   c = paramString.charAt(j);
/* 158 */                   if (c < '0' || c > '9')
/*     */                     break; 
/* 160 */                   j++;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 167 */             double d = 0.0D;
/* 168 */             String str = paramString.substring(i, j);
/*     */             
/*     */             try {
/* 171 */               d = Double.parseDouble(str);
/* 172 */             } catch (Throwable throwable) {
/* 173 */               throw new d("Improperly formatted value: " + str, i + paramInt);
/*     */             } 
/*     */             
/* 176 */             if (bool3) d = -d; 
/* 177 */             c1.push(new n(d));
/* 178 */             i = j - 1;
/*     */             
/* 180 */             bool3 = false;
/* 181 */             bool1 = false;
/* 182 */             bool2 = false;
/*     */           }
/* 184 */           else if (c != ',' && c != ')' && c != '^' && c != '*' && c != '/' && c != '+' && c != '-') {
/* 185 */             int j = i + 1;
/* 186 */             while (j < paramString.length()) {
/* 187 */               c = paramString.charAt(j);
/* 188 */               if (c != ',' && c != ' ' && c != '\t' && c != '\n' && c != '(' && c != ')' && c != '^' && c != '*' && c != '/' && c != '+' && c != '-') {
/* 189 */                 j++;
/*     */               }
/*     */             } 
/*     */             
/* 193 */             if (j < paramString.length()) {
/* 194 */               int k = j;
/*     */               
/* 196 */               k++;
/* 197 */               while ((c == ' ' || c == '\t' || c == '\n') && k != paramString.length()) {
/* 198 */                 c = paramString.charAt(k);
/*     */               }
/*     */               
/* 201 */               if (c == '(') {
/* 202 */                 g g = new g(paramString.substring(i, j), bool3);
/* 203 */                 byte b = 1;
/* 204 */                 int m = k + 1;
/* 205 */                 while (b) {
/* 206 */                   k++;
/*     */                   
/* 208 */                   if (k >= paramString.length()) {
/* 209 */                     throw new d("Missing function close bracket.", i + paramInt);
/*     */                   }
/*     */                   
/* 212 */                   c = paramString.charAt(k);
/*     */                   
/* 214 */                   if (c == ')') {
/* 215 */                     b--; continue;
/*     */                   } 
/* 217 */                   if (c == '(') {
/* 218 */                     b++; continue;
/*     */                   } 
/* 220 */                   if (c == ',' && b == 1) {
/* 221 */                     c c4 = a(paramString.substring(m, k), m);
/* 222 */                     if (c4 == null) {
/* 223 */                       throw new d("Incomplete function.", m + paramInt);
/*     */                     }
/* 225 */                     g.b(c4);
/* 226 */                     m = k + 1;
/*     */                   } 
/*     */                 } 
/* 229 */                 c c3 = a(paramString.substring(m, k), m);
/* 230 */                 if (c3 == null) {
/* 231 */                   if (g.aP() > 0) {
/* 232 */                     throw new d("Incomplete function.", m + paramInt);
/*     */                   }
/*     */                 } else {
/*     */                   
/* 236 */                   g.b(c3);
/*     */                 } 
/* 238 */                 c1.push(g);
/* 239 */                 i = k;
/*     */               } else {
/*     */                 
/* 242 */                 c1.push(new p(paramString.substring(i, j), bool3));
/* 243 */                 i = k - 1;
/*     */               } 
/*     */             } else {
/*     */               
/* 247 */               c1.push(new p(paramString.substring(i, j), bool3));
/* 248 */               i = j - 1;
/*     */             } 
/*     */             
/* 251 */             bool3 = false;
/* 252 */             bool1 = false;
/* 253 */             bool2 = false;
/*     */           } else {
/*     */             
/* 256 */             throw new d("Unexpected character: " + String.valueOf(c), i + paramInt);
/*     */           }
/*     */         
/*     */         }
/* 260 */         else if (c == ')') {
/* 261 */           c c3 = new c();
/* 262 */           c c4 = new c();
/*     */           while (true) {
/* 264 */             if (c2.isEmpty()) {
/* 265 */               throw new d("Missing open bracket.", i + paramInt);
/*     */             }
/* 267 */             Object object = c2.pop();
/* 268 */             if (object.equals("("))
/* 269 */               break;  c3.y(c1.pop());
/* 270 */             c4.y(object);
/*     */           } 
/* 272 */           c3.y(c1.pop());
/*     */           
/* 274 */           c1.push(a(c3, c4));
/*     */         }
/* 276 */         else if (c == '^' || c == '*' || c == '/' || c == '+' || c == '-') {
/* 277 */           bool1 = true;
/* 278 */           c2.push(String.valueOf(c));
/*     */         } else {
/*     */           
/* 281 */           throw new d("Expected operator or close bracket but found: " + String.valueOf(c), i + paramInt);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 286 */     if (c1.size() != c2.size() + 1) {
/* 287 */       throw new d("Incomplete expression.", paramInt + paramString.length());
/*     */     }
/*     */     
/* 290 */     return a(c1, c2);
/*     */   }
/*     */   
/*     */   private static c a(c paramc1, c paramc2) {
/* 294 */     c c1 = new c();
/* 295 */     c c2 = new c();
/*     */     
/* 297 */     while (!paramc2.isEmpty()) {
/* 298 */       Object object1 = paramc2.I();
/* 299 */       Object object2 = paramc1.I();
/* 300 */       Object object3 = paramc1.I();
/*     */       
/* 302 */       if (object1.equals("^")) {
/* 303 */         paramc1.y(new k((c)object2, (c)object3));
/*     */         continue;
/*     */       } 
/* 306 */       paramc1.y(object3);
/* 307 */       c2.push(object1);
/* 308 */       c1.push(object2);
/*     */     } 
/*     */ 
/*     */     
/* 312 */     c1.push(paramc1.pop());
/*     */     
/* 314 */     while (!c2.isEmpty()) {
/* 315 */       Object object1 = c2.I();
/* 316 */       Object object2 = c1.I();
/* 317 */       Object object3 = c1.I();
/*     */       
/* 319 */       if (object1.equals("*")) {
/* 320 */         c1.y(new h((c)object2, (c)object3)); continue;
/*     */       } 
/* 322 */       if (object1.equals("/")) {
/* 323 */         c1.y(new b((c)object2, (c)object3));
/*     */         continue;
/*     */       } 
/* 326 */       c1.y(object3);
/* 327 */       paramc2.push(object1);
/* 328 */       paramc1.push(object2);
/*     */     } 
/*     */ 
/*     */     
/* 332 */     paramc1.push(c1.pop());
/*     */     
/* 334 */     while (!paramc2.isEmpty()) {
/* 335 */       Object object1 = paramc2.I();
/* 336 */       Object object2 = paramc1.I();
/* 337 */       Object object3 = paramc1.I();
/*     */       
/* 339 */       if (object1.equals("+")) {
/* 340 */         paramc1.y(new a((c)object2, (c)object3)); continue;
/*     */       } 
/* 342 */       if (object1.equals("-")) {
/* 343 */         paramc1.y(new l((c)object2, (c)object3));
/*     */         
/*     */         continue;
/*     */       } 
/* 347 */       throw new d("Unknown operator: " + object1, -1);
/*     */     } 
/*     */ 
/*     */     
/* 351 */     return (c)paramc1.pop();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */