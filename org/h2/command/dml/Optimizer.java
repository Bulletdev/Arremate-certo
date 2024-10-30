/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.table.Plan;
/*     */ import org.h2.table.PlanItem;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.BitField;
/*     */ import org.h2.util.Permutations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Optimizer
/*     */ {
/*     */   private static final int MAX_BRUTE_FORCE_FILTERS = 7;
/*     */   private static final int MAX_BRUTE_FORCE = 2000;
/*     */   private static final int MAX_GENETIC = 500;
/*     */   private long start;
/*     */   private BitField switched;
/*     */   private final TableFilter[] filters;
/*     */   private final Expression condition;
/*     */   private final Session session;
/*     */   private Plan bestPlan;
/*     */   private TableFilter topFilter;
/*     */   private double cost;
/*     */   private Random random;
/*     */   
/*     */   Optimizer(TableFilter[] paramArrayOfTableFilter, Expression paramExpression, Session paramSession) {
/*  51 */     this.filters = paramArrayOfTableFilter;
/*  52 */     this.condition = paramExpression;
/*  53 */     this.session = paramSession;
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
/*     */   private static int getMaxBruteForceFilters(int paramInt) {
/*  67 */     byte b = 0; int i = paramInt, j = paramInt;
/*  68 */     while (i > 0 && j * i * (i - 1) / 2 < 2000) {
/*  69 */       i--;
/*  70 */       j *= i;
/*  71 */       b++;
/*     */     } 
/*  73 */     return b;
/*     */   }
/*     */   
/*     */   private void calculateBestPlan() {
/*  77 */     this.cost = -1.0D;
/*  78 */     if (this.filters.length == 1 || this.session.isForceJoinOrder()) {
/*  79 */       testPlan(this.filters);
/*     */     } else {
/*  81 */       this.start = System.currentTimeMillis();
/*  82 */       if (this.filters.length <= 7) {
/*  83 */         calculateBruteForceAll();
/*     */       } else {
/*  85 */         calculateBruteForceSome();
/*  86 */         this.random = new Random(0L);
/*  87 */         calculateGenetic();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void calculateFakePlan() {
/*  93 */     this.cost = -1.0D;
/*  94 */     this.bestPlan = new Plan(this.filters, this.filters.length, this.condition);
/*     */   }
/*     */   
/*     */   private boolean canStop(int paramInt) {
/*  98 */     if ((paramInt & 0x7F) == 0) {
/*  99 */       long l = System.currentTimeMillis() - this.start;
/*     */       
/* 101 */       if (this.cost >= 0.0D && (10L * l) > this.cost) {
/* 102 */         return true;
/*     */       }
/*     */     } 
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   private void calculateBruteForceAll() {
/* 109 */     TableFilter[] arrayOfTableFilter = new TableFilter[this.filters.length];
/* 110 */     Permutations permutations = Permutations.create((Object[])this.filters, (Object[])arrayOfTableFilter);
/* 111 */     for (byte b = 0; !canStop(b) && permutations.next(); b++) {
/* 112 */       testPlan(arrayOfTableFilter);
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculateBruteForceSome() {
/* 117 */     int i = getMaxBruteForceFilters(this.filters.length);
/* 118 */     TableFilter[] arrayOfTableFilter = new TableFilter[this.filters.length];
/* 119 */     Permutations permutations = Permutations.create((Object[])this.filters, (Object[])arrayOfTableFilter, i);
/* 120 */     for (byte b = 0; !canStop(b) && permutations.next(); b++) {
/*     */       
/* 122 */       for (TableFilter tableFilter : this.filters)
/* 123 */         tableFilter.setUsed(false); 
/*     */       int j;
/* 125 */       for (j = 0; j < i; j++) {
/* 126 */         arrayOfTableFilter[j].setUsed(true);
/*     */       }
/*     */       
/* 129 */       for (j = i; j < this.filters.length; j++) {
/* 130 */         double d = -1.0D;
/* 131 */         byte b1 = -1;
/* 132 */         for (byte b2 = 0; b2 < this.filters.length; b2++) {
/* 133 */           if (!this.filters[b2].isUsed()) {
/* 134 */             if (j == this.filters.length - 1) {
/* 135 */               b1 = b2;
/*     */               break;
/*     */             } 
/* 138 */             arrayOfTableFilter[j] = this.filters[b2];
/* 139 */             Plan plan = new Plan(arrayOfTableFilter, j + 1, this.condition);
/* 140 */             double d1 = plan.calculateCost(this.session);
/* 141 */             if (d < 0.0D || d1 < d) {
/* 142 */               d = d1;
/* 143 */               b1 = b2;
/*     */             } 
/*     */           } 
/*     */         } 
/* 147 */         this.filters[b1].setUsed(true);
/* 148 */         arrayOfTableFilter[j] = this.filters[b1];
/*     */       } 
/* 150 */       testPlan(arrayOfTableFilter);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void calculateGenetic() {
/* 155 */     TableFilter[] arrayOfTableFilter1 = new TableFilter[this.filters.length];
/* 156 */     TableFilter[] arrayOfTableFilter2 = new TableFilter[this.filters.length];
/* 157 */     for (byte b = 0; b < 'Ǵ' && 
/* 158 */       !canStop(b); b++) {
/*     */ 
/*     */       
/* 161 */       boolean bool = ((b & 0x7F) == 0) ? true : false;
/* 162 */       if (!bool) {
/* 163 */         System.arraycopy(arrayOfTableFilter1, 0, arrayOfTableFilter2, 0, this.filters.length);
/* 164 */         if (!shuffleTwo(arrayOfTableFilter2)) {
/* 165 */           bool = true;
/*     */         }
/*     */       } 
/* 168 */       if (bool) {
/* 169 */         this.switched = new BitField();
/* 170 */         System.arraycopy(this.filters, 0, arrayOfTableFilter1, 0, this.filters.length);
/* 171 */         shuffleAll(arrayOfTableFilter1);
/* 172 */         System.arraycopy(arrayOfTableFilter1, 0, arrayOfTableFilter2, 0, this.filters.length);
/*     */       } 
/* 174 */       if (testPlan(arrayOfTableFilter2)) {
/* 175 */         this.switched = new BitField();
/* 176 */         System.arraycopy(arrayOfTableFilter2, 0, arrayOfTableFilter1, 0, this.filters.length);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean testPlan(TableFilter[] paramArrayOfTableFilter) {
/* 182 */     Plan plan = new Plan(paramArrayOfTableFilter, paramArrayOfTableFilter.length, this.condition);
/* 183 */     double d = plan.calculateCost(this.session);
/* 184 */     if (this.cost < 0.0D || d < this.cost) {
/* 185 */       this.cost = d;
/* 186 */       this.bestPlan = plan;
/* 187 */       return true;
/*     */     } 
/* 189 */     return false;
/*     */   }
/*     */   
/*     */   private void shuffleAll(TableFilter[] paramArrayOfTableFilter) {
/* 193 */     for (byte b = 0; b < paramArrayOfTableFilter.length - 1; b++) {
/* 194 */       int i = b + this.random.nextInt(paramArrayOfTableFilter.length - b);
/* 195 */       if (i != b) {
/* 196 */         TableFilter tableFilter = paramArrayOfTableFilter[b];
/* 197 */         paramArrayOfTableFilter[b] = paramArrayOfTableFilter[i];
/* 198 */         paramArrayOfTableFilter[i] = tableFilter;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean shuffleTwo(TableFilter[] paramArrayOfTableFilter) {
/* 204 */     int i = 0, j = 0; byte b = 0;
/* 205 */     for (; b < 20; b++) {
/* 206 */       i = this.random.nextInt(paramArrayOfTableFilter.length);
/* 207 */       j = this.random.nextInt(paramArrayOfTableFilter.length);
/* 208 */       if (i != j) {
/*     */ 
/*     */         
/* 211 */         if (i < j) {
/* 212 */           int m = i;
/* 213 */           i = j;
/* 214 */           j = m;
/*     */         } 
/* 216 */         int k = i * paramArrayOfTableFilter.length + j;
/* 217 */         if (!this.switched.get(k)) {
/*     */ 
/*     */           
/* 220 */           this.switched.set(k); break;
/*     */         } 
/*     */       } 
/* 223 */     }  if (b == 20) {
/* 224 */       return false;
/*     */     }
/* 226 */     TableFilter tableFilter = paramArrayOfTableFilter[i];
/* 227 */     paramArrayOfTableFilter[i] = paramArrayOfTableFilter[j];
/* 228 */     paramArrayOfTableFilter[j] = tableFilter;
/* 229 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void optimize(boolean paramBoolean) {
/* 239 */     if (paramBoolean) {
/* 240 */       calculateFakePlan();
/*     */     } else {
/* 242 */       calculateBestPlan();
/* 243 */       this.bestPlan.removeUnusableIndexConditions();
/*     */     } 
/* 245 */     TableFilter[] arrayOfTableFilter = this.bestPlan.getFilters();
/* 246 */     this.topFilter = arrayOfTableFilter[0];
/* 247 */     for (byte b = 0; b < arrayOfTableFilter.length - 1; b++) {
/* 248 */       arrayOfTableFilter[b].addJoin(arrayOfTableFilter[b + 1], false, false, null);
/*     */     }
/* 250 */     if (paramBoolean) {
/*     */       return;
/*     */     }
/* 253 */     for (TableFilter tableFilter : arrayOfTableFilter) {
/* 254 */       PlanItem planItem = this.bestPlan.getItem(tableFilter);
/* 255 */       tableFilter.setPlanItem(planItem);
/*     */     } 
/*     */   }
/*     */   
/*     */   public TableFilter getTopFilter() {
/* 260 */     return this.topFilter;
/*     */   }
/*     */   
/*     */   double getCost() {
/* 264 */     return this.cost;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Optimizer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */