/*     */ package org.passay;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x
/*     */ {
/*     */   private String password;
/*     */   private String username;
/*     */   
/*     */   public enum c
/*     */   {
/*  22 */     b,
/*     */ 
/*     */     
/*  25 */     c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   private List<d> aX = new ArrayList<>();
/*     */ 
/*     */   
/*  38 */   private c a = c.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public x(String paramString) {
/*  52 */     setPassword(paramString);
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
/*     */   public x(String paramString1, String paramString2) {
/*  64 */     setUsername(paramString1);
/*  65 */     setPassword(paramString2);
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
/*     */   public x(String paramString, c paramc) {
/*  77 */     setPassword(paramString);
/*  78 */     a(paramc);
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
/*     */   public x(String paramString1, String paramString2, c paramc) {
/*  91 */     setUsername(paramString1);
/*  92 */     setPassword(paramString2);
/*  93 */     a(paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(String paramString) {
/* 104 */     if (paramString == null) {
/* 105 */       throw new NullPointerException("Password cannot be null");
/*     */     }
/* 107 */     this.password = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/* 118 */     return this.password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(c paramc) {
/* 129 */     if (paramc == null) {
/* 130 */       throw new NullPointerException("Origin cannot be null");
/*     */     }
/* 132 */     this.a = paramc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c a() {
/* 143 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsername(String paramString) {
/* 154 */     if (paramString == null) {
/* 155 */       throw new NullPointerException("Username cannot be null");
/*     */     }
/* 157 */     this.username = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsername() {
/* 168 */     return this.username;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<d> bA() {
/* 179 */     return this.aX;
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
/*     */   public <T extends d> List<T> d(Class<T> paramClass) {
/* 194 */     ArrayList<? extends T> arrayList = new ArrayList();
/* 195 */     if (this.aX != null) {
/* 196 */       arrayList.addAll((Collection)this.aX.stream().filter(paramClass::isInstance)
/* 197 */           .map(paramd -> paramd).collect(Collectors.toList()));
/*     */     }
/* 199 */     return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(d... paramVarArgs) {
/* 210 */     L(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void L(List<d> paramList) {
/* 221 */     this.aX = paramList;
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
/*     */   public static x a(x paramx) {
/* 234 */     x x1 = new x();
/* 235 */     x1.setUsername(paramx.getUsername());
/* 236 */     x1.setPassword(paramx.getPassword());
/* 237 */     x1.L(paramx.bA());
/* 238 */     x1.a(paramx.a());
/* 239 */     return x1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 246 */     return 
/* 247 */       String.format("%s@%h::username=%s,password=%s,origin=%s,passwordReferences=%s", new Object[] {
/*     */           
/* 249 */           getClass().getName(), 
/* 250 */           Integer.valueOf(hashCode()), this.username, this.password, this.a, this.aX
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public x() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface d
/*     */   {
/*     */     String getPassword();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */     extends a
/*     */   {
/*     */     public b(String param1String) {
/* 284 */       super(null, param1String);
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
/*     */     public b(String param1String1, String param1String2) {
/* 296 */       super(param1String1, param1String2);
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
/*     */   public static class e
/*     */     extends a
/*     */   {
/*     */     public e(String param1String) {
/* 313 */       super(null, param1String);
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
/*     */     public e(String param1String1, String param1String2) {
/* 325 */       super(param1String1, param1String2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class a
/*     */     implements d
/*     */   {
/*     */     private final String label;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String password;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(String param1String1, String param1String2) {
/* 349 */       this.label = param1String1;
/* 350 */       this.password = param1String2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getLabel() {
/* 361 */       return this.label;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPassword() {
/* 368 */       return this.password;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 375 */       return String.format("%s@%h::label=%s,password=%s", new Object[] { getClass().getName(), Integer.valueOf(hashCode()), this.label, this.password });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */