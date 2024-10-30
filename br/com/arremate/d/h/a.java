/*     */ package br.com.arremate.d.h;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  18 */   private int X = 0;
/*  19 */   private int Y = 0;
/*  20 */   private long u = 0L;
/*  21 */   private Map<Integer, Integer> o = new TreeMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double b() {
/*  27 */     return BigDecimal.valueOf(r()).divide(BigDecimal.valueOf(q()), 4, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100L)).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double c() {
/*  34 */     return BigDecimal.valueOf(h()).divide(BigDecimal.valueOf(q()), 4, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_EVEN).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public i k() {
/*  39 */     i i = new i();
/*     */     
/*  41 */     this.o.forEach((paramInteger1, paramInteger2) -> {
/*     */           double d = BigDecimal.valueOf(paramInteger2.intValue()).divide(BigDecimal.valueOf(q()), 4, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100L)).doubleValue();
/*     */ 
/*     */           
/*     */           parami.a(Integer.toString(paramInteger1.intValue()), d);
/*     */         });
/*     */ 
/*     */     
/*  49 */     return i;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  53 */     this.X = 0;
/*  54 */     this.Y = 0;
/*  55 */     this.u = 0L;
/*  56 */     this.o.clear();
/*     */   }
/*     */   
/*     */   public void F(int paramInt) {
/*  60 */     this.X += paramInt;
/*     */   }
/*     */   
/*     */   public void G(int paramInt) {
/*  64 */     this.Y += paramInt;
/*     */   }
/*     */   
/*     */   public void o(long paramLong) {
/*  68 */     this.u += paramLong;
/*     */   }
/*     */   
/*     */   public int q() {
/*  72 */     return this.X;
/*     */   }
/*     */   
/*     */   public void H(int paramInt) {
/*  76 */     this.X = paramInt;
/*     */   }
/*     */   
/*     */   public int r() {
/*  80 */     return this.Y;
/*     */   }
/*     */   
/*     */   public void I(int paramInt) {
/*  84 */     this.Y = paramInt;
/*     */   }
/*     */   
/*     */   public long h() {
/*  88 */     return this.u;
/*     */   }
/*     */   
/*     */   public void p(long paramLong) {
/*  92 */     this.u = paramLong;
/*     */   }
/*     */   
/*     */   public void a(int paramInt1, int paramInt2) {
/*  96 */     int i = a(paramInt1);
/*  97 */     int j = i + paramInt2;
/*  98 */     this.o.put(Integer.valueOf(paramInt1), Integer.valueOf(j));
/*     */   }
/*     */   
/*     */   private int a(int paramInt) {
/* 102 */     return this.o.containsKey(Integer.valueOf(paramInt)) ? ((Integer)this.o.get(Integer.valueOf(paramInt))).intValue() : 0;
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> h() {
/* 106 */     return this.o;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\h\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */