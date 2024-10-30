/*     */ package org.passay;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
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
/*     */ public class e
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "INSUFFICIENT_CHARACTERISTICS";
/*     */   private List<g> rules;
/*  26 */   private int iT = 1;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dr = true;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean ds = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e() {
/*  40 */     this.rules = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(g... paramVarArgs) {
/*  51 */     this(1, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(List<g> paramList) {
/*  62 */     this(1, paramList);
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
/*     */   public e(int paramInt, g... paramVarArgs) {
/*  74 */     this(paramInt, Arrays.asList(paramVarArgs));
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
/*     */   public e(int paramInt, List<g> paramList) {
/*  86 */     bv(paramInt);
/*  87 */     K(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> getRules() {
/*  98 */     return this.rules;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void K(List<g> paramList) {
/* 109 */     this.rules = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(g... paramVarArgs) {
/* 120 */     this.rules = Arrays.asList(paramVarArgs);
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
/*     */   public void bv(int paramInt) {
/* 132 */     if (paramInt > 0) {
/* 133 */       this.iT = paramInt;
/*     */     } else {
/* 135 */       throw new IllegalArgumentException("argument must be greater than zero");
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
/*     */   public boolean gC() {
/* 147 */     return this.dr;
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
/* 158 */     this.dr = paramBoolean;
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
/*     */   public int bZ() {
/* 170 */     return this.iT;
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
/* 181 */     return this.ds;
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
/* 192 */     this.ds = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 199 */     if (this.iT > this.rules.size()) {
/* 200 */       throw new IllegalStateException("Number of characteristics must be <= to the number of rules");
/*     */     }
/*     */     
/* 203 */     byte b = 0;
/* 204 */     E e1 = new E(true);
/* 205 */     for (g g : this.rules) {
/* 206 */       E e2 = g.a(paramx);
/* 207 */       if (!e2.isValid()) {
/* 208 */         if (this.ds) {
/* 209 */           e1.bB().addAll(e2.bB());
/*     */         }
/*     */       } else {
/* 212 */         b++;
/*     */       } 
/* 214 */       e1.a().b(e2.a());
/*     */     } 
/* 216 */     if (b < this.iT) {
/* 217 */       e1.aR(false);
/* 218 */       if (this.dr) {
/* 219 */         e1.bB().add(new F("INSUFFICIENT_CHARACTERISTICS", f(b)));
/*     */       }
/*     */     } 
/* 222 */     return e1;
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
/*     */   protected Map<String, Object> f(int paramInt) {
/* 235 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 236 */     linkedHashMap.put("successCount", Integer.valueOf(paramInt));
/* 237 */     linkedHashMap.put("minimumRequired", Integer.valueOf(this.iT));
/* 238 */     linkedHashMap.put("ruleCount", Integer.valueOf(this.rules.size()));
/* 239 */     return (Map)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 246 */     return 
/* 247 */       String.format("%s@%h::numberOfCharacteristics=%s,rules=%s,reportRuleFailures=%s", new Object[] {
/*     */           
/* 249 */           getClass().getName(), 
/* 250 */           Integer.valueOf(hashCode()), 
/* 251 */           Integer.valueOf(this.iT), this.rules, 
/*     */           
/* 253 */           Boolean.valueOf(this.ds)
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */