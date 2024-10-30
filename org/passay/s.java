/*     */ package org.passay;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class s
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "INSUFFICIENT_COMPLEXITY";
/*     */   public static final String mn = "INSUFFICIENT_COMPLEXITY_RULES";
/*  31 */   private final Map<a, List<D>> rules = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dr = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean ds = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(String paramString, List<D> paramList) {
/*  51 */     if (paramList == null || paramList.isEmpty()) {
/*  52 */       throw new IllegalArgumentException("Rules cannot be empty or null");
/*     */     }
/*  54 */     a a = new a(paramString);
/*  55 */     for (a a1 : this.rules.keySet()) {
/*  56 */       if (a1.b(a)) {
/*  57 */         throw new IllegalArgumentException("Interval " + a + " intersects existing interval " + a1);
/*     */       }
/*     */     } 
/*  60 */     this.rules.put(a, paramList);
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
/*     */   public void a(String paramString, D... paramVarArgs) {
/*  72 */     b(paramString, (paramVarArgs != null) ? Arrays.<D>asList(paramVarArgs) : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gC() {
/*  83 */     return this.dr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aP(boolean paramBoolean) {
/*  94 */     this.dr = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean gD() {
/* 105 */     return this.ds;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aQ(boolean paramBoolean) {
/* 116 */     this.ds = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<a, List<? extends D>> W() {
/* 127 */     return Collections.unmodifiableMap(this.rules);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 134 */     int i = paramx.getPassword().length();
/* 135 */     List<D> list = a(i);
/* 136 */     if (list == null) {
/* 137 */       return new E(false, new F("INSUFFICIENT_COMPLEXITY_RULES", 
/*     */             
/* 139 */             a(i, 0, 0)));
/*     */     }
/* 141 */     byte b = 0;
/* 142 */     E e = new E(true);
/* 143 */     for (D d : list) {
/* 144 */       E e1 = d.a(paramx);
/* 145 */       if (!e1.isValid()) {
/* 146 */         if (this.ds) {
/* 147 */           e.bB().addAll(e1.bB());
/*     */         }
/*     */       } else {
/* 150 */         b++;
/*     */       } 
/* 152 */       e.a().b(e1.a());
/*     */     } 
/* 154 */     if (b < list.size()) {
/* 155 */       e.aR(false);
/* 156 */       if (this.dr) {
/* 157 */         e.bB().add(new F("INSUFFICIENT_COMPLEXITY", 
/*     */ 
/*     */               
/* 160 */               a(i, b, list.size())));
/*     */       }
/*     */     } 
/* 163 */     return e;
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
/*     */   private List<D> a(int paramInt) {
/* 177 */     Optional<List<D>> optional = this.rules.entrySet().stream().filter(paramEntry -> ((a)paramEntry.getKey()).A(paramInt)).map(Map.Entry::getValue).findFirst();
/* 178 */     return optional.isPresent() ? optional.get() : null;
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
/*     */   protected Map<String, Object> a(int paramInt1, int paramInt2, int paramInt3) {
/* 196 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 197 */     linkedHashMap.put("passwordLength", Integer.valueOf(paramInt1));
/* 198 */     linkedHashMap.put("successCount", Integer.valueOf(paramInt2));
/* 199 */     linkedHashMap.put("ruleCount", Integer.valueOf(paramInt3));
/* 200 */     return (Map)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     return 
/* 208 */       String.format("%s@%h::rules=%s,reportRuleFailures=%s", new Object[] {
/*     */           
/* 210 */           getClass().getName(), 
/* 211 */           Integer.valueOf(hashCode()), this.rules, 
/*     */           
/* 213 */           Boolean.valueOf(this.ds)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     public enum b
/*     */     {
/* 227 */       b,
/*     */ 
/*     */       
/* 230 */       c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static b a(String param2String) {
/* 245 */         if ("[".equals(param2String) || "]".equals(param2String)) {
/* 246 */           return b;
/*     */         }
/* 248 */         if ("(".equals(param2String) || ")".equals(param2String)) {
/* 249 */           return c;
/*     */         }
/* 251 */         throw new IllegalArgumentException("Invalid interval notation: " + param2String);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 256 */     private static final Pattern G = Pattern.compile("^([\\(|\\[])(\\d+),(\\d+|\\*)([\\)|\\]])$");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final a a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final a b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(String param1String) {
/* 272 */       Matcher matcher = G.matcher(param1String);
/* 273 */       if (!matcher.matches()) {
/* 274 */         throw new IllegalArgumentException("Invalid interval notation: " + param1String);
/*     */       }
/*     */       
/* 277 */       String str1 = matcher.group(1);
/* 278 */       String str2 = matcher.group(2);
/* 279 */       String str3 = matcher.group(3);
/* 280 */       String str4 = matcher.group(4);
/*     */       
/* 282 */       this.a = new a(this, Integer.parseInt(str2), b.a(str1));
/* 283 */       this
/*     */         
/* 285 */         .b = new a(this, "*".equals(str3) ? Integer.MAX_VALUE : Integer.parseInt(str3), b.a(str4));
/*     */       
/* 287 */       if (ce() - cd() < 0) {
/* 288 */         throw new IllegalArgumentException("Invalid interval notation: " + param1String + " produced an empty set");
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean A(int param1Int) {
/* 302 */       boolean bool = false;
/* 303 */       if (param1Int >= a.a(this.a) && param1Int <= a.a(this.b)) {
/* 304 */         if (param1Int > a.a(this.a) && param1Int < a.a(this.b)) {
/* 305 */           bool = true;
/* 306 */         } else if (param1Int == a.a(this.a) && this.a.isClosed()) {
/* 307 */           bool = true;
/* 308 */         } else if (param1Int == a.a(this.b) && this.b.isClosed()) {
/* 309 */           bool = true;
/*     */         } 
/*     */       }
/* 312 */       return bool;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean a(a param1a) {
/* 325 */       return (A(param1a.cd()) && A(param1a.ce()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean b(a param1a) {
/* 338 */       return (A(param1a.cd()) || A(param1a.ce()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int cd() {
/* 349 */       return this.a.isClosed() ? a.a(this.a) : (a.a(this.a) + 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int ce() {
/* 360 */       return this.b.isClosed() ? a.a(this.b) : (a.a(this.b) - 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 367 */       if (param1Object == this) {
/* 368 */         return true;
/*     */       }
/* 370 */       if (param1Object != null && getClass() == param1Object.getClass()) {
/* 371 */         a a1 = (a)param1Object;
/* 372 */         return (this.a.equals(a1.a) && this.b.equals(a1.b));
/*     */       } 
/* 374 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 381 */       return Objects.hash(new Object[] { this.a, this.b });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 388 */       return 
/* 389 */         String.format("%s%s,%s%s", new Object[] {
/*     */             
/* 391 */             Character.valueOf(this.a.isClosed() ? 91 : 40), 
/* 392 */             Integer.valueOf(a.a(this.a)), 
/* 393 */             Integer.valueOf(a.a(this.b)), 
/* 394 */             Character.valueOf(this.b.isClosed() ? 93 : 41)
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private class a
/*     */     {
/*     */       private final int value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final s.a.b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       a(s.a this$0, int param2Int, s.a.b param2b) {
/* 419 */         this.value = param2Int;
/* 420 */         this.a = (s.a)param2b;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isClosed() {
/* 431 */         return (s.a.b.b == this.a);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isOpen() {
/* 442 */         return (s.a.b.c == this.a);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(Object param2Object) {
/* 449 */         if (param2Object == this) {
/* 450 */           return true;
/*     */         }
/* 452 */         if (param2Object != null && getClass() == param2Object.getClass()) {
/* 453 */           a a1 = (a)param2Object;
/* 454 */           return (this.value == a1.value && this.a == a1.a);
/*     */         } 
/* 456 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 463 */         return Objects.hash(new Object[] { Integer.valueOf(this.value), this.a });
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */